package Steps.SelenIDESteps;

import Elements.SelenIDEElements.MaximumPriceHotel;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static org.openqa.selenium.By.xpath;

public class MaximumPriceHotelSteps extends MaximumPriceHotel {

    public static Double hotelMaxPrice;
    public static int hotelMaxPriceIndex;
    public static String maxPricedHotelName;

    public static Double roomMaxPrice;
    public static int  roomMaxPriceIndex;
    public static String maxRoomPriceName;

    public static String selectedRoomName;

    public MaximumPriceHotelSteps filterWithStar5 () {
        starRating5.shouldBe(visible, Duration.ofSeconds(10)).click();
        return this;
    }


    public MaximumPriceHotelSteps applyFilter () {
        boolean highestRank = false;
        while (!highestRank) {
            try {
                applyFilter.scrollIntoView(false).shouldBe(visible, Duration.ofSeconds(10));
                Selenide.executeJavaScript("arguments[0].click();", applyFilter);
                for (int i = 0; i < 5; i++) {
                    Selenide.executeJavaScript("window.scrollTo(0, document.body.scrollHeight);");
                    maxRanking.last().shouldBe(Condition.visible, Duration.ofSeconds(5));
                }
                    List<String> hotelsRanking = maxRanking.texts();
                    List <Integer> listInNumber = hotelsRanking.stream().
                            map(text -> {
                                try {
                                    return Integer.parseInt(text.replaceAll("[^0-9.]", ""));
                                } catch (NumberFormatException e) {
                                    return 0;
                                }
                            }).toList();
                    if (listInNumber.stream().noneMatch(value -> value !=55)) {
                        highestRank = true;
                        System.out.println("5/5 hotels filtered successful!");
                    }
                } catch (Exception e) {
                    System.out.println("Filter failed. Retrying...");
                }
        }
        return this;
    }


    public MaximumPriceHotelSteps findMaxPriceHotel () {
        for (int i = 0; i < 5; i++) {
            Selenide.executeJavaScript("window.scrollTo(0, document.body.scrollHeight);");
            hotelPriceList.last().shouldBe(Condition.visible);
        }

        List<String> hotelListPrices = hotelPriceList.texts();
        List <Double> listInNumber = hotelListPrices.stream().
                map(text -> {
                    try {
                        return Double.parseDouble(text.replaceAll("[^0-9.]", ""));
                    } catch (NumberFormatException e) {
                        return 0.0;
                    }
                }).toList();
        hotelMaxPrice = listInNumber.stream().max(Double::compareTo).orElse(0.00);
        hotelMaxPriceIndex = listInNumber.indexOf(hotelMaxPrice);

        Assert.assertTrue(listInNumber.stream().allMatch(value -> value <= hotelMaxPrice),
                "There exists a value greater than the extracted maximum value.");

        return this;
    }

    public MaximumPriceHotelSteps findMaxPriceHotelName () {
        maxPricedHotelName = hotelPriceList.get(hotelMaxPriceIndex).
                $(Selectors.byXpath("../../preceding-sibling::div//h5/strong")).getText();
        System.out.println("Most expensive hotel: " + maxPricedHotelName + " with price: " + hotelMaxPrice);
        return this;
    }


    public MaximumPriceHotelSteps selectMaxPriceHotel () {
        Selenide.executeJavaScript("arguments[0].click();",
                hotelPriceList.get(hotelMaxPriceIndex).parent().parent().find("a"));
        return this;
    }


    public MaximumPriceHotelSteps findMaxPriceRoom () {
        selectRoom.shouldHave(CollectionCondition.sizeGreaterThan(0),  Duration.ofSeconds(15));
        List <String> hotelRoomListPrices = selectRoom.texts();
        List <Double> listInNumber = hotelRoomListPrices.stream().
                map(text -> {
                    try {
                        return Double.parseDouble(text.replaceAll("[^0-9.]", ""));
                    } catch (NumberFormatException e) {
                        return 0.0;
                    }
                }).toList();
        roomMaxPrice = listInNumber.stream().max(Double::compareTo).orElse(0.00);
        roomMaxPriceIndex = listInNumber.indexOf(roomMaxPrice);

        Assert.assertTrue(listInNumber.stream().allMatch(value -> value <= roomMaxPrice),
                "There exists a value greater than the extracted maximum value.");

        return this;
    }

    public MaximumPriceHotelSteps findMaxPriceRoomName () {
        maxRoomPriceName = selectRoom.get(roomMaxPriceIndex).
                $(Selectors.byXpath("ancestor::div[contains(@class, 'rounded p-3 mt-2')]//h5/strong")).getText();
        System.out.println("Most expensive room: " + maxRoomPriceName + " with price: " + roomMaxPrice);
        return this;
    }

    public MaximumPriceHotelSteps selectRoomForReserve () {
        Selenide.executeJavaScript("arguments[0].click();", selectRoom.get(roomMaxPriceIndex).
                $(xpath("./following::button[@type='submit']")));
        return this;
    }

    public MaximumPriceHotelSteps findSelectedRoomPrice () {
        selectedRoomName = chosenRoomName.shouldBe(visible, Duration.ofSeconds(5)).getText();
        return this;
    }

    public void assertSelectedRoom () {

        boolean selectedRoomIsRight = false;
        while (!selectedRoomIsRight) {
            if (selectedRoomName.equals(maxRoomPriceName)) {
                selectedRoomIsRight = true;
                System.out.println("Hotel names matching");
            } else {
                Selenide.executeJavaScript("window.history.back()");
                selectRoomForReserve();
            }

        }

    }

}

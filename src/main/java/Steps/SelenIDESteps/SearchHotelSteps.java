package Steps.SelenIDESteps;

import Elements.SelenIDEElements.SearchHotel;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.ex.ElementNotFound;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.visible;

public class SearchHotelSteps extends SearchHotel {

    public SearchHotelSteps clickOnHotels () {
        clickOnHotels.click();
        return this;
    }

    public SearchHotelSteps chooseCity () {
        city.click();
        setCityValue.setValue("Delhi");
        getCity.get(1).click();
        return this;
    }

    public SearchHotelSteps setCheckInDate () {
        LocalDate today = LocalDate.now();
        String todayDate = today.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        checkInDate.setValue(todayDate);
        return this;
    }

    public SearchHotelSteps setCheckOutDate () {
        LocalDate today = LocalDate.now();
        String secondDate = today.plusDays(3).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        checkOutDate.setValue(secondDate);
        return this;
    }

    public SearchHotelSteps decreaseAdultQuantity () {
        Selenide.executeJavaScript("arguments[0].click();", adultQuantity);
        return this;
    }


    public SearchHotelSteps clickSearchButton () {
        searchButton.click();
        return this;
    }

    public void assertSearchedHotel () {
        while (true) {
            try {
                if (hotelList.shouldBe(visible, Duration.ofSeconds(10)).isDisplayed()) {
                    System.out.println("Hotel found");
                    break;
                } else {
                    clickSearchButton();
                }

            } catch (ElementNotFound e) {
                System.out.println("Error message: " + e.getMessage());
            }
        }
    }

}

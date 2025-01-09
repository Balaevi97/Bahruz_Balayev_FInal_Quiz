package Steps.SelenIDESteps;

import Elements.SelenIDEElements.RoomBooking;
import SetUp.FileUtils;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;

public class RoomBookingSteps extends RoomBooking {

    public RoomBookingSteps setAdultFirstName () {
        adultFirstName.setValue(getFirstName.getValue());
        return this;
    }

    public RoomBookingSteps setAdultLastName () {
        aAdultLastName.setValue(getLastName.getValue());
        return this;
    }


    public RoomBookingSteps clickPayPayLater () {
        Selenide.executeJavaScript("arguments[0].click();", payPayLater);
        return this;
    }

    public RoomBookingSteps clickAgreeToAll () {
        Selenide.executeJavaScript("arguments[0].click();", agreeToAll);
        return this;
    }

    public RoomBookingSteps clickBooking () {
        Selenide.executeJavaScript("arguments[0].click();", booking);
        return this;
    }

    public RoomBookingSteps assertNightQuantity () {
        String nightQuantityText = nightQuantity.shouldBe(visible, Duration.ofSeconds(10)).text();
        Assert.assertTrue(nightQuantityText.contains("Total Nights : 3"));
        return this;
    }

    public RoomBookingSteps assertPaymentMethod () {
        String paymentMethodText = getPaymentMethod.text();
        Assert.assertEquals(paymentMethodText, "Pay Later");
        return this;
    }

    public RoomBookingSteps assertCheckInDate () {
        String nightQuantityText = nightQuantity.text();
        Assert.assertTrue(nightQuantityText.contains(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
        return this;
    }

    public RoomBookingSteps assertCheckOutDate () {
        String nightQuantityText = nightQuantity.text();
        Assert.assertTrue(nightQuantityText.contains(LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
        return this;
    }

    public RoomBookingSteps downloadInvoice () {
        downloadInvoice.shouldBe(clickable, Duration.ofSeconds(10));
        Selenide.executeJavaScript("arguments[0].click();", downloadInvoice);
        return this;
    }

    public void assertFile () {
        boolean fileISPresent = false;
        while (!fileISPresent) {

            Optional<File> foundFile = FileUtils.findFile(System.getProperty("user.home") + "\\Downloads", "invoice.pdf");
            if (foundFile.isPresent()) {
                System.out.println("File is present");
                fileISPresent = true;

            }
            else {
                System.out.println("File not found");
            }
        }
    }
}

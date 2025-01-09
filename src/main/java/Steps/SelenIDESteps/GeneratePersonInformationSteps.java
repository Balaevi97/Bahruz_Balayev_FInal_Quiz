package Steps.SelenIDESteps;

import Elements.SelenIDEElements.GeneratePersonInformation;

import java.time.Duration;

import static SetUp.SelenIDESetUp.openPage;
import static SetUp.URLClass.personGenerate;
import static com.codeborne.selenide.Condition.visible;



public class GeneratePersonInformationSteps extends GeneratePersonInformation {

    public static String getFirstName;
    public static String getLastName;
    public static String getLivingAddress;
    public static String getCity;
    public static String getPostalCode;
    public static String getPhoneNumber;
    public static String getEmailAddress;


    public GeneratePersonInformationSteps openDataGeneratorLink() {
        openPage(personGenerate);
        return this;
    }

    public void getFirstName() {
        getFirstName = fullName.shouldBe(visible, Duration.ofSeconds(10)).getText().split(" ")[0];
    }

    public void getLastName() {
        getLastName = fullName.getText().split(" ")[1];

    }

    public void getLivingAddress() {
        getLivingAddress = livingAddress.getText();
    }

    public void getCity() {
        getCity = city.getText();
    }

    public void getPostalCode() {
        getPostalCode = postalCode.getText();
    }

    public void getPhoneNumber() {
        getPhoneNumber = phoneNumber.getText();
    }

    public void getEmailAddress() {
        getEmailAddress = emailAddress.getText();
    }


    public void getUserInformation() {
        getFirstName();
        getLastName();
        getLivingAddress();
        getCity();
        getPostalCode();
        getPhoneNumber();
        getEmailAddress();
    }


}

package Steps.SeleniumSteps;

import Elements.SeleniunElements.GeneratePersonInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static SetUp.SeleniumSetUp.driver;
import static SetUp.SeleniumSetUp.wait;
import static SetUp.URLClass.personGenerate;


public class GeneratePersonInformationSteps extends GeneratePersonInformation {

    public static String getFirstName;
    public static String getLastName;
    public static String getLivingAddress;
    public static String getCity;
    public static String getPostalCode;
    public static String getPhoneNumber;


    public GeneratePersonInformationSteps openDataGeneratorURL () {
        driver.get(personGenerate);
        return this;
    }


    public void getFirstName () {
        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(fullName));
        String fullName = firstName.getText();
        getFirstName = fullName.split(" ")[0];
    }

    public void getLastName () {
        WebElement lastName = wait.until(ExpectedConditions.visibilityOfElementLocated(fullName));
        String fullName = lastName.getText();
        getLastName = fullName.split(" ")[1];

    }

    public void getLivingAddress () {
        WebElement address = driver.findElement(livingAddress);
        getLivingAddress = address.getText();
    }

    public void getCity () {
        WebElement cityName = driver.findElement(city);
        getCity = cityName.getText();
    }

    public void getPostalCode () {
        WebElement code = driver.findElement(postalCode);
        getPostalCode = code.getText();
    }

    public void getPhoneNumber () {
        WebElement phoneNum = driver.findElement(phoneNumber);
        String correctedNumber = phoneNum.getText();
        getPhoneNumber = correctedNumber.split(" x")[0].replace(".", "-");
    }

    public void getAllInformation () {
        getFirstName();
        System.out.println(getFirstName);

        getLastName();
        System.out.println(getLastName);

        getLivingAddress();
        System.out.println(getLivingAddress);

        getCity();
        System.out.println(getCity);
        getPostalCode();
        System.out.println(getPostalCode);
        getPhoneNumber();
        System.out.println(getPhoneNumber);



    }

}

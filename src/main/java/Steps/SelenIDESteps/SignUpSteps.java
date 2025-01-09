package Steps.SelenIDESteps;

import Elements.SelenIDEElements.SignUp;

import java.time.Duration;
import java.util.UUID;

import static SetUp.URLClass.hotelBooking;
import static Steps.SelenIDESteps.GenerateEmailSteps.getGeneratedEmail;
import static Steps.SelenIDESteps.GeneratePersonInformationSteps.*;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.switchTo;

public class SignUpSteps extends SignUp {

    public static String userPassword;


    public void generateRandomCredentials() {
        userPassword = UUID.randomUUID().toString().substring(0, 12);
        System.out.println("Generated Password: " + userPassword);
    }

    public SignUpSteps openPhpTravelsURl () {
        executeJavaScript("window.open(arguments[0], '_blank');", hotelBooking);
        switchTo().window(2);
        return this;
    }

    public SignUpSteps signUpButton () {
        executeJavaScript("arguments[0].click();", signUp);
        return this;
    }

    public SignUpSteps setFirstName () {
        firstName.setValue(getFirstName);
        System.out.println(getFirstName);
        return this;
    }

    public SignUpSteps setLastName () {
        lastName.setValue(getLastName);
        return this;
    }

    public SignUpSteps setCountry () {
        countryField.click();
        country.click();
        return this;
    }

    public SignUpSteps setPhone () {
        phone.setValue(getPhoneNumber);
        return this;
    }

    public SignUpSteps setEmail () {
        System.out.println(getGeneratedEmail);
        email.setValue(getGeneratedEmail);
        return this;
    }

    public SignUpSteps setPassword () {
        generateRandomCredentials();
        password.setValue(userPassword);
        return this;
    }


    public void clickSubmitButton () {
        switchTo().defaultContent();
        submitButton.shouldBe(enabled, Duration.ofSeconds(100));
        submitButton.click();
    }

    public Boolean signUpChecker () {
        return signUpChecker.shouldBe(visible, Duration.ofSeconds(10)).isDisplayed();
    }

    public void signUpMethod () {
        boolean isSignUpSuccessful = false;
        while (!isSignUpSuccessful) {
            try {
                    openPhpTravelsURl()
                        .signUpButton()
                        .setFirstName()
                        .setLastName()
                        .setCountry()
                        .setPhone()
                        .setEmail()
                        .setPassword()
                        .clickSubmitButton();
                if (signUpChecker()) {
                    isSignUpSuccessful = true;
                    System.out.println("Sign-up successful!");
                    switchTo().window(1);
                }
            } catch (Exception e) {
                System.out.println("Sign-up failed. Retrying...");

            }
        }
    }

}

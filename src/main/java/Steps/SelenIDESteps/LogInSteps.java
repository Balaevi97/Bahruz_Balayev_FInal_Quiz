package Steps.SelenIDESteps;


import Elements.SelenIDEElements.LogIn;
import org.testng.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;


public class LogInSteps extends LogIn {

    public LogInSteps getLoginPage () {
        logIn.click();
        return this;
    }

    public LogInSteps setEmail () {
        String generatedEmail = GenerateEmailSteps.getGeneratedEmail;
        System.out.println(generatedEmail);
        email.setValue(generatedEmail);
        return this;
    }

    public LogInSteps setPassword () {
        String getPassword = SignUpSteps.userPassword;
        System.out.println(getPassword);
        password.setValue(getPassword);
        return this;
    }

    public LogInSteps clickLoginBTN () {
        submitBTN.click();
        return this;
    }

    public void assertLogin () {
        Assert.assertTrue(welcomeMessage.shouldBe(visible, Duration.ofSeconds(10)).isDisplayed());
    }

}

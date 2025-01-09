package Steps.SeleniumSteps;

import Elements.SeleniunElements.ReLogin;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import static SetUp.SeleniumSetUp.actions;
import static SetUp.SeleniumSetUp.driver;

public class ReLoginSteps extends ReLogin {

    public ReLoginSteps logOut () {
        driver.findElement(logOut).click();
        return this;
    }

    public ReLoginSteps sendUsername1 () {
        String getGeneratedEmail = RegisterSteps.getGeneratedEmail;
        driver.findElement(username).click();
        actions.sendKeys(getGeneratedEmail).perform();
        return this;
    }

    public ReLoginSteps sendPassword1 () {
        System.out.println();
        String getCurrentPassword = RegisterSteps.userPassword;
        driver.findElement(password).click();
        actions.sendKeys(getCurrentPassword).perform();
        actions.sendKeys(Keys.BACK_SPACE).perform();
        return this;
    }

    public ReLoginSteps logIn1 () {
        driver.findElement(logIn).click();
        return this;
    }

    public void assertLogIn () {
        Assert.assertTrue(driver.findElement(assertLoginElementDashboard).isDisplayed());
        Assert.assertTrue(driver.findElement(assertLoginElementOrders).isDisplayed());
        Assert.assertTrue(driver.findElement(assertLoginElementAccountDetails).isDisplayed());
        System.out.println("LogIn accepted");
    }
}
package Steps.SeleniumSteps;

import Elements.SeleniunElements.ChangePassword;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import static SetUp.SeleniumSetUp.actions;
import static SetUp.SeleniumSetUp.driver;


public class ChangePasswordSteps extends ChangePassword {


    public ChangePasswordSteps moveToAccountDetails () {
        driver.findElement(accountDetails).click();
        return this;
    }

    public ChangePasswordSteps sendAccountFirstName () {
        driver.findElement(accountFirstName).click();
        actions.sendKeys(GeneratePersonInformationSteps.getFirstName).perform();
        return this;
    }

    public ChangePasswordSteps sendAccountLastName () {
        driver.findElement(accountLastName).click();
        actions.sendKeys(GeneratePersonInformationSteps.getLastName).perform();
        return this;
    }

    public ChangePasswordSteps sendCurrentPassword () {
        String getCurrentPassword = RegisterSteps.userPassword;
        driver.findElement(currentPassword).click();
        actions.sendKeys(getCurrentPassword).perform();
        return this;
    }

    public ChangePasswordSteps sendNewPassword () {
        String getCurrentPassword = RegisterSteps.userPassword;
        driver.findElement(newPassword).click();
        actions.sendKeys(getCurrentPassword).perform();
        actions.sendKeys(Keys.BACK_SPACE).perform();
        return this;
    }

    public ChangePasswordSteps repeatPassword () {
        String getCurrentPassword = RegisterSteps.userPassword;
        driver.findElement(repeatPassword).click();
        actions.sendKeys(getCurrentPassword).perform();
        actions.sendKeys(Keys.BACK_SPACE).perform();
        return this;
    }

    public ChangePasswordSteps clickSaveChangedPassword () {
        driver.findElement(saveChangedPassword).click();
        return this;
    }

    public void assertChangedPassword () {
        Assert.assertTrue(driver.findElement(changedPassword).isDisplayed());
    }
}

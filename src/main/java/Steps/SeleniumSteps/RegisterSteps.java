package Steps.SeleniumSteps;

import Elements.SeleniunElements.Register;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

import static SetUp.SeleniumSetUp.*;
import static SetUp.URLClass.generateEmail;
import static SetUp.URLClass.onlineShop;

public class RegisterSteps extends Register {

    Toolkit toolkit = Toolkit.getDefaultToolkit();

    public static String getGeneratedEmail;
    public static String userPassword;

    public void generateRandomCredentials() {
        userPassword = UUID.randomUUID().toString().substring(0, 12);
    }

    public RegisterSteps switchToNeTab() {
        String currentHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();

        ArrayList<String> handlesList = new ArrayList<>(handles);
        String lastHandle = (String) ((ArrayList<?>) handlesList).get(handlesList.size() - 1);

        if (!lastHandle.equals(currentHandle)) {
            driver.switchTo().window(lastHandle);

        }
        return this;
    }


    public RegisterSteps openURl () {
        js.executeScript("window.open(arguments[0], '_blank');", generateEmail);
        return this;
    }

    public RegisterSteps copyEmail () throws IOException, UnsupportedFlavorException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(copyEmail)).click();
        getGeneratedEmail = (String) toolkit.getSystemClipboard().getData(DataFlavor.stringFlavor);
        return this;
    }
    public RegisterSteps openNeTab () {
        js.executeScript("window.open(arguments[0], '_blank');", onlineShop);
        return this;
    }



    public RegisterSteps setEmailInput () {
        System.out.println(getGeneratedEmail);
        String generatedEmail = RegisterSteps.getGeneratedEmail;
        driver.findElement(emailInput).sendKeys(generatedEmail);
        return this;
    }

    public RegisterSteps setPasswordInput () {

        boolean sigUpCompleted = false;
        while (!sigUpCompleted) {
            try {
                generateRandomCredentials();
                System.out.println(userPassword);
                driver.findElement(passwordInput).click();
                actions.keyDown(Keys.CONTROL).sendKeys("a").sendKeys(Keys.BACK_SPACE).keyUp(Keys.CONTROL).perform();
                driver.findElement(passwordInput).sendKeys(userPassword);
                driver.findElement(registerButton).click();

                WebElement Dashboard = driver.findElement(assertLoginElementDashboard);
                WebElement Orders = driver.findElement(assertLoginElementOrders);

                if (Dashboard.isDisplayed() & Orders.isDisplayed()) {
                    sigUpCompleted = true;
                    System.out.println("Sign up completed!");
                }

            }   catch (Exception e) {
                System.out.println("Sign up can not completed. Retrying...");
            }
        }
        return this;
    }

    public void assertLogin () {
        Assert.assertTrue(driver.findElement(assertLoginElementDashboard).isDisplayed());
        Assert.assertTrue(driver.findElement(assertLoginElementOrders).isDisplayed());
        Assert.assertTrue(driver.findElement(assertLoginElementAccountDetails).isDisplayed());

    }
}

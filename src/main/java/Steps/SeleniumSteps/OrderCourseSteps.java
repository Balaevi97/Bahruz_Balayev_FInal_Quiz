package Steps.SeleniumSteps;

import Elements.SeleniunElements.OrderCourse;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static SetUp.SeleniumSetUp.*;


public class OrderCourseSteps extends OrderCourse {

    public OrderCourseSteps sendFirstName () {

        driver.findElement(firstName).click();
        actions.sendKeys(GeneratePersonInformationSteps.getFirstName).perform();
    return this;
}

    public OrderCourseSteps sendLastName () {
        driver.findElement(lastName).click();
        actions.sendKeys(GeneratePersonInformationSteps.getLastName).perform();
        return this;
    }

    public OrderCourseSteps sendPhoneNumber () {
        driver.findElement(phoneNumber).click();
        actions.sendKeys(GeneratePersonInformationSteps.getPhoneNumber).perform();
        return this;
    }

    public OrderCourseSteps sendAddress () {
        driver.findElement(address).click();
        actions.sendKeys(GeneratePersonInformationSteps.getLivingAddress).perform();
        return this;
    }

    public OrderCourseSteps sendCity () {
        WebElement cityElement = driver.findElement(city);
        ((JavascriptExecutor) driver).
                executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", cityElement);
        cityElement.click();
        actions.sendKeys(GeneratePersonInformationSteps.getCity).perform();
        return this;
    }

    public OrderCourseSteps sendPostalCode () {
        WebElement cityPostalCode = driver.findElement(postalCode);
        ((JavascriptExecutor) driver).
                executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", cityPostalCode);
        cityPostalCode.click();
        actions.sendKeys(GeneratePersonInformationSteps.getPostalCode).perform();
        return this;
    }

    public OrderCourseSteps  clickPaymentMethod () {
        WebElement element = driver.findElement(paymentWithCash);
        ((JavascriptExecutor) driver).
                executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
        driver.findElement(paymentWithCash).click();
        return this;
    }

    public OrderCourseSteps placeOrder () {
        driver.findElement(placeOrder).click();
        return this;
    }

    public OrderCourseSteps assertPaymentMethod () {
        String gettext = wait.until(ExpectedConditions.visibilityOfElementLocated(checkPaymentMethod)).getText();
        Assert.assertEquals(gettext, "Cash on Delivery");
        return this;
    }

    public OrderCourseSteps assertProductQuantity () {
        int saveOrderItemQuantityInformation = CheckoutCourseSteps.getProductQuantitySize;
        int getSize = driver.findElements(checkProductQuantity).size();
        Assert.assertEquals(getSize, saveOrderItemQuantityInformation);
        return this;
    }

    public OrderCourseSteps assertTotalPrice () {
        WebElement priceElement = driver.findElement(checkTotalPrice);
        String getTextFromElement = priceElement.getText().replaceAll("[^\\d.]", "");
        Double totalPrice = Double.parseDouble(getTextFromElement);
        Assert.assertEquals(totalPrice, 744.6);
        return this;
    }

    public OrderCourseSteps moveToMyAccount () {
        driver.findElement(moveToMyAccount).click();
        return this;
    }

    public OrderCourseSteps openOrders () {
        driver.findElement(openOrders).click();
        return this;
    }

    public void assertOrderDisplayed () {
        WebElement orderIsDisplayed = driver.findElement(order);
        Assert.assertTrue(orderIsDisplayed.isDisplayed());
    }
}

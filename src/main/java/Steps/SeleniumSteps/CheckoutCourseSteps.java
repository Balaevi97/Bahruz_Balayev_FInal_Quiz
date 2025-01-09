package Steps.SeleniumSteps;

import Elements.SeleniunElements.CheckoutCourse;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static SetUp.SeleniumSetUp.*;

public class CheckoutCourseSteps extends CheckoutCourse {

    private Double totalPriceBeforeCoupon;
    private Double totalPriceAfterCoupon;
    private Double totalPriceAfterDeletingCoupon;
    public static int getProductQuantitySize;

    public void moveToBasket () {
        driver.findElement(moveToBasket).click();
    }

    public CheckoutCourseSteps findTotalPriceBeforeCoupon () {
        moveToBasket();
        WebElement priceElement = driver.findElement(getCheckTotalPrice);
        String getTextFromElement = priceElement.getText().replaceAll("[^\\d.]", "");
        totalPriceBeforeCoupon = Double.parseDouble(getTextFromElement);
        return this;
    }


    public CheckoutCourseSteps enterCouponValue () {
        driver.findElement(couponField).sendKeys("krishnasakinala");
        return this;
    }

    public CheckoutCourseSteps clickApplyCoupon () {
        WebElement clickOApplyCoupon = wait.until(ExpectedConditions.elementToBeClickable(applyCoupon));
        js.executeScript("arguments[0].click();", clickOApplyCoupon);
        return this;
    }

    public boolean assertRemoveCoupon () {
        WebElement removeButton = driver.findElement(removeCoupon);
        return removeButton.isDisplayed();

    }

    public CheckoutCourseSteps couponIsDisplayed () {
        boolean couponIsDisplayed = false;
        while (!couponIsDisplayed) {
            try {
                    enterCouponValue()
                    .clickApplyCoupon();
                if (assertRemoveCoupon()) {
                    couponIsDisplayed = true;
                    System.out.println("Coupon Added!");
                }
            }catch (Exception e) {
                System.out.println("Coupon Can Not Added. Retrying...");
            }
        }
        return this;
    }

    public CheckoutCourseSteps findTotalPriceAfterCoupon () {
        moveToBasket();
        WebElement priceElement = driver.findElement(getCheckTotalPrice);
        String getTextFromElement = priceElement.getText().replaceAll("[^\\d.]", "");
        totalPriceAfterCoupon = Double.parseDouble(getTextFromElement);
        return this;
    }

    public CheckoutCourseSteps assertCouponEffect () {
        Assert.assertTrue(totalPriceBeforeCoupon > totalPriceAfterCoupon);
        return this;
    }

    public CheckoutCourseSteps clickRemoveCoupon () {
        driver.findElement(removeCoupon).click();
        return this;
    }

    public CheckoutCourseSteps findTotalPriceAfterDeletingCoupon () {
        moveToBasket();
        WebElement priceElement = driver.findElement(getCheckTotalPrice);
        String getTextFromElement = priceElement.getText().replaceAll("[^\\d.]", "");
        totalPriceAfterDeletingCoupon = Double.parseDouble(getTextFromElement);
        return this;
    }

    public CheckoutCourseSteps assertRemovingCoupon () {
        Assert.assertEquals(totalPriceBeforeCoupon, totalPriceAfterDeletingCoupon);
        return this;
    }

    public CheckoutCourseSteps saveOrderItemQuantityInformation () {
         getProductQuantitySize = driver.findElements(productQuantity).size();
        return this;
    }

    public void clickCheckOut () {
        WebElement checkoutElement = wait.until(ExpectedConditions.elementToBeClickable(checkOut));
                js.executeScript("arguments[0].click();", checkoutElement);
       // checkoutElement.click();
    }
}

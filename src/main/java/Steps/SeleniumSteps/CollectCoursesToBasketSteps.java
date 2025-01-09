package Steps.SeleniumSteps;

import Elements.SeleniunElements.CollectCoursesToBasket;
import org.openqa.selenium.WebElement;

import static SetUp.SeleniumSetUp.actions;
import static SetUp.SeleniumSetUp.driver;


public class CollectCoursesToBasketSteps extends CollectCoursesToBasket {


    private Double seleniumCoursePrice;
    private Double HTLMCoursePrice;


    public CollectCoursesToBasketSteps backToShop () {
        driver.findElement(backToShop).click();
        return this;
    }

    public CollectCoursesToBasketSteps clickFilterJavaScript () {
        driver.findElement(filterJavaScript).click();
        return this;
    }

    public void getHTML5CoursePrice () {
        WebElement HTML5Price = driver.findElement(HTML5FormsBookPrice);
        String getTextFromHTML5Price = HTML5Price.getText().replaceAll("[^\\d.]", "");
        HTLMCoursePrice = Double.parseDouble(getTextFromHTML5Price);
        System.out.println(HTLMCoursePrice);

    }


    public CollectCoursesToBasketSteps addHTML5FormsBook1 () {
        WebElement html5 = driver.findElement(addHTML5FormsBook);
        actions.moveToElement(html5).perform();
        actions.click().perform();
        return this;
    }

    public boolean checkBasket (Double price) {

        WebElement priceInBasket = driver.findElement(basketItem);
        String getTextBasketPrice = priceInBasket.getText().replaceAll("[^\\d.]", "");
        Double BasketPrice = Double.parseDouble(getTextBasketPrice);
        return BasketPrice.equals(price);
    }

    public CollectCoursesToBasketSteps addHTML5FormsBook () {
        boolean firstCourseAtAdded = false;
        while (!firstCourseAtAdded) {
            try {
                clickFilterJavaScript()
                        .getHTML5CoursePrice();
                addHTML5FormsBook1()
                        .refreshPage();
                if (checkBasket(HTLMCoursePrice)) {
                    firstCourseAtAdded = true;
                    System.out.println("First Product Added!");
                }
            }catch (Exception e) {
                System.out.println("Product Can Not Added. Retrying...");
            }
        }
        return this;
    }

    public void refreshPage () {
        driver.navigate().refresh();
    }

    public void clickFilterSelenium () {
        driver.findElement(filterSelenium).click();
    }

    public void   getSeleniumCoursePrice () {
        WebElement seleniumBookPrice = driver.findElement(seleniumRubyBookPrice);
        String getTextFromSeleniumBookPrice = seleniumBookPrice.getText().replaceAll("[^\\d.]", "");
        seleniumCoursePrice = Double.parseDouble(getTextFromSeleniumBookPrice);
        System.out.println(seleniumCoursePrice);
    }

    public CollectCoursesToBasketSteps addSeleniumRubyBook1 () {
        WebElement seleniumRuby = driver.findElement(addSeleniumRubyBook);
        actions.moveToElement(seleniumRuby).perform();
        actions.click().perform();
        return this;
    }

    public void addSeleniumRubyBook () {
        boolean secondCourseAdded = false;
        while (!secondCourseAdded) {
            try {
                clickFilterSelenium();
                getSeleniumCoursePrice();
                addSeleniumRubyBook1()
                        .refreshPage();
                if (checkBasket(HTLMCoursePrice + seleniumCoursePrice)) {
                    secondCourseAdded = true;
                    System.out.println("Second Product Added!");
                }
            }catch (Exception e) {
                System.out.println("Product Can Not Added. Retrying...");
            }
        }
    }
}

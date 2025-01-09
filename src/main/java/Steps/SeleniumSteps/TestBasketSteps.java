package Steps.SeleniumSteps;

import Elements.SeleniunElements.TestBasket;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

import static SetUp.SeleniumSetUp.*;

public class TestBasketSteps extends TestBasket {

    public static int totalJavascriptCourse;
    public static String totalHeaderOfJavascriptCourses;
    public static int productAbove300;
    public static Double seleniumRubyCoursePrice;


    public TestBasketSteps clickShopButton () {
        driver.findElement(shopButton).click();
        return this;
    }

    public TestBasketSteps clickOrderByLowToHigh () {
        driver.findElement(orderByButton).click();
        return this;
    }

    public TestBasketSteps assertPriceOrder () {

        List<WebElement> priceElements = driver.findElements(orderedList);
        priceElements.forEach(element -> System.out.println(element.getText()));
        List<Double> prices = priceElements.stream()
                .map(WebElement::getText)
                .map(text -> text.replaceAll("[^\\d.]", ""))
                .map(Double::parseDouble)
                .toList();

        boolean priceSortedCorrectly = true;
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) > prices.get(i + 1)) {
                priceSortedCorrectly = false;
                break;
            }
        }

        if (priceSortedCorrectly) {
            System.out.println("Prices are correctly sorted.");
        }else {
            System.out.println("Prices are not sorted correctly.");
        }

        return this;
    }

    public void findTotalJavascriptCourseInDom () {
        totalJavascriptCourse = driver.findElements(totalJavascriptCourseInDom).size();
        System.out.println(totalJavascriptCourse);
    }

    public void headerOfJavascriptCourses () {
        List<String> texts = driver.findElements(headerOfJavascriptCourses)
                .stream()
                .map(WebElement::getText)
                .sorted()
                .toList();
        texts.forEach(System.out::println);
        totalHeaderOfJavascriptCourses = String.valueOf(texts);
        System.out.println(totalHeaderOfJavascriptCourses);

    }

    public TestBasketSteps clickFilterJavaScript () {
        findTotalJavascriptCourseInDom ();
        headerOfJavascriptCourses ();
        driver.findElement(filterJavaScript).click();
        return this;
    }

    public TestBasketSteps assertAllFilteredJavasScriptElements () {
        int filteredElementSize = driver.findElements(findAllFilteredElements).size();
        Assert.assertEquals(filteredElementSize, totalJavascriptCourse);
        return this;
    }

    public TestBasketSteps assertHeaderOfJavascriptCourses () {
        List<String> texts = driver.findElements(headerOfJavascriptCourses)
                .stream()
                .map(WebElement::getText)
                .sorted()
                .toList();
        texts.forEach(System.out::println);
        String getListText = texts.toString();
        Assert.assertEquals(getListText, totalHeaderOfJavascriptCourses);
        return this;
    }

    public void getAllProductAbove300 () {
        productAbove300 = driver.findElements(allProductAbove300).size();
        System.out.println(productAbove300);
    }

    public TestBasketSteps priceFilterBar () {
        getAllProductAbove300();
        WebElement filter = driver.findElement(priceFilterBar);
        actions.clickAndHold(filter).perform();
        WebElement priceElement = driver.findElement(priceFilter);
        int currentPrice = Integer.parseInt(priceElement.getText().replaceAll("[^0-9]", ""));

        while (currentPrice < 300) {
            actions.sendKeys(Keys.ARROW_RIGHT).perform();
            currentPrice = Integer.parseInt(priceElement.getText().replaceAll("[^0-9]", ""));
        }
        actions.release().perform();
        return this;
    }

    public TestBasketSteps clickFilterButton () {
        driver.findElement(filterButton).click();
        return this;
    }

    public TestBasketSteps assertOneItem () {
        int filteredItemCount = driver.findElements(allProductAbove300).size();
        System.out.println();
        Assert.assertEquals(filteredItemCount,productAbove300 );
        return this;
    }

    public TestBasketSteps clickAdToBasket () {
        driver.findElement(addToBasket).click();
        return this;
    }

    public TestBasketSteps seleniumRubyCoursePrice () {
        WebElement getPrice = driver.findElement(seleniumRubyPrice);
        String getText = getPrice.getText();
        getText = getText.replaceAll("[^\\d.]", "");
        seleniumRubyCoursePrice = Double.valueOf(getText);
        System.out.println(seleniumRubyCoursePrice);
        return this;
    }

    public TestBasketSteps refreshPage () {
        driver.navigate().refresh();
        return this;
    }

    public TestBasketSteps assertBasketPrice () {
        WebElement basketPrice = driver.findElement(findBasketPrice);
        String getText = basketPrice.getText();
        getText = getText.replaceAll("[^\\d.]", "");
        Assert.assertEquals(Double.parseDouble(getText), seleniumRubyCoursePrice);
        return this;
    }

    public TestBasketSteps moveToBasket () {
        driver.findElement(moveToBasket).click();
        return this;
    }

    public TestBasketSteps assertAddedItem () {
        WebElement addedItem = driver.findElement(findAddedItem);
        Assert.assertTrue(addedItem.isDisplayed());
        return this;
    }

    public TestBasketSteps clickRemoveItem () {
        driver.findElement(removeItem).click();
        return this;
    }

    public void assertBasket () {

        WebElement emptyBasket = wait.until(ExpectedConditions.visibilityOfElementLocated(checkBasket));
                Assert.assertTrue(emptyBasket.isDisplayed());

    }
}

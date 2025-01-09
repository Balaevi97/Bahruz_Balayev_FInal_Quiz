package Elements.SeleniunElements;

import org.openqa.selenium.By;

public class TestBasket {

    public By shopButton = By.xpath("//li [@id='menu-item-40']//a [text()='Shop']");
    public By orderByButton = By.xpath("//div [@id='content']//option [@value='price']");
    public By orderedList = By.cssSelector(".price span.woocommerce-Price-amount:not(del .woocommerce-Price-amount)");
    public By totalJavascriptCourseInDom = By.xpath("//li [contains (@class, 'product_tag-javascript')]");
    public By headerOfJavascriptCourses = By.xpath("//li [contains (@class, 'product_tag-javascript')]//h3");
    public By filterJavaScript = By.xpath("//*//a [text()='JavaScript']");
    public By findAllFilteredElements = By.xpath("//*//ul[@class='products masonry-done']//li");
    public By allProductAbove300 = By.xpath("//span [@class='woocommerce-Price-amount amount' and text()>300]");
    public By priceFilterBar = By.xpath("//*//span [contains (@class, 'ui-slider-handle')][1]");
    public By priceFilter = By.xpath("//div [@class='price_label']//span [@class='from']");
    public By filterButton = By.xpath("//*//button [@class= 'button']");
    public By addToBasket = By.xpath("//*//li [contains (@class, 'product_tag-javascript ')]//a [text()='Add to basket']");
    public By seleniumRubyPrice = By.xpath("//*//li [contains (@class, 'product_tag-javascript ')]//span [@class='woocommerce-Price-amount amount']");
    public By findBasketPrice = By.xpath("//li[@id='wpmenucartli']//span[@class='amount']");
    public By moveToBasket = By.xpath("//*//li[@id='wpmenucartli']");
    public By findAddedItem = By.xpath("//*//div [@class='woocommerce']//tr [@class='cart_item']//a [text()='Mastering JavaScript']");
    public By removeItem = By.xpath("//*//div [@class='woocommerce']//tr [@class='cart_item']//a [text()='×']");
    public By checkBasket = By.xpath("//*//div [@class='woocommerce']//p [@class='cart-empty']");

}

package Elements.SeleniunElements;

import org.openqa.selenium.By;


public class CollectCoursesToBasket {
    public By backToShop = By.xpath("//*//div [@class='woocommerce']//a [@class='button wc-backward']");
    public By filterJavaScript = By.xpath("//*//a [text()='HTML']");
    public By filterSelenium = By.xpath("//*//a [text()='selenium']");
    public By HTML5FormsBookPrice = By.xpath("//*//li[.//h3[text()='HTML5 Forms']]//span[@class='woocommerce-Price-amount amount']");
    public By addHTML5FormsBook = By.xpath("//*//li[.//h3[text()='HTML5 Forms']]//a[text()='Add to basket']");
    public By basketItem = By.xpath("//li[@id='wpmenucartli']//span[@class='amount']");
    public By seleniumRubyBookPrice = By.xpath("//*//li[.//h3[text()='Selenium Ruby']]//span[@class='woocommerce-Price-amount amount']");
    public By addSeleniumRubyBook = By.xpath("//*//li[.//h3[text()='Selenium Ruby']]//a[text()='Add to basket']");

}

package Elements.SeleniunElements;

import org.openqa.selenium.By;

public class OrderCourse {

    public By firstName = By.id("billing_first_name");
    public By lastName = By.id("billing_last_name");
    public By phoneNumber = By.id("billing_phone");
    public By address = By.id("billing_address_1");
    public By city = By.id("billing_city");
    public By postalCode = By.id("billing_postcode");
    public By paymentWithCash = By.id("payment_method_cod");
    public By placeOrder = By.id("place_order");
    public By checkPaymentMethod = By.xpath("//*//th [@scope='row' and text()='Payment Method:']/following-sibling::td");
    public By checkProductQuantity = By.xpath("//*//tbody//tr [@class='order_item']");
    public By checkTotalPrice = By.xpath("//*//th [@scope='row' and text()='Total:']/following-sibling::td");
    public By moveToMyAccount = By.id("menu-item-50");
    public By openOrders = By.xpath("//*//a [text()='Orders']");
    public By order = By.xpath("//*//td [@class='order-number']");
}

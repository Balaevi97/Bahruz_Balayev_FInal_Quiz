package Elements.SeleniunElements;

import org.openqa.selenium.By;

public class CheckoutCourse {

    public By getCheckTotalPrice = By.xpath("//*//tr[@class='order-total']//span [@class='woocommerce-Price-amount amount']");
    public By moveToBasket = By.xpath("//*//li[@id='wpmenucartli']");
    public By couponField = By.id("coupon_code");
    public By applyCoupon = By.xpath("//*//input [@name='apply_coupon']");
    public By removeCoupon = By.xpath("//*//a[@data-coupon='krishnasakinala']");
    public By productQuantity = By.xpath("//*//tbody//td [@class='product-name']");
    public By checkOut = By.xpath("//*//a [@class = 'checkout-button button alt wc-forward']");
}

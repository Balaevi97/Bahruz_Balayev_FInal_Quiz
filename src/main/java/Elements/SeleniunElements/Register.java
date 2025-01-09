package Elements.SeleniunElements;

import org.openqa.selenium.By;

public class Register {

    public By copyEmail = By.id("copbtn");
    public By emailInput = By.id("reg_email");
    public By passwordInput = By.id("reg_password");
    public By registerButton = By.xpath("//*//input [@value='Register']");
    public By assertLoginElementDashboard = By.xpath("//a [text()='Dashboard']");
    public By assertLoginElementOrders = By.xpath("//a [text()='Orders']");
    public By assertLoginElementAccountDetails = By.xpath("//a [text()='Account Details']");

}

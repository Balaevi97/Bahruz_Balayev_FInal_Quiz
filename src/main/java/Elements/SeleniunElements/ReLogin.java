package Elements.SeleniunElements;

import org.openqa.selenium.By;

public class ReLogin {

        public By logOut  = By.xpath("//*//a [text()='Logout']");
        public By username = By.id("username");
        public By password = By.id("password");
        public By logIn = By.xpath("//*//input [@type='submit' and @name='login']");
        public By assertLoginElementDashboard = By.xpath("//a [text()='Dashboard']");
        public By assertLoginElementOrders = By.xpath("//a [text()='Orders']");
        public By assertLoginElementAccountDetails = By.xpath("//a [text()='Account Details']");

}

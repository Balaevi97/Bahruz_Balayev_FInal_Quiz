package Elements.SeleniunElements;

import org.openqa.selenium.By;

public class ChangePassword {

    public By accountDetails  = By.xpath("//*//a [text()='Account Details']");
    public By accountFirstName = By.id("account_first_name");
    public By accountLastName = By.id("account_last_name");
    public By currentPassword = By.id("password_current");
    public By newPassword = By.id("password_1");
    public By repeatPassword = By.id("password_2");
    public By saveChangedPassword = By.xpath("//*//input [@type='submit' and @name='save_account_details']");
    public By changedPassword = By.xpath("//div [text()='Account details changed successfully.']");

}

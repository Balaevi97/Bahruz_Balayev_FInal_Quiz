package Elements.SelenIDEElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SignUp {
    public SelenideElement signUp = $(byXpath("//*//li [@class='nav-item dropdown']//strong [text()='Signup ']"));
    public SelenideElement firstName = $(byId("firstname"));
    public SelenideElement lastName = $(byId("last_name"));
    public SelenideElement countryField = $(byXpath("//*//div [@class='dropdown bootstrap-select w-100']"));
    public SelenideElement country = $(byId("bs-select-1-226"));
    public SelenideElement phone = $(byId("phone"));
    public SelenideElement email = $(byId("user_email"));
    public SelenideElement password = $(byId("password"));
    public SelenideElement submitButton = $(byId("submitBTN"));
    public SelenideElement signUpChecker = $(byXpath("//*//strong[text()='Your account has been created']"));
}

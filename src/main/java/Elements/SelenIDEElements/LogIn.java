package Elements.SelenIDEElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LogIn {

    public SelenideElement logIn = $(byXpath("//a[text()='Login']"));
    public SelenideElement email = $(byId("email"));
    public SelenideElement password = $(byId("password"));
    public SelenideElement submitBTN = $(byId("submitBTN"));
    public SelenideElement welcomeMessage = $(byXpath("//span [@class='author__meta' and text()='Welcome Back']"));
}

package SetUp.SelenIDEElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class GenerateEmail {

    public SelenideElement copyEmail = $(byId(("copbtn")));
    public SelenideElement activateAccount = $(byXpath("//a [text()='Activate Account']"));
    public SelenideElement checkActivation = $(byXpath("//strong[text()='Your account has been activated']"));

}

package Elements.SelenIDEElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GeneratePersonInformation {

    public SelenideElement fullName = $(byXpath("//span [@id='nameLoading' and @title='Click To Copy' and text()]"));
    public SelenideElement livingAddress = $(byXpath("//span [@id='addressLoading' and @title='Click To Copy' and text()]"));
    public SelenideElement city = $(byXpath("//span [@id='cityLoading' and @title='Click To Copy' and text()]"));
    public SelenideElement postalCode = $(byXpath("//span [@id='postcodeLoading' and @title='Click To Copy' and text()]"));
    public SelenideElement phoneNumber = $(byXpath("//span [@id='phoneLoading' and @title='Click To Copy' and text()]"));
    public SelenideElement emailAddress = $(byXpath("//span [@id='emailLoading' and @title='Click To Copy' and text()]"));
    public SelenideElement openMailBox = $(byXpath("//a [@href and text()='Open Mailbox']"));
    public SelenideElement activateAccount = $(byXpath("//a [text()='Activate Account']"));
    public SelenideElement checkActivation = $(byXpath("//strong[text()='Your account has been activated']"));
}

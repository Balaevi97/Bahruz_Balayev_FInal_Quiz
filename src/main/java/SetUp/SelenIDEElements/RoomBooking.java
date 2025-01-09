package SetUp.SelenIDEElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class RoomBooking {

    public SelenideElement getFirstName = $(byXpath("//*//input[@name='user[first_name]']"));
    public SelenideElement getLastName = $(byXpath("//*//input[@name='user[last_name]']"));
    public SelenideElement adultFirstName = $(byXpath("//*//input [@name='firstname_1' and @placeholder='First Name']"));
    public SelenideElement aAdultLastName = $(byXpath("//*//input [@name='lastname_1' and @placeholder='Last Name']"));
    public SelenideElement payPayLater = $(byXpath("//input [@id='gateway_pay_later' and @value='pay_later']"));
    public SelenideElement agreeToAll = $(byId("agreechb"));
    public SelenideElement nightQuantity = $(byXpath("//*//li[@class='list-group-item']//strong[text()='Total Nights ']//ancestor::li [contains (normalize-space(), '3')]"));
    public SelenideElement getPaymentMethod = $(byXpath("//*//button [@title='Pay Later']//span [@class='text-dark']"));
    public SelenideElement booking = $(byId("booking"));
    public SelenideElement downloadInvoice = $(byXpath("//*//button [@onclick='if (!window.__cfRLUnblockHandlers) return false; download_pdf()']"));
}

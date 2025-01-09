package SetUp.SelenIDEElements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchHotel {

    public SelenideElement clickOnHotels = $(byXpath("//*//a [@class='nav-link fadeout  waves-effect' and contains (@href, 'hotels')]"));
    public SelenideElement city = $(byXpath("//*//span[@id='select2-hotels_city-container']"));
    public SelenideElement setCityValue = $(byXpath("//*//input [@type='search']"));
    public ElementsCollection getCity = $$(byXpath("//*[contains(text(), 'Delhi')]"));
    public SelenideElement checkInDate = $(byId("checkin"));
    public SelenideElement checkOutDate = $(byId("checkout"));
    public SelenideElement adultQuantity = $(byXpath("//*[@id='hotels_adults']/preceding-sibling::*[@class='qtyDec']"));
    public SelenideElement searchButton = $(byXpath("//*//div [@class='col-lg-1']"));
    public SelenideElement hotelList = $(byXpath("//div [@class='card--item col-12']"));
}

package Elements.SelenIDEElements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class MaximumPriceHotel {

    public SelenideElement starRating5 = $(byId("starRating5"));
    public SelenideElement applyFilter = $(byXpath("//*//button [@data-bs-dismiss='offcanvas']"));
    public ElementsCollection maxRanking = $$(byXpath("//span[@class='rounded-4 p-0 d-flex gap-2 justify-content-between align-items-center px-0']"));
    public ElementsCollection hotelPriceList = $$(byXpath("//div[@class='col-md-9']//strong[@class='w-100']"));
    public ElementsCollection selectRoom = $$(byXpath("//*//p [@class='m-0']//strong"));
    public SelenideElement chosenRoomName = $(byXpath("//p [@class='mt-2']"));
}

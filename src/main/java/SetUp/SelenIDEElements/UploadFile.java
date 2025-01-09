package SetUp.SelenIDEElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;


public class UploadFile {

    public SelenideElement fileUpload = $(byId("myFile"));
    public SelenideElement uploadSubmit = $(byId("submit-button"));

}

package Elements.SeleniunElements;

import org.openqa.selenium.By;

public class GeneratePersonInformation {

    public By fullName = By.xpath("//span [@id='nameLoading' and @title='Click To Copy' and text()]");
    public By livingAddress = By.xpath("//span [@id='addressLoading' and @title='Click To Copy' and text()]");
    public By city = By.xpath("//span [@id='cityLoading' and @title='Click To Copy' and text()]");
    public By postalCode = By.xpath("//span [@id='postcodeLoading' and @title='Click To Copy' and text()]");
    public By phoneNumber = By.xpath("//span [@id='phoneLoading' and @title='Click To Copy' and text()]");

}

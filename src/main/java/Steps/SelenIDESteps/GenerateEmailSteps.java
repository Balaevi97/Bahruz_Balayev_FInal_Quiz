package Steps.SelenIDESteps;

import Elements.SelenIDEElements.GenerateEmail;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;

import static SetUp.URLClass.generateEmail;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.switchTo;

public class GenerateEmailSteps extends GenerateEmail {

    Toolkit toolkit = Toolkit.getDefaultToolkit();

    public static String getGeneratedEmail;

    public GenerateEmailSteps openURl () {
        executeJavaScript("window.open(arguments[0], '_blank');", generateEmail);
        switchTo().window(1);
        return this;
    }

    public void copyEmail () throws IOException, UnsupportedFlavorException {
        copyEmail.shouldBe(visible).click();
        getGeneratedEmail = (String) toolkit.getSystemClipboard().getData(DataFlavor.stringFlavor);
        System.out.println(getGeneratedEmail);
    }


    public GenerateEmailSteps clickActivateAccount () {

        while (true) {
            try {
                if (activateAccount.exists() && activateAccount.isDisplayed()) {
                    activateAccount.scrollIntoCenter().click();
                    System.out.println("Clicked 'Activate Account' successfully");
                    return this;
                }
            } catch (Exception e) {
                System.out.println("Error message: " + e.getMessage());
            }
            Selenide.refresh();
        }
    }


    public void assertActivation () {
        switchTo().window(3);
        checkActivation.shouldBe(visible, Duration.ofSeconds(20));
        Assert.assertTrue(checkActivation.isDisplayed());
    }

}

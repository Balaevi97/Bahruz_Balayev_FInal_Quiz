package SetUp;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;

public class SelenIDESetUp {

    @BeforeClass
    public void setDriver() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", System.getProperty("user.home"));
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("download.directory_upgrade", true);
        chromePrefs.put("safebrowsing.enabled", true);
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("profile.default_content_setting_values.automatic_downloads", 1);

        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
      //  options.addArguments("--incognito");

        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.browserCapabilities = options;
        Configuration.downloadsFolder = System.getProperty("user.home") ;
        Configuration.headless = false;

    }

    @AfterClass
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    public static void openPage (String url) {
        Selenide.open(url);
    }

    public SelenIDESetUp () {
        setDriver();
    }
}

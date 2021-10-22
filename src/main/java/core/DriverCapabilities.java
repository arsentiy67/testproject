package core;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.logging.iLogger;

import java.util.HashMap;
import java.util.Map;

public class DriverCapabilities {

    private MutableCapabilities capabilities;

    public DriverCapabilities(BrowserNames browser) {
        switch (browser) {
            case CHROME:
                ChromeOptions options = new ChromeOptions();
                Map<String, Object> prefs = new HashMap<>();
                options.setExperimentalOption("prefs", prefs);
                capabilities = options;
                break;
            case FIREFOX:
                capabilities = new FirefoxOptions();
                break;
            default:
                break;
        }
    }

    public MutableCapabilities getCapabilities() {
        iLogger.info("Browser options are : {}", capabilities.toString());
        return capabilities;
    }
}

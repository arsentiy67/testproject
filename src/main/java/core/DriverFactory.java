package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.logging.iLogger;
import utils.properties.SystemProperties;

public class DriverFactory {

  private static DriverNames driverName;
  private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

  public static WebDriver getDriver() throws Exception {
    driverName = DriverNames.valueOf(SystemProperties.DRIVER.toUpperCase());
    iLogger.info("Create driver " + driverName);
    switch (driverName) {
      case CHROME:
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = (ChromeOptions) (new DriverCapabilities(BrowserNames.CHROME)).getCapabilities();
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--headless");
        DRIVER.set(new ChromeDriver(chromeOptions));
        return DRIVER.get();
      case FIREFOX:
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = (FirefoxOptions) (new DriverCapabilities(BrowserNames.FIREFOX)).getCapabilities();
        firefoxOptions.addArguments("--disable-dev-shm-usage");
        firefoxOptions.addArguments("--no-sandbox");
        firefoxOptions.addArguments("--headless");
        DRIVER.set(new FirefoxDriver(firefoxOptions));
        return DRIVER.get();
      default:
        throw new Exception("No such driver in DriverFactory");
    }
  }

  public static WebDriver getCurrentDriver() {
    return DRIVER.get();
  }
}

package utils;

import static utils.PropertyReader.getValueByProperty;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class TestBase {

  private static final Logger log = LogManager.getLogger(PropertyReader.class);

  WebDriver driver;
  URL remoteUrl;

  public WebDriver WebDriverManager() {
    String browser = System.getProperty("browser", "chrome").toLowerCase();
    String headless = System.getProperty("headless", "false");
    String runMode = System.getProperty("runMode", "local").toLowerCase();

    boolean isHeadless = Boolean.parseBoolean(headless);
    if (driver == null) {
      try {
        remoteUrl = new URL("http://localhost:4444/wd/hub");
        switch (browser) {
          case "chrome":
            final Map<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("credentials_enable_service", false);
            chromePrefs.put("profile.password_manager_enabled", false);
            chromePrefs.put("profile.password_manager_leak_detection", false);

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("prefs", chromePrefs);
            chromeOptions.addArguments(
                "--no-sandbox", "--disable-dev-shm-usage", "--disable-extensions");
            if (isHeadless) {
              chromeOptions.addArguments("--headless");
            }
            driver =
                runMode.equals("remote")
                    ? new RemoteWebDriver(remoteUrl, chromeOptions)
                    : new ChromeDriver(chromeOptions);
            break;
          case "firefox":
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            if (isHeadless) {
              firefoxOptions.addArguments("-headless");
            }
            driver =
                runMode.equals("remote")
                    ? new RemoteWebDriver(remoteUrl, firefoxOptions)
                    : new FirefoxDriver(firefoxOptions);
            break;

          case "safari":
            SafariOptions safariOptions = new SafariOptions();
            driver =
                runMode.equals("remote")
                    ? new RemoteWebDriver(remoteUrl, safariOptions)
                    : new SafariDriver();
            break;

          default:
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        driver.manage().window().maximize();
        driver.get(getValueByProperty("baseurl"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      } catch (MalformedURLException e) {
        throw new RuntimeException(e);
      }
    }
    return driver;
  }
}

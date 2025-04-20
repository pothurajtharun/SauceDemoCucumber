package Factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utils.PropertyReader;

public class PageObjectFactory {

  private static final Logger log = LogManager.getLogger(PropertyReader.class);

  public WebDriver driver;

  // Constructor to initialize the WebDriver and PageFactory elements
  public PageObjectFactory(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public LoginPage getLoginPage() {
    return new LoginPage(driver);
  }

  public HomePage getHomePage() {
    return new HomePage(driver);
  }
}

package Factory;

import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class PageObjectFactory {
  WebDriver driver;

  public PageObjectFactory(WebDriver driver) {
    this.driver = driver;
  }

  public LoginPage getLoginPage() {
    return new LoginPage(driver);
  }

  public HomePage getHomePage() {
    return new HomePage(driver);
  }
}

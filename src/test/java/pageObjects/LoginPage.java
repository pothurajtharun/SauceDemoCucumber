package pageObjects;

import Factory.PageObjectFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObjectFactory {

  private static final Logger log = LogManager.getLogger(LoginPage.class);

  public LoginPage(WebDriver driver) {
    // Call the parent constructor to initialize WebDriver and PageFactory
    super(driver);
  }

  @FindBy(id = "user-name")
  WebElement usernameField;

  @FindBy(id = "password")
  WebElement passwordField;

  @FindBy(id = "login-button")
  WebElement loginButton;

  @FindBy(className = "app_logo")
  WebElement swagLabsTitle;

  public void verifyLogin(String email, String password) {
    log.debug("Entering username: {}", email);
    usernameField.sendKeys(email);
    log.info("Entering password.");
    passwordField.sendKeys(password);
    log.info("Clicking the login button.");
    loginButton.click();
  }

  public String verifyLoginPageTitle() {
    return driver.getTitle();
  }

  public String verifyHomePageTitle() {
    return swagLabsTitle.getText();
  }
}

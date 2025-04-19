package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
  WebDriver driver;

  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  By usernameField = By.id("user-name");
  By passwordField = By.id("password");
  By loginButton = By.id("login-button");
  By swagLabsTitle = By.className("app_logo");

  public void verifyLogin(String email, String password) {
    driver.findElement(usernameField).sendKeys(email);
    driver.findElement(passwordField).sendKeys(password);
    driver.findElement(loginButton).click();
  }

  public String verifyLoginPageTitle() {
    return driver.getTitle();
  }

  public String verifyHomePageTitle() {
    return driver.findElement(swagLabsTitle).getText();
  }
}

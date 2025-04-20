package pageObjects;

import static utils.PropertyReader.getValueByProperty;

import Factory.PageObjectFactory;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageObjectFactory {

  private static final Logger log = LogManager.getLogger(HomePage.class);

  public HomePage(WebDriver driver) {
    // Call the parent constructor to initialize the WebDriver and PageFactory
    super(driver);
  }

  @FindBy(css = ".bm-burger-button")
  WebElement hamburgerMenu;

  @FindBy(xpath = "//*[contains(@id,'sidebar_link')]")
  List<WebElement> hamburgerMenuOptions;

  public void clickOnTheHamburgerMenu() {
    log.info("Clicking on the hamburger menu.");
    hamburgerMenu.click();
  }

  public List<String> getTheHamburgerMenuOptions() {
    log.info("Fetching hamburger menu options.");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfAllElements(hamburgerMenuOptions));
    return hamburgerMenuOptions.stream().map(WebElement::getText).collect(Collectors.toList());
  }

  public void validateTheHamburgerMenuOptions() {
    log.info("Validating the hamburger menu options.");
    List<String> actualHamburgerOptions = getTheHamburgerMenuOptions();
    List<String> expectedHamburgerOptions =
        List.of(getValueByProperty("hamburger.menu.items").split(","));
    if (!actualHamburgerOptions.equals(expectedHamburgerOptions)) {
      log.error("Hamburger menu options do not match expected values.");
      throw new AssertionError("Hamburger menu options do not match expected values.");
    }
  }
}

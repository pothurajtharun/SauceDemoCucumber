package pageObjects;

import static utils.PropertyReader.getValueByProperty;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage {
  WebDriver driver;

  public HomePage(WebDriver driver) {
    this.driver = driver;
  }

  By hamburgerMenu = By.cssSelector(".bm-burger-button");
  By hamburgerMenuOptions = By.xpath("//*[contains(@id,'sidebar_link')]");

  public void clickOnTheHamburgerMenu() {
    driver.findElement(hamburgerMenu).click();
  }

  public List<String> getTheHamburgerMenuOptions() {
    List<WebElement> menuElements = driver.findElements(hamburgerMenuOptions);
    return menuElements.stream().map(WebElement::getText).collect(Collectors.toList());
  }

  public void validateTheHamburgerMenuOptions() {
    List<String> actualHamburgerOptions = getTheHamburgerMenuOptions();
    String menuItemsProp = getValueByProperty("hamburger.menu.items");
    List<String> expectedHamburgerOptions = Arrays.asList(menuItemsProp.split(","));
    Assert.assertEquals(actualHamburgerOptions, expectedHamburgerOptions);
  }
}

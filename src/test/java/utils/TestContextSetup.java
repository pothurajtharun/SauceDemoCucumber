package utils;

import Factory.PageObjectFactory;
import org.openqa.selenium.WebDriver;

public class TestContextSetup {

  public WebDriver driver;
  public String homePageTitle;
  public PageObjectFactory pageObjectFactory;
  public TestBase testBase;

  public TestContextSetup() {
    testBase = new TestBase();
    pageObjectFactory = new PageObjectFactory(testBase.WebDriverManager());
  }
}

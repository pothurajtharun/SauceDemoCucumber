package utils;

import Factory.PageObjectFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestContextSetup {

  private static final Logger log = LogManager.getLogger(PropertyReader.class);

  public PageObjectFactory pageObjectFactory;
  public TestBase testBase;

  public TestContextSetup() {
    testBase = new TestBase();
    pageObjectFactory = new PageObjectFactory(testBase.WebDriverManager());
  }
}

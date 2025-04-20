package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageObjects.HomePage;
import utils.TestContextSetup;

public class HomePageStepDefinition {

  private static final Logger log = LogManager.getLogger(HomePageStepDefinition.class);

  TestContextSetup testContextSetup;
  HomePage homePage;

  public HomePageStepDefinition(TestContextSetup testContextSetup) {
    this.testContextSetup = testContextSetup;
    homePage = testContextSetup.pageObjectFactory.getHomePage();
  }

  @Given("User is on the hamburger menu.")
  public void user_is_on_the_hamburger_menu() {
    homePage.clickOnTheHamburgerMenu();
  }

  @When("Take all the elements in a list.")
  public void take_all_the_elements_in_a_list() {
    homePage.getTheHamburgerMenuOptions();
  }

  @Then("Validate the elements in the hamburger menu.")
  public void validate_the_elements_in_the_hamburger_menu() {
    homePage.validateTheHamburgerMenuOptions();
  }
}

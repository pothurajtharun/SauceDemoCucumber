package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LoginPage;
import utils.TestContextSetup;

public class LoginPageStepDefinition {

  TestContextSetup testContextSetup;

  LoginPage loginPage;

  public LoginPageStepDefinition(TestContextSetup testContextSetup) {
    this.testContextSetup = testContextSetup;
    loginPage = testContextSetup.pageObjectFactory.getLoginPage();
  }

  @Given("User is on sauce demo login page.")
  public void user_is_on_sauce_demo_login_page() {
    Assert.assertTrue(loginPage.verifyLoginPageTitle().contains("Swag Labs"));
  }

  @When("^User entered the (.+) and (.+) into respective fields.$")
  public void user_entered_the_email_and_password_into_respective_fields(
      String email, String password) {
    loginPage.verifyLogin(email, password);
  }

  @Then("Validate the Swag Labs title in the home page.")
  public void validate_the_swag_labs_title_in_the_home_page() {
    Assert.assertEquals(loginPage.verifyHomePageTitle(), "Swag Labs");
  }
}

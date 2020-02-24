package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginStepDefs {

    @Given("The user should be Login Page")
    public void the_user_should_be_Login_Page() {

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
      BrowserUtils.waitFor(10);

        Driver.get().findElement(By.id("signin_button")).click();



    }

    @When("The user should be valid credentials")
    public void the_user_should_be_valid_credentials() {
        BrowserUtils.waitFor(3);
        LoginPage loginPage= new LoginPage();

        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        loginPage.login(username,password);

    }

    @Then("The user should be able to  login")
    public void the_user_should_be_able_to_login() {

        System.out.println( Driver.get().getTitle());

    }
    @When("The user should enter invalid credentials")
    public void the_user_should_enter_invalid_credentials() {
        LoginPage loginPage= new LoginPage();

        String username = "user23";
        String password = "pastword";
        loginPage.login(username,password);
    }



    @Then("Error message should be {string}")
    public void error_message_should_be(String errorMessage) {

        String actualMessage = Driver.get().findElement(By.cssSelector(".alert.alert-error")).getText();

        Assert.assertEquals(errorMessage,actualMessage);

    }
    @Then("Account summary page should be displayed.")
    public void account_summary_page_should_be_displayed() {
        Driver.get().findElement(By.id("account_summary_tab")).isDisplayed();
    }
    @When("The user should enter submit without typing credentials")
    public void the_user_should_enter_submit_without_typing_credentials() {
       LoginPage loginPage = new LoginPage();
       String username = "";
       String password= "";
       loginPage.login(username,password);
    }
}

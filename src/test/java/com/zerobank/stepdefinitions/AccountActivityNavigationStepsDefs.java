package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.DashBoardPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class AccountActivityNavigationStepsDefs {

    @When("the user clicks on Savings link on the Account Summary page")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_page() {
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
    accountSummaryPage.Savings.click();
    }

    @Then("the Account Activitypage should be displayed")
    public void the_Account_Activitypage_should_be_displayed() {
        DashBoardPage dashBoardPage = new DashBoardPage();

        Assert.assertTrue(dashBoardPage.accountActivity.isDisplayed());
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String string) {
        AccountActivityPage accountActivityPage= new AccountActivityPage();
        Select select= new Select(accountActivityPage.defaultOption);
       Assert.assertTrue(select.getFirstSelectedOption().getText().equals(string));

            }

            //---------------------------------------------------------------
            @When("the user clicks on Brokerage link on the Account Summary page")
            public void the_user_clicks_on_Brokerage_link_on_the_Account_Summary_page() {
                AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
                accountSummaryPage.Brokerage.click();
            }
    @When("the user clicks on Checking link on the Account Summary page")
    public void the_user_clicks_on_Checking_link_on_the_Account_Summary_page() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.Checking.click();
    }

    @When("the user clicks on Credit card link on the Account Summary page")
    public void the_user_clicks_on_Credit_card_link_on_the_Account_Summary_page() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.CreditCard.click();
    }

    @When("the user clicks on Loan link on the Account Summary page")
    public void the_user_clicks_on_Loan_link_on_the_Account_Summary_page() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.Loan.click();
    }



}

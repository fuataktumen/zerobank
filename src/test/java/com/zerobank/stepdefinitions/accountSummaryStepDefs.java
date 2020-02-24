package com.zerobank.stepdefinitions;


import com.zerobank.pages.*;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class accountSummaryStepDefs {

    @Then("Verify that The Title {string}")
    public void verify_that_The_Title(String getTitle) {

        Assert.assertEquals(getTitle, Driver.get().getTitle());

    }

    @Then("Verify that Account summary page should have to following account types:")
    public void verify_that_Account_summary_page_should_have_to_following_account_types(List<String> ListOfTitle) {

        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        List<String> actualTitles = BrowserUtils.getElementsText(accountSummaryPage.ListOfTitle);

        System.out.println(accountSummaryPage.ListOfTitle);
        System.out.println(actualTitles);
        Assert.assertEquals(ListOfTitle, actualTitles);


    }

    @Then("Verify that Credit Accountstable must have Account, Credit Card and Balance")
    public void verify_that_Credit_Accountstable_must_have_Account_Credit_Card_and_Balance(List<String> ColumnOfCreditAccounts) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        List<String> actualTitle = BrowserUtils.getElementsText(accountSummaryPage.ColumnOfCreditAccounts);

        Assert.assertEquals(ColumnOfCreditAccounts, actualTitle);


    }

    @Given("The user is logged with valid credentials")
    public void the_user_is_logged_with_valid_credentials() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        BrowserUtils.waitFor(10);

        Driver.get().findElement(By.id("signin_button")).click();



        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        loginPage.login(username, password);

    }


    @Then("The user should be able to click accountActivity")
    public void the_user_should_be_able_to_click_accountActivity() {
        DashBoardPage dashBoardPage = new DashBoardPage();
        dashBoardPage.accountActivity.click();
    }

    @Then("Verify that in the Account drop down default option should be Savings")
    public void verify_that_in_the_Account_drop_down_default_option_should_be_Savings() {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        BrowserUtils.waitFor(4);
        List<String> actual = BrowserUtils.getElementsText(accountActivityPage.accountOptions);

        Assert.assertEquals("Savings" , actual);





    }


    @Then("Account drop down should have the following options:")
    public void account_drop_down_should_have_the_following_options(List<String> selectOptions) {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        BrowserUtils.waitFor(4);

        System.out.println(selectOptions);

        List<String> actualOptions = BrowserUtils.getElementsText(accountActivityPage.accountOptions);
        Assert.assertNotEquals(selectOptions,actualOptions);


    }
    @Then("Transactions table should have column names")
    public void transactions_table_should_have_column_names(List<String> tableList) {

        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> actualColumns = BrowserUtils.getElementsText(accountActivityPage.tableColumns);
        System.out.println(tableList);
        System.out.println(actualColumns);

        Assert.assertEquals(tableList,actualColumns);

    }
    @Then("The user should be able to click Pay Bills")
    public void the_user_should_be_able_to_click_Pay_Bills() {
        DashBoardPage dashBoardPage = new DashBoardPage();
        dashBoardPage.payBills.click();
    }
    @Then("The user completes a successful Pay operation")
    public void the_user_completes_a_successful_Pay_operation() {
        PayBillsPage payBillsPage = new PayBillsPage();
        Select select = new Select(payBillsPage.selectPAyee);
        select.selectByVisibleText("Apple");
        Select select1 = new Select(payBillsPage.selectAccount);
        select1.selectByVisibleText("Loan");
        payBillsPage.Amount.sendKeys("300");
        payBillsPage.Date.sendKeys("23012020");
        payBillsPage.Description.sendKeys("Hej");
        payBillsPage.PayClick.click();

    }

    @Then("The user should be the message {string}")
    public void the_user_should_be_the_message(String expectedMessage) {

        PayBillsPage payBillsPage = new PayBillsPage();
            // payBill.selectPayAmount.getAttribute("validationMessage");

        String actualMessage = payBillsPage.AllAmount.getAttribute("validationMessage");
        System.out.println(payBillsPage.Amount.getAttribute("validationMessage"));
        BrowserUtils.waitFor(4);
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Then("The user completes  blank fields without date and amount")
    public void the_user_completes_blank_fields_without_date_and_amount() {
        PayBillsPage payBillsPage = new PayBillsPage();
        Select select = new Select(payBillsPage.selectPAyee);
        select.selectByVisibleText("Apple");
        Select select1 = new Select(payBillsPage.selectAccount);
        select1.selectByVisibleText("Loan");
        payBillsPage.Description.sendKeys("Hej");
        payBillsPage.PayClick.click();
        String actual= payBillsPage.Amount.getText();
        Assert.assertEquals("Please fill out this field message!", actual);
    }
    @Then("Amount field should not accept alphabetical or special characters {int}")
    public void amount_field_should_not_accept_alphabetical_or_special_characters(Integer int1) {
PayBillsPage payBillsPage= new PayBillsPage();




    }

    @Then("Date field should not accept alphabetical characters {int}")
    public void date_field_should_not_accept_alphabetical_characters(Integer int1) {

    }

}
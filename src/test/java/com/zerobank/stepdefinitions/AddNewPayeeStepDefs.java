package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Map;

public class AddNewPayeeStepDefs {


    @Given("Add New Payeetab")
    public void add_New_Payeetab() {

        Driver.get().findElement(By.linkText("Add New Payee")).click();

    }

    @Given("creates new payee usingfollowing information")
    public void creates_new_payee_usingfollowing_information(Map<String,String> userData) {

         PayBillsPage payBillsPage = new PayBillsPage();
        BrowserUtils.waitFor(3);
      payBillsPage.payeName.sendKeys(userData.get("Payee Name"));
      payBillsPage.payeeAdress.sendKeys(userData.get("Payee Address"));
        payBillsPage.payeeAccount.sendKeys(userData.get("Account"));
        payBillsPage.payeeDetails.sendKeys(userData.get("Payee details"));
        payBillsPage.AddPayee.click();



    }

    @Then("message The new payee The Law Offices of Hyde, Price & Scharks was successfully created.should be displayed")
    public void message_The_new_payee_The_Law_Offices_of_Hyde_Price_Scharks_was_successfully_created_should_be_displayed() {

PayBillsPage payBillsPage = new PayBillsPage();

Assert.assertTrue(payBillsPage.messaagePayee.isDisplayed());

    }
}
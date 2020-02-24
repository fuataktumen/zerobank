package com.zerobank.stepdefinitions;

import com.zerobank.pages.DashBoardPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class PurchaseForeignCurrencyStep {
    @Given("the user accesses the Purchase foreign currency cashtab")
    public void the_user_accesses_the_Purchase_foreign_currency_cashtab() {
        BrowserUtils.waitFor(4);
        Driver.get().findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();
    }

    @Then("following currenciesshould be available")
    public void following_currenciesshould_be_available(List<String> listOfCashTab) {

        PayBillsPage payBillsPage = new PayBillsPage();
        System.out.println("menuOptions.size = " +listOfCashTab.size());
        System.out.println("Menu options: " + listOfCashTab);
        BrowserUtils.waitFor(2);
        WebElement actualMenuOptions = Driver.get().findElement(By.id("pc_currency"));
        Select select = new Select(actualMenuOptions);
        ArrayList<String> actualMenu = new ArrayList<>();

        for (int i = 1; i < select.getOptions().size(); i++) {
            actualMenu.add(select.getOptions().get(i).getText());
        }
        System.out.println(actualMenu.toString());
        boolean isContains=false;
        for (int i = 0; i < actualMenu.size(); i++) {
            for (int j = 0; j < listOfCashTab.size(); j++) {
                if (!actualMenu.get(i).contains(listOfCashTab.get(j))) {
                    isContains=true;
                    break;
                }
            }
        }
        Assert.assertTrue(isContains);
    }


//---------------------------------------------------------------------------------------------
@When("usertries to calculate cost without selecting a currency")
public void usertries_to_calculate_cost_without_selecting_a_currency() {
BrowserUtils.waitFor(4);
new PayBillsPage().currencyAmount.sendKeys("100");
new PayBillsPage().calculateCost.click();



}

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        PayBillsPage payBillsPage = new PayBillsPage();
        BrowserUtils.waitFor(2);
        Alert alert = Driver.get().switchTo().alert();
        String actual=alert.getText();
        alert.accept();
        String expected="Please, ensure that you have filled all the required fields with valid values.";
        Assert.assertEquals(expected,actual);
       //System.out.println(alert.getText());




    }
//-------------------------------------------------------------------------------------------------------
@When("usertries to calculate cost without entering a value")
public void usertries_to_calculate_cost_without_entering_a_value() {

        BrowserUtils.waitFor(5);
    new PayBillsPage().calculateCost.click();


}


}

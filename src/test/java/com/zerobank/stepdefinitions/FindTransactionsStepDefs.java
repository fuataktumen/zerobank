package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.DashBoardPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


public class FindTransactionsStepDefs {

    @And("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        BrowserUtils.waitFor(3);

        DashBoardPage dashBoardPage = new DashBoardPage();

        dashBoardPage.accountActivity.click();
        BrowserUtils.waitFor(4);
        AccountActivityPage accountActivityPage = new AccountActivityPage();

        accountActivityPage.FindTransactions.click();

    }



    @When("the user enters date range from {string} to {string}And clicks search")
    public void the_user_enters_date_range_from_to_And_clicks_search(String string, String string2) {

        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.fromDate.sendKeys(string);
        accountActivityPage.toDate.sendKeys(string2);
        BrowserUtils.waitFor(3);
        accountActivityPage.Find.click();

    }

    @Then("results table should only show transactions dates between{string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String string, String string2) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        System.out.println(accountActivityPage.fromDate.getAttribute("value"));
        System.out.println(accountActivityPage.toDate.getAttribute("value"));
        int fromDateint=Integer.parseInt(accountActivityPage.fromDate.getAttribute("value").replace("-", ""));
        int toDate=Integer.parseInt(accountActivityPage.toDate.getAttribute("value").replace("-", ""));
        BrowserUtils.waitFor(4);
        List<WebElement> Date=Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//td[1]"));
        int columnData=0;
        List<Integer> columnsValues=new ArrayList<>();
        for (int i = 0; i < Date.size(); i++) {
            int columnsData=Integer.parseInt(Date.get(i).getText().replace("-",""));
            String[] strings1=Date.get(i).getText().split("-");
            String columnDataString=strings1[0].concat(strings1[1]).concat(strings1[2]);
            columnData=Integer.parseInt(columnDataString);
            columnsValues.add(columnData);
            System.out.println(columnData);
        }
        System.out.println(columnsValues.toString());
        int counter=0;
        for (int i = 0; i < columnsValues.size(); i++) {
            if(columnsValues.get(i)<=toDate&&columnsValues.get(i)>=fromDateint){
                counter++;
            }
            System.out.println(counter);
        }
        boolean isRange=false;
        if(columnData>=Date.size()){
            isRange=true;
        }
        Assert.assertTrue(isRange);

    }



    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {


    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }



    @Then("the results table should only not contain transactionsdated {string}")
    public void the_results_table_should_only_not_contain_transactionsdated(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    //----------------------------------------------------------------------------------------
    @When("the user enters description {string} And clicks search")
    public void the_user_enters_description_And_clicks_search(String string) {
        BrowserUtils.waitFor(3);
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.description.sendKeys(string);
        accountActivityPage.Find.click();

    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();


        for (int i = 0; i < accountActivityPage.wholeColumn.size(); i++) {


            Assert.assertTrue(accountActivityPage.wholeColumn.get(i).getText().contains(string));
        }


    }

    @Then("results table should notshow descriptions containing {string}")
    public void results_table_should_notshow_descriptions_containing(String string) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();


        for (int i = 0; i < accountActivityPage.wholeColumn.size(); i++) {


            Assert.assertFalse(accountActivityPage.wholeColumn.get(i).getText().contains(string+" "));
        }

    }
    //------------------------------------------------------


    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {
        BrowserUtils.waitFor(3);
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.description.sendKeys(string);
        accountActivityPage.Find.click();
    }
//--------------------------------------------------------------------------------

    @And("clicks search")
    public void clicks_search() {

        BrowserUtils.waitFor(4);
        AccountActivityPage accountActivityPage = new AccountActivityPage();

        accountActivityPage.Find.click();
    }
    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {

        BrowserUtils.waitFor(4);
      Assert.assertFalse(Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_" +
              "for_account']/table/tbody/tr/td[3]")).getText().isEmpty());
      BrowserUtils.waitFor(4);
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
int a =0;

        List<WebElement> optionOfWithdraw=Driver.get().findElements(By.xpath("(//table[@class='table table-condensed" +
                " table-hover'])[2]//tbody/tr/td[" + a +"]"));


        if( a /4==0){

            for (int i = 0; i <4 ; i++) {


                BrowserUtils.waitFor(4);
                Assert.assertFalse(optionOfWithdraw.get(i).getText().isEmpty());
                BrowserUtils.waitFor(4);
            }
        }
    }

    @When("user selects type {string}Then results table should show at least one result under Deposit")
    public void user_selects_type_Then_results_table_should_show_at_least_one_result_under_Deposit(String string) {
        Select select = new Select(Driver.get().findElement(By.id("aa_type")));
        select.selectByVisibleText(string);
        BrowserUtils.waitFor(3);
        Assert.assertFalse(Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_" +
                "for_account']/table/tbody/tr/td[3]")).getText().isEmpty());
        BrowserUtils.waitFor(4);
    }

    @But("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        Select select = new Select(Driver.get().findElement(By.id("aa_type")));
        select.selectByVisibleText("Deposit");

        BrowserUtils.waitFor(4);
        int a =0;
        if(a /4==0){
            for (int i = 0; i <50 ; i++) {


                Assert.assertTrue(Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_" +
                        "for_account']/table/tbody/tr/td[" + a + "]")).get(i).getText().isEmpty());
            }
        }

    }

    @When("user selects type {string}")
    public void user_selects_type(String string) {
        Select select = new Select(Driver.get().findElement(By.id("aa_type")));

        select.selectByVisibleText(string);
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        Select select = new Select(Driver.get().findElement(By.id("aa_type")));
        select.selectByVisibleText("Withdrawal");
        BrowserUtils.waitFor(4);
        int a =0;
        if(a /3==0){
            for (int i = 0; i <50 ; i++) {


                Assert.assertTrue(Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_" +
                        "for_account']/table/tbody/tr/td[" + a + "]")).get(i).getText().isEmpty());
            }
        }
    }
}



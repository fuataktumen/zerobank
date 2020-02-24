package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountActivityPage extends BasePage {

    @FindBy(id = "aa_accountId")
    public WebElement defaultOption;

    @FindBy(css = "[id='aa_accountId']>option")
    public List<WebElement> accountOptions;

    @FindBy(css= "table[class^='t']>thead>tr>th")
    public List<WebElement> tableColumns;

    @FindBy(xpath= "//a[text()='Find Transactions']")
    public WebElement FindTransactions;


    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;

    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    @FindBy (css = "[type='submit']")
    public WebElement Find;

    @FindBy (xpath = "((//table[@class='table table-condensed table-hover'])[2]//tbody/tr/td)[1]")
    public WebElement DateOfTable1;

    @FindBy (xpath = "((//table[@class='table table-condensed table-hover'])[2]//tbody/tr/td)[5]")
    public WebElement DateOfTAble2;

    @FindBy (xpath = "((//table[@class='table table-condensed table-hover'])[2]//tbody/tr/td)[9]")
    public WebElement DateOfTable3;

    @FindBy(id = "aa_description")
    public WebElement description;

    @FindBy(id = "//div[@id='filtered_transactions_for_account']/table/tbody/tr")
    public List<WebElement> wholeColumn;



}

package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummaryPage extends BasePage {

    @FindBy(id = "account_summary_tab")
   public WebElement accountSummaryTab;

    @FindBy(xpath = "//h2[1]")
   public WebElement CashAccount;

    @FindBy(xpath = "//h2[2]")
   public WebElement investmentAccounts;

    @FindBy(xpath = "//h2[3]")
    public WebElement creditAccounts;

    @FindBy(xpath = "//h2[4]")
   public  WebElement loanAccounts;

    @FindBy(xpath = "//h2")
    public List<WebElement> ListOfTitle;

    @FindBy (xpath = "(//div[@class='board-content'])[3]//thead/tr/th")
    public List<WebElement> ColumnOfCreditAccounts;

   @FindBy (xpath = "(//a[text()='Savings'])[1]")
    public WebElement Savings;

    @FindBy (xpath = "//a[text()='Brokerage']")
    public WebElement Brokerage;

    @FindBy (xpath = "//a[text()='Checking']")
    public WebElement Checking;

    @FindBy (xpath = "//a[text()='Credit Card']")
    public WebElement CreditCard;

    @FindBy (xpath = "//a[text()='Loan']")
    public WebElement Loan;
}

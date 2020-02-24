package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    @FindBy(id = "account_summary_tab")
   public  WebElement accountSummary;

    @FindBy(id = "account_activity_tab")
    public WebElement accountActivity;

    @FindBy(id = "transfer_funds_tab")
   public  WebElement transferFunds;

    @FindBy(id = "pay_bills_tab")
    public WebElement payBills;


    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }


}



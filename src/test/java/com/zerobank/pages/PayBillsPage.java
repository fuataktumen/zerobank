package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PayBillsPage extends BasePage {

    @FindBy(id = "sp_payee")
    public WebElement selectPAyee;

    @FindBy(id = "sp_account")
    public WebElement selectAccount;

    @FindBy (css = "#sp_amount")
    public WebElement Amount;

    @FindBy(id = " (//div [@class='controls'])[3]")
    public WebElement AllAmount;


    @FindBy(id = "sp_date")
    public WebElement Date;

    @FindBy(id = "sp_description")
    public WebElement Description;

    @FindBy(id = "pay_saved_payees")
    public WebElement PayClick;

    @FindBy(id = "alert_content")
    public WebElement confirmMessage;

    @FindBy(id = "pc_currency")
    public WebElement currency;

    @FindBy(id ="[id='pc_currency']>option")
    public List<WebElement> currencyOption;

    @FindBy(id = "np_new_payee_name")
    public WebElement payeName;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAdress;

    @FindBy(id = "np_new_payee_account")
    public WebElement payeeAccount;

    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetails;

    @FindBy(id = "add_new_payee")
    public WebElement AddPayee;

    @FindBy(id = "alert_content")
    public WebElement messaagePayee;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCost;

    @FindBy(id = "pc_amount")
    public WebElement currencyAmount;

}

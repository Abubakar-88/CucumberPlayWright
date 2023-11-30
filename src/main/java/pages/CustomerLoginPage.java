package pages;

import base.BasePage;

public class CustomerLoginPage extends BasePage {
   public void clickOnCustomerLoginMenu(){
        click("customerLoginMenu");
    }
    public void customerUserIdInputFunction(String value){
       type("custUserIdInput",value);

    }

    public void customerUserPasswordInputFunction(String value){
        type("custUserPasswordInput",value);

    }

    public void clickOnCustLoginButton(){
       click("custLoginButton");
    }
}

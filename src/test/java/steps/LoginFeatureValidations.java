package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import base.BasePage;
import pages.CustomerHomePage;
import pages.CustomerLoginPage;
import pages.LandingPage;
import utils.ExcelReader;
import utils.PlaywrightDriver;

public class LoginFeatureValidations extends BasePage{
    LandingPage landingPage = new LandingPage();
    CustomerLoginPage customerLoginPage = new CustomerLoginPage();
    CustomerHomePage customerHomePage = new CustomerHomePage();
    
    String email;
    String password;
    @Given("I am in landing page")
    public void i_am_in_landing_page() {
        PlaywrightDriver.openPage(PlaywrightDriver.config.getProperty("testsiteurl"));
    }


    @When("I Click on Login menu")
    public void i_click_on_login_menu() {
        landingPage.clickOnLoginMenu();
    }

    @When("Click on Customer Login")
    public void click_on_customer_login() throws InterruptedException {
        Thread.sleep(3000);
        customerLoginPage.clickOnCustomerLoginMenu();
    }
    @When("I am Taking data from excel {string} and {int}")
    public void i_am_Taking_data_from_excel_and(String sheetName, int rowNumber) throws InvalidFormatException, IOException {
    	reader = new ExcelReader();
		List<Map<String,String>> readData = 
				reader.getData(System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\loginData.xlsx", sheetName);	
		 email = readData.get(rowNumber).get("Email");
		 password = readData.get(rowNumber).get("Password"); 
    }
    
    @Then("I Enter UserId")
    public void enter_userid ()throws InterruptedException {

       customerLoginPage.customerUserIdInputFunction(email);
        Thread.sleep(2000);
    }

    @Then("I Enter Password")
    public void i_enter_password() throws InterruptedException {
        customerLoginPage.customerUserPasswordInputFunction(password);
        Thread.sleep(3000);
    }

    @Then("I Click on Login Button")
    public void i_click_on_login_button() {
        customerLoginPage.clickOnCustLoginButton();
    }

    @Then("Verify that I am in CUSTOMER Home Page")
    public void verify_that_i_am_in_customer_home_page() {
        String expectedText = customerHomePage.customerHomePageText();
        System.out.println(expectedText);
        Assert.assertEquals("Customer Id: 444",expectedText);
    }

}

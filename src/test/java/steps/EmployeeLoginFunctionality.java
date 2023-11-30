package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.EmployeeLoginPage;
import pages.LandingPage;
import utils.ExcelReader;
import utils.PlaywrightDriver;

import java.util.List;
import java.util.Map;

import base.BasePage;

public class EmployeeLoginFunctionality extends BasePage{
//    ExcelReader excelReader = new ExcelReader();
////    public static List<Map<String,String>> testData;
////    testData =
//public static List<Map<String,String>> testData;
//testData
	
//    testData = excelReader.getData(System.getProperty("user.dir") + "\\src\\main\\resources\\testData\\loginData.xlsx", "loginTestData");
    LandingPage landingPage = new LandingPage();
    EmployeeLoginPage employeeLoginPage = new EmployeeLoginPage();
    @Given("I am in Landing Page")
    public void i_am_in_landing_page() {
        PlaywrightDriver.openPage(PlaywrightDriver.config.getProperty("testsiteurl"));
    }

    @Then("I click on Login Menu")
    public void i_click_on_login_menu() {
        landingPage.clickOnLoginMenu();
    }

    @Then("I click on Employee Login Menu")
    public void i_click_on_employee_login_menu() {
        employeeLoginPage.clickOnEmployeeLoginMenu();
    }

    @Then("I Enter Employee User Id and Password from {string} and {int}")
    public void i_enter_employee_user_id_and_password_from_and(String string, Integer int1) {
//        testData = excelReader.getData(System.getProperty("user.dir") + "\\src\\main\\resources\\testData\\loginData.xlsx", "loginTestData");
//        String userId = testData.get(rowNumber).get("empUserId");
//        String password = testData.get(rowNumber).get("empPassword");
//        sendKeys(EmployeeLoginPage.textEmployeeUserId, userId);
//        sendKeys(EmployeeLoginPage.textEmployeePassword, password);
    }

    @When("I click on Employee Login button")
    public void i_click_on_employee_login_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Verify I am in Employee Home Page")
    public void verify_i_am_in_employee_home_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}

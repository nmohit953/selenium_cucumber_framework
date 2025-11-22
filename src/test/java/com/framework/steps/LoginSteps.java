package com.framework.steps;

import com.framework.utils.DriverFactory;
import com.framework.utils.PropertiesReader;
import com.framework.utils.SoftAssertManager;
import com.framework.pages.LoginPage;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.*;

public class LoginSteps {

    LoginPage login = new LoginPage(DriverFactory.getDriver());

    @Given("user is on the SauceDemo login page")
    public void user_on_login_page() {
        String url = PropertiesReader.get("baseUrl");
        DriverFactory.getDriver().get(url);
    }

    @When("user enters {string} and {string}")
    public void user_logs_in(String Username, String Password) {
        login.login(Username,Password);
    }

    @Then("login should {string}")
    public void verify_products_page(String Result) {
    	
    	if(Result.equalsIgnoreCase("Success")) {
    		SoftAssert softAssert = SoftAssertManager.getSoftAssert();
    		softAssert.assertTrue(DriverFactory.getDriver().getTitle().equalsIgnoreCase("Swag Labs"));
        	}
        else {
        	
        		System.out.println(login.getErrorMessage());
        		
        	}
    }
}

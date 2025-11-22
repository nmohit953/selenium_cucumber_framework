package com.framework.steps;

import com.framework.utils.DriverFactory;
import com.framework.utils.PropertiesReader;
import com.framework.pages.LoginPage;

import org.testng.Assert;
import io.cucumber.java.en.*;

public class LoginSteps {

    LoginPage login = new LoginPage(DriverFactory.getDriver());

    @Given("user is on the SauceDemo login page")
    public void user_on_login_page() {
        String url = PropertiesReader.get("baseUrl");
        DriverFactory.getDriver().get(url);
    }

    @When("user logs in with valid credentials")
    public void user_logs_in() {
        login.login("standard_user","secret_sauce");
    }

    @Then("user should be redirected to the products page")
    public void verify_products_page() {
        Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("inventory"));
    }
}

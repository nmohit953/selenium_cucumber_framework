package com.framework.hooks;

import com.framework.utils.DriverFactory;
import com.framework.utils.ExtentManager;
import com.framework.utils.SoftAssertManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.*;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import java.util.UUID;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.initDriver(); // initialize WebDriver before scenario
    }

    @After
    public void tearDown() {
    
    	SoftAssertManager.assertAll();
        DriverFactory.quitDriver(); // quit WebDriver after scenario
    }
}

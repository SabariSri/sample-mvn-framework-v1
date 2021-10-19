package com.trials.sample_mvn_framework_v1.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.trials.sample_mvn_framework_v1.utils.report.CustomExtentReports;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public WebDriver driver;

	public CustomExtentReports report = new CustomExtentReports();

	@BeforeSuite
	public void beforeSuite() {
		report.startReport();
	}

	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//lib//mac_chromedriver_77");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
		report.endTest();
		driver.close();
		driver.quit();
	}

	@AfterSuite
	public void afterSuite() {
		report.endReport();
	}

}

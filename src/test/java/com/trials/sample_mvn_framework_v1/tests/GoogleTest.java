package com.trials.sample_mvn_framework_v1.tests;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.trials.sample_mvn_framework_v1.base.TestActions;
import com.trials.sample_mvn_framework_v1.pages.GoogleHomePage;

@Test(dataProvider = "sampleTest", dataProviderClass = com.trials.sample_mvn_framework_v1.utils.dataprovider.TestDataProviders.class)
public class GoogleTest extends TestActions {
	public void sampleTest(HashMap<String,String> data) {

		report.startTest("Test-Trial001");
		launchUrl("https://www.google.co.in");

		GoogleHomePage homePage = PageFactory.initElements(driver, GoogleHomePage.class);

		homePage.searchAndVerify(data.get("SearchKey"));
	}
}

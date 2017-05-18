package com.octo.calculator.automation;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;
import static org.apache.commons.lang3.StringUtils.join;

public class multiplicationTest {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://ec2-54-219-133-160.us-west-1.compute.amazonaws.com:8080/Calculator/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testMultiplication() throws Exception {
		selenium.open("/Calculator/");
		selenium.type("name=number1", "2");
		selenium.type("name=number2", "3");
		selenium.select("name=mathOperation", "label=Multiplication *");
		selenium.click("css=input[type=\"submit\"]");
		selenium.waitForPageToLoad("30000");
		verifyEquals("Hello Result!!!! The result is :6\n Go Back", selenium.getText("css=html"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}

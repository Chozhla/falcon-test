package test.smoke;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import lib.ui.CreateDriver;
import lib.ui.Loginpage;

public class Testsample {
	WebDriver driver;
	Loginpage login;
	@BeforeMethod
	public void preCondition()
	{
		driver=CreateDriver.getBrowserInstance();
		login=new Loginpage(driver);
	}

	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}
	@Test
	public void testsample()
	{
		String actualTitle=driver.getTitle();
		String expectedTitle="actiTIME-Login";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	

}

package lib.ui;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loginpage
{
	WebDriver driver;
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
	}
public WebElement getUsernameTextbox()
{
	try {
		WebElement un=driver.findElement(By.name("username"));
		return un;
	}
	catch(Exception e)
	{
		return null;
	}
}
public WebElement getPasswordTextbox()
{
	try
	{
		return driver.findElement(By.name("pwd"));
	
	}
	catch(Exception e)
	{
		return null;
	}
}
public WebElement getLoginButton()
{
	try
	{
		return driver.findElement(By.xpath("//input[@type='submit]"));
	}
	catch(Exception e)
	{
		return null;
		
	}
}
public WebElement getLoginErrorMsg()
{
	try
	{
		return driver.findElement(By.xpath("//span[text()='Username or Password is Invalid.Please try again"));
	}
	catch(Exception e)
	{
		return null;
	}
}
public void waitForLoginPageToLoad()
{
	WebDriverWait wait=new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOf(getUsernameTextbox()));
	wait.until(ExpectedConditions.visibilityOf(getPasswordTextbox()));
	wait.until(ExpectedConditions.visibilityOf(getLoginButton()));
}
}
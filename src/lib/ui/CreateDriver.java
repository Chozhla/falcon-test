package lib.ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CreateDriver {

	public static WebDriver getBrowserInstance() {
		// TODO Auto-generated method stub
		WebDriver driver=null;
		String browser=DataHandlers.getDataFromProperties1("configuration","browser");
		String url=DataHandlers.getDataFromProperties1("configuration","url");
		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./browser-servers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.driver","./browser-servers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver","./browser-servers/iedriver.exe");
			driver=new InternetExplorerDriver();
		}
		else
		{
		System.err.println("=======Invalid Browser option check configuration.Properties"+"file in config-data folder=======");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if(url.equalsIgnoreCase("prod"))
		{
			driver.get("http)://demo.actitime.com");
		}
		else
		{
			driver.get("http://localhost");
		}
		return driver;
		}
	
	}



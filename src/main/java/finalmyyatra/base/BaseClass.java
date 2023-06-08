package finalmyyatra.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import finalmyyatra.utilities.ExtentManager;
import finalmyyatra.utilities.Log;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	public static Properties prop;
	public static FileInputStream fis;
	@BeforeSuite
	public void loadConfig() throws IOException {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		 prop = new Properties ();
		 fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		 prop.load(fis);
	}
	public static WebDriver getDriver() {
		return driver.get();
	}
	public void launchBrowser() {
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
//			if (System.getProperty("browser").equalsIgnoreCase("chrome")) 
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		}
		else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		}else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		}else {
			System.out.println("enter valid browser : ");
		}
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().window().maximize();
		
	}
	@AfterSuite
	public void endExtent() {
		Log.info("end program");
		ExtentManager.endExtent();
		
	}
}

package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/*
 * This class returns a WebDriver object using 3 overloaded .get() methods:
 * 1. get() - default
 * 2. get(String browserType)
 * 3. get(String browserType, String webURL)
 */

public class base {
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	public WebDriver driver;
	
	//String rootFolder = System.getProperty("user.dir")+"\\resources\\drivers\\";
	
	// Write a function that returns a default WebDriver (user does not specify)
	/*
	 * public static WebDriver initializeDriver() { WebDriver driver;
	 * System.out.println("Opening chrome browser");
	 * System.setProperty("webdriver.chrome.driver",
	 * System.getProperty("user.dir")+"\\resources\\drivers\\" + "chromedriver.exe")
	 * ; driver = new ChromeDriver(); return driver; }
	 */
	
	// Write a function that returns a WebDriver when user sends desired browser
	/*
	 * public static WebDriver initializeDriver(String browserType) throws
	 * IOException { WebDriver driver; browserType = (String)
	 * getPropData("browser"); if (browserType.equalsIgnoreCase("Chrome")) {
	 * System.out.println("Opening chrome browser");
	 * System.setProperty("webdriver.chrome.driver",
	 * System.getProperty("user.dir")+"\\resources\\drivers\\" + "chromedriver.exe")
	 * ; driver = new ChromeDriver(); } else if
	 * (browserType.equalsIgnoreCase("Firefox")) {
	 * System.out.println("Opening Firefox browser");
	 * System.setProperty("webdriver.gecko.driver",
	 * System.getProperty("user.dir")+"\\resources\\drivers\\" + "geckodriver.exe");
	 * driver = new FirefoxDriver(); } else if (browserType.equalsIgnoreCase("IE"))
	 * { System.out.println("Opening IE browser");
	 * System.setProperty("webdriver.ie.driver",
	 * System.getProperty("user.dir")+"\\resources\\drivers\\" + "IEDriverServer.exe
	 * "); driver = new InternetExplorerDriver(); } else {
	 * System.out.println("Could not understand input. Will open Chrome as default"
	 * ); System.setProperty("webdriver.chrome.driver",
	 * System.getProperty("user.dir")+"\\resources\\drivers\\" + "chromedriver.exe")
	 * ; driver = new ChromeDriver(); } setConfigs(driver); return driver; }
	 */	
	// Exercise: write one more overloaded method, that includes the URL the user wants to test
	@BeforeSuite
	public  WebDriver initializeDriver() throws IOException {
		//WebDriver driver;
		String browserType = (String) getPropData("browser");
		String webURL = (String) getPropData("prodENV");
		if (browserType.equalsIgnoreCase("Chrome")) {
			System.out.println("Opening chrome browser");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\drivers\\" + "chromedriver.exe");
			driver = new ChromeDriver();
			log.error("Chrome browser launched");
		}
		else if (browserType.equalsIgnoreCase("Firefox")) {
			System.out.println("Opening Firefox browser");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\resources\\drivers\\" + "geckodriver.exe");
			driver = new FirefoxDriver();
			log.info("Firefox browser launched");
		}
		else if (browserType.equalsIgnoreCase("IE")) {
			System.out.println("Opening IE browser");
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\resources\\drivers\\" + "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			log.info("IE browser launched");
		}
		else {
			System.out.println("Could not understand input. Will open Chrome as default");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\drivers\\" + "chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Could not understand input. Will open Chrome as default");
		}
		driver.get(webURL);
		setConfigs(driver);
		return driver;
	}
	
	// This function returns a WebDriver with maximized window and 3 second wait
		private static void setConfigs(WebDriver driver) {
			System.out.println("Setup basic WebDriver configurations");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		}
		
	//This function reads the properties file
		public static Object getPropData(String key) throws IOException {
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\utilities\\Global.properties");
			prop.load(fis);
			return prop.get(key);
		}
	
	@AfterSuite
	public void tearDown() {
		
		driver.quit();
	}
	
	public void getScreenShot() {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		
	}
	
}

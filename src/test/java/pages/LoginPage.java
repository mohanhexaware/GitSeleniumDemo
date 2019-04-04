package pages;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utilities.base;

public class LoginPage {
	WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());

	// Define webelements at class level
	@FindBy(name = "identifier")
	WebElement emailID;

	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement nextButton;

	@FindBy(name= "password")
	WebElement passwordBox;

	
	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement loginButton;

	// Steps
	public void setUserName(String userName) {
		emailID.sendKeys(userName);

	}

	public void clickNextBtn() {
		nextButton.click();

	}
	
	public void setPassword(String password) {
		passwordBox.sendKeys(password);
	}

	public void clickSubmit() {
		loginButton.click();
	}

	// Actions
	public void login(String userName, String password) {
		setUserName(userName);
		clickNextBtn();
		setPassword(password);
		//clickSubmit();
	}

	// Constructor initializes the state of the driver
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		/*
		 * WebDriverWait d = new WebDriverWait(driver, 5); DesiredCapabilities ch =
		 * DesiredCapabilities.chrome(); ch.acceptInsecureCerts(); ChromeOptions c = new
		 * ChromeOptions(); c.merge(ch);
		 */		
		
		PageFactory.initElements(driver, this);
		
		
		
	}
}

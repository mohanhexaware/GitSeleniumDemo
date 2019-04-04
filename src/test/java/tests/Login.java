package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


import utilities.base;
import pages.*;

public class Login extends base{
	//public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@Test
	public void loginTestPOM() throws IOException {
		String userName = "mohansiddhart@gmail.com";
		String password = "test";
		
		//WebDriver driver = utilities.base.initializeDriver();
		

		
		LoginPage loginPage = new LoginPage(driver); 
		loginPage.login(userName,password);
				

	}
}

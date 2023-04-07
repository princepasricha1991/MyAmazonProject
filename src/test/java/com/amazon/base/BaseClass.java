package com.amazon.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import com.amazon.actiondriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	
	

	public static Properties prop = new Properties();// to read from properties file
	public static WebDriver driver;
	

	// Step 1
	public BaseClass() {
		try {
			FileInputStream file = new FileInputStream(
					"C:\\JavaClass\\MyAmazonProject\\src\\test\\java\\Cinfiguration\\Config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static void launchBrowser() {

		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		 else if (browserName.equals("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			
		
		
		Action action = new Action();
		action.implicitWait(driver, 15);;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));

	}

}

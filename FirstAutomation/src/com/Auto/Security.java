package com.Auto;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.BitSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Security {

	public static String sEmail = "SureshGnanasekar";
	public static String sPassword = "123456789";
	public static WebDriver browser;


	public static WebElement getXpath(String xpath)
	{		 
		WebElement element = browser.findElement(By.xpath(xpath));		 
		return element;
	}

	public static void LoadUrl(String url)
	{		
		browser.manage().window().maximize();
		browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		browser.get(url);
	}

	public static void loadDriver()
	{
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sures\\eclipse-workspace\\FirstAutomation\\Drivers\\msedgedriver.exe");	
		browser = new EdgeDriver();
		browser.manage().window().maximize();
	}
	public static void MousePerform( WebElement Element)
	{
		Actions acc = new Actions(browser);
		acc.moveToElement(Element).perform();
	}

	public static void KeyPressDown(int Count) throws AWTException 
	{
		Robot rbt = new Robot();
		for (int i = 0; i < Count; i++) {			 
			rbt.keyPress(KeyEvent.VK_DOWN);
			rbt.keyRelease(KeyEvent.VK_DOWN);				
		}
		rbt.keyPress(KeyEvent.VK_ENTER);

	}

	public static void insertValueByScript(String Xpath,String value)
	{
		WebElement element = browser.findElement(By.xpath(Xpath));
		JavascriptExecutor js = (JavascriptExecutor) browser;  //Type Casting
		js.executeScript("arguments[0].setAttribute('value','"+value+"')", element);

	}

	public static void clickByScript(String Xpath)
	{
		WebElement element = browser.findElement(By.xpath(Xpath));
		JavascriptExecutor js = (JavascriptExecutor) browser;
		js.executeScript("arguments[0].click()", element);
	}

	public static String getAttributeByScript(String Xpath)
	{
		WebElement element = browser.findElement(By.xpath(Xpath));		 
		JavascriptExecutor js = (JavascriptExecutor) browser;  //Type Casting
		Object script = js.executeScript("return arguments[0].getAttribute('value')", element);
		String s= (String) script;
		return s;
	}

	public static void scrollUpandDown(String Xpath,boolean type)
	{
		WebElement element = browser.findElement(By.xpath(Xpath));
		JavascriptExecutor js = (JavascriptExecutor) browser;  //Type Casting
		js.executeScript("arguments[0].scrollIntoView("+type+")", element);
	}

	public static WebElement findElementByid(String id)
	{
		WebElement element = browser.findElement(By.id(id));
		return element;
	}
	public static WebElement findElementByName(String name) 
	{
		WebElement element = browser.findElement(By.name(name));
		return element;
	}

	public static void adactinNewRegistrationPage(String Username, String Pass, String ConfirmPass, String Fullname, String Email, String Captcha,Boolean Agree)
	{
		WebElement txtUsername = findElementByid("username");	
		txtUsername.sendKeys(Username);
		WebElement txtPassword = findElementByid("password");
		txtPassword.sendKeys(Pass);
		WebElement txtConfirmPass = findElementByid("re_password");
		txtConfirmPass.sendKeys(ConfirmPass);
		WebElement txtFullName = findElementByid("full_name");
		txtFullName.sendKeys(Fullname);
		WebElement txtEmail = findElementByid("email_add");
		txtEmail.sendKeys(Email);
		WebElement txtCaptcha = findElementByid("captcha-form");
		txtCaptcha.sendKeys(Captcha);
		WebElement chkAgree = findElementByid("tnc_box");
		if(Agree)
		{
			chkAgree.click();
		}
		WebElement btnSubmit = findElementByid("Submit");
		btnSubmit.click();
	}

	
}

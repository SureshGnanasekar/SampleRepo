package com.Auto;



import java.awt.AWTException;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OpenMicrosoftEdge extends Security {

	public static void main(String[] args) throws Exception {

		//automate();
		//automatebyXpath("Youtube videos");
		//automatebyXpathWithoutAttribute();
		//referenceMethod();
		//MouseOver();
		//ScriptWrite();
		//AdvancedConcept(3000);
		//DropDownConcept();
		//WindowsHandling();
		//adactinLogin(sEmail,sPassword);
		New();
	}

	public static void automate() {

		System.setProperty("webdriver.edge.driver", "C:\\Users\\sures\\eclipse-workspace\\FirstAutomation\\Drivers\\msedgedriver.exe");	
		WebDriver driver= new EdgeDriver();
		driver.get("https://www.google.co.in/");		 
		WebElement SearchGoogle = driver.findElement(By.name("q")); 
		WebElement btnSearch = driver.findElement(By.name("btnK")); 
		SearchGoogle.sendKeys("Youtube videos");
		btnSearch.submit();	
		driver.quit();
	}


	public static void automatebyXpath(String gSearch)
	{
		System.setProperty("webdriver.edge.driver", 
				"C:\\\\Users\\\\sures\\\\eclipse-workspace\\\\FirstAutomation\\\\Drivers\\\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		WebElement txtSearch = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
		txtSearch.sendKeys(gSearch);
		WebElement btnSearch = driver.findElement(By.xpath("(//input[@class ='gNO89b'])[2]"));
		//WebElement btnSearch = driver.findElement(By.xpath("(//input[@type = 'submit'])[3]")); 
		btnSearch.click();
		WebElement LinkYoutube = driver.findElement(By.xpath("(//h3[@class='LC20lb DKV0Md'])[1]"));
		LinkYoutube.click();		
	}

	public static void automatebyXpathWithoutAttribute() throws InterruptedException
	{
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sures\\eclipse-workspace\\FirstAutomation\\Drivers\\msedgedriver.exe");	
		WebDriver browser = new EdgeDriver();
		browser.manage().window().maximize();
		browser.get("https://en-gb.facebook.com/");
		WebElement txtUsername = browser.findElement(By.xpath("//input[contains(@placeholder,'Email')]"));
		if(txtUsername.isDisplayed() && txtUsername.isEnabled())
		{
			//Enter the username
			txtUsername.sendKeys(sEmail);	// getting username from another class for Secure purpose
			//getting username value from attribute 		
			String getUsername = txtUsername.getAttribute("value");
			System.out.println("username : "+getUsername);
		}
		WebElement txtPassword = browser.findElement(By.xpath("//input[@placeholder = 'Password']"));	
		if(txtPassword.isDisplayed() && txtPassword.isEnabled())
		{
			//Enter the Password
			txtPassword.sendKeys(sPassword);  // getting password from another class for Secure purpose
			//getting password from attribute	
			String getPassword = txtPassword.getAttribute("value");
			System.out.println("Password : "+getPassword);
		}
		WebElement btnSubmit = browser.findElement(By.xpath("//button[contains(@type,Sub)]"));
		if(btnSubmit.isEnabled()) 
		{
			//Click Submit
			btnSubmit.click();	
		}
		Thread.sleep(3000);
		browser.get("https://www.verizon.com/");
		Thread.sleep(5000);
		browser.navigate().back();
		Thread.sleep(5000);
		browser.navigate().forward();
		Thread.sleep(5000);
		browser.navigate().refresh();
		//Close the browser		
		browser.quit();
	}

	public static void referenceMethod() throws InterruptedException 
	{
		loadDriver();
		WebDriver browser = new EdgeDriver();
		LoadUrl("https://en-gb.facebook.com/");		
		WebElement Username = getXpath("//input[contains(@placeholder,'Email')]");
		WebElement password = getXpath("//input[@placeholder = 'Password']");
		Username.sendKeys(sEmail);
		password.sendKeys(sPassword);
		WebElement btnSubmit = getXpath("//button[contains(@type,Sub)]");
		btnSubmit.click();
		Thread.sleep(5000);		
		browser.quit();
	}

	public static void MouseOver() throws InterruptedException, AWTException
	{
		loadDriver();
		WebDriver browser = new EdgeDriver();
		LoadUrl( "http://greenstech.in/");
		WebElement OvrCourses = getXpath( "//li[@class  = 'dropdown mega-dropdown']");
		Thread.sleep(10000);
		Actions ac = new Actions(browser);
		MousePerform( OvrCourses);		
		WebElement OvrSoftware = getXpath( "(//i[@class = 'fa fa-caret-right'])[5]");
		MousePerform( OvrSoftware);
		WebElement SeleniumTraining = getXpath( "//a[text() = 'Selenium Training']");
		ac.contextClick(SeleniumTraining).perform();		
		KeyPressDown(1);  // To open the site on another tab					
	}

	public static void ScriptWrite() throws Exception
	{
		loadDriver();
		
		LoadUrl( "https://www.google.co.in/");	
		
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		insertValueByScript( "//input[@type = 'text']", "Hello Google");

		String getstring = getAttributeByScript( "//input[@type = 'text']");

		clickByScript( "(//input[@value= 'Google Search'])[2]");

		LoadUrl( "https://www.facebook.com/");	

		insertValueByScript( "//input[@type = 'text']", getstring);

		LoadUrl( "https://www.amazon.in/");	

		scrollUpandDown( "(//a[text() = 'Your Account'])[1]", true);

		WebElement LinkAccount = getXpath( "(//a[text() = 'Your Account'])[1]");

		TakesScreenshot tks = (TakesScreenshot) browser;

		File FromLocation = tks.getScreenshotAs(OutputType.FILE);

		File ToLocation = new File("C:\\Users\\sures\\eclipse-workspace\\FirstAutomation\\Screenshots\\Sample1.png");

		FileUtils.copyFile(FromLocation, ToLocation);

		Thread.sleep(3000);

		LinkAccount.click();

	}

	public static void AdvancedConcept(int WaitingTime) throws InterruptedException
	{
		loadDriver();
		LoadUrl("http://demo.automationtesting.in/Alerts.html");
		WebElement btnOK = getXpath("(//a[@class = 'analystic'])[3]");
		btnOK.click();
		Thread.sleep(1000);
		WebElement btnalert = getXpath("//button[@onclick = 'promptbox()']");
		btnalert.click();
		Thread.sleep(WaitingTime);
		Alert alert = browser.switchTo().alert();
		Thread.sleep(5000);
		alert.sendKeys("Sureshkumar");		
		alert.accept();	
	}

	public static void DropDownConcept()
	{
		loadDriver();
		LoadUrl("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		WebElement ddSingle = browser.findElement(By.id("multi-select"));
		Select s =new Select(ddSingle);
		
		if(s.isMultiple())
		{
			s.selectByValue("New Jersey");
			s.selectByVisibleText("Ohio");

		}
		List<WebElement> ddOptions = s.getOptions();
		for (int i = 0; i < ddOptions.size(); i++) {
			WebElement element = ddOptions.get(i);
			String text = element.getText();
			System.out.println(text);
		}
		System.out.println("***************************************************");
		System.out.println("***************************************************");
		System.out.println("***************************************************");
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		for (int i = 0; i < allSelectedOptions.size(); i++)
		{
			WebElement webElement = allSelectedOptions.get(i);	
			String text = webElement.getText();
			System.out.println(text);
		}
	}

	public static void WindowsHandling() throws Exception
	{
		loadDriver();

		browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		LoadUrl("https://www.amazon.in/");

		String ParentWindowId = browser.getWindowHandle();

		WebElement txtSearch = getXpath("//input[@id ='twotabsearchtextbox']");

		txtSearch.sendKeys("Oneplus 7 pro",Keys.ENTER);

		WebElement linkPhone = getXpath("(//span[@class ='a-size-medium a-color-base a-text-normal'])[1]");

		linkPhone.click();

		Set<String> getTabId = browser.getWindowHandles();

		for (String CurrentWindow : getTabId) 
		{
			if(!CurrentWindow.equals(ParentWindowId))
			{

				browser.switchTo().window(CurrentWindow);

				WebElement LinkMobile = getXpath("(//span[@class = 'nav-a-content'])[2]");

				Actions acc = new Actions(browser);

				acc.contextClick(LinkMobile).perform();

				KeyPressDown(1);

				System.out.println(ParentWindowId);
			}
		}

		getTabId = browser.getWindowHandles();
		System.out.println(getTabId);		
	}
	
	public static void adactinLogin(String Username, String Pass)
	{
		loadDriver();
		LoadUrl("http://adactinhotelapp.com/index.php");
		WebElement txtUsername = findElementByid("username");	
		txtUsername.sendKeys(Username);
		WebElement txtPassword = findElementByid("password");
		txtPassword.sendKeys(Pass);
		WebElement btnSubmit = findElementByid("login");
		btnSubmit.click();
		//Next Page
		adactinSearchHotel(1, 2, 2, 3, "10/07/2021", "11/07/2021", 3, 1);
		WebElement rdHotel = findElementByid("radiobutton_0");
		rdHotel.click();
		WebElement btnContinue = findElementByid("continue");
		btnContinue.click();
		Payment("Suresh", "Gnanasekar", "Chennai", "1234567890123456", 2, "April", "2022", "123");
	}
	
	public static void adactinSearchHotel(int locationIndex,int hotelIndex,int RoomTypeIndex,int RoomCountIndex,String CheckIn, String CheckOut,
			int AdultCountIndex,int ChildCountIndex)
	{
		WebElement ddLocation = findElementByid("location");
		Select s = new Select(ddLocation);
		s.selectByIndex(locationIndex);
		WebElement ddHotels = findElementByid("hotels");
		s = new Select(ddHotels);
		s.selectByIndex(hotelIndex);
		WebElement ddRoomType = findElementByid("room_type");
		s = new Select(ddRoomType);
		s.selectByIndex(RoomTypeIndex);
		WebElement ddRoomCount = findElementByid("room_nos");
		s = new Select(ddRoomCount);
		s.selectByIndex(RoomCountIndex);
		WebElement txtCheckIn = findElementByid("datepick_in");
		txtCheckIn.sendKeys(CheckIn);
		WebElement txtCheckOut = findElementByid("datepick_out");
		txtCheckOut.sendKeys(CheckOut);
		WebElement ddAdultCount = findElementByid("adult_room");
		s = new Select(ddAdultCount);
		s.selectByIndex(AdultCountIndex);
		WebElement ddChildCount = findElementByid("child_room");
		s = new Select(ddChildCount);
		s.selectByIndex(ChildCountIndex);
		WebElement btnSubmit = findElementByid("Submit");
		btnSubmit.click();
	}

	public static void Payment(String FirstName,String LastName,String Address,String CreditNo,int CreditTypeIndex,String ExpMonth,String ExpYear,String cvv)
	{
		WebElement txtFirstName = findElementByid("first_name");
		txtFirstName.sendKeys(FirstName);
		WebElement txtLastName = findElementByid("last_name");
		txtLastName.sendKeys(LastName);
		WebElement txtAddress = findElementByid("address");
		txtAddress.sendKeys(Address);
		WebElement txtCreditno = findElementByid("cc_num");
		txtCreditno.sendKeys(CreditNo);
		WebElement ddCreditType = findElementByid("cc_type");
		Select s =new Select(ddCreditType);
		s.selectByIndex(CreditTypeIndex);
		WebElement ddExpMonth = findElementByid("cc_exp_month");
		s =new Select(ddExpMonth);
		s.selectByVisibleText(ExpMonth);
		WebElement ddExpYear = findElementByid("cc_exp_year");
		s =new Select(ddExpYear);
		s.selectByVisibleText(ExpYear);
		WebElement txtCvv = findElementByid("cc_cvv");
		txtCvv.sendKeys(cvv);
		WebElement btnBook = findElementByid("book_now");
		btnBook.click();
		WebElement txtBookingId = findElementByid("order_no");
		String attribute = txtBookingId.getAttribute("value");
		scrollUpandDown("//input[@name ='order_no']", true);
		System.out.println(attribute);
		//browser.quit();
	}
	public static WebElement email;
	public static WebElement pass;
	public static WebElement login;
	public static void New()
	{
		loadDriver();
		LoadUrl("https://www.facebook.com/");
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(browser,OpenMicrosoftEdge.class);
		email.sendKeys("Hello World");
		pass.sendKeys("12345");
		login.click();
		
	}
}

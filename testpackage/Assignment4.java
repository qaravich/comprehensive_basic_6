package testpackage;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.*;

public class Assignment4 {

	public WebDriver driver;
	@BeforeTest
	public void init() {
     
		System.setProperty("webdriver.chrome.driver",
				"C://Users//ravi//Downloads//chromedriver-win64//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		//WebDriver driver = new ChromeDriver(options);
	}

	@Test(groups = { "Validate" })	
	public void check_child_window() {

		driver.navigate().to("https://www.autify.com/");
		driver.manage().window().maximize();
		String popupwindow = driver.getWindowHandle();
		System.out.println(popupwindow);
		System.out.println(" current window title is :::::" + driver.getTitle());
		driver.switchTo().window(popupwindow).findElement(By.xpath("//*[text()='Deny']")).click();

		// this.driver = driver;

		driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/company/autify?trk=affiliated-pages']"))
				.click();
		// getting no of windows
		Set<String> popwind = driver.getWindowHandles();
		System.out.println("popwindow is :::::" + popwind);
		// go through the windows and switching from parent window to child window
		// b. Verify that new tab is opened and Switch from Parent window to child
		// window

		for (String windowHandle : popwind) {
			if (!windowHandle.equals(popwind)) {
				driver.switchTo().window(windowHandle);
			}
		}

		String actualchildwintitle = driver.getTitle();
		System.out.println(" child window name is ::   " + actualchildwintitle);

		String expectedname = "Autify | LinkedIn";

		assertEquals(actualchildwintitle, expectedname, "both expected and Actual are not equal");

	}

	@Test(groups = { "Validate" })	
	public final void check_error_message() {

		driver.findElement(By.xpath("//a[@class='contextual-sign-in-modal__join-link']")).click();
		driver.findElement(By.xpath("//button[@class='join-form__form-body-submit-button ']")).click();

		String actualemailVal = driver
				.findElement(By.xpath("//p[contains(text(),'Please enter your email address or mobile number.')]"))
				.getText();
		String actualpwdVal = driver.findElement(By.xpath("//p[contains(text(),'Please enter your password.')]"))
				.getText();

		System.out.println(" email validation error message is " + actualemailVal);
		System.out.println(" pwd validation error message is " + actualpwdVal);

		String expectedemailval = "Please enter your email address or mobile number.";
		String expectedpwdval = "Please enter your password.";

		assertEquals(actualemailVal, expectedemailval, "both actual and expected are not mtching");
		assertEquals(actualpwdVal, expectedpwdval, "both actual and expected are not mtching");

	}

}

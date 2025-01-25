package testpackage;

import org.openqa.selenium.chrome.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

import org.openqa.selenium.*;

public class Assignment3 {

	WebDriver driver;

	@BeforeTest
	public void initialize() {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//ravi//Downloads//chromedriver-win64//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

	}
	@Test(groups = { "ValidateAss3" })	
	public void chk_Switch_from_Parent_to_childwindow() {

		driver.navigate().to("https://www.autify.com/");
		driver.manage().window().maximize();
		String popupwindow = driver.getWindowHandle();
		System.out.println(popupwindow);
		System.out.println(" current window title is :::::" + driver.getTitle());
		driver.switchTo().window(popupwindow).findElement(By.xpath("//*[text()='Deny']")).click();
		driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/company/autify?trk=affiliated-pages']"))
				.click();

		// go through the windows and switching from parent window to child window
		// b. Verify that new tab is opened and Switch from Parent window to child
		// window
	}
	@Test(groups = { "ValidateAss3" })	
	public void chk_title_of_childwindow() {

		// getting no of windows
		Set<String> popwind = driver.getWindowHandles();
		System.out.println("popwindow is :::::" + popwind);

		for (String windowHandle : popwind) {
			if (!windowHandle.equals(popwind)) {
				driver.switchTo().window(windowHandle);
			}
		}
		String childwintitle = driver.getTitle();
		System.out.println(" child window name is ::   " + childwintitle);

		// c. Verify the title of the child window and after that close only child
		// window
		if (childwintitle.contains("Autify | LinkedIn")) {
			driver.close();
			System.out.println("hello child window  closed");

		} else {

			System.out.println("hello child window not closed");

		}

	}

};

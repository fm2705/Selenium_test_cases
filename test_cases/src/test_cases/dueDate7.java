package test_cases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class dueDate7 {

	WebDriver driver;

	@BeforeClass
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\eclipse\\Selenium-Chrome-driver\\chromedriver.exe");

		driver = new ChromeDriver();
		System.out.println("===========Browser started=========");
	}

	@Test(priority = 1)
	public void startApp() {

		driver.get("https://todoist.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String currentURL = driver.getCurrentUrl();
		 driver.manage().window().maximize();
		Assert.assertTrue(currentURL.contains("todoist"));
		System.out.println("=======Application started=======");
	}

	@Test(priority = 2)
	public void loginApp() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("judi@email.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("pass1234");
		driver.findElement(By.xpath("//button[@class='submit_btn ist_button ist_button_red sel_login']")).click();

		boolean status = driver.findElement(By.xpath("//button[contains(text(),'Projects')]")).isDisplayed();

		Assert.assertTrue(status);

		System.out.println("========Log in==========");
	}

	@Test(dependsOnMethods = "loginApp")
	public void dueDate() throws InterruptedException {

		// second button "schedule'
		driver.findElement(By.xpath("//li[1]//div[1]//div[3]//button[2]//*[local-name()='svg']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"//button[@class='calendar__day calendar__day--busy']//span[@class='calendar__day__date__number'][contains(text(),'30')]"))
				.click();

		Thread.sleep(2000);

		System.out.println("========Due date added==========");
	}

	/*
	 * 	
	@Test(dependsOnMethods = "loginApp")
	public void logoutApp() {
		driver.close();
	}
	 */

	
}

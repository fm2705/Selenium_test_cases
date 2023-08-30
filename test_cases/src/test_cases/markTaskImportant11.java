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

public class markTaskImportant11 {

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
	public void importantTask() throws InterruptedException {

		// click the list
		driver.findElement(By.xpath(
				"//div[@class='expansion_panel expansion_panel--expanded']//li[3]//table[1]//tbody[1]//tr[1]//td[2]"))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//li[1]//div[1]//div[3]//button[4]//*[local-name()='svg']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[name()='path' and contains(@stroke,'#DE4C4A')]")).click();

		boolean status = driver.findElement(By.xpath(
				"//body/div[@id='todoist_app']/div[@id='page_background']/div[@id='app_holder']/div[@id='content_wrapper']/div[@id='content']/div[@id='editor']/div[@id='agenda_view']/ul[@class='items']/li[1]/div[1]/button[1]"))
				.isDisplayed();

		Assert.assertTrue(status);
		System.out.println("========Note added to a task==========");
	}
	
	/*
	 * 	
	@Test(dependsOnMethods = "loginApp")
	public void logoutApp() {
		driver.close();
	}
	 */

	
}

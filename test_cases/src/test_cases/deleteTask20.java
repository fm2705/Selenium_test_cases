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

public class deleteTask20 {

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
	public void deleteTask() throws InterruptedException {

		// click the list
		driver.findElement(By.xpath("//td[@class='name']//span[contains(text(),'Grocery List')]")).click();
		Thread.sleep(2000);

		// click the 3 dots
		driver.findElement(By.xpath("//li[2]//div[1]//div[3]//button[4]")).click();
		Thread.sleep(2000);

		// click delete
		driver.findElement(By.xpath("//li[@class='menu_item icon_menu_item danger_menu']")).click();
		Thread.sleep(2000);
		// confirm
		driver.findElement(By.xpath("//button[@class='ist_button ist_button_red']")).click();

		Thread.sleep(2000);
		boolean status = driver.findElement(By.xpath("//td[@class='name']//span[contains(text(),'Grocery List')]"))
				.isDisplayed();

		Assert.assertTrue(status);
		System.out.println("========Delete a task==========");
	}

	/*
	 * 	
	@Test(dependsOnMethods = "loginApp")
	public void logoutApp() {
		driver.close();
	}
	 */

	
}

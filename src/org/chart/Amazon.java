package org.chart;

import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
	static WebDriver driver;
	static long startTime;
	static String realme;

	@BeforeClass
	public static void BeforeClass() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Thirumaran\\eclipse-workspace\\FLIPKART\\Flipkart\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	@Before
	public void beforeMethod() {
		startTime = System.currentTimeMillis();

	}

	@AfterClass
	public static void afterClass() throws InterruptedException {

		driver.quit();
	}

	@After
	public void afterMethod() {
		long endTime = System.currentTimeMillis();
		System.out.println("That took" + (endTime - startTime) + "Millisecond");

	}

	

	

	@Test
	public void m2() throws InterruptedException {
		WebElement searchText = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchText.sendKeys("mobiles",Keys.ENTER);
		

		

	}
}

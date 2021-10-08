package org.chart;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Flipkart {

public static void main(String[] args) throws InterruptedException, IOException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Thirumaran\\eclipse-workspace\\Flipkart\\Driver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	String currentUrl = driver.getCurrentUrl();
	System.out.println(currentUrl);
	driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();

	WebElement searchText = driver.findElement(By.xpath("//input[@type='text']"));
	searchText.sendKeys("mobiles");
	
	WebElement searchIcon = driver.findElement(By.xpath("//button[@type='submit']"));
	searchIcon.click();
	Thread.sleep(2000);
	
	WebElement realmeC21YBlack = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
	
	//System.out.println(realmeC21YBlack.getText());
	String realme = realmeC21YBlack.getText();
	System.out.println(realme);
	realmeC21YBlack.click();
	
	String parent = driver.getWindowHandle();
	Set<String> child = driver.getWindowHandles();
	
	for (String x : child) {
		if (!parent.equals(x)) {
			driver.switchTo().window(x);
		}
	}
		
	
		WebElement newTabRealme = driver.findElement(By.xpath("//*[@class='B_NuCI']"));
		//System.out.println(newTabRealme.getText());
		String newRealme = newTabRealme.getText();
		System.out.println(newRealme);
		
		if (realme == newRealme) {
			System.out.println("Same Text");
		}else {
			System.out.println("Different Text");
		}
		WebElement dualSim = driver.findElement(By.xpath("//li[contains(text(),'Dual Sim')]"));
		JavascriptExecutor je = (JavascriptExecutor)driver;
		
		je.executeScript("arguments[0].scrollIntoView(true)", dualSim);
		
		//WebElement resolution = ;
		//System.out.println(resolution.getText());
		Actions ac = new Actions(driver);
		ac.doubleClick(driver.findElement(By.xpath("//li[contains(text(),'1600 x 720 Pixels')]"))).perform();
		
		//ac.doubleClick(resolution).perform();
		TakesScreenshot tak = (TakesScreenshot)driver;
		File source = tak.getScreenshotAs(OutputType.FILE);
		File location = new File("C:\\Users\\Thirumaran\\eclipse-workspace\\Flipkart\\screenShots\\realmi");
		FileUtils.copyFile(source, location);
	}
}


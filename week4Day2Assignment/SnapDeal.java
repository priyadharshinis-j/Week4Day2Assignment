package week4Day2Assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {
//	Assignment 5:SnapDeal
//	============
//	1. Launch https://www.snapdeal.com/
//	2. Go to Mens Fashion
//	3. Go to Sports Shoes
//	4. Get the count of the sports shoes
//	5. Click Training shoes
//	6. Sort by Low to High
//	7. Check if the items displayed are sorted correctly
//	8.Select the price range (900-1200)
//	9.Filter with color Navy 
//	10 verify the all applied filters 
//	11. Mouse Hover on first resulting Training shoes
//	12. click QuickView button
//	13. Print the cost and the discount percentage
//	14. Take the snapshot of the shoes.
//	15. Close the current window
//	16. Close the main window

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		driver.get("https://www.snapdeal.com/");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[@class='catText']"))).perform();
		
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		
		String itemsCount = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		
		String x =itemsCount.replace('(', ' ');
		String count = x.replace(')', ' ');
		System.out.println("Total no of Shoes in resultant page===> "+count);
		
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		
		driver.findElement(By.className("sort-selected")).click();
		
		driver.findElement(By.xpath("//li[@class='search-li']")).click();
		Thread.sleep(3000);
		
		WebElement slider = driver.findElement(By.xpath("//a[contains(@class,'price-slider-scroll left-handle')]"));
		Thread.sleep(3000);
		
		action.dragAndDropBy(slider,58,0).release().perform();
		
		WebElement slider2 = driver.findElement(By.xpath("//a[contains(@class,'price-slider-scroll right-handle')]"));
		Thread.sleep(1000);
		action.dragAndDropBy(slider2,-55, 0).release().perform();
		
		Thread.sleep(1000);
		WebElement range1 = driver.findElement(By.xpath("//input[@class='input-filter']"));
		range1.clear();
		range1.sendKeys("900");
		Thread.sleep(1000);
		WebElement range2 = driver.findElement(By.xpath("(//input[@class='input-filter'])[2]"));
		range2.clear();
		range2.sendKeys("1200");
		driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow btn')]")).click();
		
		Thread.sleep(3000);
		WebElement result = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
		action.moveToElement(result).perform();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[contains(@class,'center quick-view-bar')]")).click();
		
		String price = driver.findElement(By.className("payBlkBig")).getText();
		System.out.println("Price of the product==> Rs"+price);
		
		String discount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("Discount price===> "+discount);
		
		driver.findElement(By.xpath("//div[contains(@class,'close close1')]")).click();
		
		
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("div#products>section>div>div:nth-of-type(2)>a>picture>img")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(windows.size()-1));
		
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snap/shotSnapdeal.jpg");
		FileUtils.copyFile(screenshotAs, dest);
		
		driver.quit();
		
		
		
		
		
		
		
	}

}

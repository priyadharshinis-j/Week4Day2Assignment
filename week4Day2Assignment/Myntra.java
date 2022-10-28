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

//Myntra
//1) Open https://www.myntra.com/
//2) Mouse hover on MeN 
//3) Click Jackets 
//4) Find the total count of item 
//5) Validate the sum of categories count matches
//6) Check jackets
//7) Click + More option under BRAND
//8) Type Duke and click checkbox
//9) Close the pop-up x
//10) Confirm all the Coats are of brand Duke
//    Hint : use List 
//11) Sort by Better Discount
//12) Find the price of first displayed item
//Click on the first product
//13) Take a screen shot
//14) Click on WishList Now
//15) Close Browser


public class Myntra {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		
		driver.get("https://www.myntra.com/");
		
		WebElement menLink = driver.findElement(By.xpath("//a[text()='Men']"));
		Actions action = new Actions(driver);
		action.moveToElement(menLink).perform();
		
		driver.findElement(By.xpath("//a[text()='Jackets']")).click();
		
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		
		driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("Duke");
		
		driver.findElement(By.xpath("//label[text()='Duke']")).click();
		
		driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']/following-sibling::span")).click();
		
		List<WebElement> brandNames = driver.findElements(By.xpath("(//div[@class='product-productMetaInfo']//h3[@class='product-brand'])"));
		int list_Size = brandNames.size();
		Thread.sleep(3000);
		
		List<String> brandName = new ArrayList<String>();
		
		for(int i=1;i<=list_Size;i++)
		{
			String names = driver.findElement(By.xpath("(//div[@class='product-productMetaInfo']//h3[@class='product-brand'])["+i+"]")).getText();
			brandName.add(names);
		}
		
		System.out.println(brandName);
		
		
		WebElement sort = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		action.moveToElement(sort).perform();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//ul[@class='sort-list']//li[4]")).click();
		
		String price = driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText();
		System.out.println("Price of the First Product====> "+price);
		
		driver.findElement(By.xpath("(//picture[@class='img-responsive']/img)[1]")).click();
		Thread.sleep(3000);
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		Thread.sleep(3000);
		
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snap/shotMyntra.jpg");
		FileUtils.copyFile(screenshotAs, dest);
		
		driver.findElement(By.xpath("//span[contains(@class,'headerWishlist')]")).click();
		
		driver.quit();
		
		
		
	}

}

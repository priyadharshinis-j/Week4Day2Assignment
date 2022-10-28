package week4Day2Assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

//Assignment 6:Amazon
//====================
//1.Load the uRL https://www.amazon.in/
//2.search as oneplus 9 pro 
//3.Get the price of the first product
//4. Print the number of customer ratings for the first displayed product
//5. Mouse Hover on the stars
//6. Get the percentage of ratings for the 5 star.
//7. Click the first text link of the first image
//8. Take a screen shot of the product displayed
//9. Click 'Add to Cart' button
//10. Get the cart subtotal and verify if it is correct.
public class Amazon 
{
	public static void main(String[] args) throws InterruptedException, IOException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.amazon.in/");
		
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.click();
		search.sendKeys("oneplus 9 pro",Keys.ENTER);
		
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		String price  = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println("Price of the first product===> "+price);
		String priceAmount = price.trim();

		
		WebElement rating = driver.findElement(By.xpath("//i[contains(@class,'a-icon a-icon-star-small')]"));
		Actions action = new Actions(driver);
		action.moveToElement(rating).click().build().perform();
		
		String globalRatings = driver.findElement(By.xpath("//span[@data-hook='total-review-count']")).getText();
		System.out.println("Global ratings==> "+globalRatings );
		
		String ofReviews = driver.findElement(By.xpath("//*[@id=\"histogramTable\"]/tbody/tr[1]/td[3]/span[2]/a")).getText();
		System.out.println("5 star rating===> "+ofReviews);
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//span[contains(@class,'a-size-medium a-color-base')]")).click();
		
		Thread.sleep(3000);
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snap/shotAmazon.jpg");
		FileUtils.copyFile(screenshotAs, dest);
		Thread.sleep(2000);
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@id='attach-sidesheet-view-cart-button']/span[1]/input[1]")).click();

		
		String price1 = driver.findElement(By.xpath("//span[contains(@class,'a-size-medium a-color-base')]")).getText();

		System.out.println("CartSubTotal====> "+price1);
		String replace = price1.replace(".00", "");
		
		String price1Amount = replace.trim();
				
		if(priceAmount.equals(price1Amount))
		{
			System.out.println("Verified : Success");
		}
		
		else
			System.out.println("Verified : Fail");
	
	}
}

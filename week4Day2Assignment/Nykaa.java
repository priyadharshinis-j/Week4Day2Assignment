package week4Day2Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

//1) Go to https://www.nykaa.com/
//2) Mouseover on Brands and Search L'Oreal Paris
//3) Click L'Oreal Paris
//4) Check the title contains L'Oreal Paris(Hint-GetTitle)
//5) Click sort By and select customer top rated
//6) Click Category and click Hair->Click haircare->Shampoo
//7) Click->Concern->Color Protection
//8)check whether the Filter is applied with Shampoo
//9) Click on L'Oreal Paris Colour Protect Shampoo
//10) GO to the new window and select size as 175ml
//11) Print the MRP of the product
//12) Click on ADD to BAG
//13) Go to Shopping Bag 
//14) Print the Grand Total amount
//15) Click Proceed
//16) Click on Continue as Guest
//17) Check if this grand total is the same in step 14
//18) Close all windows

public class Nykaa {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.nykaa.com/");
		
		Actions action = new Actions(driver);
		
		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
		
		action.moveToElement(brand).perform();
		Thread.sleep(3000);
		

		WebElement clickElement = driver.findElement(By.xpath("//a[text()='L']"));
		action.moveToElement(clickElement).perform();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("div#scroller-container>div:nth-of-type(1111)>a")).click();
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		
		if(title.toLowerCase().contains("l'oreal")) {
			System.out.println("Title of the page is ====> "+title);
		}
		else
		{
			System.out.println("Wrong Title");
		}
		
		driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();
		
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
		Thread.sleep(3000);
		
		WebElement shampooElement = driver.findElement(By.xpath("//span[@class='title']"));
		shampooElement.click();
		
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		
		driver.findElement(By.className("css-xrzmfa")).click();
		Thread.sleep(3000);
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		


		WebElement selectSIZE = driver.findElement(By.className("css-2t5nwu")); 
		Select select = new Select(selectSIZE);
		select.selectByIndex(1);
		
		String tag = driver.findElement(By.xpath("//span[text()='MRP:']")).getText();
		
		String rate = driver.findElement(By.xpath("//span[text()='₹189']")).getText();
		System.out.println("Price of the prodcut====> "+tag +rate);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[@class='btn-text']")).click();		
		driver.findElement(By.className("cart-count")).click();
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
		driver.switchTo().frame(frame);
		Thread.sleep(2000);
		
		String grandTotal = driver.findElement(By.xpath("//span[@class='css-n8gwxi e171rb9k3']")).getText();
		System.out.println("Grand Total===> "+grandTotal);
		
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		
		String grandTotal_ = driver.findElement(By.xpath("(//div[@class='value'])[2]//span")).getText();
		System.out.println("Grand Total in Cart===>"+grandTotal_);
		driver.quit();
	}

}

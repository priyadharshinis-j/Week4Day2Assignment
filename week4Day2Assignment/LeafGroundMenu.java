package week4Day2Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

//1. Launch the url: https://www.leafground.com/menu.xhtml
//    Menu Bar
//        -Do click on shipment and mousehover on Tracker and Do rightClick on Tracker
//    Slide Menu
//        -Do click Orders and click Back 
public class LeafGroundMenu {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.leafground.com/menu.xhtml");
		
		driver.findElement(By.xpath("//span[text()='Shipments']")).click();
		
		WebElement click = driver.findElement(By.xpath("//span[text()='Tracker']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(click).contextClick().perform();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[text()='Orders'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(@class,'ui-slidemenu-backward')]")).click();
		
		
		
	}

}

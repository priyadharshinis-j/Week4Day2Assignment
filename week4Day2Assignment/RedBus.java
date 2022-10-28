package week4Day2Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {


//Step:1-Launch the url (https://www.redbus.in/)
//Step:2-Enter From -Madiwala Bangalore
//Step:3-Enter To Koyambedu Chennai
//Step:4-Select the Date 30-September-2022
//Step:5-Print the Title of the page
	
	public static void main(String[] args) 
	
	{
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		driver.get("https://www.redbus.in/");
		
		WebElement fromInput = driver.findElement(By.xpath("//label[text()='FROM']/preceding-sibling::input"));
		fromInput.click();
		fromInput.sendKeys("Madiwala Bangalore",Keys.ENTER);
		
		
		WebElement toInput = driver.findElement(By.xpath("//label[text()='TO']/preceding-sibling::input"));
		toInput.click();
		toInput.sendKeys("Koyambedu Chennai",Keys.ENTER);
		
		WebElement dateInput = driver.findElement(By.xpath("//label[text()='Date']/preceding-sibling::input"));
		dateInput.click();
		
		WebElement chooseDate = driver.findElement(By.xpath("//td[text()='30']"));
		chooseDate.click();
		
	
		String title = driver.getTitle();
		System.out.println("Title of the current page===>  "+title);
		

		
	}
}

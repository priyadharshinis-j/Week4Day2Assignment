package week4Day2Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//1. Launch the URL https://html.com/tags/table/
//2. You have to print the respective values based on given Library
//(hint: if the library was absolute usage, then print all its value)


public class TagsAndTablesAssignment3 {
	
	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//WebDriver driverValue;
		driver.get("https://html.com/tags/table/");
		
		List<WebElement> rowValues = driver.findElements(By.xpath("//td[text()='Absolute Usage']/parent::tr/td"));
		
		//List<String> stringList = new ArrayList<String>();
		System.out.println("Absolute Usage Libray Values");
		for(int i=1;i<=rowValues.size()-1;i++)
		{
			String name = driver.findElement(By.xpath("//td[text()='Absolute Usage']/parent::tr/td["+i+"]")).getText();
			System.out.println(name);
		}
		
	}
}

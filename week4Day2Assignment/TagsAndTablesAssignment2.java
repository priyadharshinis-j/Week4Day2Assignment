package week4Day2Assignment;
//1. Launch the URL https://html.com/tags/table/
//2. Get the count of number of rows
//3. Get the count of number of columns

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TagsAndTablesAssignment2 {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://html.com/tags/table/");
		
		System.out.println("================Table 1======================");
		
		List<WebElement> rowElements = driver.findElements(By.xpath("//div[@class='render']//table//tr"));
		int noOfRows = rowElements.size();		
		System.out.println("No of rows====> "+noOfRows);
		
		List<WebElement> columnElements = driver.findElements(By.xpath("//div[@class='render']//table//tr/th"));
		int noOfColumns = columnElements.size();
		System.out.println("No of columns====> "+noOfColumns);
		
		
		System.out.println("================Table 2======================");
		
		List<WebElement> rowElement = driver.findElements(By.xpath("//table[@class='attributes-list']//tr"));
		int rowCount = rowElement.size();
		System.out.println("No of rows====> "+rowCount);
		
		List<WebElement> columnElement = driver.findElements(By.xpath("//table[@class='attributes-list']//tr/th"));
		int columnSize = columnElement.size();
		System.out.println("No of columns=====> "+columnSize);
	
		
		
		
	}

}

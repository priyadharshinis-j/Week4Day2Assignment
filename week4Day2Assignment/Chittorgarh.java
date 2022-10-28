package week4Day2Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {
	
//	Assignment 1:
//		============
//		1. Launch the URL https://www.chittorgarh.com/
//		2. Click on stock market
//		3. Click on NSE bulk Deals
//		4. Get all the Security names
//		5. Ensure whether there are duplicate Security names
	public static void main(String[] args)
	{
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =  new  ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.chittorgarh.com/");
		
		driver.findElement(By.xpath("//a[text()='STOCK MARKET ']")).click();
		
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		
		List<WebElement> nameList = driver.findElements(By.xpath("(//div[@class = 'table-responsive']//tbody)//td[3]"));
		
		int size = nameList.size();
		
		List<String> stringList = new ArrayList<String>();
		System.out.println("All the Security names");
		System.out.println("===========================");
		
		for(int i =1;i<=size-1;i++)
		{
			String name = driver.findElement(By.xpath("((//div[@class = 'table-responsive']//tbody)//td[3])["+i+"]")).getText();
			System.out.println(name);
			stringList.add(name);
			
		}
		int listSize = stringList.size();
		
		Set<String> stringSet = new LinkedHashSet<String>(stringList);
		int setSize = stringSet.size();
		System.out.println("======================================================");
		if(listSize==setSize)
		{
			System.out.println("No duplicates");
		}
		else
		System.out.println("Duplicates are there");
		
		System.out.println("======================================================");
		System.out.println("Security Name without duplicates");
		System.out.println("======================================================");
		List<String> stringList1 = new ArrayList<String>(stringSet);
		for(int i=0;i<=stringList1.size()-1;i++)
		{
			System.out.println(stringList1.get(i));
		}
		
//		System.out.println("===============Set=====================================");
//		System.out.println(stringSet);
//		System.out.println("==================String===============================");
//		String string = stringSet.toString();
//		System.out.println(string);
		
		
		
		
	}
	

}

package week4Day2Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

//2.Launch the url : https://www.leafground.com/drag.xhtml
//Draggable Columns
//        -Move the Column Name to Column Quanity 
//       -Get the Toaster message to confirm it
//Draggable Rows
//        -Move the row 3 to row 4
//        -Get the Toaster message to confirm it
//Resize Image 
//         -Resize the message and Verify it 
//Range Slider
//            -Give a range between 10 and 80 (use movebyOffset() for x values ,y should be 0  and use negative value for right move)
public class LeafGroundDragAndDrop 
{
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.leafground.com/drag.xhtml");
		
		
		
		WebElement dragColumnB = driver.findElement(By.xpath("//table[@role='grid']//tr[1]//th[3]/span[1]"));
		WebElement dragColumnA = driver.findElement(By.xpath("//table[@role='grid']//tr[1]//th[1]/span[1]"));

		
		Actions action = new Actions(driver);
		action.moveToElement(dragColumnA).dragAndDrop(dragColumnA,dragColumnB).perform();
		Thread.sleep(3000);
		
		
		WebElement dragRowA = driver.findElement(By.xpath("(//table[@role='grid'])[2]//tr[3]/td"));
		WebElement dragRowB = driver.findElement(By.xpath("(//table[@role='grid'])[2]//tr[4]/td"));
		
		action.moveToElement(dragRowB).dragAndDrop(dragRowB, dragRowA).perform();
		Thread.sleep(3000);
		

		WebElement image = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-e']"));

		Point imageLocation = image.getLocation();
		int xValue = imageLocation.getX();
		int yValue = imageLocation.getY();
		System.out.println("Before image position ");
		System.out.println(xValue);
		System.out.println( yValue);
		System.out.println("=========================");
		

		action.dragAndDropBy(image,20,20).release().build().perform();
		
		Point imageLocation1 = image.getLocation();
		int xValue1 = imageLocation1.getX();
		int yValue1 = imageLocation1.getY();
		System.out.println("After resizing image position  ");
		System.out.println(xValue1);
		System.out.println( yValue1);
		
		WebElement leftHandle = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
		
		action.dragAndDropBy(leftHandle, -80, 0).release().perform();
	}

}

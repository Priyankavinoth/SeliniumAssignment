package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
ChromeDriver driver=new ChromeDriver();
driver.get("https://www.leafground.com/frame.xhtml");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

//switch to frame
driver.switchTo().frame(0);

//click frame
WebElement frame = driver.findElement(By.id("Click"));
frame.click();
System.out.println(frame.getText());
driver.switchTo().defaultContent();

//handle nested frame
driver.switchTo().frame(2);
driver.switchTo().frame("frame2");
WebElement nested = driver.findElement(By.id("Click"));
nested.click();
System.out.println(nested.getText());
driver.switchTo().defaultContent();

//how many frame present
//count frames
		driver.switchTo().defaultContent();
		List<WebElement> frameouter = driver.findElements(By.tagName("iframe"));
		int size = frameouter.size();
		System.out.println("the count of the frame" +size);
		//count inner frames
		int count=0;
		for(int i=0;i<size;i++)
		{
			driver.switchTo().frame(frameouter.get(i));
			List<WebElement> innerframe = driver.findElements(By.tagName("iframe"));
			count=count+innerframe.size();
			driver.switchTo().defaultContent();
			
		}
		System.out.println(count+size);



	
}



	}



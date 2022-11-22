package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		
		//Click on Merge Contacts using Xpath Locator
		driver.findElement(By.linkText("Merge Contacts")).click();
		
		//Click on Widget of From Contact
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		//handle the window
		Set<String> sethandle = driver.getWindowHandles();
		System.out.println(sethandle.size());
		//convert set to list
		List<String>lstwindow=new ArrayList<String>(sethandle);
		//switch the control to the new open window
		driver.switchTo().window(lstwindow.get(1));
		driver.findElement(By.xpath("//div[contains(class,'x-grid3-cell-inner')]/a")).click();
		driver.switchTo().window(lstwindow.get(0));
		
		//Click on Widget of to Contact
		driver.findElement(By.xpath(("//img[@alt='Lookup'])[2]"))).click();
		
		Set<String> sethandle2 = driver.getWindowHandles();
		List<String>lstwindow2=new ArrayList<String>(sethandle2);
		driver.switchTo().window(lstwindow.get(1));
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId'][2])/a")).click();
		driver.switchTo().window(lstwindow.get(0));
		
		driver.findElement(By.className("buttonDangerous")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
		String title1 = driver.getTitle();
		if(title1.contains("View Contact"))
		{
			System.out.println("file merged successfully"+title1);
		}
		else
		{
			System.out.println("not merged");
		}
}
		
		
		
		
		
	}



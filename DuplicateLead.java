package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
				
		driver.findElement(By.id("password")).sendKeys("crmsfa");
					
		driver.findElement(By.className("decorativeSubmit")).click();
				
		driver.findElement(By.linkText("CRM/SFA")).click();
				
		driver.findElement(By.linkText("Leads")).click();
				
		driver.findElement(By.linkText("Find Leads")).click();
				
		driver.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[3]")).click();
				
		driver.findElement(By.name("emailAddress")).sendKeys("123@abc.com");
				
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
				
		String name1 = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]/a")).getText();
				
		driver.findElement(By.linkText("10039")).click();
		
		driver.findElement(By.linkText("Duplicate Lead")).click();
				
		String duplicateLead = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
		System.out.println(""+duplicateLead);
				
		driver.findElement(By.name("submitButton")).click();
		
		String companyName = driver.findElement(By.xpath("//span[@class='requiredField']")).getText();
		
		if(name1==companyName)
		{
			System.out.println("Duplicate name");
		}
		
		driver.close();
		

	}
}

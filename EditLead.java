package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead extends BaseTest{

	@Test
	public void editlead() throws InterruptedException {
			
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("firstname");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
		String title = driver.getTitle();
		if (title.contains("View Lead")) {
			System.out.println("Title verified");
		} else {
			System.out.println("Title is not verified");
		}
		
		// Edit Lead
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
		CharSequence name = null;
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		
		String updatedName = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		System.out.println(updatedName);
		
		if(updatedName.contains(name)) {
			System.out.println("Company name updated"); 
		} else {
			System.out.println("Company name not updated"); 
		}
		
		driver.close();
		
	}

}

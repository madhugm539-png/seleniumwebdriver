package testNGclass1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
/*
 1) Open appliacion
 2)Test logo presence
 3)login
 4)close
 * 
 */

public class OrangeHRMtest {
	WebDriver driver;//now its a class variable we can acess it every method
 @Test(priority=1)
void openapp()
{
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.manage().window().maximize();
			
}
 @Test(priority=2)
void logopresencetest() throws InterruptedException 
{
	 Thread.sleep(3000);
	boolean logo=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
	System.out.println("logo status is :"+logo);
}
 @Test(priority=3)
void testlogin() 
{
	
	driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
}
 @Test(priority=4)
void Testclose()
{
	driver.close();
}
}
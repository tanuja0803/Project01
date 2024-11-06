package ddt;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ThroughApplicationWritingInDatabase {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://106.51.90.215:8084/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		String parent=driver.getWindowHandle();
		
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		Set<String> handles=driver.getWindowHandles();
		for(String handle:handles) {
			if(!handle.equals(parent))
				driver.switchTo().window(handle);
		}
		driver.findElement(By.name("projectName")).sendKeys("Abcd");
		driver.findElement(By.name("createdBy")).sendKeys("vdiands");
		Select sel=new Select(driver.findElement(By.xpath("(//select[@name='status'] )[2]")));
		sel.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		driver.quit();
	}
}

package testNG;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

@Test
public class Automating_dealsdray_Application {
	WebDriver driver;
	String Applicatoin_URL = "https://demo.dealsdray.com/ ";
	Timeouts Duration;
	Duration ofSeconds;
	
	@Test(priority=1)
	public void Launch_dealsdray()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pushpa\\Desktop\\java folder\\JavaNewProgramms\\browser files\\geckodriver.exe ");
		driver = new FirefoxDriver();
		driver.get(Applicatoin_URL);
		driver.manage().window().maximize();
	}
	@Test(priority=2)
	public void Enter_credentials()
	{
		//xpath for username - //*[@id="mui-1"]
		By Username_locator = By.xpath("//*[@id=\"mui-1\"]");
		WebElement Username=driver.findElement(Username_locator);
		Username.sendKeys("prexo.mis@dealsdray.com");
		
		//xpath for password - //*[@id="mui-2"]
		By password_locator=By.xpath("//*[@id=\"mui-2\"]");
		WebElement password=driver.findElement(password_locator);
		password.sendKeys("prexo.mis@dealsdray.com");
		
		//xpath for login_button - /html/body/div/div/div/div/div[2]/div/form/div[3]/div/button
		By login_locator=By.xpath("/html/body/div/div/div/div/div[2]/div/form/div[3]/div/button");
		WebElement login=driver.findElement(login_locator);
		login.click();
	}
	@Test(priority=3)
	public void click_orders()
	{
		//xpath for order_button - /html/body/div/div/div[1]/div/div[2]/div[1]/div[2]/button
	    WebDriverWait wait = new WebDriverWait(driver,10);
	    WebElement order=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[1]/div/div[2]/div[1]/div[2]/button")));
	    order.click();
	    
	    //xpath for orders_button - /html/body/div/div/div[1]/div/div[2]/div[1]/div[2]/div/div[1]/a/button
	    WebDriverWait wait2 = new WebDriverWait(driver,10);
	    WebElement orders=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[1]/div/div[2]/div[1]/div[2]/div/div[1]/a/button")));
	    orders.click();
	    
	    //xpath for Add bulk orders - /html/body/div/div/div[2]/div[2]/div/div/div[2]/div[2]/button
	    WebDriverWait wait3 = new WebDriverWait(driver,10);
	    WebElement Add_Bulkorders=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div[2]/div/div/div[2]/div[2]/button")));
	    Add_Bulkorders.click();
	    
	}
	@Test(priority=4)
	public void Click_on_Browse_File() throws InterruptedException, IOException
	{
		
		//xpath for browse - //*[@id="mui-7"]
		/*WebDriverWait wait4 = new WebDriverWait(driver,20)
	    WebElement Browse_button=wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mui-7\"]")));
	    Browse_button.click();*/
		
		//<input aria-invalid="false" type="file" class="MuiOutlinedInput-input MuiInputBase-input MuiInputBase-inputSizeSmall css-1imb3v5" value="" id="mui-7">
		 WebDriverWait wait4 = new WebDriverWait(driver,30);
		 WebElement Browse_button=wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("mui-7")));
		 Browse_button.sendKeys("C:\\Users\\pushpa\\Downloads\\demo-data.xlsx");
		 
		 //xpath for import - /html/body/div/div/div[2]/div[2]/div/div/div[2]/div[3]/button
		 WebDriverWait wait5 = new WebDriverWait(driver,10);
		 WebElement import_button=wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div[2]/div/div/div[2]/div[3]/button")));
		 import_button.click();
		 
		 //xpath for Validate data - /html/body/div/div/div[2]/div[2]/div/div/div[2]/div[3]/button
		 WebDriverWait wait6 = new WebDriverWait(driver,10);
		 WebElement Validate_data=wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div[2]/div/div/div[2]/div[3]/button")));
		 Validate_data.click();
		 
		 try {
	            // Open a blank page
	            //driver.get("about:blank");

	            // Execute JavaScript to create an alert
	            //((FirefoxDriver) driver).executeScript("alert('This is a sample alert!');");

	            // Use WebDriverWait to wait until the alert is present
	            WebDriverWait wait = new WebDriverWait(driver,30);
	            wait.until(ExpectedConditions.alertIsPresent());

	            // Switch to the alert
	            Alert alert = driver.switchTo().alert();

	            // Print the alert text
	            //System.out.println("Alert Text: " + alert.getText());

	            // Accept the alert
	            alert.accept();

	        } catch (Exception e) {
	            e.printStackTrace();
	        } 
		
		 File CapturedCsreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(CapturedCsreenShot,new File ("./Screenshot/dealsdray1.png"));
		 
		 //xpath for submit button - /html/body/div/div/div[2]/div[2]/div/div/div[2]/div[3]/button
		 WebDriverWait wait7 = new WebDriverWait(driver,10);
		 WebElement Submit_button=wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div[2]/div/div/div[2]/div[3]/button")));
		 Submit_button.click();
		 try {
	            
	            WebDriverWait wait = new WebDriverWait(driver,30);
	            wait.until(ExpectedConditions.alertIsPresent());

	            // Switch to the alert
	            Alert alert = driver.switchTo().alert();
	            alert.accept();

	        } catch (Exception e) {
	            e.printStackTrace();
	        } 
		 File CapturedCsreenShot2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(CapturedCsreenShot2,new File ("./Screenshot/dealsdray2.png"));
		 
	}	 
}

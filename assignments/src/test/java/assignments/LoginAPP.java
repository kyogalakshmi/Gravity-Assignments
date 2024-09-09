package assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import org.apache.commons.io.FileUtils;import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




public class LoginAPP {
	public WebDriver driver;

	@Test(dataProvider = "logindata")
	public void LoginData(String uname,String pwd) {
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


		driver.manage().window().maximize();


		driver.findElement(By.name("username"))
		.sendKeys(uname);


		driver.findElement(By.name("password"))
		.sendKeys(pwd);

		driver.findElement(By.xpath("//*[@name='password']//following::button"))
		.click();



	}

	@AfterMethod
	public void screenshots() throws IOException {
		
      
		TakesScreenshot screenshot = (TakesScreenshot)driver;

		File source = screenshot.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(source, new File("./Screenshots/loginApp.png"));
		System.out.println("Screenshot is captured");	
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
	@DataProvider(name="logindata")
	public Object[][] logindata() throws Exception {

		String[][] data ={

				{"Admin","admin123"}
				
		};
		return data;

	}
}


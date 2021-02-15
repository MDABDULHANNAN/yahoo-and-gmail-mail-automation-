package mail.automation.mailautomation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class Driversetup {


	public static WebDriver driver;
	public static WebElement element;



	@BeforeSuite 
	public static void mail() throws InterruptedException{

		System.setProperty("webdriver.chrome.driver",".//chromedriver.exe");
		driver = new ChromeDriver();


	}
	//browser close 
	@AfterTest
	public void exit() {


		driver.close();


	}

}
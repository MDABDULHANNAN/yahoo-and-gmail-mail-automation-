package mail.automation.mailautomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;


public class mailtest extends Driversetup {

	public static String baseurl="https://mail.yahoo.com/";
	public static String actualText = "test automation by selenium";
	public static String expectedText;


    @BeforeTest
	public static void yahoomail() throws InterruptedException{

		driver.get(baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Thread.sleep(2000);

		//log in

		//WebElement  el  =  driver.findElement(By.id("signin-main"));
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("arguments[0].click();", el);

		driver.findElement(By.xpath("//*[@id=\"signin-main\"]/div[1]/a[2]")).click();
		WebElement username = driver.findElement(By.xpath("//input[contains(@autocomplete,'username')]"));
		username.sendKeys("abdul_hannan29@yahoo.com");
		driver.findElement(By.xpath("//input[@data-rapid-tracking='true']")).click();

		WebElement password = driver.findElement(By.xpath("//input[contains(@data-ylk,'elm:input;elmt:focus;slk:passwd;mKey:password-challenge-focus-passwd')]"));

		password.sendKeys("H84322348");
		driver.findElement(By.xpath("//button[contains(.,'Next')]")).click();

	}
	@Test(priority = 1)
	public static void composemail() throws InterruptedException {

		//compose mail
		driver.findElement(By.xpath("//a[text()='Compose']")).click();
		WebElement to = driver.findElement(By.xpath("//input[@id='message-to-field']"));
		to.sendKeys("abdulhannan8000@gmail.com");

		//subject
		WebElement subject = driver.findElement(By.xpath("//input[contains(@data-test-id,'compose-subject')]"));
		subject.sendKeys("test automation by selenium");

		//mail body
		WebElement body = driver.findElement(By.xpath("//div[@class='rte em_N ir_0 iy_A iz_h N_6Fd5']"));
		body.sendKeys("hey,my name is Hannan"); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='q_Z2aVTcY e_dRA k_w r_P H_6VdP s_3mS2U en_0 M_1gLo4F V_M cZ1RN91d_n y_Z2hYGcu A_6EqO u_e69 b_0 C_52qC I4_Z29WjXl ir3_1JO2M7 it3_dRA']")).click();
		Thread.sleep(5000);

		WebElement element = driver.findElement(By.xpath("//span[contains(@role,'presentation')]"));
		String actualuser=element.getText();
		System.out.println("Actual user is " + actualuser);


	}

	@Test(priority=2)
	public static void vbalidate() throws InterruptedException {
		//sent button click
		driver.findElement(By.xpath("//a[@href='/d/folders/2']")).click();
		Thread.sleep(3000);

		expectedText = driver.findElement(By.xpath(
				"//div[@class='en_3ixhM o_h a_6D6F D_F ab_C']"))
				.getText();
		if(expectedText.equalsIgnoreCase(actualText)) {

			System.out.println("mail is verified");
			Assert.assertTrue(true);

		}
		else {

			System.out.println("mail is verified faield");
			Assert.assertTrue(false);
		}


	}

	@Test (priority = 3)
	public static void logOut() throws InterruptedException{

		Actions action = new Actions(driver);

		action.clickAndHold(driver.findElement(By.xpath("//label[@id='ybarAccountMenuOpener']"))).build().perform();

		driver.findElement(By.xpath("//a[@class='_yb_tdi30 _yb_po6e2 _yb_m78yl _yb_16g61 _yb_1delc']")).click();
		Thread.sleep(3000);
	}



}


















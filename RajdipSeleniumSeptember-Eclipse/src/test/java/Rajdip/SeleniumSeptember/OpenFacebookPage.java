package Rajdip.SeleniumSeptember;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenFacebookPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		List<WebElement> elelist = driver.findElements(By.id("reg_box"));
		WebElement FN = elelist.get(0).findElement(By.xpath("//*[@name=\"firstname\"][@type='text']"));
		FN.click(); FN.sendKeys("Test");
		elelist.get(0).findElement(By.xpath("//*[@name=\"lastname\"]")).sendKeys("User");
		elelist.get(0).findElement(By.xpath("//*[@name=\"reg_email__\"]")).sendKeys("shubham.patra059@gmail.com");
		if (elelist.get(0).findElement(By.xpath("//*[@name='reg_email_confirmation__']")).isEnabled())
			elelist.get(0).findElement(By.xpath("//*[@name='reg_email_confirmation__']"))
					.sendKeys("shubham.patra059@gmail.com");
		elelist.get(0).findElement(By.xpath("//*[@id=\"password_step_input\"]")).sendKeys("Password$1");
		Select day = new Select(elelist.get(0).findElement(By.xpath("//*[@title='Day']")));
		day.selectByIndex(17);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
		Select month = new Select(elelist.get(0).findElement(By.xpath("//*[@title='Month']")));
		month.selectByVisibleText("May");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
		Select year = new Select(elelist.get(0).findElement(By.xpath("//*[@title='Year']")));
		year.selectByVisibleText("1986");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
		elelist.get(0).findElement(By.xpath("//input[@type='radio'][@name='sex'][@value='-1']")).click();
		WebElement pronoun = extracted(elelist);
		if (pronoun.isDisplayed()) {
			Select pro = new Select(pronoun);
			pro.selectByVisibleText("He: \"Wish him a happy birthday!\"");
		}
		elelist.get(0).findElement(By.xpath("//*[@name='custom_gender']")).sendKeys("Do not Share");
		elelist.get(0).findElement(By.xpath("//*[@id=\"reg_form_box\"]//*[@type='submit'][text()='Sign Up']")).click();
	}

	private static WebElement extracted(List<WebElement> elelist) {
		WebElement pronoun = elelist.get(0).findElement(By.xpath("//*[@name='preferred_pronoun']"));
		return pronoun;
	}

}

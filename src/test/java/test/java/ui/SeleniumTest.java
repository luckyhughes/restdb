package test.java.ui;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

import static org.junit.Assert.*;

public class SeleniumTest {

	private WebDriver driver;

	/*
	 * @Before public void setUp() throws Exception {
	 * System.setProperty("webdriver.chrome.driver",
	 * "C:\\Users\\email\\chromedriver_win32\\chromedriver.exe"); driver = new
	 * ChromeDriver(); }
	 */

	@BeforeClass
	public static void setupClass() {
		ChromeDriverManager.getInstance().setup();
	}

	@Before
	public void setupTest() {
		driver = new ChromeDriver();
	}

	@Test
	@Ignore
	public void TC1() throws InterruptedException {

		driver.get("http://google.com/");
		WebElement searchtext = driver.findElement(By.id("lst-ib"));
		searchtext.sendKeys("selenium java example");
		WebElement searchbutton = driver.findElement(By.name("btnK"));
		searchbutton.submit();
		Thread.sleep(5000);
		String resultstats = driver.findElement(By.id("resultStats")).getText();
		System.out.println(resultstats);
		Assert.assertTrue(resultstats.contains("About"));

	}

	@Test
	@Ignore
	public void TC2() {
		driver.get("http://amazon.com/");
		WebElement logo = driver.findElement(By.className("nav-logo-link"));
		Boolean isDisp = logo.isDisplayed();
		Assert.assertTrue(isDisp);

	}

	@Test
	public void TC3() {
		driver.get("http://amazon.com/");
		WebElement signinpopup = driver.findElement(By.className("nav-line-1"));
		WebElement signlink = driver.findElement(By.linkText("Sign in"));
		signlink.click();
		WebElement firstfield = driver.findElement(By.id("ap_email"));
		firstfield.sendKeys("emailanishagarg@gmail.com");
		WebElement secfield = driver.findElement(By.id("ap_password"));
		secfield.sendKeys("abcde");
		WebElement signingin = driver.findElement(By.id("signInSubmit"));
		signingin.click();
		WebElement result = driver.findElement(By.className("a-alert-heading"));
		String msg = result.getText();
		Assert.assertEquals(msg, "There was a problem");

	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}
}

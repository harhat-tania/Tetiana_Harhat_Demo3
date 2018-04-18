package testAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test2 {

    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
	System.setProperty("webdriver.chrome.driver",
		"C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	System.out.println("\t\t\tclass TestNg01: @BeforeClass beforeClass()");
    }

    @AfterClass
    public void afterClass() {
	driver.quit();
	System.out.println("\t\t\tclass TestNg01: @AfterClass afterClass()");
    }

    @Test
    public void testCheck() throws Exception {
	driver.get("http://atqc-shop.epizy.com/?i=1");
	driver.findElement(By.linkText("MacBook")).click();
	driver.findElement(By.linkText("Reviews (0)")).click();
	driver.findElement(By.id("input-name")).clear();
	driver.findElement(By.id("input-name")).sendKeys("Tania");
	driver.findElement(By.id("input-review")).clear();
	driver.findElement(By.id("input-review")).sendKeys(
		"The same laptop is big and big. It's not critical if you do not want to go out with him a lot. But at the same time it is quite powerful. I have a PC on Windows, but I work only in Mac.");
	driver.findElement(By.xpath("(//input[@name='rating'])[4]")).click();
	driver.findElement(By.id("button-review")).click();
	driver.findElement(By.cssSelector("i.fa.fa-check-circle"));
	String textDisplayed = driver.findElement(By.cssSelector("div.alert.alert-success")).getText();
	Assert.assertEquals(textDisplayed.split("\n")[0],
		"Thank you for your review. It has been submitted to the webmaster for approval.");
    }

    @Test
    public void testWarningName() throws Exception {
	driver.get("http://atqc-shop.epizy.com/?i=1");
	driver.findElement(By.linkText("MacBook")).click();
	driver.findElement(By.linkText("Reviews (0)")).click();
	driver.findElement(By.id("input-name")).clear();
	driver.findElement(By.id("input-name")).sendKeys("Ta");
	driver.findElement(By.id("input-review")).clear();
	driver.findElement(By.id("input-review")).sendKeys(
		"The same laptop is big and big. It's not critical if you do not want to go out with him a lot. But at the same time it is quite powerful. I have a PC on Windows, but I work only in Mac.");
	driver.findElement(By.xpath("(//input[@name='rating'])[4]")).click();
	driver.findElement(By.id("button-review")).click();
	driver.findElement(By.cssSelector("i.fa.fa-exclamation-circle"));
	String textDisplayed = driver.findElement(By.cssSelector("div.alert.alert-danger")).getText();
	Assert.assertEquals(textDisplayed.split("\n")[0], "Warning: Review Name must be between 3 and 25 characters!");

    }

    @Test
    public void testWarningReview() throws Exception {
	driver.get("http://atqc-shop.epizy.com/?i=1");
	driver.findElement(By.linkText("MacBook")).click();
	driver.findElement(By.linkText("Reviews (0)")).click();
	driver.findElement(By.id("input-name")).clear();
	driver.findElement(By.id("input-name")).sendKeys("Tania");
	driver.findElement(By.id("input-review")).clear();
	driver.findElement(By.id("input-review")).sendKeys("The same");
	driver.findElement(By.xpath("(//input[@name='rating'])[4]")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("button-review")).click();
	driver.findElement(By.cssSelector("i.fa.fa-exclamation-circle"));

	String textDisplayed = driver.findElement(By.cssSelector("div.alert.alert-danger")).getText();
	Assert.assertEquals(textDisplayed.split("\n")[0],
		"Warning: Review Text must be between 25 and 1000 characters!");
    }

    @Test
    public void testWarningRating() throws Exception {
	driver.get("http://atqc-shop.epizy.com/?i=1");
	driver.findElement(By.linkText("MacBook")).click();
	driver.findElement(By.linkText("Reviews (0)")).click();
	driver.findElement(By.id("input-name")).clear();
	driver.findElement(By.id("input-name")).sendKeys("Ta");
	driver.findElement(By.id("input-review")).clear();
	driver.findElement(By.id("input-review")).sendKeys(
		"The same laptop is big and big. It's not critical if you do not want to go out with him a lot. But at the same time it is quite powerful. I have a PC on Windows, but I work only in Mac.");
	driver.findElement(By.id("button-review")).click();
	driver.findElement(By.cssSelector("i.fa.fa-exclamation-circle"));

	String textDisplayed = driver.findElement(By.cssSelector("div.alert.alert-danger")).getText();
	Assert.assertEquals(textDisplayed.split("\n")[0], "Warning: Please select a review rating!");

    }

}
package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Test.*;

import testAutomation.HomePage;
import testAutomation.ReviewPage;
import test.ReviewTest;
import io.qameta.allure
@Title("This is our cool test suite")
@Description("In this cool suite we will test only cool features") 
public class ReviewTest {
    public static WebDriver driver;
    public static ReviewPage reviewPage;
    public static HomePage homePage;
    

    @BeforeClass
    public static void setup() {
	System.setProperty("webdriver.chrome.driver",
		"C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
	driver = new ChromeDriver();
	homePage = new HomePage(driver);
	reviewPage = new ReviewPage(driver);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://atqc-shop.epizy.com");
    }
    
    

    @Title("First cool check")     
    @Description("In this cool test we will check cool thing") 
    @Test
    public void reviewTest() {
	homePage.clickProductTab();
	homePage.clickReviewsTab();
	String reviewBoxMessage = reviewPage.getrewiewMassege();
	Assert.assertEquals("There are no reviews for this product.", reviewBoxMessage);
	reviewPage.inputName("Tania");
	reviewPage.inputReview("review review review v review review");
	reviewPage.clickratingButton();
	reviewPage.clickreviewButton();
	String rewiewMassegeChek = reviewPage.chekRewiewMassege();
	Assert.assertEquals("Thank you for your review. It has been submitted to the webmaster for approval.", rewiewMassegeChek);

    }
    
    @DataProvider(name = "test1")
    public static Object[][] stringData() {
       return new Object[][] {{"There are no reviews for this product.", "Tania" ,"review " ,"Warning: Review Text must be between 25 and 1000 characters!" },
       {"There are no reviews for this product.", "Ta", "review review review v review review", "Warning: Review Name must be between 3 and 25 characters!"}};
        }

    
    @Test (dataProvider = "test1")
    public void reviewTestWrong(String checkPage, String sendName, String feedbackText, String chekResult) {
	homePage.clickProductTab();
	homePage.clickReviewsTab();
	String reviewBoxMessage = reviewPage.getrewiewMassege();
	Assert.assertEquals(checkPage, reviewBoxMessage);
	reviewPage.inputName(sendName);
	reviewPage.inputReview(feedbackText);
	reviewPage.clickratingButton();
	reviewPage.clickreviewButton();
	String rewiewMassegeWarning = reviewPage.chekRewiewWrongMassege();
	Assert.assertEquals(chekResult, rewiewMassegeWarning);

    }
  
    @Test
    public void reviewTestNotRaiting() {
	homePage.clickProductTab();
	homePage.clickReviewsTab();
	String reviewBoxMessage = reviewPage.getrewiewMassege();
	Assert.assertEquals("There are no reviews for this product.", reviewBoxMessage);
	reviewPage.inputName("Tania");
	reviewPage.inputReview("review review review review review review review ");
	//reviewPage.clickratingButton();
	reviewPage.clickreviewButton();
	String rewiewMassegeWarning = reviewPage.chekRewiewWrongMassege();
	Assert.assertEquals("Warning: Please select a review rating!", rewiewMassegeWarning);

    }
    
    @AfterClass
    public static void tearDown() {
	driver.quit();
    }



    public void onTestSuccess() {
	// TODO Auto-generated method stub
	
    }
}

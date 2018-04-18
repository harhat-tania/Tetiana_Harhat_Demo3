package testAutomation;
import java.util.regex.Pattern;
    import java.util.concurrent.TimeUnit;
    import org.testng.annotations.*;
    import static org.testng.Assert.*;
    import org.openqa.selenium.*;
    import org.openqa.selenium.firefox.FirefoxDriver;
    import org.openqa.selenium.support.ui.Select;

public class Test3 {

    
      private WebDriver driver;
      private String baseUrl;
      private boolean acceptNextAlert = true;
      private StringBuffer verificationErrors = new StringBuffer();

      @BeforeClass(alwaysRun = true)
      public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://atqc-shop.epizy.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      }

      @Test
      public void testUntitled() throws Exception {
        driver.findElement(By.linkText("Reviews (0)")).click();
        driver.findElement(By.id("input-name")).clear();
        driver.findElement(By.id("input-name")).sendKeys("מנןמנ");
        driver.findElement(By.id("input-review")).clear();
        driver.findElement(By.id("input-review")).sendKeys("כמנמכ מכנמכן מכנטמן מכנמנןמ מכנכמנ");
        driver.findElement(By.xpath("(//input[@name='rating'])[2]")).click();
        driver.findElement(By.id("button-review")).click();
        driver.get(baseUrl + "/");
        driver.findElement(By.linkText("Canon EOS 5D")).click();
      }

      @AfterClass(alwaysRun = true)
      public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
          fail(verificationErrorString);
        }
      }

      private boolean isElementPresent(By by) {
        try {
          driver.findElement(by);
          return true;
        } catch (NoSuchElementException e) {
          return false;
        }
      }

      private boolean isAlertPresent() {
        try {
          driver.switchTo().alert();
          return true;
        } catch (NoAlertPresentException e) {
          return false;
        }
      }

      private String closeAlertAndGetItsText() {
        try {
          Alert alert = driver.switchTo().alert();
          String alertText = alert.getText();
          if (acceptNextAlert) {
            alert.accept();
          } else {
            alert.dismiss();
          }
          return alertText;
        } finally {
          acceptNextAlert = true;
        }
      }
    }


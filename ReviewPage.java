package testAutomation;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewPage {

    public ReviewPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(id = "input-name")
    private WebElement nameField;

    @FindBy(id = "input-review")
    private WebElement reviewField;

   @FindBy(xpath = "(//input[@name='rating'])")
    private WebElement ratingButton;

    @FindBy(id = "button-review")
    private WebElement reviewButton;
    
    @FindBy(id = "review")
    private WebElement reviewBox;
    
    @FindBy(css = "div.alert.alert-success")
    private WebElement reviewChek;
    
    public String chekRewiewMassege() {
        String rewiewMassegeChek = reviewChek.getText();
        return rewiewMassegeChek;
    }
    @FindBy(css = "div.alert.alert-danger")
    private WebElement reviewWrong;
    
    public String chekRewiewWrongMassege() {
        String rewiewMassegeWarning = reviewWrong.getText();
        return rewiewMassegeWarning;
    }
    
    public String getrewiewMassege() {
        String rewiewMassege = reviewBox.getText();
        return rewiewMassege;
    }
    public void  sentTestDate() {
	    inputName("Tania");
inputReview("review review review v review review");
	clickratingButton();
	clickreviewButton();
    }


    public void inputName(String name) {
	nameField.sendKeys(name);
    }

    public void inputReview(String review) {
	reviewField.sendKeys(review);
    }

    public void clickratingButton() {
	ratingButton.click();
    }

    public void clickreviewButton() {
	reviewButton.click();
    }
}

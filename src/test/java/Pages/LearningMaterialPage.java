package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LearningMaterialPage {

    WebDriver driver;

    @FindBy(id = "practice-heading") WebElement welcomeTitle_id;
    @FindBy(id = "logout-button") WebElement logout_btn_id;
    @FindBy(id = "tab-btn-api") WebElement api_btn_id;
    @FindBy(id = "tab-btn-web") WebElement web_btn_id;
    @FindBy(id = "tab-btn-password") WebElement basic_btn_id;
    @FindBy(id = "tab-btn-mobile") WebElement mobile_btn_id;


    public LearningMaterialPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void verifyWelcomeTitle()
    {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(visibilityOf(welcomeTitle_id));
        welcomeTitle_id.isDisplayed();
    }

    public  void logout()
    {
        logout_btn_id.click();
    }

    public void navigateLearningMaterialPage(String page)
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(logout_btn_id));

        switch (page.toLowerCase()) {
            case "api":
                api_btn_id.click();
                break;

            case "web":
                web_btn_id.click();
                break;

            case "basic":
                basic_btn_id.click();
                break;

            case "mobile":
                mobile_btn_id.click();
                break;

            default:
                throw new IllegalArgumentException("Invalid page: " + page);
        }
    }
}

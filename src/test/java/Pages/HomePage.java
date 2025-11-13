package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import java.time.Duration;

public class HomePage {


    WebDriver driver;

    @FindBy(id = "overview-hero")
    WebElement homepageTitle_id;

    @FindBy(id = "nav-btn-practice")
    WebElement learningMaterial_id;

    @FindBy(id = "nav-btn-contact")
    WebElement contactPage_id;

    @FindBy(id ="nav-btn-setup")
    WebElement enrolPage_id;

    @FindBy(id="nav-btn-about")
    WebElement aboutPage_id;

    @FindBy(id = "nav-btn-curriculum")
    WebElement curriculumPage_id;

    @FindBy(id = "nav-btn-testimonial")
    WebElement testimonialPage_id;



    public  HomePage(WebDriver driver)
    {
        this.driver = driver;

    }
    public void verifyHomePageIsDisplayed()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(homepageTitle_id));
        homepageTitle_id.isDisplayed();
    }
    public void clickLearningMaterial()
    {

        learningMaterial_id.click();

    }

    public void navigateHomePage(String page)
    {


        switch (page.toLowerCase()) {
            case "learning":
                learningMaterial_id.click();
                break;

            case "contact":
                contactPage_id.click();
                break;

            case "enrol":
                enrolPage_id.click();
                break;

            case "testimonial":
                testimonialPage_id.click();
                break;

            default:
                throw new IllegalArgumentException("Invalid page: " + page);
        }
    }




}

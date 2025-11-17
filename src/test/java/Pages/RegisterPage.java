package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driver)
    {
        this.driver = driver;
    }

    @FindBy(id= "register-firstName")
    WebElement firstName_id;
    @FindBy(id = "register-lastName")
    WebElement lastName_id;
    @FindBy(id= "register-email")
    WebElement email_id;
    @FindBy(id= "register-password")
    WebElement password_id;
    @FindBy(id = "register-confirmPassword")
    WebElement confirmPassword_id;
    @FindBy(id ="register-submit") WebElement register_submit_id;

    public  void registerAccount(String name, String surname,String email, String password, String confirmPassword)
    {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(visibilityOf(email_id));
        firstName_id.sendKeys(name);
        lastName_id.sendKeys(surname);
        email_id.sendKeys(email);
        password_id.sendKeys(password);
        confirmPassword_id.sendKeys(confirmPassword);
        register_submit_id.click();
    }

    public void clearRegisterFields()
    {
        firstName_id.clear();
        lastName_id.clear();
        email_id.clear();
        password_id.clear();
        confirmPassword_id.clear();
    }
}

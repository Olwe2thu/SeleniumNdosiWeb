package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "login-email")
    WebElement email_id;

    @FindBy(id = "login-password")
    WebElement password_id;

    @FindBy(id = "login-submit")
    WebElement login_btn_id;

    @FindBy(id = "signup-toggle")
    WebElement signUp_btn;



    public LoginPage (WebDriver driver)
    {
        this.driver = driver;
    }

    public void login( String email, String password)
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(email_id));
        email_id.sendKeys(email);
        password_id.sendKeys(password);
        login_btn_id.click();

    }

    public  void clickRegister()
    {
        signUp_btn.click();
    }
}

package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    WebElement confirmPasword_id;

    public  void registerAccount(String name, String surname,String email, String password, String confrimPassword)
    {
        firstName_id.sendKeys(name);
        lastName_id.sendKeys(surname);
        email_id.sendKeys(email);
        password_id.sendKeys(password);
        confirmPasword_id.sendKeys(confrimPassword);
    }
}

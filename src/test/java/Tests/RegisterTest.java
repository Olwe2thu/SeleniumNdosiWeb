package Tests;


import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

@Test
public class RegisterTest extends  Base{

    public void verifyHomePageIsDisplayedTest()
    {
        homePage.verifyHomePageIsDisplayed();
    }
    /*
        Password mismatch → Alert: Passwords do not match!
        Bad email format → Alert: Please enter a valid email address
        Password < 8 → Alert: Password must be at least 8 characters long
        Success → Alert includes Registration successful; login form shown with email filled.
     */

    @Test(dependsOnMethods = "verifyHomePageIsDisplayedTest")
    public void clickLearningMaterialTest()
    {
        homePage.clickLearningMaterial();
        loginPage.clickRegister();
    }

    @Test(dependsOnMethods = "clickLearningMaterialTest")
    public void passwordMismatchRegistrationTest()
    {
        registerPage.registerAccount("Java","TestNG","java@ng.com","T3sT","TEST");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        Assert.assertEquals(actualText, "Passwords do not match!");

        alert.accept();
    }

    @Test(dependsOnMethods = "clickLearningMaterialTest")
    public void badEmailFormatTest()
    {
        registerPage.registerAccount("Java","TestNG","testng.com","T3st","T3st");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert= driver.switchTo().alert();
        String actualText = alert.getText();
        Assert.assertEquals(actualText,"Please enter a valid email address");
    }

    @Test(dependsOnMethods = "clickLearningMaterialTest")
    public void passwordLengthTest()
    {
        registerPage.registerAccount("Java", "TestNG","test@ng.com","short","short");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert= driver.switchTo().alert();
        String actualText = alert.getText();
        Assert.assertEquals(actualText,"Password must be at least 8 characters long");
    }

    @Test(dependsOnMethods = "clickLearningMaterialTest")
    public  void validRegistrationTest()
    {
        registerPage.registerAccount("Java","TestNG","test@ng.com","ValidPassword","ValidPassword");
    }

    @Test(dependsOnMethods = "validRegistrationTest")
    public void newRegistrationLoginTest()
    {
        loginPage.login("test@ng.com","ValidPassword");
        learningMaterialPage.verifyWelcomeTitle();
    }


}

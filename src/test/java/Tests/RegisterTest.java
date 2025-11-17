package Tests;


import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

@Test
public class RegisterTest extends  Base{

    @Test(priority = 1)
    public void verifyHomePageIsDisplayedTest()
    {
        homePage.verifyHomePageIsDisplayed();
    }


    @Test(dependsOnMethods = "verifyHomePageIsDisplayedTest")
    public void badEmailFormatTest()
    {
        homePage.navigateHomePage("learning");
        loginPage.clickRegister();

        registerPage.registerAccount("Java","TestNG","testng","T3st","T3st");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert= driver.switchTo().alert();
        String actualText = alert.getText();
        Assert.assertEquals(actualText,"Please enter a valid email address");
        alert.accept();
        registerPage.clearRegisterFields();

    }

    @Test(dependsOnMethods = "badEmailFormatTest")
    public void passwordMismatchRegistrationTest()
    {

        registerPage.registerAccount("Java","TestNG","java@ng.com","T3sT","TEST");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        Assert.assertEquals(actualText, "Passwords do not match!");
        alert.accept();
        registerPage.clearRegisterFields();
    }



    @Test(dependsOnMethods = "verifyHomePageIsDisplayedTest")
    public void passwordLengthTest()
    {
        homePage.navigateHomePage("learning");
        loginPage.clickRegister();
        registerPage.registerAccount("Java", "TestNG","test@ng.com","short","short");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert= driver.switchTo().alert();
        String actualText = alert.getText();
        Assert.assertEquals(actualText,"Password must be at least 8 characters long");
        alert.accept();
        registerPage.clearRegisterFields();
    }

    @Test(dependsOnMethods = "passwordLengthTest")
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

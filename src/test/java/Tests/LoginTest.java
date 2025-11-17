package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.testng.AssertJUnit.assertTrue;


@Test
public class LoginTest extends Base {

    // REVIEW  THE DEPENDS ON FOR  THE  TESTS

    @Test(priority = 1)
    public void verifyHomePageIsDisplayedTest()
    {
        homePage.verifyHomePageIsDisplayed();
    }


    @Test(priority = 2)
    public void loginTest()
    {
        homePage.navigateHomePage("learning");
        loginPage.login("gti@test.com", "ozner22ktw");
        learningMaterialPage.verifyWelcomeTitle();
        learningMaterialPage.logout();
    }

    @Test(dependsOnMethods = "loginTest")
    public void extraSpacesLoginTest()
    {

        loginPage.login("gti@test.com ", "ozner22ktw");
        learningMaterialPage.verifyWelcomeTitle();
        learningMaterialPage.logout();
    }

    @Test(dependsOnMethods = "extraSpacesLoginTest")
    public void invalidLoginTest()
    {
        homePage.navigateHomePage("learning");
        loginPage.login("gti@wrongEmail.com", "ozner22ktw");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        Assert.assertEquals(actualText, "Invalid email or password");
        alert.accept();


    }
    @Test(dependsOnMethods = "invalidLoginTest")
    public  void switchTabsTest()
    {
        loginPage.clearField();
        loginPage.login("gti@test.com", "ozner22ktw");
        learningMaterialPage.verifyWelcomeTitle();
        homePage.navigateHomePage("enrol");
        homePage.navigateHomePage("learning");
        loginPage.login("gti@test.com", "ozner22ktw");
        learningMaterialPage.verifyWelcomeTitle();

    }



}

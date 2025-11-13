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

    public void verifyHomePageIsDisplayedTest()
    {
        homePage.verifyHomePageIsDisplayed();
    }

    @Test(dependsOnMethods = "verifyHomePageIsDisplayedTest")
    public void clickLearningMaterialTest()
    {
        homePage.clickLearningMaterial();
    }

    @Test(dependsOnMethods = "clickLearningMaterialTest")
    public void loginTest()
    {
        loginPage.login("gti@test.com", "ozner22ktw");
        learningMaterialPage.verifyWelcomeTitle();
    }
    @Test(dependsOnMethods = "clickLearningMaterialTest")
    public void extraSpacesLoginTest()
    {
        loginPage.login("gti@test.com ", "ozner22ktw");
        learningMaterialPage.verifyWelcomeTitle();
    }

    @Test(dependsOnMethods = "clickLearningMaterialTest")
    public void invalidLoginTest()
    {
        loginPage.login("gtti@test.com", "oznerk");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());


        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        Assert.assertEquals(actualText, "Invalid email or password");

        // Accept the alertalert.accept();
    }



    @Test(dependsOnMethods = "loginTest")
    public void navigateToWebAutomationAdvance() throws InterruptedException
    {
        learningMaterialPage.navigateLearningMaterialPage("web");
        Thread.sleep(3000);
        //assert
    }

    @Test(dependsOnMethods = "navigateToWebAutomationAdvance")
    public void formCompletionTest() throws InterruptedException
    {
        webAutomationAdvancePage.completeInvoice("Phone","Apple","White","3","404 Error Street");
        Thread.sleep(3000);
    }

    @Test(dependsOnMethods = "formCompletionTest")
    public  void verifyOrderSummary() throws  InterruptedException
    {
        assert webAutomationAdvancePage.verify64GBPricingSummary(3) == 1200;
        Thread.sleep(2000);

    }








//    @AfterTest
//    public  void closeBrowser()
//    {
//        driver.quit();
//    }


}

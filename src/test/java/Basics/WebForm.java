package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebForm {

    WebDriver driver;

    @BeforeTest
    public void launchBrowser()
    {
        driver = new ChromeDriver();

    }

    @Test
    public void startBrowser()throws InterruptedException
    {
        driver.get("https://www.ndosiautomation.co.za/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public  void verifyHomePage()
    {
        driver.findElement(By.xpath("//*[@id=\"overview-hero\"]/h2")).isDisplayed();
    }

    @Test(priority = 2)
    public  void navigateToLearningMaterial() throws InterruptedException
    {
        driver.findElement(By.id("nav-btn-practice")).click();
        Thread.sleep(2000);
//        String expectedUrl = "https://www.ndosiautomation.co.za/#practice";
//        String currentUrl= driver.getCurrentUrl();
//        assert expectedUrl.equals(currentUrl);
    }

    @Test(priority = 3)
    public void login() throws  InterruptedException
    {
        driver.findElement(By.id("login-email")).sendKeys("gti@test.com");
        Thread.sleep(2000);
        driver.findElement(By.id("login-password")).sendKeys("ozner22ktw");
        Thread.sleep(2000);
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void navigateToForm() throws InterruptedException
    {
        driver.findElement(By.xpath("//span[text()='Web Automation Basic Form']")).click();
    }

    @Test(priority = 5)
    public void fillInForm() throws InterruptedException
    {
        driver.findElement(By.id("name")).sendKeys("Olwethu");
        driver.findElement(By.id("email")).sendKeys("allwhere2@name.com");
        driver.findElement(By.id("age")).sendKeys("36");
        driver.findElement(By.id("gender")).sendKeys("Male");
        driver.findElement(By.id("country")).sendKeys("Canada");
        driver.findElement(By.id("experience")).sendKeys("Beginner(0-1 years)");
        driver.findElement(By.id("skill-javascript")).click();
        driver.findElement(By.id("comments")).sendKeys("Let's Learn Automation");
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("submit-btn")).click();
    }

    @Test(priority = 6)
    public void closeBrowser()
    {
        driver.quit();
    }




}

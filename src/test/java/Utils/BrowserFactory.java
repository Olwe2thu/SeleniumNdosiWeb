package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.Test;

public class BrowserFactory {
    static WebDriver driver;


    public static WebDriver startBrowser( String browserChoice, String url)
    {
        if(browserChoice.equalsIgnoreCase("Chrome"))
        {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headed");
            driver = new ChromeDriver();
        }
        else if(browserChoice.equalsIgnoreCase("FireFox"))
        {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--headless");
            driver= new FirefoxDriver();
        }
        else
        {
           driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

//    @Test
//    public void test()
//    {
//        startBrowser("Chrome" , "https://dde.qa.condorgreenapps.co.za/signin");
//    }
}

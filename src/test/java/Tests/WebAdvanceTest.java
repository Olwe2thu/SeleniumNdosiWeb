package Tests;

import org.testng.annotations.Test;

@Test
public class WebAdvanceTest extends Base{

    @Test
    public void order64GBPhoneTest()
    {
        homePage.navigateHomePage("learning");
        loginPage.login("gti@test.com","ozner22ktw");
        learningMaterialPage.verifyWelcomeTitle();
        learningMaterialPage.navigateLearningMaterialPage("web");
        webAutomationAdvancePage.completeInvoice("Phone","Apple","64","White","1","64GB Phone Street");
        webAutomationAdvancePage.clickNext();
        webAutomationAdvancePage.chooseShipping("express");
        webAutomationAdvancePage.chooseWarranty("one");
        webAutomationAdvancePage.enterDiscount("SAVE10");
        webAutomationAdvancePage.clickAddToCart();
    }

    @Test(dependsOnMethods = "order64GBPhoneTest")
    public  void order128GBPhoneTest()
    {
        webAutomationAdvancePage.completeInvoice("Phone","Samsung","128","Black","2","128Gb Phone Street");
        webAutomationAdvancePage.clickNext();
        webAutomationAdvancePage.chooseShipping("express");
        webAutomationAdvancePage.chooseWarranty("two");
        webAutomationAdvancePage.enterDiscount("SAVE20");
        webAutomationAdvancePage.clickAddToCart();
    }

    @Test(dependsOnMethods ="order128GBPhoneTest" )
    public  void  order256GBLaptopTest()
    {
        webAutomationAdvancePage.completeInvoice("Laptop","Macbook air","256","White","2","256Gb Phone Street");
        webAutomationAdvancePage.clickNext();
        webAutomationAdvancePage.chooseShipping("express");
        webAutomationAdvancePage.chooseWarranty("one");
        webAutomationAdvancePage.enterDiscount("SAVE20");
        webAutomationAdvancePage.clickAddToCart();
    }

}

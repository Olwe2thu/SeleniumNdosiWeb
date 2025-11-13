package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class WebAutomationAdvancePage {
    WebDriver driver;

    @FindBy(id = "invoices-toggle-btn") WebElement invoice_btn_id;
    @FindBy(id = "deviceType") WebElement device_type_id;
    @FindBy(id ="brand") WebElement brand_id;
    @FindBy(id = "color") WebElement color_id;
    @FindBy(id = "storage-64GB") WebElement storage64_GB_id;
    @FindBy(id = "storage-128GB") WebElement storage128_GB_id;
    @FindBy(id = "storage-256GB") WebElement storage256_GB_id;
    @FindBy(id = "quantity") WebElement quantity_id;

    @FindBy(id="unit-price-value") WebElement unit_price_label;
    @FindBy(id="quantity-label") WebElement quantity_label;
    @FindBy(id = "subtotal-label") WebElement subtotal_label;


    @FindBy(id = "address") WebElement address_id;
    @FindBy(id = "inventory-next-btn") WebElement iNext_btn_id;
    @FindBy(id = "close-invoice-history-btn") WebElement closeInvoices_id;
    @FindBy(id = "clear-all-invoices-btn") WebElement clear_invoices_id;
    @FindBy(id = "assessment-instructions") WebElement instructions_id;


    public  WebAutomationAdvancePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void completeInvoice(String deviceType, String  brand, String color, String quantity ,String address)
    {

        device_type_id.sendKeys(deviceType);
        brand_id.sendKeys(brand);
        storage64_GB_id.click();
        quantity_id.clear();
        quantity_id.sendKeys(quantity);
        address_id.sendKeys(address);
        color_id.sendKeys(color);

    }
    public int verify64GBPricingSummary(int quantity)
    {
        int unitPrice = 400,subtotal;
        subtotal = unitPrice * quantity;
        iNext_btn_id.click();
        return  subtotal;

    }




}

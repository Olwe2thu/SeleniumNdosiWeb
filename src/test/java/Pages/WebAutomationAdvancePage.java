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

    @FindBy(id="shipping-option-express") WebElement express_shipping_id;
    @FindBy(id="shipping-option-standard") WebElement standard_shipping_id;
    @FindBy(id="warranty-option-2yr") WebElement twoYear_warranty_id;
    @FindBy(id="warranty-option-1yr") WebElement oneYear_warranty_id;
    @FindBy(id="warranty-option-none") WebElement no_warranty_id;
    @FindBy(id ="discount-code") WebElement discount_code_id;
    @FindBy(id ="breakdown-total-value") WebElement breakdownTotal_id;


    @FindBy(id = "address") WebElement address_id;
    @FindBy(id = "inventory-next-btn") WebElement iNext_btn_id;
    @FindBy(id = "close-invoice-history-btn") WebElement closeInvoices_id;
    @FindBy(id = "clear-all-invoices-btn") WebElement clear_invoices_id;
    @FindBy(id = "assessment-instructions") WebElement instructions_id;
    @FindBy(id = "add-to-cart-btn") WebElement addToCart_id;


    public  WebAutomationAdvancePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void completeInvoice(String deviceType, String  brand, String storage,String color, String quantity ,String address)
    {

        device_type_id.sendKeys(deviceType);
        brand_id.sendKeys(brand);
        chooseStorage(storage);
        quantity_id.clear();
        quantity_id.sendKeys(quantity);
        address_id.sendKeys(address);
        color_id.sendKeys(color);

    }
    public void chooseStorage(String button)
    {
        switch (button.toLowerCase()) {
            case "64":
                storage64_GB_id.click();
                break;

            case "128":
                storage128_GB_id.click();
                break;

            case "256":
                storage256_GB_id.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid button: " + button);
        }
    }

    public void chooseShipping(String shippingMethod)
    {
        switch (shippingMethod.toLowerCase()){
            case "standard":
                standard_shipping_id.click();
                break;

            case "express":
                express_shipping_id.click();
                break;

            default:
                throw  new IllegalArgumentException("Shipping method "+ shippingMethod + " does not exist");
        }
    }

    public void chooseWarranty(String warranty)
    {
        switch (warranty.toLowerCase()) {
            case "none":
                no_warranty_id.click();
                break;

            case "one":
                oneYear_warranty_id.click();
                break;

            case "two":
                twoYear_warranty_id.click();
                break;

            default:
                throw new IllegalArgumentException(" Invalid warranty" );

        }
    }

    public  void enterDiscount(String discountCode)
    {
        discount_code_id.sendKeys(discountCode);
    }


    public void  verifyPricingBreakdown( int unitPrice, int quantity,int warranty,String shipping,int discount)
    {
        double tenPercentDiscount=0.1, twentyPercentDiscount=0.2;
        int oneYearWarranty = 49,  twoYearWarranty = 89, expressShipping = 25;

        int subtotal = unitPrice *quantity;
//        int total = subtotal + warranty+shippin;

        if(discount == 10)
        {
            if(warranty == 1 || shipping.equalsIgnoreCase("express"))
            {
                int total = subtotal + oneYearWarranty + expressShipping;
                int discountedValue = (int) (total * tenPercentDiscount);
                int overallTotal = subtotal - discountedValue;

            }
            else if (warranty ==2 || shipping.equalsIgnoreCase("express"))
            {
                int total = subtotal + twoYearWarranty + expressShipping;
                int discountedValue = (int) (total * tenPercentDiscount);
                int overallTotal = subtotal - discountedValue;
            }

        } else if (discount == 20)
        {
            if(warranty == 1 || shipping.equalsIgnoreCase("express"))
            {
                int total = subtotal + oneYearWarranty + expressShipping;
                int discountedValue = (int) (total * twentyPercentDiscount);
                int overallTotal = subtotal - discountedValue;
            }
            else if (warranty ==2 || shipping.equalsIgnoreCase("express"))
            {
                int total = subtotal + twoYearWarranty + expressShipping;
                int discountedValue = (int) (total * twentyPercentDiscount);
                int overallTotal = subtotal - discountedValue;
            }
        }
        else{
            System.out.print("Invalid discount entered");
        }

        // to add  assert



    }

    public void clickNext()
    {
        iNext_btn_id.click();
    }
    public  void clickAddToCart()
    {
        addToCart_id.click();

    }







}

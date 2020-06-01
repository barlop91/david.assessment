package com.automation.techassessment.ui.pages.sauce;

import com.automation.techassessment.ui.lib.UIThreadManager;
import com.slickqa.webdriver.FindBy;
import com.slickqa.webdriver.PageElement;
import com.slickqa.webdriver.WebDriverWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DashboardPage {
    private final Logger logger = LogManager.getLogger(this.getClass());

    private PageElement productContainer = new PageElement("Product container", FindBy.id("inventory_container"));
    private PageElement productOnesie = new PageElement("Sauce Labs Onesie", FindBy.id("item_2_title_link"));
    private PageElement productBikeLight = new PageElement("Sauce Labs Bike Light", FindBy.id("item_0_title_link"));
    private PageElement productDetails = new PageElement("Inventory Details", FindBy.id("inventory_details"));
    private PageElement addToCartBtn = new PageElement("Add to cart btn", FindBy.className("btn_primary"));
    private PageElement cartBadge = new PageElement("Cart Badge",FindBy.className("fa-layers-counter"));
    private PageElement backBtn = new PageElement("Back Button", FindBy.className("inventory_details_back_button"));
    private PageElement cartIcon =  new PageElement("Cart Icon", FindBy.id("shopping_cart_container"));

    public void selectItem(String item) throws InterruptedException {
        WebDriverWrapper webDriverWrapper = UIThreadManager.getBrowser();
        switch (item) {
            case "Sauce Labs Onesie":
                webDriverWrapper.waitForVisible(productOnesie, 10);
                webDriverWrapper.click(productOnesie);
                break;
            case "Sauce Labs Bike Light":
                webDriverWrapper.waitForVisible(productBikeLight, 10);
                webDriverWrapper.click(productBikeLight);
                break;
        }
    }

    public void clickAddToCart(){
        WebDriverWrapper webDriverWrapper = UIThreadManager.getBrowser();
        webDriverWrapper.waitForVisible(addToCartBtn, 10);
        webDriverWrapper.click(addToCartBtn);
    }

    public void clickBackBtn(){
        WebDriverWrapper webDriverWrapper = UIThreadManager.getBrowser();
        webDriverWrapper.waitForVisible(backBtn, 10);
        webDriverWrapper.click(backBtn);
    }

    public void clickCartIcon(){
        WebDriverWrapper webDriverWrapper = UIThreadManager.getBrowser();
        webDriverWrapper.waitForVisible(backBtn, 10);
        webDriverWrapper.click(backBtn);
    }



    public boolean productContainerIsVisible () {
        return UIThreadManager.getBrowser().exists(productContainer);
    }

    public boolean productDescriptionIsVisible(){
        return UIThreadManager.getBrowser().exists(productDetails);
    }

    public boolean shoppingBadgeIsVisible(){
        return UIThreadManager.getBrowser().exists(cartBadge);
    }
}

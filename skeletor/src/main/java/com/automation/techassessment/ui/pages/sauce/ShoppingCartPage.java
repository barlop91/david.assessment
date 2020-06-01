package com.automation.techassessment.ui.pages.sauce;
import com.automation.techassessment.ui.lib.UIThreadManager;
import com.slickqa.webdriver.FindBy;
import com.slickqa.webdriver.PageElement;
import com.slickqa.webdriver.WebDriverWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShoppingCartPage{
    private final Logger logger = LogManager.getLogger(this.getClass());

    private PageElement itemOne = new PageElement("Item One", FindBy.id("item_0_title_link"));
    private PageElement itemTwo = new PageElement("Item Two", FindBy.id("item_2_title_link"));


    public String getItemOneText() {
        return UIThreadManager.getBrowser().getText(itemOne);
    }

    public String getItemTwoText() {
        return UIThreadManager.getBrowser().getText(itemTwo);
    }
}

package com.automation.techassessment.ui.Sauce;

import com.automation.techassessment.ui.lib.Wait;
import com.automation.techassessment.ui.pages.sauce.DashboardPage;
import com.automation.techassessment.ui.pages.sauce.SauceDemo;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class AddItemsSauceTest extends BaseUITest{


    @Test
    public void addItemTest() throws Exception {
        SoftAssert softAssert = new SoftAssert();

        SauceDemo.Login.login("standard_user", "secret_sauce");
        softAssert.assertTrue(SauceDemo.MenuBar.menuBarButtonExists(), "Unable to find Menu Bar button, login must have failed");
        softAssert.assertTrue(SauceDemo.Dashboard.productContainerIsVisible(), "Unable to find Product Container, dashboard must have failed to load");

        /// SELECT ITEM 1 ////
        SauceDemo.Dashboard.selectItem("Sauce Labs Onesie");
        softAssert.assertTrue(SauceDemo.Dashboard.productDescriptionIsVisible(), "Unable to find Product details");
        SauceDemo.Dashboard.clickAddToCart();
        softAssert.assertTrue(SauceDemo.Dashboard.shoppingBadgeIsVisible(), "Unable to find Shopping Cart Badge");
        SauceDemo.Dashboard.clickBackBtn();
        softAssert.assertTrue(SauceDemo.Dashboard.productContainerIsVisible(), "Unable to find Product Container, dashboard must have failed to load");

        /// SELECT ITEM 2 ///
        SauceDemo.Dashboard.selectItem("Sauce Labs Bike Light");
        softAssert.assertTrue(SauceDemo.Dashboard.productDescriptionIsVisible(), "Unable to find Product details");
        SauceDemo.Dashboard.clickAddToCart();
        softAssert.assertTrue(SauceDemo.Dashboard.shoppingBadgeIsVisible(), "Unable to find Shopping Cart Badge");

        //// VALIDATE BOTH ITEMS ARE IN SHOPPING CART ///
        SauceDemo.Dashboard.clickCartIcon();
        final String expectedMessageOne = "Sauce Labs Bike Light";
        String actualMessage = SauceDemo.ShoppingCard.getItemOneText();
        Assert.assertTrue(actualMessage.contains(expectedMessageOne), String.format("Incorrect Item Name.  Expected partial message: '%s'  Found: '%s'", expectedMessageOne, actualMessage));

        final String expectedMessageTwo = "Sauce Labs Onesie";
        String actualMessageTwo = SauceDemo.ShoppingCard.getItemTwoText();
        Assert.assertTrue(actualMessageTwo.contains(expectedMessageTwo), String.format("Incorrect Item Name.  Expected partial message: '%s'  Found: '%s'", expectedMessageTwo, actualMessageTwo));

        }
}
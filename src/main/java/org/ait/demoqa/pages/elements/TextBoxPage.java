package org.ait.demoqa.pages.elements;

import org.ait.demoqa.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class TextBoxPage extends BasePage {
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "currentAddress")
    WebElement currentAddress;
    public TextBoxPage keyboardEvent(String text) {
        typeWithJSExecutor(currentAddress,text,0,100);
        Actions actions = new Actions(driver);
        //select current address
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        //copy current address
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        //press TAB key to switch focus to permanent address
        actions.sendKeys(Keys.TAB).perform();
        //paste current address in permanent address field
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        return this;
    }

    /*@FindBy(xpath = "//p[@id='permanentAddress']")
    WebElement permanentAddress;

 @FindBy(xpath = "//p[@id='currentAddress']")
    WebElement currentAddressAfterSubmit;


    public TextBoxPage assertCopyPasteText(String expectedText) {

        String text1 = String.valueOf(currentAddressAfterSubmit.getText().startsWith(expectedText));
        String text2 = String.valueOf(permanentAddress.getText().startsWith(expectedText));
       Assert.assertEquals(text1,text2);
        return this;
    }*/
    @FindBy(id = "submit")
    WebElement submitBtn;

    @FindBy(css = ".border > #currentAddress")
    WebElement currentAddressResult;

    @FindBy(css = ".border > #permanentAddress")
    WebElement permanentAddressResult;

    public TextBoxPage assertCopyPasteText() {
        clickWithJSExecutor(submitBtn,0,400);
        String[] current =  currentAddressResult.getText().split(":");
        String[] permanent =  permanentAddressResult.getText().split(":");

        Assert.assertEquals(permanent[1],current[1]);
        return this;
    }
}

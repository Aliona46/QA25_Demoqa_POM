package org.ait.demoqa.pages.alertsFrameWindows;

import org.ait.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class WindowsPage extends BasePage {

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

   @FindBy(id = "tabButton")
    WebElement newTab;
    public WindowsPage switchToNewTab(int index) {
        click(newTab);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }

    @FindBy(tagName = "h1")
    WebElement title;
    public WindowsPage verifyNewTabTitle(String text) {
        Assert.assertTrue(isTextPresent(title, text));

        return this;
    }

    @FindBy(id = "windowButton")
    WebElement newWindow;
    public WindowsPage switchToNewWindow(int index) {
        click(newWindow);
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(index));
        return this;
    }

    @FindBy(tagName = "h1")
    WebElement newWindowTitle;
    public WindowsPage verifyNewWindowTitle(String text) {
        Assert.assertTrue(isTextPresent(newWindowTitle, text));
        return this;
    }
}

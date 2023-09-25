package org.ait.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanel extends BasePage{

    public SidePanel(WebDriver driver) {
        super(driver);
    }
@FindBy(css= ".show #item-0")
    WebElement login;

    public LoginPage selectLogin() {
        clickWithJSExecutor(login, 0, 600);
        return new LoginPage(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'Alerts')]")
    WebElement alertsLinkFromAccordion;
    public AlertsPage selectAlerts() {
        clickWithJSExecutor(alertsLinkFromAccordion,0,400);
        return new AlertsPage(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'Browser Windows')]")
    WebElement browserWindowsLinkFromAccordion;
    public WindowsPage selectBrowserWindows() {
        clickWithJSExecutor(browserWindowsLinkFromAccordion,0,400);
        return new WindowsPage(driver);
    }
}

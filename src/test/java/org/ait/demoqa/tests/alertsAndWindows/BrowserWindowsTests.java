package org.ait.demoqa.tests.alertsAndWindows;

import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.SidePanel;
import org.ait.demoqa.pages.alertsAndWindows.WindowsPage;
import org.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserWindowsTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getWindows();
        new SidePanel(driver).selectBrowserWindows();
    }

    @Test
    public void switchToNewTabTest() {

        new WindowsPage(driver).switchToNewTab(1)
                .verifyNewTabTitle("This is a sample page");
    }

    @Test
    public void switchToNewWindowTest() {
        new WindowsPage(driver).switchToNewWindow(1)
                .verifyNewWindowTitle("This is a sample page");
    }
}

package org.ait.demoqa.tests;

import org.ait.demoqa.pages.AlertsPage;
import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.SidePanel;
import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase {
    @BeforeMethod
    public void preconditions() {

        new HomePage(driver).getAlerts();
    }

    @Test
    public void acceptSimpleAlert() {
        new SidePanel(driver).selectAlerts();
        new AlertsPage(driver).clickOnAlertButton()
                .acceptAlert();

    }

    @Test
    public void acceptSimpleTimerAlert() {
        new SidePanel(driver).selectAlerts();
        new AlertsPage(driver).clickOnTimerAlertButton()
                .acceptAlertAfter5Sec();
    }

    @Test
    public void confirmAlertTest() {
        new SidePanel(driver).selectAlerts();
        new AlertsPage(driver).clickOnConfirmAlertButton()
                .selectConfirm("Ok")
                .verifyResult("Ok");
    }

    @Test
    public void sendMessageToAlertTest() {
        new SidePanel(driver).selectAlerts();
        new AlertsPage(driver).clickOnPromptButton()
                .enterMessageToAlert("hello")
                .acceptAlert()
                .verifyPromptResult("hello");
    }
}

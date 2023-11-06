package demoqa;

import base.BaseTest;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.AutomationUtilities;
import utilities.Logs;

public class WindowsTabTests extends BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        Logs.info("Navigating to Index");
        driver.get("https://demoqa.com/browser-windows");

        Logs.info("Waiting 3 seconds");
        AutomationUtilities.automationSleep(3000);
    }

    @Test
    public void newTabTest() {
        final var idFirstPage = driver.getWindowHandle();
        final var newWindowLocator = By.id("tabButton");
        final var windowTabButton = driver.findElement(newWindowLocator);

        windowTabButton.click();

        final var idsPagesList = driver.getWindowHandles();
        Logs.debug("IdList: %s", idsPagesList);

        var newIndex = "";

        for (var id : idsPagesList) {
            if (!id.equals(idFirstPage)) {
                newIndex = id;
            }
        }

        Logs.info("Switching tab with ID %s", newIndex);
        driver.switchTo().window(newIndex);

        Logs.info("Waiting 1 seconds");
        AutomationUtilities.automationSleep(1000);

        Logs.info("Closing Second Page");
        driver.close();

        Logs.info("Return to HomePage");
        driver.switchTo().window(idFirstPage);

        final var titleLocator = By.xpath("//div[text()='Browser Windows']");
        final var title = driver.findElement(titleLocator);

        Logs.info("Verifying return to Principal tab");
        Assert.assertTrue(title.isDisplayed());
    }

    @Test
    public void newTab2Test() {
        final var idFirstPage = driver.getWindowHandle();
        final var newWindowLocator = By.id("tabButton");
        final var windowTabButton = driver.findElement(newWindowLocator);

        final var faker = new Faker();
        final var n = faker.random().nextInt(5, 10);

        Logs.info("Clicking %s times", n);
        for (var i = 0; i < n; i++) {
            Logs.info("Clicking");
            windowTabButton.click();
            Logs.info("Waiting 0.5 seconds");
            AutomationUtilities.automationSleep(500);
        }

        final var idsPagesList = driver.getWindowHandles();
        Logs.debug("IdList: %s", idsPagesList);

        Logs.info("Verifying Size of Tabs open");
        Assert.assertEquals(idsPagesList.size(), n + 1);

        Logs.info("Closing tabs");
        for (var id : idsPagesList) {
            if (!id.equals(idFirstPage)) {
                driver.switchTo().window(id);
                Logs.info("Closing tab %s", id);
                driver.close();
            }

        }

        Logs.info("Verifying Tabs open it's only 1");
        final var idsPagesListActual = driver.getWindowHandles();
        Assert.assertEquals(idsPagesListActual.size(), 1);
    }

    @Test
    public void newWindowTest() {
        final var idFirstPage = driver.getWindowHandle();
        final var newWindowLocator = By.id("windowButton");
        final var windowButton = driver.findElement(newWindowLocator);

        final var faker = new Faker();
        final var n = faker.random().nextInt(5, 10);

        Logs.info("Clicking %s times", n);
        for (var i = 0; i < n; i++) {
            Logs.info("Clicking");
            windowButton.click();
            Logs.info("Waiting 0.5 seconds");
            AutomationUtilities.automationSleep(500);
        }

        final var idsPagesList = driver.getWindowHandles();
        Logs.debug("IdList: %s", idsPagesList);

        Logs.info("Verifying Size of Windows open");
        Assert.assertEquals(idsPagesList.size(), n + 1);

        Logs.info("Closing Windows");
        for (var id : idsPagesList) {
            if (!id.equals(idFirstPage)) {
                driver.switchTo().window(id);
                Logs.info("Closing Window %s", id);
                driver.close();
            }
        }

        Logs.info("Verifying Window open it's only 1");
        final var idsPagesListActual = driver.getWindowHandles();
        Assert.assertEquals(idsPagesListActual.size(), 1);
    }
}
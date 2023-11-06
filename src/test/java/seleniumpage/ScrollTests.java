package seleniumpage;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.AutomationUtilities;
import utilities.Logs;

public class ScrollTests extends BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        Logs.info("Navigating to Index");
        driver.get("https://www.selenium.dev/selenium/web/scrolling_tests/frame_with_nested_scrolling_frame_out_of_view.html");

        Logs.info("Waiting 2 seconds");
        AutomationUtilities.automationSleep(2000);
    }

    @Test
    public void verifyingScrollPage() {
        Logs.info("Switching focus to Iframe");

        final var iframeLocator = By.name("nested_scrolling_frame");
        final var iframe = driver.findElement(iframeLocator);

        Logs.info("Verifying Iframe is visible");
        Assert.assertTrue(iframe.isDisplayed());

        final var actions = new Actions(driver);
        Logs.info("Scrolling to the Iframe ");
        actions.scrollToElement(iframe).pause(1000).perform();

        Logs.info("Verifying Iframe is visible");
        Assert.assertTrue(iframe.isDisplayed());
    }
}

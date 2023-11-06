package automation;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.AutomationUtilities;
import utilities.Logs;

public class FirstTests extends BaseTest {
    @Test
    public void basicTest() {
        Logs.info("Navigating to Google");
        driver.get("https://www.google.com/");

        Logs.info("Waiting 3 seconds");
        AutomationUtilities.automationSleep(3000);
    }

    @Test
    public void newTest() {
        Logs.info("Go to ultimatega page");
        final var url = "https://ultimateqa.com/automation";
        driver.get(url);

        Logs.info("Waiting 3 seconds");
        AutomationUtilities.automationSleep(3000);

        Logs.info("Getting for the actual URL ");
        final var currentURL = driver.getCurrentUrl();

        Logs.info("Verifying that both URL are the same");
        Assert.assertEquals(url, currentURL);
    }

    @Test
    public void secondTest() {

        Logs.info("Go to ultimatega page");
        final var url = "https://ultimateqa.com/automation";
        driver.get(url);

        Logs.info("Waiting 3 seconds");
        AutomationUtilities.automationSleep(3000);

        Logs.info("Go to Stackoverflow page");
        final var url2 = "https://stackoverflow.com/";
        driver.get(url2);

        Logs.info("Back to the last page");
        driver.navigate().back();

        Logs.info("Getting for the actual URL ");
        var currentURL = driver.getCurrentUrl();

        Logs.info("Verifying that Back page is correct ");
        Assert.assertEquals(url, currentURL);

        Logs.info("forward Page");
        driver.navigate().forward();

        currentURL = driver.getCurrentUrl();
        Logs.info("Verifying that forward page is correct ");
        Assert.assertEquals("https://stackoverflow.com/", currentURL);
    }
}
package automation;

import base.BaseTest;
import org.testng.annotations.Test;
import utilities.AutomationUtilities;
import utilities.Logs;

public class FirstTests extends BaseTest {
    @Test(groups = regression)
    public void basicTest() {
        Logs.info("Navigating to Google");
        driver.get("https://www.google.com/");

        Logs.info("Waiting 3 seconds");
        AutomationUtilities.automationSleep(3000);
    }
}

package practicepage;

import base.BaseTest;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.AutomationUtilities;
import utilities.Logs;

public class PracticePageTests extends BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        Logs.info("Navigating to Index");
        driver.get("https://practice.expandtesting.com/large");

        Logs.info("Waiting 3 seconds");
        AutomationUtilities.automationSleep(3000);
    }

    @Test
    public void scrollTest() {
        final var dimension = driver.manage().window().getSize();
        final var dimensionHigh = dimension.getHeight();

        final var actions = new Actions(driver);

        Logs.info("Scrolling twice");
        actions.scrollByAmount(0, dimensionHigh * 2).pause(1000).perform();
    }
}

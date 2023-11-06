package globalsqa;

import base.BaseTest;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.AutomationUtilities;
import utilities.Logs;

public class IframeTests extends BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        Logs.info("Navigating to Index");
        driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame");

        Logs.info("Waiting 2 seconds");
        AutomationUtilities.automationSleep(2000);
    }

    @Test
    public void iFrameTest() {
        final var faker = new Faker();
        final var randomText = faker.lordOfTheRings().character();

        Logs.info("Switching focus to Iframe");
        driver.switchTo().frame("globalSqa");

        final var searchLocator = By.id("s");
        final var searchBar = driver.findElement(searchLocator);

        Logs.info("Writing Random text");
        searchBar.click();
        searchBar.sendKeys(randomText);

        Logs.info("Waiting 2 seconds");
        AutomationUtilities.automationSleep(2000);

        final var searchButtonLocator = By.className("button_search");
        final var searchButton = driver.findElement(searchButtonLocator);
        Logs.info("Clicking search button");
        searchButton.click();

        Logs.info("Waiting 6 seconds");
        AutomationUtilities.automationSleep(6000);

        final var resultLocator = By.xpath("//p[text()='Sorry, no posts matched your criteria.']");
        final var resultText = driver.findElement(resultLocator);

        Logs.info("Verifying Result text");
        Assert.assertTrue(resultText.isDisplayed());
    }
}

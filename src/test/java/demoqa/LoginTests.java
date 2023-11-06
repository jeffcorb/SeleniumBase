package demoqa;

import base.BaseTest;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.AutomationUtilities;
import utilities.Logs;

public class LoginTests extends BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        Logs.info("Navigating to Index");
        driver.get("https://demoqa.com/login");

        Logs.info("Waiting 2 seconds");
        AutomationUtilities.automationSleep(2000);
    }

    @Test
    public void demoQAActionTest() {
        final var inputLocator = By.id("userName");
        final var input = driver.findElement(inputLocator);
        input.click();

        final var faker = new Faker();
        final var textInput = faker.lordOfTheRings().character();

        Logs.info("Sending Keys with Actions Shift UP and Down");
        final var actions = new Actions(driver);

        Logs.info("Pressing down shift");
        actions.keyDown(Keys.LEFT_SHIFT);

        Logs.info("Writing text input");
        actions.sendKeys(textInput);

        Logs.info("Pressing Up Left Shift");
        actions.keyUp(Keys.LEFT_SHIFT);

        Logs.info("Waiting 1500ms");
        actions.pause(1500);

        Logs.info("Performing sequence");
        actions.perform();

        Logs.info("Verifying Text its correct");
        Assert.assertEquals(input.getAttribute("value"), textInput.toUpperCase());
    }

    @Test
    public void demoQAtripleClick() {
        final var inputLocator = By.id("userName");
        final var input = driver.findElement(inputLocator);

        final var faker = new Faker();
        final var textInput = faker.lordOfTheRings().character();

        Logs.info("Sending Keys with Actions Shift UP and Down");
        new Actions(driver)
                .click(input)
                .sendKeys(textInput)
                .click()
                .click()
                .click()
                .pause(1000)
                .keyDown(Keys.COMMAND)
                .keyDown("c")
                .keyUp(Keys.COMMAND)
                .keyUp("c")
                .pause(500)
                .keyDown(Keys.DELETE)
                .keyUp(Keys.DELETE)
                .keyDown(Keys.COMMAND)
                .keyDown("v")
                .pause(200)
                .keyUp(Keys.COMMAND)
                .keyUp("v") //fin 1
                .keyDown(Keys.COMMAND)
                .keyDown("v")
                .pause(200)
                .keyUp(Keys.COMMAND)
                .keyUp("v") //fin 2
                .pause(1000)
                .perform();

        Logs.info("Verifying Text its correct");
        Assert.assertEquals(input.getAttribute("value"), String.format("%s%s", textInput, textInput));
    }
}
package utilities;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOExceptionList;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class FileManager {
    private final static String screenshotPath ="src/test/resources/screenshots";
    private final static String allurePath = "target/allure-results";

    public static void getScreenshot(String screenShotName){
        Logs.debug("Taking Screenshot");
        final var screenshotFile = ((TakesScreenshot)BaseTest.getDriver()).getScreenshotAs(OutputType.FILE);
        final var path = String.format("%s/%s.png",screenshotPath,screenShotName);

        try {
            FileUtils.copyFile(screenshotFile, new File(path));
        } catch (IOException ioException){
            Logs.error("ioException: %s ",ioException.getLocalizedMessage());
        }
    }

    public static void deleteTestEvidence(){
        try {
            Logs.debug("Deleting Screenshot Folder");
            FileUtils.deleteDirectory(new File(screenshotPath));

            Logs.debug("Deleting Allure results folder");
            FileUtils.deleteDirectory(new File(allurePath));
        }catch (IOException ioException){
            Logs.error("ioException: %s ",ioException.getLocalizedMessage());
        }
    }
}
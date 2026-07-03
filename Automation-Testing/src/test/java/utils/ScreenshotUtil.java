package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {
    public static String captureScreenshot(WebDriver driver, String testName){

        File source = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        File folder = new File("reports/screenshots");

        if (!folder.exists()) {
            folder.mkdirs();
        }

        String path = "reports/screenshots/" + testName + ".png";

        File destination = new File(path);

        try {
            FileHandler.copy(source, destination);
        } catch (IOException e){
            e.printStackTrace();
        }
        return path;
    }
}

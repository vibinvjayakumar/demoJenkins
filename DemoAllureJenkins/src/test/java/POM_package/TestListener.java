package POM_package;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

public class TestListener implements ITestListener {
	
	public void onTestFailure(ITestResult result) {
		
		
		Object testClass = result.getInstance();
        WebDriver driver = ((LoginTest) testClass).driver;
        if (driver != null) {
            saveScreenshot(driver);
        }
        saveTextLog(result.getName()+"test failed and screenshot captured");
    }

    @Attachment(value = "Screenshot on Failure", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
    
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }
	}



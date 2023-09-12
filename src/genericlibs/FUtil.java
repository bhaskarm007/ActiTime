package genericlibs;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class FUtil {

	public static String takeScreenshot(WebDriver driver, String testCaseName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File tempFile = ts.getScreenshotAs(OutputType.FILE);
		
		String timeStamp = LocalDateTime.now().toString().replace(':', '-');
		String newFilePath = "./errorshots/"+timeStamp+testCaseName+".png";
		
		FileUtils.copyFile(tempFile, new File(newFilePath));
		return newFilePath;
		
	}
	public static void sleepInSeconds(long seconds) {
		try {
			Thread.sleep(seconds*1000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

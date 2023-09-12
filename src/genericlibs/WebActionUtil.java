package genericlibs;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebActionUtil {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor jse;
	Actions actions;
	
	public WebActionUtil(WebDriver driver, long eto) {
		this.driver =driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(eto));
		jse = (JavascriptExecutor) driver;
		actions = new Actions(driver);
	}
	
	public void enterData(WebElement ele, String keysToSend) {
		ele.clear();
		ele.sendKeys(keysToSend);
	}
	
	public void click(WebElement ele) {
		wait.until(ExpectedConditions.visibilityOf(ele));
		try {
			ele.click();
		}catch(ElementClickInterceptedException e) {
			jsClick(ele);
		}
	}
	
//	public void clickableAndClick(WebElement ele) {
//		wait.until(ExpectedConditions.visibilityOf(ele));
//		wait.until(ExpectedConditions.elementToBeClickable(ele));
//		ele.click();
//	}
	
	public void jsClick(WebElement ele) {
		wait.until(ExpectedConditions.visibilityOf(ele));
		jse.executeScript("arguments[0].click();", ele);
	}
	
	public void scroll(int xPixels, int yPixels) {
		jse.executeScript("scrollBy(arguments[0],arguments[1);", xPixels, yPixels);
	}
	
	public void jseEnterData(WebElement ele, String keysToSend) {
		jse.executeScript("arguments[0].value=arguments[1];", ele, keysToSend);
	}
	
	public void dragAndDrop(WebElement source, WebElement target) {
		actions.dragAndDrop(source, target).perform();
	}
	
	public void doubleClick(WebElement ele) {
		actions.contextClick(ele).perform();
	}
	
	public void rightClick(WebElement ele) {
		actions.contextClick().perform();
	}
	
	public void selectByVisbleText(WebElement listBox, String visibleText) {
		Select s= new Select(listBox);
	}
	
	public void selectByIndex(WebElement listBox, int index) {
		Select s = new Select(listBox);
		s.selectByIndex(index);
	}
     
	public void switchToWindow(String titleFraction) {
//		List<String> list = new ArrayList<String>(driver.getWindowHandles());
		Set<String> allWindowIds = driver.getWindowHandles();
		for (String windowId : allWindowIds) {
			driver.switchTo().window(windowId);
			if(driver.getTitle().contains(titleFraction)) {
				return;
			}
		}
	}

	public void closeAllChildBrowsers() {
		String parentWindowId= driver.getWindowHandle();
		
		Set<String> allWindowIds = driver.getWindowHandles();
		allWindowIds.remove(parentWindowId);
		
		for(String windowId:allWindowIds) {
			driver.switchTo().window(windowId);
			driver.close();
		}
	}
	public void switchToFrame(String frameIdNameOrIndex) {
		try {
			int index = Integer.parseInt(frameIdNameOrIndex);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
			driver.switchTo().frame(index);
			
		} catch (NumberFormatException e) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIdNameOrIndex));
			driver.switchTo().frame(frameIdNameOrIndex);
		}
	}
	
	public void switchToAlertAndClickOn(boolean okButton) {
		wait.until(ExpectedConditions.alertIsPresent());
		if(okButton) {
			driver.switchTo().alert().accept();
		} else {
			driver.switchTo().alert().dismiss();
		}
	}
	
	public void waitUntilConatains(String urlFraction) {
		wait.until(ExpectedConditions.urlContains(urlFraction));
	}
		
	}

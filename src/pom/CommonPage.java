package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericlibs.WebActionUtil;

public class CommonPage extends BasePage {
	
	@FindBy(id="logoutLink")
	private WebElement logoutLink;
	
	public WebElement getLogoutLink() {
		return logoutLink;
	}
		
	
	public CommonPage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver, webActionUtil);
	}
	
	public LoginPage logout() {
		webActionUtil.click(logoutLink);
		return new LoginPage(driver, webActionUtil);
	}
}
		
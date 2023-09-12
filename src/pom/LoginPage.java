package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericlibs.WebActionUtil;
import pom.timetrack.EnterTimeTrackPage;

public class LoginPage extends BasePage {

	@FindBy(id="username")
	private WebElement usernameTextField;
	
	@FindBy(name="pwd")
	private WebElement passwordField;
	
	@FindBy(id="loginButton")
	private WebElement loginButton;
	
	@FindBy(id="keepLoggedInCheckBox")
	private WebElement rememberCheckBox;
	
	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getRememberCheckBox() {
		return rememberCheckBox;
	}

	public LoginPage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver, webActionUtil);
	}
	
	public EnterTimeTrackPage login(String userData, String passData) {
		webActionUtil.enterData(usernameTextField, userData);
		webActionUtil.enterData(passwordField,passData);
		webActionUtil.click(loginButton);
		return new EnterTimeTrackPage(driver, webActionUtil);
	}
	
}

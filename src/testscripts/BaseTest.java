package testscripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import genericlibs.AutoConstants;
import genericlibs.WebActionUtil;
import pom.CommonPage;
import pom.LoginPage;
import pom.timetrack.EnterTimeTrackPage;



public class BaseTest implements AutoConstants {

	public WebDriver driver;
	public WebActionUtil webActionUtil;
	public EnterTimeTrackPage enterTimeTrackPage;
	
	@Parameters({"browserName", "appUrl", "implicit", "explicit"})
	
	@BeforeClass(alwaysRun=true)
	public void setUp(@Optional(DEFAULT_BROWSER) String browserName,
			          @Optional(APP_URL) String appUrl, 
			          @Optional(ITO) String implicit,
			          @Optional(ETO) String explicit) {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty(CHROME_KEY, CHROME_PATH);
			ChromeOptions options= new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty(GECKO_KEY, GECKO_PATH);
			FirefoxOptions options= new FirefoxOptions();
			options.addPreference("dom.webnotifications.enabled", false);
			driver = new FirefoxDriver(options);
			
		}else {
			Assert.fail("Sorry, This Browser is Not Supported");
		}
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(implicit)));
		driver.get(appUrl);
		webActionUtil = new WebActionUtil(driver, Long.parseLong(explicit));
    }
	
	
	@Parameters({"username", "password"})
    @BeforeMethod(alwaysRun=true)
    public void login(@Optional(DEFAULT_USERNAME) String username, @Optional(DEFAULT_PASSWORD) String password) {
    	enterTimeTrackPage=new LoginPage(driver, webActionUtil).login(username, password);
    }
    
    @AfterMethod(alwaysRun =true)
    public void logout() {
    	new CommonPage(driver, webActionUtil).logout();
    }
    
    @AfterClass(alwaysRun=true)
    public void tearDown() {
     driver.quit();
    }
 }

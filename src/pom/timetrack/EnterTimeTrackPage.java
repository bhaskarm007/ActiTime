package pom.timetrack;

import java.time.LocalDateTime;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericlibs.WebActionUtil;
import pom.BasePage;


public class EnterTimeTrackPage extends BasePage{

	
	@FindBy(id="addTaskButtonId")
	private WebElement newLink;
	
	@FindBy(xpath="//div[contains(@class,'customerSelector')]//div[@class='dropdownButton']")
	private WebElement customerSelectorDropdownButton;
	
	@FindBy(css="input[placeholder='Enter Customer Name']")
	private WebElement customerNameTextField;
	
	@FindBy(css="input[placeholder='Enter Project Name']")
	private WebElement projectNameTextField;
	
	@FindBy(xpath="(//input[@placeholder='Enter task name'])[1]")
	private WebElement taskNameTextField;
	
	@FindBy(xpath="(//input[@placeholder='not needed'])[1]")
	private WebElement timeEstimateTextField;
	
	@FindBy(xpath="(//button[text()='set deadline'])[1]")
	private WebElement setDeadLineDateButton;
	
	@FindBy(xpath="(//div[@class='typeOfWorkButton editable'])[1]")
	private WebElement typeOfWorkButton;
	
	@FindBy(xpath="//div[text()='Create Tasks']")
	private WebElement  createTasksButton;
	
	
	@FindBy(xpath="//div[contains(@class,'customerSelector')]//div[contains(@class,'itemRow')]")
	private List<WebElement> customerDropDownOptionsList;
	
	@FindBy(xpath="//div[contains(@style,'visibility: visible')]//td[contains(@class,'date-middle')]//button")
	private WebElement monthAndYearSelectorButton;
	
	@FindBy(xpath="//td[contains(@class,'x-date-mp-year')]")
	private List<WebElement> yearsList;
	
	@FindBy(xpath="//td[contains(@class,'x-date-mp-month')]")
	private List<WebElement> monthsList;
	
	@FindBy(xpath="//td[contains(@class,'x-date-active')]//a[@class='x-date-date']")
	
//	@FindBy(xpath="//div[contains(@style,'visibility: visible')]//td[contains(@class,'x-date-active')]")
	private List<WebElement> daysList;
	
	@FindBy(className="x-date-mp-next")
	private WebElement nextYearListIcon;
	
	@FindBy(xpath="//tr[@class='x-date-mp-btns']//button[contains(text(),'OK')]")
	private WebElement monthAndYearsOkButton;
	
	@FindBy(xpath="//div[contains(@class,'typeOfWorkMenu') and contains(@style,'display: block')]//div[@class='typeLabel ellipsis']")
	private List<WebElement> typeOfWorkOptionsList;
	
	@FindBy(className="task")
	private List<WebElement> tasksList;
	
	
	
	@FindBy(linkText="Tasks")
	private WebElement tasksLink;
	
	
	@FindBy(xpath="//div[contains(@class,'customersProjectsTree')]//div[@class='collapseAllButton']")
	private WebElement collapseAllButton;
	
	
	@FindBy(xpath="//div[@class='title']//div[@class='text']")
	private List<WebElement> customersList;
	
//	
//	@FindBy(xpath="//div[@class='title']//div[text()='Tesla']")
//	private WebElement createdCustomerName;
//	
//	
//	public WebElement getCreatedCustomerName() {
//		return createdCustomerName;
//	}


	@FindBy(xpath="//div[contains(@class,'hasSelectedCustomer')]//div[@class='editButton']")
	private WebElement custSettingsButton;
	 
	@FindBy(xpath="//div[@class='editCustomerPanelHeader']//div[text()='ACTIONS']")
	private WebElement actionsButton;
	
	@FindBy(xpath="//div[contains(@class,'edit_customer')]//div[text()='Delete']")
	private WebElement deleteButton;
	
	@FindBy(xpath="//span[text()='Delete permanently']")
	private WebElement deletePermanentlyButton;
	
	
	
	
	public List<WebElement> getCustomersList() {
		return customersList;
	}

	public WebElement getTasksLink() {
		return tasksLink;
	}

	public WebElement getCustSettingsButton() {
		return custSettingsButton;
	}

	public WebElement getActionsButton() {
		return actionsButton;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	public WebElement getDeletePermanentlyButton() {
		return deletePermanentlyButton;
	}

	public WebElement getCollapseAllButton() {
		return collapseAllButton;
	}

	public List<WebElement> getCustomerDropDownOptionsList() {
		return customerDropDownOptionsList;
	}

	public WebElement getMonthAndYearSelectorButton() {
		return monthAndYearSelectorButton;
	}

	public List<WebElement> getYearsList() {
		return yearsList;
	} 

	public List<WebElement> getMonthsList() {
		return monthsList;
	}

	public List<WebElement> getDaysList() {
		return daysList;
	}

	public WebElement getNextYearListIcon() {
		return nextYearListIcon;
	}

	public WebElement getMonthAndYearsOkButton() {
		return monthAndYearsOkButton;
	}

	public List<WebElement> getTypeOfWorkOptionsList() {
		return typeOfWorkOptionsList;
	}

	public List<WebElement> getTasksList() {
		return tasksList;
	}

	public WebElement getNewLink() {
		return newLink;
	}

	public WebElement getCustomerSelectorDropdownButton() {
		return customerSelectorDropdownButton;
	}

	public WebElement getCustomerNameTextField() {
		return customerNameTextField;
	}

	public WebElement getProjectNameTextField() {
		return projectNameTextField;
	}

	public WebElement getTaskNameTextField() {
		return taskNameTextField;
	}

	public WebElement getTimeEstimateTextField() {
		return timeEstimateTextField;
	}

	public WebElement getSetDeadLineDateButton() {
		return setDeadLineDateButton;
	}

	public WebElement getTypeOfWorkButton() {
		return typeOfWorkButton;
	}

	public WebElement getCreateTasksButton() {
		return createTasksButton;
	}

	public EnterTimeTrackPage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver, webActionUtil);
	}
	
	public void selectCustomerDropDown(String dropDownOption) {
		webActionUtil.jsClick(customerSelectorDropdownButton);
		for (WebElement ele : customerDropDownOptionsList) {
			if(ele.getText().contains(dropDownOption)) {
				webActionUtil.click(ele);
				break;
			}
		}
	} 
	public void selectYear(String year) {
		outer:
			for(;;) {
				for(WebElement ele:yearsList) {
					if(ele.getText().equals(year)) {
						webActionUtil.click(ele);
						break outer;
					}
				}
				webActionUtil.click(nextYearListIcon);
			}
	}
	
	public void selectMonth(String month) {
		
		for(WebElement ele:monthsList) {
			if(ele.getText().equalsIgnoreCase(month)) {
				webActionUtil.click(ele);
				break;
			}
		}
	}
		
		public void selectDay(String day) {
			
			for(WebElement ele:daysList) {
				if(ele.getText().equalsIgnoreCase(day)) {
					webActionUtil.click(ele);
					break;
				}
			}
		}
			
	public void selectDeadLineDate(String day, String month, String year) {
		if(Integer.parseInt(year) >= LocalDateTime.now().getYear()) {
			webActionUtil.click(setDeadLineDateButton);
			webActionUtil.click(monthAndYearSelectorButton);
			selectMonth(month);
			selectYear(year);
			webActionUtil.click(monthAndYearsOkButton);
			selectDay(day);	
		} else {
			throw new IllegalArgumentException("Sorry, You cant give Previous Year");
		}
		
	}
	
	public void selectTypeOfWork(String typeOfWork) {
		webActionUtil.click(typeOfWorkButton);
		for(WebElement ele:typeOfWorkOptionsList) {
			if(ele.getText().contains(typeOfWork)) {
				webActionUtil.click(ele);
				break;
			}
 		}
		
	}
	
	public void createTask(String dropDownOption, String custName, String projectName, String taskName,
			               String timeEstimate, String day, String month, String year, String typeOfWork) {
       	webActionUtil.click(newLink);
		selectCustomerDropDown(dropDownOption);
		webActionUtil.enterData(customerNameTextField, custName);
		webActionUtil.enterData(projectNameTextField, projectName);
		webActionUtil.enterData(taskNameTextField, taskName);
		webActionUtil.enterData(timeEstimateTextField, timeEstimate);
		selectDeadLineDate(day, month, year);
		selectTypeOfWork(typeOfWork);
		webActionUtil.click(createTasksButton);
		webActionUtil.waitUntilConatains("dateStr");
		 
	}
	public boolean verifyTask(String taskName) {
		for(WebElement ele:tasksList) {
			if(ele.getText().contains(taskName)) {
				return true;
				
			}
		}
		return false;
	}
	
    public void clickOnCustomer(String customerName) {
		for(WebElement ele:customersList) {
			if(ele.getText().contains(customerName)) {
				webActionUtil.click(ele);
				break;
			}
         }  
	}
    
    
	public void deleteCustomer(String customerName) {
		
		
		webActionUtil.click(tasksLink);
		webActionUtil.jsClick(collapseAllButton);
	
		clickOnCustomer(customerName);
		webActionUtil.click(custSettingsButton);
		webActionUtil.click(actionsButton);
		webActionUtil.click(deleteButton);
		webActionUtil.click(deletePermanentlyButton);
		
	}

	}
// more than 6 number of Customers, we need to write code Scroll bar and
// Scrolling Problem add scroll down properly then it's work
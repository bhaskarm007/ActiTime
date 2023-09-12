package testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import genericlibs.ExcelLibrary;

public class TC001 extends BaseTest {
	
	String custName;
	
     @Test(description = "Add Task And Verify in Tasks List")
     public void addTaskAndVerify() {
    	 String sheetName="TC001";
    	 int rowNumber=1;
    	 String dropdownOption =ExcelLibrary.getStringData(sheetName, rowNumber, 0);
    	 custName=ExcelLibrary.getStringData(sheetName, rowNumber, 1);
    	 String projectName =ExcelLibrary.getStringData(sheetName, rowNumber, 2);
    	 String taskName =ExcelLibrary.getStringData(sheetName, rowNumber, 3);
    	 String timeEstimate =ExcelLibrary.getStringData(sheetName, rowNumber, 4).split("\\.")[0];
    	 String day =ExcelLibrary.getStringData(sheetName, rowNumber, 5).split("\\.")[0];
    	 String month =ExcelLibrary.getStringData(sheetName, rowNumber, 6);
    	 String year =ExcelLibrary.getStringData(sheetName, rowNumber, 7).split("\\.")[0];
    	 String typeOfWork =ExcelLibrary.getStringData(sheetName, rowNumber, 8);
    	 
    	 enterTimeTrackPage.createTask(dropdownOption, custName, projectName, taskName, timeEstimate, day, month, year, typeOfWork);
         Assert.assertTrue(enterTimeTrackPage.verifyTask(taskName));
    	 
    	 
     }
//    	 enterTimeTrackPage.createTask("- New Customer -","Tesla", "Mahibh Tesla", "Car Brake Task", 
//    			                                              "100","10","September","2023","manufacturing");
//    	 Assert.assertTrue(enterTimeTrackPage.verifyTask("Car Brake Task"));
//  }
     
     @AfterMethod(alwaysRun=true)
     public void deleteCustomer() {
    	 enterTimeTrackPage.deleteCustomer("Tesla");
    		 
    	 }
     }

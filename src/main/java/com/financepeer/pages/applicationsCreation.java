package com.financepeer.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.text.WordUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.financepeer.base.TestBase;
import com.financepeer.util.TestUtil;

public class applicationsCreation extends TestBase {

	public static LoginPage login;

	String dropDownOptions 		= "//*[@class='ant-select-item ant-select-item-option']//div[@class='ant-select-item-option-content']";
	String PAN_Path 			= System.getProperty("user.dir") + "\\src\\test\\resources\\fileUploads\\PAN.jpg";
	String Aadhar_Path 			= System.getProperty("user.dir") + "\\src\\test\\resources\\fileUploads\\test_aadhar.jpg";
	String PAN_test1 			= System.getProperty("user.dir") + "\\src\\test\\resources\\fileUploads\\PAN test1.jpg";
	String applicantColorPhoto 	= System.getProperty("user.dir") + "\\src\\test\\resources\\fileUploads\\Passport_Size_Image_of_Nouman.jpg";
	String bankStatements 		= System.getProperty("user.dir") + "\\src\\test\\resources\\fileUploads\\sample.pdf";
	String Aadhar_test1 		= System.getProperty("user.dir") + "\\src\\test\\resources\\fileUploads\\Aadhaar test1.jpg";
	String appleProductsList 	= "//*[@id='appleFinancingDiv']//*[@id='showProductDiv']//*[@class='ant-checkbox-wrapper']";
	String btocInstallments 	= "//*[@class='ant-table-tbody']//*[contains(@class,'ant-table-row')]//td[@class='ant-table-cell']";
	String emiOptionsFor_B2C 	= "//*[@class='ant-table-tbody']//tr[contains(@class,'selected')]//td[3]";
	String tentativeEMI_List 	= "//*[@class='flex justify-between items-center']//*[contains(@class,'p-3 md:text-2xl font-medium tracking-tight')]";
	String summaryEMI_Options 	= "//*[@id='summaryDiv']//span[@class='md:text-xl tracking-tight']";
	String feeAndAppleLoanIds 	= "//*[contains(@class,'flex lg:block')]//p";
	String deliveryBranchList 	= "//*[@id='rc_select_3_list']//following-sibling::*[@class='rc-virtual-list']//*[@class='ant-select-item-option-content']";
	String applyButton 			= "//*[@class='hidden md:flex col-span-2 justify-end mr-3']//a/button";
	String studentNameList		= "//*[@class='flex justify-between ']//span[contains(@class,'text')]";
	String dashboardAppIDs 		= "//*[contains(@class,'hidden md:block')]";
	String totalAmount_Dashboard= "//*[contains(@class,'text-xs font-medium')]";
	String tentativeEMI_Dashboard = "//*[contains(@class,'text-xs font-medium text-blue')]";
	String applicationStatus 	= "//*[contains(@class,'justify-end')]//*[@class='inline']";
	
	String appleProdEmiAndPrice = "//*[@id='showProductDiv']//*[contains(@class,'wrapper-checked')]//parent::*[contains(@class,'flex justify-between items-center')]//*[contains(@class,'items-end')]//span";
	String appleFinanceEMi 		= "//*[contains(@class,'bg-green-100')]//div[2]//span";
	
	
	// Page Factory : OR
	@FindBy(xpath = "//*[contains(@src,'user_icon.png')]")
	WebElement userIcon;

	@FindBy(xpath = "//p//*[contains(text(),'New Application')]")
	WebElement newApplicationBtn;

	@FindBy(xpath = "//*[@class='hidden md:flex col-span-2 justify-end mr-3']//a/button")
	WebElement applyBtn;

	@FindBy(xpath = "//*[@name='studentName']")
	WebElement studentName;

	@FindBy(xpath = "//*[@name='folioRollNumber']")
	WebElement rollNumber;

	@FindBy(xpath = "//*[@name='studentDOB']")
	WebElement datePicker;

	@FindBy(xpath = "//*[@name='folioRollNumber']")
	WebElement rollNum;

	@FindBy(xpath = "//*[@type='search']")
	WebElement instituteSearch;

	@FindBy(xpath = "//*[@id='rc_select_1']")
	WebElement branchName;

	@FindBy(xpath = "//*[@name='selectedCourse']//*[@type='search']")
	WebElement courseName;

	@FindBy(xpath = "//*[@name='selectedCourse']")
	WebElement course_Name;

	@FindBy(xpath = "//*[@id='pinCodeDiv']//*[@name='pincode']")
	WebElement branch_Pincode;

	@FindBy(xpath = "//*[@id='courseTenureDiv']//*[@class='ant-select-selection-item']")
	WebElement tenure;

	@FindBy(xpath = "//*[@id='summaryDiv']//div[1]//*[@class='flex items-center justify-between pb-3']//span[2]")
	WebElement tenureInSummary;
	
	@FindBy(xpath = "//*[@name='loanamount']")
	WebElement courseFee;

	@FindBy(xpath = "//*[@id='appleFinancingDiv']//*[@class='ant-checkbox ant-checkbox-checked']")
	WebElement appleFinanceCheckBox;

	@FindBy(xpath = "//*[@id='summaryDiv']//*[@class='flex justify-between items-center']//div[2]")
	WebElement totalAmount;

	@FindBy(xpath = "//*[text()='Proceed']")
	WebElement proceedBtn;

	@FindBy(xpath = "//*[contains(text(),'Color photo of PAN')]")
	WebElement panColorPhoto;

	@FindBy(xpath = "(//span[@aria-label='upload'])[1]")
	WebElement PAN_ChooseFileBtn;

	@FindBy(xpath = "//*[@data-icon='caret-right']")
	WebElement uploadDocs_RightIcon;

	@FindBy(xpath = "//div[@class='w-full md:pl-8']//div//div//div[2]//div[2]//span[1]//div[1]//span[1]//div[1]//button[1]")
	WebElement AADHAR_ChooseFileBtn;

	@FindBy(xpath = "//body//div[@id='app']//div[@class='ant-spin-nested-loading']//div[@class='ant-spin-nested-loading']//div[3]//div[2]//span[1]//div[1]//span[1]//div[1]")
	WebElement AADHAR_Backside_ChooseFileBtn;

	@FindBy(xpath = "//*[text()='Upload documents']")
	WebElement uploadDocumentsBtn;

	@FindBy(xpath = "//*[text()='Document uploaded successfully']")
	WebElement documentUploaded;

	@FindBy(xpath = "//*[@name='relationship']")
	WebElement relationshipWithStudent;

	@FindBy(xpath = "//div[@class='py-3 mt-8']//div[2]//div[2]//span[1]//div[1]//span[1]//div[1]//button[1]")
	WebElement applicantPhoto;

	@FindBy(xpath = "//div[contains(@class,'mt-8 bg-white rounded')]//div[3]//div[2]//span[1]//div[1]//span[1]//div[1]//button[1]")
	WebElement bankStmts;

	@FindBy(xpath = "//*[text()='Submit']")
	WebElement submitBtn;

	@FindBy(xpath = "//*[text()='CONTINUE FOR NOW']")
	WebElement continueForNowBtn;

	@FindBy(xpath = "//*[contains(@class,'flex lg:block')]//p")
	WebElement loanIdAfterAppSubmitted;

	@FindBy(xpath = "//*[text()='Back to Dashboard']")
	WebElement backToDashboardBtn;

	@FindBy(xpath = "//*[contains(@class,'flex lg:block')]//span")
	WebElement loanID;

	@FindBy(xpath = "//*[@class='mt-5']//*[@class='ant-checkbox-input']")
	WebElement courseFinanceCheckBox;

	@FindBy(xpath = "//*[@name='AddressLine1']")
	WebElement addressLine1;

	@FindBy(xpath = "//*[@name='AddressLine2']")
	WebElement addressLine2;

	@FindBy(xpath = "//*[@name='city']")
	WebElement city;

	@FindBy(xpath = "//*[@name='state']")
	WebElement state;

	@FindBy(xpath = "//*[@name='pincode']")
	WebElement pincode;

	@FindBy(xpath = "//*[@id='appleFinancingDiv']//*[@type='checkbox']")
	WebElement appleCheckBox;

	@FindBy(xpath = "//*[@id='appleFinancingDiv']//*[@role='combobox']")
	WebElement deliveyLocation;

	@FindBy(xpath = "//*[@type='button']//*[text()='Check Availability']")
	WebElement checkAvailabilityBtn;

	@FindBy(xpath = "//*[text()='Proceed for quick authentication']")
	WebElement proceedForQuickAuthen;

	@FindBy(xpath = "//*[@name='consent.name']")
	WebElement digiLockerCheckBox;

	@FindBy(xpath = "//button[text()=' Authenticate Aadhaar ']")
	WebElement AuthenticateAadharBtn;

	@FindBy(xpath = "//*[text()='Next']")
	WebElement digiLockerNextBtn;

	@FindBy(xpath = "//*[text()='Continue']")
	WebElement digiLockerContinueBtn;

	@FindBy(xpath = "//*[@id='authorizedbtn']")
	WebElement digiLockerAllowBtn;

	@FindBy(xpath = "//*[text()='KYC Process Completed.']")
	WebElement kycProcessCompleted;

	@FindBy(xpath = "//*[contains(@id,'wrapperdigio-ifm')]//img")
	WebElement digiLockerCloseBtn;
	
	@FindBy(xpath = "//*[@class='flex justify-between items-center']//div[2]//span[1]")
	WebElement feeFinanceTentativeEMI;
	
	@FindBy(xpath = "//*[@id='summaryDiv']//div[2]//div[2]//div//span[2]")
	WebElement tentativeEMI_summary;
	
	@FindBy(xpath = "//*[@id='summaryDiv']//div[3]//div//span[2]")
	WebElement feeFinanceTotal;
	
	@FindBy(xpath = "//*[@id='summaryDiv']//div[1]//div[2]//div[2]//div[2]//span")
	WebElement totalAmountInSummary;
	
	

	// Initializing the page objects:
	public applicationsCreation() {
		PageFactory.initElements(driver, this);
	}

	// Actions:

	// create B2B fee finance application
	public String[] createB2BFeeFinance(String dob, String instituteKeys, String instituteName, String branchKeys,
			String branch, String courseKeys, String course, String aadhaarNum, String relationship) throws Throwable {

		Thread.sleep(5000);
		applyBtn.click();

		// entering the student details
		String stntName = "Test Btob Fee ";
		String studentName1 = TestUtil.randomChars(5);
		String studtsdsName = Character.toUpperCase(studentName1.charAt(0)) + studentName1.substring(1);
		String studentNameInDashboard = stntName + studtsdsName;
		studentName.sendKeys(studentNameInDashboard);
		rollNumber.sendKeys("Test" + TestUtil.randomDigits(7));

		datePicker.click();
		datePicker.sendKeys(dob);

		// select the institute name from the drop down
		instituteSearch.sendKeys(instituteKeys);
		Thread.sleep(1000);
		By options = By.xpath(dropDownOptions);
		TestUtil.selectDropDownValue(options, instituteName);

		// selecting the branch name from the drop down
		branchName.sendKeys(branchKeys);
		Thread.sleep(1000);
		TestUtil.selectDropDownValue(options, branch);

		// selecting the course from the drop down
		courseName.sendKeys(courseKeys);
		Thread.sleep(1000);
		TestUtil.selectDropDownValue(options, course);

		// getting the course fee and tenure details
		String courseTenure = tenure.getText();
		String courseFees = courseFee.getAttribute("value");
		System.out.println("Course Tenure: " + courseTenure);
		System.out.println("Course Fee: " + courseFees);
		
		
		// verifying the course tenure in the financing summary
		String tenureInFinanceSummary = tenureInSummary.getText();
		Assert.assertTrue(tenureInFinanceSummary.contains(courseTenure));
		System.out.println("Tenure in the financing summary: "+tenureInSummary.getText());
		
		//verifying the tentative emi in course finance and financing summary section
		String feeFinanceTentativeEmi = feeFinanceTentativeEMI.getText(); 
		String feeFinanceTentativeEmi_summary = tentativeEMI_summary.getText();
		Assert.assertEquals(feeFinanceTentativeEmi, feeFinanceTentativeEmi_summary);
		System.out.println("fee Finance Tentative EMI in financing details section: "+ feeFinanceTentativeEmi+ 
				"\n"+ "fee Finance Tentative EMI in summary section: "+feeFinanceTentativeEmi_summary);

		//verifying the fee finance total in the summary section
		String feeFinanceTotalInSummary  = feeFinanceTotal.getText();
		System.out.println("Fee finance total in summary: "+feeFinanceTotalInSummary);
			
		//verifying the total amount
		String totalFinanceAmount = totalAmountInSummary.getText();
		Assert.assertEquals(feeFinanceTotalInSummary, totalFinanceAmount);
		System.out.println("total finance amount: "+totalFinanceAmount);
		
		
		appleFinanceCheckBox.click();
		Thread.sleep(2000);
		String total = totalAmount.getText();
		Thread.sleep(2000);
		proceedBtn.click();
		Thread.sleep(2000);

		uploadDocs_RightIcon.click();

		// uploading PAN card
		PAN_ChooseFileBtn.click();
		TestUtil.uploadFile(PAN_Path);
		uploadDocumentsBtn.click();
		String uploadedText1 = documentUploaded.getText();
		Thread.sleep(1000);
		// uploading AADHAAR card
		AADHAR_ChooseFileBtn.click();
		TestUtil.uploadFile(Aadhar_Path);
		uploadDocumentsBtn.click();
		uploadedText1 = documentUploaded.getText();
		Thread.sleep(1000);
		// uploading AADHAAR card back side
		AADHAR_Backside_ChooseFileBtn.click();
		TestUtil.uploadFile(Aadhar_Path);
		uploadDocumentsBtn.click();
		uploadedText1 = documentUploaded.getText();
		Thread.sleep(1000);

		applicantPhoto.click();
		TestUtil.uploadFile(applicantColorPhoto);
		uploadDocumentsBtn.click();
		uploadedText1 = documentUploaded.getText();

		// uploading bank statements
		bankStmts.click();
		TestUtil.uploadFile(bankStatements);
		uploadDocumentsBtn.click();
		uploadedText1 = documentUploaded.getText();
		
//		proceedForQuickAuthen.click();
//		Thread.sleep(5000);
//		driver.switchTo().frame(0);
//		Thread.sleep(2000);
//		digiLockerCheckBox.click();
//		Thread.sleep(2000);
//		AuthenticateAadharBtn.click();
//		Thread.sleep(2000);
//
//		Set<String> handler = driver.getWindowHandles();
//		Iterator<String> it = handler.iterator();
//
//		String parentWindowId = it.next();
//		System.out.println("Parent window id: " + parentWindowId);
//
//		String childWindowId = it.next();
//		System.out.println("Child window id: " + childWindowId);
//
//		driver.switchTo().window(childWindowId);
//
//		driver.findElement(By.xpath("//*[@id='aadhaar_1']")).sendKeys(aadhaarNum);
//
//		digiLockerNextBtn.click();
//		Thread.sleep(30000);
//
//		digiLockerContinueBtn.click();
//		Thread.sleep(2000);
//		digiLockerAllowBtn.click();
//		Thread.sleep(20000);
//
//		driver.switchTo().window(parentWindowId);
//		Thread.sleep(2000);
//		digiLockerCloseBtn.click();
//		Thread.sleep(7000);
//
//		List<WebElement> uploadedList = driver.findElements(By.xpath("//*[text()='Uploaded']"));
//		System.out.println(uploadedList.size());
//
//		for (int i = 0; i < uploadedList.size(); i++) {
//			System.out.println("Uploaded PAN and Aadhaar through digi locker: " + uploadedList.get(i).getText());
//		}
//
//		// uploading applicant color photo
//		applicantPhoto.click();
//		TestUtil.uploadFile(applicantColorPhoto);
//		uploadDocumentsBtn.click();
//		String uploadedText1 = documentUploaded.getText();
//
//		// uploading bank statements
//		bankStmts.click();
//		TestUtil.uploadFile(bankStatements);
//		uploadDocumentsBtn.click();
//		String uploadedText2 = documentUploaded.getText();

		// click on proceed button on upload documents section
		proceedBtn.click();
		Thread.sleep(3000);

		// applicant details
		relationshipWithStudent.sendKeys(relationship);
		submitBtn.click();

		// getting the application submitted text and load ID
		String applicationSubmittedText = loanIdAfterAppSubmitted.getText();
		String loanId = loanID.getText();
		//extract only loan id from text
		String loanIdOnly = loanId.replaceAll("[^0-9]", "");
		System.out.println(loanIdOnly);
		Thread.sleep(1000);

		// verifying the condition if the text contains the application id
		if (applicationSubmittedText.contains(loanId)) {
			backToDashboardBtn.click();
		}
		
		//verifying the student name in dashboard
		String studentName_Dashboard="";
		List<WebElement> studentNamesInDashboard = driver.findElements(By.xpath(studentNameList));
		for(int i=0; i<studentNamesInDashboard.size(); i++) {
			studentName_Dashboard = studentNamesInDashboard.get(0).getText();
			Assert.assertTrue(studentName_Dashboard.contains(studentNameInDashboard));
		}
		
		//verifying the loan id in the dashboard
		String appIdWithOnlyDigits="";
		List<WebElement> appIDInDashboard = driver.findElements(By.xpath(dashboardAppIDs));
		for(int i=0; i<appIDInDashboard.size(); i++) {
			appIdWithOnlyDigits = appIDInDashboard.get(0).getText().replaceAll("[^0-9]", ""); 
			Assert.assertEquals(appIdWithOnlyDigits, loanIdOnly);	
		}
		
		//total amount validation in dashboard
		String totalAmountDashboard = "";
		List<WebElement> totalAmountInDashboardList = driver.findElements(By.xpath(totalAmount_Dashboard));
		for(int i=0; i<totalAmountInDashboardList.size(); i++) {
			totalAmountDashboard = totalAmountInDashboardList.get(0).getText();
			Assert.assertTrue(totalAmountDashboard.contains(totalFinanceAmount));
		}
		
		//tenure validation in dashboard
		String tenureInDashboard = "";
		List<WebElement> tenureList = driver.findElements(By.xpath(totalAmount_Dashboard));
		for(int i=0; i<tenureList.size(); i++) {
			tenureInDashboard = tenureList.get(0).getText();
			Assert.assertTrue(tenureInDashboard.contains(tenureInFinanceSummary));
		} 
		
		//tentative EMI validation in dashboard
		String tentativeEMIDashboard = "";
		List<WebElement> tentativeEMIList = driver.findElements(By.xpath(tentativeEMI_Dashboard));
		for(int i=0; i<tentativeEMIList.size(); i++) {
			tentativeEMIDashboard = tentativeEMIList.get(0).getText();
			Assert.assertTrue(tentativeEMIDashboard.contains(feeFinanceTentativeEmi_summary));
		}
		
		//application status validation in dashboard
		String actualStatus="";
		List<WebElement> appStatusInDashboard = driver.findElements(By.xpath(applicationStatus));
		for(int i=0; i<appStatusInDashboard.size(); i++) {
			actualStatus = appStatusInDashboard.get(0).getText();
			String expStatus = "Submitted";
			Assert.assertEquals(actualStatus.trim(),expStatus);
		}
		
		
		// getting all validations and storing in a string array
		String[] validations = { "TentativeEMI: " + "Total Amount: " + total + "\n" + "Application submitted: "
				+ applicationSubmittedText + "\n" + loanId+"\n"+ "Student name in dashboard: "+studentName_Dashboard+"\n"
				+"Application ID in dashboard: "+appIdWithOnlyDigits+"\n"+"Total amount in dashboard: "+totalAmountDashboard+"\n"
				+"Tenure in dashboard: "+tenureInDashboard+"\n"+"Tentative EMI in dashboard: "+tentativeEMIDashboard+"\n"
				+"Application status in dashboard: "+actualStatus};

		// returning all the validations
		return validations;
	}
	

	// create B2B apple finance application
	public String[] createB2BAppleFinance(String dob, String instituteKeys, String instituteName, String branchKeys,
			String branch, String courseKeys, String course, String relationship, String appleProduct)
			throws Throwable {
		
		Thread.sleep(5000);
		applyBtn.click();

		// entering the student details
		String stntName = "Test Btob apple ";
		String studentName1 = TestUtil.randomChars(5);
		String studtsdsName = Character.toUpperCase(studentName1.charAt(0)) + studentName1.substring(1);
		String studentNameInDashboard = stntName + studtsdsName;
		studentName.sendKeys(studentNameInDashboard);
		
		rollNumber.sendKeys("Test" + TestUtil.randomDigits(7));
		
		// selecting the date of birth of the student
		datePicker.click();
		datePicker.sendKeys(dob);

		// select the institute name from the drop down
		instituteSearch.sendKeys(instituteKeys);
		Thread.sleep(1000);
		By options = By.xpath(dropDownOptions);
		TestUtil.selectDropDownValue(options, instituteName);

		// selecting the branch name from the drop down
		branchName.sendKeys(branchKeys);
		Thread.sleep(1000);
		TestUtil.selectDropDownValue(options, branch);

		// selecting the course from the drop down
		courseName.sendKeys(courseKeys);
		Thread.sleep(1000);
		TestUtil.selectDropDownValue(options, course);
		Thread.sleep(1000);
		
		courseFinanceCheckBox.click();
		Thread.sleep(1000);
		By appleProducts = By.xpath(appleProductsList);
		TestUtil.selectDropDownValue(appleProducts, appleProduct);

		
		String appleTentativeEMI="";
		List<WebElement> tentativeEMIList = driver.findElements(By.xpath(appleFinanceEMi));
		for(int i=0; i<tentativeEMIList.size(); i++) {
			appleTentativeEMI = tentativeEMIList.get(1).getText();
		}
		
		System.out.println(appleTentativeEMI);
		
		String appleEMI = "";
		List<WebElement> appleProdPriceList = driver.findElements(By.xpath(appleProdEmiAndPrice));
		for(int i=0; i<appleProdPriceList.size(); i++) {
			appleEMI = appleProdPriceList.get(0).getText();
			Assert.assertTrue(appleEMI.contains(appleTentativeEMI));
		}
		
		System.out.println(appleEMI);
		
		String appleFinanceTentativeEmi_summary = tentativeEMI_summary.getText();
		Assert.assertEquals(appleFinanceTentativeEmi_summary, appleTentativeEMI);
		System.out.println("Apple finance Tentative EMI in financing details section: "+ appleTentativeEMI+ 
				"\n"+ "Apple Finance Tentative EMI in summary section: "+appleFinanceTentativeEmi_summary);
		
		// verifying the fee finance total in the summary section
		String feeFinanceTotalInSummary = feeFinanceTotal.getText();
		System.out.println("Apples finance total in summary: " + feeFinanceTotalInSummary);

		// verifying the total amount
		String totalFinanceAmount = totalAmountInSummary.getText();
		Assert.assertEquals(feeFinanceTotalInSummary, totalFinanceAmount);
		System.out.println("Total finance amount: " + totalFinanceAmount);

		String total = totalAmount.getText();
		Thread.sleep(1000);
		proceedBtn.click();
		Thread.sleep(2000);

		uploadDocs_RightIcon.click();

		// uploading PAN card
		PAN_ChooseFileBtn.click();
		TestUtil.uploadFile(PAN_Path);
		uploadDocumentsBtn.click();
		String uploadedText1 = documentUploaded.getText();
		Thread.sleep(1000);
		// uploading AADHAAR card
		AADHAR_ChooseFileBtn.click();
		TestUtil.uploadFile(Aadhar_Path);
		uploadDocumentsBtn.click();
		uploadedText1 = documentUploaded.getText();
		Thread.sleep(1000);
		// uploading AADHAAR card back side
		AADHAR_Backside_ChooseFileBtn.click();
		TestUtil.uploadFile(Aadhar_Path);
		uploadDocumentsBtn.click();
		uploadedText1 = documentUploaded.getText();
		Thread.sleep(1000);

		applicantPhoto.click();
		TestUtil.uploadFile(applicantColorPhoto);
		uploadDocumentsBtn.click();
		uploadedText1 = documentUploaded.getText();

		// uploading bank statements
		bankStmts.click();
		TestUtil.uploadFile(bankStatements);
		uploadDocumentsBtn.click();
		uploadedText1 = documentUploaded.getText();

		// click on proceed button on upload documents section
		proceedBtn.click();
		Thread.sleep(2000);

		// shipping details
		addressLine1.sendKeys(TestUtil.randomChars(8));
		addressLine2.sendKeys(TestUtil.randomChars(8));
		city.sendKeys(TestUtil.randomChars(8));
		state.sendKeys(TestUtil.randomChars(8));
		pincode.sendKeys(TestUtil.randomDigits(6));
		Thread.sleep(1000);
		proceedBtn.click();
		Thread.sleep(3000);
		// applicant details
		relationshipWithStudent.sendKeys(relationship);
		Thread.sleep(1000);
		submitBtn.click();

		// getting the application submitted text and load ID
		String applicationSubmittedText = loanIdAfterAppSubmitted.getText();
		String loanId = loanID.getText();
		Thread.sleep(1000);

		// verifying the condition if the text contains the application id
		if (applicationSubmittedText.contains(loanId)) {
			backToDashboardBtn.click();
		}

		List<WebElement> studentNamesInDashboard = driver.findElements(By.xpath(studentNameList));
		System.out.println(studentNamesInDashboard.size());
		for(int i=0; i<studentNamesInDashboard.size(); i++) {
			Assert.assertTrue(studentNamesInDashboard.get(0).getText().contains(studentNameInDashboard));
		}
		
		// getting all validations and storing in a string array
		String[] validations = { "Total Amount: " + total + "\n" + "PAN Card: " + uploadedText1 + "\n"
				+ "AADHAAR Card: " + uploadedText1 + "\n" + "AADHAAR Card back side: " + uploadedText1 + "\n"
				+ "Application submitted: " + applicationSubmittedText + "\n" + loanId };

		// returning all the validations
		return validations;
	}

	// Create B2B fee and apple finance
	public String[] createB2BFeeAndAppleFinance(String dob, String instituteKeys, String instituteName,
			String branchKeys, String branch, String courseKeys, String course, String relationship,
			String appleProduct) throws Throwable {

		Thread.sleep(5000);
		applyBtn.click();

		// entering the student details
		String stntName = "Test Btob fee and apple ";
		String studentName1 = TestUtil.randomChars(5);
		String studtsdsName = Character.toUpperCase(studentName1.charAt(0)) + studentName1.substring(1);
		String studentNameInDashboard = stntName + studtsdsName;
		studentName.sendKeys(studentNameInDashboard);
		
		//entering roll number
		rollNumber.sendKeys("Test" + TestUtil.randomDigits(7));

		// selecting student date of birth
		datePicker.click();
		datePicker.sendKeys(dob);

		// select the institute name from the drop down
		instituteSearch.sendKeys(instituteKeys);
		Thread.sleep(1000);
		By options = By.xpath(dropDownOptions);
		TestUtil.selectDropDownValue(options, instituteName);

		// selecting the branch name from the drop down
		branchName.sendKeys(branchKeys);
		Thread.sleep(1000);
		TestUtil.selectDropDownValue(options, branch);

		// selecting the course from the drop down
		courseName.sendKeys(courseKeys);
		Thread.sleep(1000);
		TestUtil.selectDropDownValue(options, course);
		Thread.sleep(1000);

		// getting course & tentative emi details
		String courseTenure = tenure.getText();
		String courseFees = courseFee.getAttribute("value");
		System.out.println("Course Tenure: " + courseTenure);
		System.out.println("Course Fee: " + courseFees);

		
		By appleProducts = By.xpath(appleProductsList);
		TestUtil.selectDropDownValue(appleProducts, appleProduct);
		Thread.sleep(1000);

		// verifying the course tenure in the financing summary
		String feeFinanceTenure = ""; 
		List<WebElement> summaryList = driver.findElements(By.xpath(appleFinanceEMi));
		for(int i=0; i<summaryList.size(); i++) {
			feeFinanceTenure = tenureInSummary.getText();
			System.out.println("List: "+feeFinanceTenure);
		}
		
		
		//Assert.assertTrue(tenureInFinanceSummary.contains(courseTenure));
		//System.out.println("Tenure in the financing summary: " + tenureInSummary.getText());

		// verifying the tentative emi in course finance and financing summary section
		String feeFinanceTentativeEmi = feeFinanceTentativeEMI.getText();
		String feeFinanceTentativeEmi_summary = tentativeEMI_summary.getText();
		Assert.assertEquals(feeFinanceTentativeEmi, feeFinanceTentativeEmi_summary);
		System.out.println("fee Finance Tentative EMI in financing details section: " + feeFinanceTentativeEmi + "\n"
				+ "fee Finance Tentative EMI in summary section: " + feeFinanceTentativeEmi_summary);

		// verifying the fee finance total in the summary section
		String feeFinanceTotalInSummary = feeFinanceTotal.getText();
		System.out.println("Fee finance total in summary: " + feeFinanceTotalInSummary);

		// verifying the total amount
		String totalFinanceAmount = totalAmountInSummary.getText();
			Assert.assertEquals(feeFinanceTotalInSummary, totalFinanceAmount);
		System.out.println("total finance amount: " + totalFinanceAmount);

		
		//getting apple tentative emi from the product
		String appleTentativeEMI="";
		List<WebElement> tentativeEMIList = driver.findElements(By.xpath(appleFinanceEMi));
		for(int i=0; i<tentativeEMIList.size(); i++) {
			appleTentativeEMI = tentativeEMIList.get(1).getText();
		}
		
		System.out.println(appleTentativeEMI);
		
		//verifying the apple tentative emi in the bottom of the page
		String appleEMI = "";
		List<WebElement> appleProdPriceList = driver.findElements(By.xpath(appleProdEmiAndPrice));
		for(int i=0; i<appleProdPriceList.size(); i++) {
			appleEMI = appleProdPriceList.get(0).getText();
			Assert.assertTrue(appleEMI.contains(appleTentativeEMI));
		}
		
		System.out.println(appleEMI);
		
		//validating both tentative emi's are same or not
		String appleFinanceTentativeEmi_summary = tentativeEMI_summary.getText();
		Assert.assertEquals(appleFinanceTentativeEmi_summary, appleTentativeEMI);
		System.out.println("Apple finance Tentative EMI in financing details section: "+ appleTentativeEMI+ 
				"\n"+ "Apple Finance Tentative EMI in summary section: "+appleFinanceTentativeEmi_summary);
//		
//		// verifying the fee finance total in the summary section
//		String feeFinanceTotalInSummary = feeFinanceTotal.getText();
//		System.out.println("Apples finance total in summary: " + feeFinanceTotalInSummary);
//
//		// verifying the total amount
//		String totalFinanceAmount = totalAmountInSummary.getText();
//		Assert.assertEquals(feeFinanceTotalInSummary, totalFinanceAmount);
//		System.out.println("Total finance amount: " + totalFinanceAmount);
		
		
		
		String total = totalAmount.getText();
		// click on proceed button on upload documents section
		proceedBtn.click();

		uploadDocs_RightIcon.click();

		// uploading PAN card
		PAN_ChooseFileBtn.click();
		TestUtil.uploadFile(PAN_test1);
		uploadDocumentsBtn.click();
		String uploadedText1 = documentUploaded.getText();

		// uploading AADHAAR card
		AADHAR_ChooseFileBtn.click();
		TestUtil.uploadFile(Aadhar_test1);
		uploadDocumentsBtn.click();
		uploadedText1 = documentUploaded.getText();

		// uploading AADHAAR card back side
		AADHAR_Backside_ChooseFileBtn.click();
		TestUtil.uploadFile(Aadhar_test1);
		uploadDocumentsBtn.click();
		uploadedText1 = documentUploaded.getText();

		applicantPhoto.click();
		TestUtil.uploadFile(applicantColorPhoto);
		uploadDocumentsBtn.click();
		uploadedText1 = documentUploaded.getText();

		// uploading bank statements
		bankStmts.click();
		TestUtil.uploadFile(bankStatements);
		uploadDocumentsBtn.click();
		uploadedText1 = documentUploaded.getText();

		// click proceed button to enter shipping details
		proceedBtn.click();
		Thread.sleep(2000);

		// shipping details
		addressLine1.sendKeys(TestUtil.randomChars(8));
		addressLine2.sendKeys(TestUtil.randomChars(8));
		city.sendKeys(TestUtil.randomChars(8));
		state.sendKeys(TestUtil.randomChars(8));
		pincode.sendKeys(TestUtil.randomDigits(6));
		Thread.sleep(1000);
		proceedBtn.click();
		Thread.sleep(3000);
		// applicant details
		relationshipWithStudent.sendKeys(relationship);
		Thread.sleep(1000);
		submitBtn.click();
		Thread.sleep(1000);

		List<WebElement> optionsList = driver.findElements(By.xpath(feeAndAppleLoanIds));
		String test = " ";
		for (WebElement e : optionsList) {
			test = e.getText();
		}

		backToDashboardBtn.click();
		Thread.sleep(1000);
		// getting all validations and storing in a string array
		String[] validations = { "TentativeEMI: " + "\n" + "Total Amount: " + total + "\n"
				+ "PAN Card: " + uploadedText1 + "\n" + "AADHAAR Card: " + uploadedText1 + "\n"
				+ "AADHAAR Card back side: " + uploadedText1 + "\n" + test };

		return validations;

	}

	// Create B2C fee finance
	public String[] createB2CFeeFinance(String dob, String relationship) throws Throwable {

		Thread.sleep(5000);
		applyBtn.click();

		// entering the student details
		String stntName = "Test Btoc Fee ";
		String studentName1 = TestUtil.randomChars(5); 
		String studtsdsName = Character.toUpperCase(studentName1.charAt(0))+studentName1.substring(1);
		String test1 = stntName+studtsdsName;
		studentName.sendKeys(test1);
		
		
		rollNumber.sendKeys("Test" + TestUtil.randomDigits(7));

		// selecting student date of birth
		datePicker.click();
		datePicker.sendKeys(dob);

		// select the institute name from the drop down
		instituteSearch.sendKeys(TestUtil.randomChars(10));
		Thread.sleep(1000);
		// selecting the branch name from the drop down
		branchName.sendKeys(TestUtil.randomChars(9));
		Thread.sleep(1000);

		// entering branch pincode
		branch_Pincode.sendKeys(TestUtil.randomDigits(6));
		Thread.sleep(1000);
		// selecting the course from the drop down
		course_Name.sendKeys(TestUtil.randomChars(9));
		courseFee.click();
		Thread.sleep(1000);
		courseFee.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
		Thread.sleep(1000);
		courseFee.sendKeys(TestUtil.randomDigits(4));
		Thread.sleep(1000);

		String courseFees = courseFee.getAttribute("value");
		System.out.println(courseFees);
		WebElement EMI = driver.findElement(By.xpath(emiOptionsFor_B2C));
		System.out.println(EMI.getText());

		List<WebElement> emiOptions = driver.findElements(By.xpath(tentativeEMI_List));

		System.out.println(emiOptions.size());

		WebElement tentativeEmi = emiOptions.get(0);
		String feeFinanceEMI = tentativeEmi.getText();
		System.out.println(feeFinanceEMI);

		List<WebElement> emi_Summary = driver.findElements(By.xpath(summaryEMI_Options));

		for (int i = 0; i < emi_Summary.size(); i++) {
			String summary_EMI = emi_Summary.get(i).getText();

			if (summary_EMI.contains(feeFinanceEMI)) {
				System.out.println(summary_EMI);
			}
		}

		String total = totalAmount.getText();
		System.out.println(total);
		Thread.sleep(2000);
		proceedBtn.click();

		uploadDocs_RightIcon.click();

		// uploading PAN card
		PAN_ChooseFileBtn.click();
		TestUtil.uploadFile(PAN_Path);
		uploadDocumentsBtn.click();
		String uploadedText1 = documentUploaded.getText();

		// uploading AADHAAR card
		AADHAR_ChooseFileBtn.click();
		TestUtil.uploadFile(Aadhar_Path);
		uploadDocumentsBtn.click();
		uploadedText1 = documentUploaded.getText();

		// uploading AADHAAR card back side
		AADHAR_Backside_ChooseFileBtn.click();
		TestUtil.uploadFile(Aadhar_Path);
		uploadDocumentsBtn.click();
		uploadedText1 = documentUploaded.getText();

		applicantPhoto.click();
		TestUtil.uploadFile(applicantColorPhoto);
		uploadDocumentsBtn.click();
		uploadedText1 = documentUploaded.getText();

		// uploading bank statements
		bankStmts.click();
		TestUtil.uploadFile(bankStatements);
		uploadDocumentsBtn.click();
		uploadedText1 = documentUploaded.getText();

		// click on proceed button on upload documents section
		proceedBtn.click();
		Thread.sleep(3000);

		// applicant details
		relationshipWithStudent.sendKeys(relationship);
		submitBtn.click();

		// getting the application submitted text and load ID
		String applicationSubmittedText = loanIdAfterAppSubmitted.getText();
		String loanId = loanID.getText();
		Thread.sleep(1000);

		// verifying the condition if the text contains the application id
		if (applicationSubmittedText.contains(loanId)) {
			backToDashboardBtn.click();
		}
		
		List<WebElement> studentNamesInDashboard = driver.findElements(By.xpath(studentNameList));
		System.out.println(studentNamesInDashboard.size());
		for(int i=0; i<studentNamesInDashboard.size(); i++) {
			Assert.assertTrue(studentNamesInDashboard.get(0).getText().contains(test1));
		}
		

		String[] validations = {
				"TentativeEMI: " + feeFinanceEMI + "\n" + "Total Amount: " + total + "\n" + "PAN Card: " + uploadedText1
						+ "\n" + "AADHAAR Card: " + uploadedText1 + "\n" + "AADHAAR Card back side: " + uploadedText1
						+ "\n" + "Application submitted: " + applicationSubmittedText + "\n" + loanId };

		return validations;
	}

	// Create B2C apple finance
	public String[] createB2CAppleFinance(String dob, String relationship, String deliveryBranchKeys,
			String deliveryBranch, String appleProduct) throws Throwable {

		Thread.sleep(5000);
		applyBtn.click();

		// entering the student details
		studentName.sendKeys("Test Btoc apple " + TestUtil.randomChars(5));
		rollNumber.sendKeys("Test" + TestUtil.randomDigits(7));

		// selecting student date of birth
		datePicker.click();
		datePicker.sendKeys(dob);

		// select the institute name from the drop down
		instituteSearch.sendKeys(TestUtil.randomChars(10));

		// selecting the branch name from the drop down
		branchName.sendKeys(TestUtil.randomChars(9));

		// entering branch pincode
		branch_Pincode.sendKeys(TestUtil.randomDigits(6));
		course_Name.sendKeys(TestUtil.randomChars(9));
		Thread.sleep(2000);

		courseFinanceCheckBox.click();
		Thread.sleep(1000);
		appleCheckBox.click();
		Thread.sleep(1000);

		deliveyLocation.sendKeys(deliveryBranchKeys);
		Thread.sleep(1000);

		By loactions = By.xpath(deliveryBranchList);
		TestUtil.selectDropDownValue(loactions, deliveryBranch);
		Thread.sleep(1000);
		checkAvailabilityBtn.click();
		Thread.sleep(1000);
		// selecting apple product
		By appleProducts = By.xpath(appleProductsList);
		TestUtil.selectDropDownValue(appleProducts, appleProduct);
		Thread.sleep(1000);

		String total = totalAmount.getText();
		System.out.println(total);
		Thread.sleep(2000);
		proceedBtn.click();

		uploadDocs_RightIcon.click();

		// uploading PAN card
		PAN_ChooseFileBtn.click();
		TestUtil.uploadFile(PAN_Path);
		uploadDocumentsBtn.click();
		String uploadedText1 = documentUploaded.getText();

		// uploading AADHAAR card
		AADHAR_ChooseFileBtn.click();
		TestUtil.uploadFile(Aadhar_Path);
		uploadDocumentsBtn.click();
		uploadedText1 = documentUploaded.getText();

		// uploading AADHAAR card back side
		AADHAR_Backside_ChooseFileBtn.click();
		TestUtil.uploadFile(Aadhar_Path);
		uploadDocumentsBtn.click();
		uploadedText1 = documentUploaded.getText();

		applicantPhoto.click();
		TestUtil.uploadFile(applicantColorPhoto);
		uploadDocumentsBtn.click();
		uploadedText1 = documentUploaded.getText();

		// uploading bank statements
		bankStmts.click();
		TestUtil.uploadFile(bankStatements);
		uploadDocumentsBtn.click();
		uploadedText1 = documentUploaded.getText();

		// click on proceed button on upload documents section
		proceedBtn.click();
		Thread.sleep(3000);
		addressLine1.sendKeys(TestUtil.randomChars(8));
		addressLine2.sendKeys(TestUtil.randomChars(8));
		city.sendKeys(TestUtil.randomChars(8));
		state.sendKeys(TestUtil.randomChars(8));
		pincode.sendKeys(TestUtil.randomDigits(6));
		Thread.sleep(1000);
		proceedBtn.click();
		Thread.sleep(3000);
		// applicant details
		relationshipWithStudent.sendKeys(relationship);
		Thread.sleep(1000);
		submitBtn.click();
		Thread.sleep(1000);

		// getting application id after submitted
		String applicationSubmittedText = loanIdAfterAppSubmitted.getText();
		String loanId = loanID.getText();
		Thread.sleep(1000);

		// verifying the condition if the text contains the application id
		if (applicationSubmittedText.contains(loanId)) {
			backToDashboardBtn.click();
		}

		// getting all validations and storing in a string array
		String[] validations = { "Total Amount: " + total + "\n" + "PAN Card: " + uploadedText1 + "\n"
				+ "AADHAAR Card: " + uploadedText1 + "\n" + "AADHAAR Card back side: " + uploadedText1 + "\n"
				+ "Application submitted: " + applicationSubmittedText + "\n" + loanId };

		// returning all the validations
		return validations;
	}

	// Create B2C Fee and Apple Finance
	public String[] createB2CFeeAndAppleFinance(String dob, String relationship, String deliveryBranchKeys,
			String deliveryBranch, String appleProduct) throws Throwable {

		Thread.sleep(5000);
		applyBtn.click();

		// entering the student details
		studentName.sendKeys("Test Btoc fee " + TestUtil.randomChars(5));
		rollNumber.sendKeys("Test" + TestUtil.randomDigits(7));

		// selecting student date of birth
		datePicker.click();
		datePicker.sendKeys(dob);

		// select the institute name from the drop down
		instituteSearch.sendKeys(TestUtil.randomChars(10));
		Thread.sleep(1000);
		// selecting the branch name from the drop down
		branchName.sendKeys(TestUtil.randomChars(9));
		Thread.sleep(1000);

		// entering branch pincode
		branch_Pincode.sendKeys(TestUtil.randomDigits(6));

		// selecting the course from the drop down
		course_Name.sendKeys(TestUtil.randomChars(9));
		courseFee.click();
		Thread.sleep(1000);
		courseFee.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
		Thread.sleep(1000);
		courseFee.sendKeys(TestUtil.randomDigits(4));
		Thread.sleep(1000);

		String courseFees = courseFee.getAttribute("value");
		System.out.println(courseFees);
		WebElement EMI = driver.findElement(By.xpath(emiOptionsFor_B2C));
		System.out.println(EMI.getText());

		List<WebElement> emiOptions = driver.findElements(By.xpath(tentativeEMI_List));

		System.out.println(emiOptions.size());

		WebElement tentativeEmi = emiOptions.get(0);
		String feeFinanceEMI = tentativeEmi.getText();
		System.out.println(feeFinanceEMI);

		appleCheckBox.click();
		Thread.sleep(1000);

		deliveyLocation.sendKeys(deliveryBranchKeys);
		Thread.sleep(1000);

		By loactions = By.xpath(deliveryBranchList);
		TestUtil.selectDropDownValue(loactions, deliveryBranch);
		Thread.sleep(1000);
		checkAvailabilityBtn.click();
		Thread.sleep(1000);
		// selecting apple product
		By appleProducts = By.xpath(appleProductsList);
		TestUtil.selectDropDownValue(appleProducts, appleProduct);
		Thread.sleep(1000);

		List<WebElement> emi_Summary = driver.findElements(By.xpath(summaryEMI_Options));

		for (int i = 0; i < emi_Summary.size(); i++) {
			String summary_EMI = emi_Summary.get(i).getText();

			if (summary_EMI.contains(feeFinanceEMI)) {
				System.out.println(summary_EMI);
			}
		}

		String total = totalAmount.getText();
		System.out.println(total);
		Thread.sleep(2000);
		proceedBtn.click();

		uploadDocs_RightIcon.click();

		// uploading PAN card
		PAN_ChooseFileBtn.click();
		TestUtil.uploadFile(PAN_Path);
		uploadDocumentsBtn.click();
		String uploadedText1 = documentUploaded.getText();

		// uploading AADHAAR card
		AADHAR_ChooseFileBtn.click();
		TestUtil.uploadFile(Aadhar_Path);
		uploadDocumentsBtn.click();
		uploadedText1 = documentUploaded.getText();

		// uploading AADHAAR card back side
		AADHAR_Backside_ChooseFileBtn.click();
		TestUtil.uploadFile(Aadhar_Path);
		uploadDocumentsBtn.click();
		uploadedText1 = documentUploaded.getText();

		applicantPhoto.click();
		TestUtil.uploadFile(applicantColorPhoto);
		uploadDocumentsBtn.click();
		uploadedText1 = documentUploaded.getText();

		// uploading bank statements
		bankStmts.click();
		TestUtil.uploadFile(bankStatements);
		uploadDocumentsBtn.click();
		uploadedText1 = documentUploaded.getText();

		// click on proceed button on upload documents section
		proceedBtn.click();
		Thread.sleep(3000);
		addressLine1.sendKeys(TestUtil.randomChars(8));
		addressLine2.sendKeys(TestUtil.randomChars(8));
		city.sendKeys(TestUtil.randomChars(8));
		state.sendKeys(TestUtil.randomChars(8));
		pincode.sendKeys(TestUtil.randomDigits(6));
		Thread.sleep(1000);
		proceedBtn.click();
		Thread.sleep(3000);
		// applicant details
		relationshipWithStudent.sendKeys(relationship);
		Thread.sleep(1000);
		submitBtn.click();
		Thread.sleep(1000);

		List<WebElement> optionsList = driver.findElements(By.xpath(feeAndAppleLoanIds));
		String test = " ";
		for (WebElement e : optionsList) {
			test = e.getText();
		}

		backToDashboardBtn.click();
		Thread.sleep(1000);
		// getting all validations and storing in a string array
		String[] validations = { "TentativeEMI: " + feeFinanceEMI + "\n" + "Total Amount: " + total + "\n"
				+ "PAN Card: " + uploadedText1 + "\n" + "AADHAAR Card: " + uploadedText1 + "\n"
				+ "AADHAAR Card back side: " + uploadedText1 + "\n" + test };

		return validations;
	}

}

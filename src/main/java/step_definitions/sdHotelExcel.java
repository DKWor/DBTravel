package step_definitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import baseclass.Baseclass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectclass.pomHotelExceldata;
import utils.commonMethodes;
import utils.excelReader;

public class sdHotelExcel extends Baseclass{
	 
	
	pomHotelExceldata home;
	excelReader reder;
	List<Map<String, String>> testData;
	 private int row;
		private static final String FARETYPE = "FARE_TYPE";
		
		private static final Logger logger = LogManager.getLogger(sdHotelExcel.class);


	 
	 @Given("User is on dbtravel Landing page with the {string} environment")
	    public void userIsOnzenithLandingPage(String environment) throws IOException  {
	        
	    	launchBrowser(environment); 
	    } 
	 
	 
	   @When("User SighnIn with username and password for {string}")
	    public void loginwithUsernamePassword(String environment) throws InterruptedException, IOException {

		   home=new pomHotelExceldata(driver);
		   home.validLogin(environment,driver);
		


	    }
	    
	    @Then("User selct the Hotel option on home page")
	    public void userSelectsHotelOption() throws InterruptedException {
	    	home=new pomHotelExceldata(driver);
	    	home.clickOnHotel(driver);
	    }
	
	    
	    @Then("Select the Nationality")
	    public void selecttheNationality() throws InterruptedException {
	    	home=new pomHotelExceldata(driver);
	    	home.selecttheNationality(driver);
	    }
	    
	    
	    @Then("selec the Advanced Search")
	    public void selectheAdvanced_Search() throws InterruptedException {
	    	home=new pomHotelExceldata(driver);
	    	home.selectAdvancedSearch(driver);
	    }
	    
	    
	 
	    
	@Then("^User pass the cityname for hotlbooking from given sheetName (.+) and rowNumber (.+)$")
	public void userpassthecitynameforhotlbookingfromgivensheetnameandrownumber(Integer sheetNumber, Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException {
		 
		  reder=new excelReader();
		 	 testData=reder.getData(commonMethodes.Excelpath(), sheetNumber);
		 	 
		 	 
		 	row=rowNumber;
		 	
		 	String  areaname = testData.get(row).get("HOTEL_NAME");
			String faretype = testData.get(row).get(FARETYPE);
			
			logger.info("My FARE TYPE IS :"+faretype);

		 	
		 	home.searchselectCity(driver, areaname);
		
	}
	
	@When("User select the brekfast option frome select breakfast")
	public void userselectthebrekfastoptionfromeselectbreakfast() throws InterruptedException {
	 	
	 	home.selecttheBrekfastoption(driver);

	}
	
	@When("User select the star rating")
	public void userselectthestarrating() throws InterruptedException {
	 	
		String starrating = testData.get(row).get("STAR_RATING");
	 	home.selecttherating(driver,starrating);

	}
	
	
	@Then("User select the date for hotle booking INdate and Outdate")
	public void userselectthedateforhotlebookingindateandoutdate() throws InterruptedException {
	 
	 	String monthyear = testData.get(row).get("MONT&YEAR");
	 	String rmonthyear = testData.get(row).get("RMONT&YEAR");
	 	String indate = testData.get(row).get("IN_DATE");
	 	String outdate = testData.get(row).get("OUT_DATE");

	 	
	 	
	 	home.SelectDatefortrip(driver, monthyear,rmonthyear, indate, outdate);

	}
	
	   @Then("User select the fare type Refundable frome Advanced Search")
	    public void userselectthefaretypeRefundablefromeAdvanced_Search() throws InterruptedException {
	    	
		   
		   String faretype = testData.get(row).get(FARETYPE);
		   logger.info("FARE_TYPE :"+faretype);
	    	home.selecttheFareType(driver,faretype);
	    }
	
	@Then("User select the Adult and child and room as per requirment")
	public void userselecttheadultandchildandroomasperrequirment() throws InterruptedException {
		String adultpax = testData.get(row).get("ADULT_PAX");
	 	String childpax = testData.get(row).get("CHILD_PAX");
	 	String roompax = testData.get(row).get("ROOM_PAX");
	 	
	 	home.selectRoomPass(driver, adultpax, childpax, roompax);
		
	 	
		
	}
	
	  @And("User clicks on the search button")
	    public void userClicksOnSearchButton() throws InterruptedException {

	    	 home.clickSearch(driver);
	    	 }
	  
	  
	  @And("User select the Quick filter")
	    public void uselecttheQuickfilter() throws InterruptedException {

	    	 home.clickQuickfilter(driver);
	    	 }
	  
	  @And("User select the Star Rating")
	    public void userselecttheStarRating() throws InterruptedException {

	    	 home.clickStarRating(driver);
	    	 }
	  
	  @And("User select the Price Range")
	    public void uselectthePriceRange() throws InterruptedException {

	    	 home.clickPriceRange(driver);
	    	 }
	 
	  @And("User select the Amenities")
	    public void userselecttheAmenities() throws InterruptedException {

	    	 home.clickPriceAmenities(driver);
	    	 }
	  
	  
	  @And("User select the Vacation Type filter")
	    public void User_select_the_Vacation_Type_filter() throws InterruptedException {

	    	 home.clickPriceVacationTypefilter(driver);
	    	 }
	  
	  @And("User select the Property Type filter")
	    public void userselectthePropertyType_filter() throws InterruptedException {

	    	 home.clickPricePropertyTypefilter(driver);
	    	 }
	  
	  @Then("User selects the hotel")
	    public void userSelectsHotel() throws InterruptedException {
	    	home.selectHotel(driver);
	    }
	   @And("User selects the refundable room")
	    public void userSelectsRoomrefundable() throws InterruptedException {
		   
		   String faretype = testData.get(row).get(FARETYPE);
	    	home.selectRoom(driver,faretype);
	    	
	    }
	   
	   @And("User selects the non-refundable room")
	    public void userSelectsRoomnonrefundable() throws InterruptedException {
		   
		   String faretype = testData.get(row).get("FARE_TYPE2");
	    	home.selectRoom(driver,faretype);
	    	
	    }
	   
	   @And("User handle the Room not available Popup")
	    public void userhandletheRoomnotavailablePopup() throws InterruptedException {
	    	home.handelRoomnotavailablePopup(driver);
	    }  
	   
	   @Then("Add Mark Up or Makr Down")
	    public void addMarkUporMakrDown() throws InterruptedException {
			boolean markType = Boolean.parseBoolean(testData.get(row).get("isMark_Down"));
	    	home.AddMarkupinpercentage(driver,markType);
	    } 
	   
	   @Then("Add Percentage or Flat")
	    public void addPercentageorFlat() throws InterruptedException {
		   boolean isPercentage = Boolean.parseBoolean(testData.get(row).get("isPercentage"));
		 	String percentageorflat = testData.get(row).get("Percentage");

	    	home.AddMarkupinFixedtype(driver,isPercentage,percentageorflat);
	    }
	   
	   @Then("Add local taxes")
	    public void addlocaltaxes() throws InterruptedException {
		 	String localtax = testData.get(row).get("LOCAL_TAX");
	    	home.Addlocaltaxes(driver,localtax);
	    }
	   
	   @Then("Calculate_the_AmountOnReviewPage")
	    public void calculatetheAmountOnReviewPage() throws InterruptedException {
	    	home.calculatetheAmountOnReviewPage(driver);
	    }
	   
	   @Then("Calculate_the_AmountOn_ConformationPage")
	    public void calculatetheAmountOnConformationPage() throws InterruptedException {
	    	home.calculatetheAmountOnReviewPage(driver);
	    }
	   
	   @And("User clicks on the continue button")
	    public void clickContinueBooking() throws InterruptedException {
		   home.clickOnContinueButton(driver);
	    }
	
	   @And("User selects the adult for as room")
	    public void whenUserSelectsAdultForRoom() throws InterruptedException 
	   {
		 	String roompax = testData.get(row).get("ROOM_PAX");

		   home.selectAdultForRoom(driver, roompax);
	    
	    }
	   
	   @And("User selects the adult for room without login")
	    public void userselectstheadultforroomwithoutlogin() throws InterruptedException 
	   {
		 	String roompax = testData.get(row).get("ROOM_PAX");

		   home.selectAdultForRoomWithoutLogin(driver, roompax);
	    
	    }
	   
		@Then("I click on continue booking for hotel accept the terms of use for Hotel")
		public void clickcontinueandproceedforpayment() throws InterruptedException
		{
		 	String roompax = testData.get(row).get("ROOM_PAX");

			home.clickContinueButtonAndProceedPayment(driver, roompax);
		}

	
	
	

}

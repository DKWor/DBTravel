package StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import Baseclass.Baseclass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectclass.POMHotelExceldata;
import utils.CommonMethodes;
import utils.ExcelReader;

public class SDHotelExcel extends Baseclass{
	 
	
	POMHotelExceldata HOME;
	ExcelReader reder;
	List<Map<String, String>> testData;
	 public int row;
	 
	 @Given("User is on dbtravel Landing page with the {string} environment")
	    public void userIsOnzenithLandingPage(String environment) throws InterruptedException, IOException {
	        
	    	launchBrowser(environment); 
	    } 
	 
	 
	   @When("User SighnIn with username and password for {string}")
	    public void LoginwithUsernamePassword(String environment) throws InterruptedException, IOException {

		   HOME=new POMHotelExceldata(driver);
		   HOME.ValidLogin(environment,driver);
		


	    }
	    
	    @Then("User selct the Hotel option on home page")
	    public void userSelectsHotelOption() throws InterruptedException {
	    	HOME=new POMHotelExceldata(driver);
	    	HOME.clickOnHotel(driver);
	    }
	
	    
	    @Then("Select the Nationality")
	    public void Select_the_Nationality() throws InterruptedException {
	    	HOME=new POMHotelExceldata(driver);
	    	HOME.Select_the_Nationality(driver);
	    }
	    
	    
	    @Then("selec the Advanced Search")
	    public void selec_the_Advanced_Search() throws InterruptedException {
	    	HOME=new POMHotelExceldata(driver);
	    	HOME.Select_Advanced_Search(driver);
	    }
	    
	    
	 
	    
	@Then("^User pass the cityname for hotlbooking from given sheetName (.+) and rowNumber (.+)$")
	public void user_pass_the_cityname_for_hotlbooking_from_given_sheet_name_and_row_number(Integer SheetNumber, Integer RowNumber) throws InvalidFormatException, IOException, InterruptedException {
		 
		  reder=new ExcelReader();
		 	 testData=reder.getData(CommonMethodes.Excelpath(), SheetNumber);
		 	 
		 	 
		 	row=RowNumber;
		 	
		 	String AREA_NAME = testData.get(row).get("HOTEL_NAME");
			String FARE_TYPE = testData.get(row).get("FARE_TYPE");
			
			System.out.println("My FARE TYPE IS :"+FARE_TYPE);

		 	
		 	HOME.Search_selectCity(driver, AREA_NAME);
		
	}
	
	@When("User select the brekfast option frome select breakfast")
	public void User_select_the_brekfast_option_frome_select_breakfast() throws InterruptedException {
	 	
	 	HOME.Select_the_Brekfastoption(driver);

	}
	
	@When("User select the star rating")
	public void User_select_the_star_rating() throws InterruptedException {
	 	
		String STAR_RATING = testData.get(row).get("STAR_RATING");
	 	HOME.Select_the_rating(driver,STAR_RATING);

	}
	
	
	@Then("User select the date for hotle booking INdate and Outdate")
	public void user_select_the_date_for_hotle_booking_i_ndate_and_outdate() throws InterruptedException {
	 
	 	String MONT_YEAR = testData.get(row).get("MONT&YEAR");
	 	String RMONT_YEAR = testData.get(row).get("RMONT&YEAR");
	 	String IN_DATE = testData.get(row).get("IN_DATE");
	 	String OUT_DATE = testData.get(row).get("OUT_DATE");

	 	
	 	
	 	HOME.SelectDatefortrip(driver, MONT_YEAR,RMONT_YEAR, IN_DATE, OUT_DATE);

	}
	
	   @Then("User select the fare type Refundable frome Advanced Search")
	    public void User_select_the_fare_type_Refundable_frome_Advanced_Search() throws InterruptedException {
	    	
		   
		   String FARE_TYPE = testData.get(row).get("FARE_TYPE");
		   System.out.println("FARE_TYPE :"+FARE_TYPE);
	    	HOME.Select_the_FareType(driver,FARE_TYPE);
	    }
	
	@Then("User select the Adult and child and room as per requirment")
	public void user_select_the_adult_and_child_and_room_as_per_requirment() throws InterruptedException {
		String ADULT_PAX = testData.get(row).get("ADULT_PAX");
	 	String CHILD_PAX = testData.get(row).get("CHILD_PAX");
	 	String ROOM_PAX = testData.get(row).get("ROOM_PAX");
	 	
	 	HOME.Select_1Room_1Pass(driver, ADULT_PAX, CHILD_PAX, ROOM_PAX);
		
	 	
		
	}
	
	  @And("User clicks on the search button")
	    public void userClicksOnSearchButton() throws InterruptedException {

	    	 HOME.click_Search(driver);
	    	 }
	  
	  
	  @And("User select the Quick filter")
	    public void User_select_the_Quick_filter() throws InterruptedException {

	    	 HOME.click_Quick_filter(driver);
	    	 }
	  
	  @And("User select the Star Rating")
	    public void User_select_the_Star_Rating() throws InterruptedException {

	    	 HOME.click_Star_Rating(driver);
	    	 }
	  
	  @And("User select the Price Range")
	    public void User_select_the_Price_Range() throws InterruptedException {

	    	 HOME.click_Price_Range(driver);
	    	 }
	 
	  @And("User select the Amenities")
	    public void User_select_the_Amenities() throws InterruptedException {

	    	 HOME.click_Price_Amenities(driver);
	    	 }
	  
	  
	  @And("User select the Vacation Type filter")
	    public void User_select_the_Vacation_Type_filter() throws InterruptedException {

	    	 HOME.click_Price_Vacation_Type_filter(driver);
	    	 }
	  
	  @And("User select the Property Type filter")
	    public void User_select_the_Property_Type_filter() throws InterruptedException {

	    	 HOME.click_Price_Property_Type_filter(driver);
	    	 }
	  
	  @Then("User selects the hotel")
	    public void userSelectsHotel() throws InterruptedException {
	    	HOME.selectHotel(driver);
	    }
	   @And("User selects the refundable room")
	    public void userSelectsRoom_refundable() throws InterruptedException {
		   
		   String FARE_TYPE = testData.get(row).get("FARE_TYPE");
	    	HOME.selectRoom(driver,FARE_TYPE);
	    	
	    }
	   
	   @And("User selects the non-refundable room")
	    public void userSelectsRoom_nonrefundable() throws InterruptedException {
		   
		   String FARE_TYPE = testData.get(row).get("FARE_TYPE2");
	    	HOME.selectRoom(driver,FARE_TYPE);
	    	
	    }
	   
	   @And("User handle the Room not available Popup")
	    public void User_handle_the_Room_not_available_Popup() throws InterruptedException {
	    	HOME.Handel_Room_not_available_Popup(driver);
	    }  
	   
	   @Then("Add Mark Up or Makr Down")
	    public void Add_Mark_Up_or_Makr_Down() throws InterruptedException {
			boolean markType = Boolean.parseBoolean(testData.get(row).get("isMark_Down"));
	    	HOME.AddMarkupinpercentage(driver,markType);
	    } 
	   
	   @Then("Add Percentage or Flat")
	    public void Add_Percentage_or_Flat() throws InterruptedException {
		   boolean isPercentage = Boolean.parseBoolean(testData.get(row).get("isPercentage"));
		 	String Percentageorflat = testData.get(row).get("Percentage");

	    	HOME.AddMarkupinFixedtype(driver,isPercentage,Percentageorflat);
	    }
	   
	   @Then("Add local taxes")
	    public void Add_local_taxes() throws InterruptedException {
		 	String LOCALTAX = testData.get(row).get("LOCAL_TAX");
	    	HOME.Addlocaltaxes(driver,LOCALTAX);
	    }
	   
	   @Then("Calculate_the_AmountOnReviewPage")
	    public void Calculate_the_AmountOnReviewPage() throws InterruptedException {
	    	HOME.Calculate_the_AmountOnReviewPage(driver);
	    }
	   
	   @Then("Calculate_the_AmountOn_ConformationPage")
	    public void Calculate_the_AmountOn_ConformationPage() throws InterruptedException {
	    	HOME.Calculate_the_AmountOnReviewPage(driver);
	    }
	   
	   @And("User clicks on the continue button")
	    public void clickContinueBooking() throws InterruptedException {
		   HOME.clickOnContinueButton(driver);
	    }
	
	   @And("User selects the adult for as room")
	    public void whenUserSelectsAdultForRoom() throws InterruptedException 
	   {
		 	String ROOM_PAX = testData.get(row).get("ROOM_PAX");

		   HOME.selectAdultForRoom(driver, ROOM_PAX);
	    
	    }
	   
	   @And("User selects the adult for room without login")
	    public void User_selects_the_adult_for_room_without_login() throws InterruptedException 
	   {
		 	String ROOM_PAX = testData.get(row).get("ROOM_PAX");

		   HOME.selectAdultForRoomWithoutLogin(driver, ROOM_PAX);
	    
	    }
	   
		@Then("I click on continue booking for hotel accept the terms of use for Hotel")
		public void clickcontinueandproceedforpayment() throws InterruptedException
		{
		 	String ROOM_PAX = testData.get(row).get("ROOM_PAX");

			HOME.clickContinueButtonAndProceedPayment(driver, ROOM_PAX);
		}

	
	
	

}

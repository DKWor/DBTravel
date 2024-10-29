package StepDefinitions;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import Baseclass.Baseclass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjectclass.B2BFlightPOM;
import utils.CommonMethodes;
import utils.ExcelReader;

public class B2BFlightStep extends Baseclass {

	private B2BFlightPOM HOME;
	private ExcelReader reader;
	private List<Map<String, String>> testData;
	private int row;
 
   

	@Then("User is Click On Flight")
	public void userClicksOnFlight() throws InterruptedException {
		HOME = new B2BFlightPOM(driver);
		HOME.clickFlightModule();
	}

	@Then("^User select the trip and pass origin and destination from given sheetName (.+) and rowNumber (.+)$")
	public void userSelectTripAndPassOriginDestination(int sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException {
		reader = new ExcelReader();
		testData = reader.getData(CommonMethodes.Excelpath(), sheetName);
		row = rowNumber;

		String tripType = testData.get(row).get("TRIP TYPE");
		String origin = testData.get(row).get("ORIGIN");
		String destination = testData.get(row).get("DESTINATION");

		System.out.println("---- user travel details ---" + "TRIP TYPE" + tripType + "origin" + origin + "destination"
				+ destination);
		HOME = new B2BFlightPOM(driver);
		//HOME.Selecttrippassoriginanddestination(driver, tripType, origin, destination);
		HOME.selectthecity(driver, tripType, origin, destination);
	}

	@Then("select the date for trip")
	public void selectDateForTrip() throws InterruptedException {
		String tripType = testData.get(row).get("TRIP TYPE");
		String inDate = testData.get(row).get("IN_DATE");
		String returnDate = testData.get(row).get("OUT_DATE");
		String monthYear = testData.get(row).get("MONT&YEAR");
		String rmonthrYear = testData.get(row).get("RMONT&YEAR");
		boolean SearchType = Boolean.parseBoolean(testData.get(row).get("Advanced_Search"));


		HOME.SelectDatefortrip(driver, tripType, monthYear, rmonthrYear, inDate, returnDate,SearchType);
	}

	@Then("select the class for trip")
	public void selectClassForTrip() throws InterruptedException, IOException {
		String tripType = testData.get(row).get("TRIP TYPE");
		String flightClass = testData.get(row).get("CLASS");

		HOME.selectClassforTrip(driver, tripType, flightClass);
	}

	@Then("select the supplier from list")
	public void selectSupplierFromList() throws InterruptedException, IOException {
		HOME.select_supplier(driver);
	}

	@Then("The user should able to select Business, First Class, Premium Economy cabin class details")
	public void selectCabinClassDetails() throws InterruptedException {
		String tripType = testData.get(row).get("TRIP TYPE");
		String flightClass = testData.get(row).get("CLASS");

		HOME.selectClassforTripandValidaetheclass(driver, tripType, flightClass);
	}

	@Then("User select the passenger for trip")
	public void selectPassengerForTrip() throws InterruptedException {
		String adultPax = testData.get(row).get("ADULT_PAX");
		String childPax = testData.get(row).get("CHILD_PAX");
		String infantsPax = testData.get(row).get("INFANTS_PAX");

		HOME.Selectpassangerfortrip(driver, adultPax, childPax, infantsPax);
	}

	@And("User clicks on the search button for flight")
	public void clickOnSearchButtonForFlight() throws InterruptedException {
		HOME = new B2BFlightPOM(driver);
		String tripType = testData.get(row).get("TRIP TYPE");
		HOME.click_Search(driver, tripType);
	}
	
	@And("user selects departure time from")
	public void selectDepartureFrom() throws InterruptedException {
		HOME.selectDepartureTimeFrom(driver);
	}

	@And("user selects Onward airlines")
	public void selectOnwardAirlines() throws InterruptedException {
		HOME.selectAirlineFromOnwards(driver);
	}
	
	@And("user selects return airlines")
	public void selectreturnAirlines() throws InterruptedException {
		HOME.selectAirlineFromReturns(driver);
	}
	
	@And("user selects Layover onwards")
	public void selectLayoverOnwards() throws InterruptedException {
		HOME.selectLayoverOnward(driver);	}
	
	@And("user selects Layover returns")
	public void selectLayoverreturns() throws InterruptedException {
		HOME.selectLayoverreturns(driver);	}
	


	@Then("select the Flight and click on book")
	public void selectRefundableFlight() throws InterruptedException {
		String tripType = testData.get(row).get("TRIP TYPE");
		String flightType = testData.get(row).get("FLIGHT_TYPE");
		String fareType = testData.get(row).get("FARE_TYPE");
		boolean SearchType = Boolean.parseBoolean(testData.get(row).get("Advanced_Search"));
		HOME.selectFareTypeFlight(driver, fareType,SearchType,tripType);
	}
	
	
	@Then("User check search result")
	public void User_check_search_result() throws InterruptedException {
		HOME.checksearchresult(driver);
	}


	@Then("User handel the Price Change Alert Popup")
	public void User_handel_the_Price_Change_Alert_Popup() throws InterruptedException {
		HOME.HandelThePriceChangeAlert(driver);
	}

	@Then("user select search filter number of stops")
	public void selectNoOFStops() throws InterruptedException {
		String noOfStops = testData.get(row).get("noOfStops");
		HOME.selectStops(driver, noOfStops);
	}

	@Then("user select search filter fare type")
	public void selectFareType() throws InterruptedException {
		String fareType = testData.get(row).get("FARE_TYPE");
		HOME.selectFareType(driver, fareType);
	}

	@Then("user select marktype radio button")
	public void selectMarkUpType() throws InterruptedException {
		boolean markType = Boolean.parseBoolean(testData.get(row).get("isMark_Down"));

		HOME.selectMarkType(driver, markType);
	}

	@Then("user select either percent or flat toggle")
	public void selectPercentAndEnterPercent() throws InterruptedException {
		
		boolean isPercentToggle = Boolean.parseBoolean(testData.get(row).get("isPercentage"));
		String Percentage =testData.get(row).get("Percentage");

		HOME.selectPercentOrFlat(driver, isPercentToggle,Percentage);
	}

 

	@Then("user enter flat value in text box")
	public void enterFlatValue() throws InterruptedException {
//		int flat = Integer.parseInt(testData.get(row).get("FLAT"));
		String flat = testData.get(row).get("FLAT");

		HOME.enterFlatValue(driver, flat);
	}

	@Then("user apply pricerange filters")
	public void selectPriceRangeValues() throws InterruptedException {
;
		HOME.selectDynamicPriceRange(driver);
	}

	@Then("user apply trip duration filters")
	public void applyTimeRaneFilters() throws InterruptedException {
		HOME.selectDynamicTimeRange(driver);
	}

	@Then("user enter local taxes")
	public void enterLocalTaxValues() throws InterruptedException {
//		int localTax = Integer.parseInt(testData.get(row).get("LOCAL_TAXC"));
		String localTax = testData.get(row).get("LOCAL_TAX");
		System.out.println("local tsx value is ---" + localTax);
		HOME.enterLocalTaxes(driver, localTax);
	}


	@Then("check for Fare Details total amounts calculation")
	public void checkFareDetailsTotalAmounts() throws InterruptedException {
		HOME.checkFareDetails(driver);
	}
	
	@And("User select the Advanced Search option")
	public void User_select_the_Advanced_Search_option() throws InterruptedException 
	{		HOME = new B2BFlightPOM(driver);

		HOME.clickAdvancebooking(driver);	

	}
	
	
	@Then("User select the RBD classes")
	public void User_select_the_RBD_classes() throws InterruptedException 
	{
		String RBD = testData.get(row).get("RBD");
		String TRIP_TYPE = testData.get(row).get("TRIP TYPE");


		HOME.SelectRBDClases(driver,RBD,TRIP_TYPE);	

	}
	

	
	
	@Then("User select the Cabin classes")
	public void User_select_the_Cabin_classes() throws InterruptedException 
	{
		String CLASS = testData.get(row).get("CLASS");
		String TRIP_TYPE = testData.get(row).get("TRIP TYPE");

		HOME.SelectCabin(driver,CLASS,TRIP_TYPE);	

	}
	
	@Then("User select the Supplier name")
	public void User_select_the_Supplier_name() throws InterruptedException 
	{
		String Supplier = testData.get(row).get("Supplier");

		HOME.SelectSupplier(driver,Supplier);	

	}
	
	@Then("User select the Depature Time")
	public void  User_select_the_Depature_Time() throws InterruptedException 
	{
		String DepartureTime = testData.get(row).get("DepartureTime");
		String TRIP_TYPE = testData.get(row).get("TRIP TYPE");

		HOME.SelectDepartureTime(driver,DepartureTime,TRIP_TYPE);	

	}
	
	
	
}

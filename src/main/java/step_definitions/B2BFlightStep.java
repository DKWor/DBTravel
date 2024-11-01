package step_definitions;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import baseclass.Baseclass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjectclass.B2BFlightPOM;
import utils.CommonMethods;
import utils.ExcelReader;

public class B2BFlightStep extends Baseclass {

	private B2BFlightPOM home;
	private ExcelReader reader;
	private List<Map<String, String>> testData;
	private int row;
 
	private static final String TRIPTYPE = "TRIP TYPE";
	private static final String CLASS="CLASS";
	
	private static final Logger logger = LogManager.getLogger(B2BFlightStep.class);
	@Then("User is Click On Flight")
	public void userClicksOnFlight() throws InterruptedException {
		home = new B2BFlightPOM(driver);
		home.clickFlightModule();
	}

	@Then("^User select the trip and pass origin and destination from given sheetName (.+) and rowNumber (.+)$")
	public void userSelectTripAndPassOriginDestination(int sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException {
		reader = new ExcelReader();
		testData = reader.getData(CommonMethods.getExcelPath(), sheetName);
		row = rowNumber;

		String tripType = testData.get(row).get(TRIPTYPE);
		String origin = testData.get(row).get("ORIGIN");
		String destination = testData.get(row).get("DESTINATION");

		logger.info("---- user travel details --- TRIPTYPE: {}, Origin: {}, Destination: {}", tripType, origin, destination);

		home = new B2BFlightPOM(driver);
		home.selectthecity(driver, tripType, origin, destination);
	}

	@Then("select the date for trip")
	public void selectDateForTrip() throws InterruptedException {
		String tripType = testData.get(row).get(TRIPTYPE);
		String inDate = testData.get(row).get("IN_DATE");
		String returnDate = testData.get(row).get("OUT_DATE");
		String monthYear = testData.get(row).get("MONT&YEAR");
		String rmonthrYear = testData.get(row).get("RMONT&YEAR");
		boolean searchType = Boolean.parseBoolean(testData.get(row).get("Advanced_Search"));


		home.selectDatefortrip(driver, tripType, monthYear, rmonthrYear, inDate, returnDate,searchType);
	}

	@Then("select the class for trip")
	public void selectClassForTrip()   {
		String flightClass = testData.get(row).get(CLASS);

		home.selectClassforTrip(driver, flightClass);
	}

	@Then("select the supplier from list")
	public void selectSupplierFromList() throws InterruptedException {
		home.selectsupplierlist(driver);
	}

	@Then("The user should able to select Business, First Class, Premium Economy cabin class details")
	public void selectCabinClassDetails() throws InterruptedException {
		String tripType = testData.get(row).get(TRIPTYPE);
		String flightClass = testData.get(row).get(CLASS);

		home.selectClassforTripandValidaetheclass(driver, tripType, flightClass);
	}

	@Then("User select the passenger for trip")
	public void selectPassengerForTrip() throws InterruptedException {
		String adultPax = testData.get(row).get("ADULT_PAX");
		String childPax = testData.get(row).get("CHILD_PAX");
		String infantsPax = testData.get(row).get("INFANTS_PAX");

		home.selectpassangerfortrip(driver, adultPax, childPax, infantsPax);
	}

	@And("User clicks on the search button for flight")
	public void clickOnSearchButtonForFlight()   {
		home = new B2BFlightPOM(driver);
		home.clickSearch();
	}
	
	@And("user selects departure time from")
	public void selectDepartureFrom() throws InterruptedException {
		home.selectDepartureTimeFrom(driver);
	}

	@And("user selects Onward airlines")
	public void selectOnwardAirlines() throws InterruptedException {
		home.selectAirlineFromOnwards(driver);
	}
	
	@And("user selects return airlines")
	public void selectreturnAirlines() throws InterruptedException {
		home.selectAirlineFromReturns(driver);
	}
	
	@And("user selects Layover onwards")
	public void selectLayoverOnwards() throws InterruptedException {
		home.selectLayoverOnward(driver);	}
	
	@And("user selects Layover returns")
	public void selectLayoverreturns() throws InterruptedException {
		home.selectLayoverreturns(driver);	}
	


	@Then("select the Flight and click on book")
	public void selectRefundableFlight() throws InterruptedException     {
		String tripType = testData.get(row).get(TRIPTYPE);
		String fareType = testData.get(row).get("FARE_TYPE");
		boolean searchType = Boolean.parseBoolean(testData.get(row).get("Advanced_Search"));
		home.selectFareTypeFlight(driver, fareType,searchType,tripType);
	}
	
	
	@Then("User check search result")
	public void userCheckSearchResult() throws InterruptedException {
	    home.checksearchresult(driver);
	}

	@Then("User handle the Price Change Alert Popup")
	public void userHandlePriceChangeAlertPopup(){
	    home.handelThePriceChangeAlert(driver);
	}

	@Then("user select search filter number of stops")
	public void selectNoOFStops() throws InterruptedException {
		String noOfStops = testData.get(row).get("noOfStops");
		home.selectStops(driver, noOfStops);
	}

	@Then("user select search filter fare type")
	public void selectFareType() throws InterruptedException {
		String fareType = testData.get(row).get("FARE_TYPE");
		home.selectFareType(driver, fareType);
	}

	@Then("user select marktype radio button")
	public void selectMarkUpType()   {
		boolean markType = Boolean.parseBoolean(testData.get(row).get("isMark_Down"));

		home.selectMarkType(driver, markType);
	}

	@Then("user select either percent or flat toggle")
	public void selectPercentAndEnterPercent() throws InterruptedException {
		
		boolean isPercentToggle = Boolean.parseBoolean(testData.get(row).get("isPercentage"));
		String percentage =testData.get(row).get("Percentage");

		home.selectPercentOrFlat(driver, isPercentToggle,percentage);
	}

 

	@Then("user enter flat value in text box")
	public void enterFlatValue()   {
		String flat = testData.get(row).get("FLAT");

		home.enterFlatValue(driver, flat);
	}

	@Then("user apply pricerange filters")
	public void selectPriceRangeValues() throws InterruptedException {

		home.selectDynamicPriceRange(driver);
	}

	@Then("user apply trip duration filters")
	public void applyTimeRaneFilters() throws InterruptedException {
		home.selectDynamicTimeRange(driver);
	}

	@Then("user enter local taxes")
	public void enterLocalTaxValues()   {
		String localTax = testData.get(row).get("LOCAL_TAX");
		logger.info("Local tax value is --- {}", localTax);

		home.enterLocalTaxes(localTax);
	}


	@Then("check for Fare Details total amounts calculation")
	public void checkFareDetailsTotalAmounts() throws InterruptedException {
		home.checkFareDetails(driver);
	}
	
	@And("User select the Advanced Search option")
	public void userSelectAdvancedSearchOption() throws InterruptedException {
	    home = new B2BFlightPOM(driver);
	    home.clickAdvancebooking(driver);
	}
	
	
	@Then("User select the RBD classes")
	public void userSelectRBDClasses() throws InterruptedException {
	    String rbd = testData.get(row).get("RBD");
	    String tripType = testData.get(row).get(TRIPTYPE);
	    home.selectRBDClases(driver, rbd, tripType);
	}
	

	
	
	@Then("User select the Cabin classes")
	public void userselecttheCabinclasses() throws InterruptedException 
	{
		String cLASS = testData.get(row).get(CLASS);
		String tripType = testData.get(row).get(TRIPTYPE);

		home.selectCabin(driver,cLASS,tripType);	

	}
	
	@Then("User select the Supplier name")
	public void userselecttheSuppliername() throws InterruptedException 
	{
		String supplier = testData.get(row).get("Supplier");

		home.selectSupplier(driver,supplier);	

	}
	
	@Then("User select the Depature Time")
	public void  userselecttheDepatureTime() throws InterruptedException 
	{
		String departureTime = testData.get(row).get("DepartureTime");
		String tripType = testData.get(row).get(TRIPTYPE);

		home.selectDepartureTime(driver,departureTime,tripType);	

	}
	
	
	
}

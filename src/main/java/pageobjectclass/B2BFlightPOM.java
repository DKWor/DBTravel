package pageobjectclass; // Package declaration for organizing related classes

// Importing necessary libraries
import static org.testng.Assert.assertEquals; // For asserting equality
import static org.testng.Assert.assertTrue;   // For asserting boolean conditions

import java.io.IOException; // For handling IO exceptions
import java.math.BigDecimal; // For precise decimal calculations
import java.math.RoundingMode; // For defining rounding behavior
import java.time.Duration; // For managing time durations
import java.util.HashMap; // For storing key-value pairs
import java.util.List; // For handling lists of objects
import java.util.Map; // For storing mappings of keys to values
import java.util.Random; // For generating random numbers

import org.apache.logging.log4j.LogManager; // For logging framework
import org.apache.logging.log4j.Logger; // For logger instance
import org.openqa.selenium.By; // For locating web elements
import org.openqa.selenium.JavascriptExecutor; // For executing JavaScript in the browser
import org.openqa.selenium.Keys; // For simulating keyboard keys
import org.openqa.selenium.WebDriver; // For controlling the browser
import org.openqa.selenium.WebElement; // For interacting with web elements
import org.openqa.selenium.interactions.Actions; // For simulating complex user interactions
import org.openqa.selenium.support.FindBy; // For locating elements using annotations
import org.openqa.selenium.support.PageFactory; // For creating page objects
import org.openqa.selenium.support.ui.ExpectedConditions; // For waiting for conditions
import org.openqa.selenium.support.ui.WebDriverWait; // For managing explicit waits
import org.testng.Assert; // For TestNG assertions

import baseclass.Baseclass;
import bsh.Console; // For console output (if needed)
import utils.commonMethodes; // For common utility methods

public class b2bFlightPOM { // Page Object Model class for B2B Flight functionality

	
	
    // Logger instance for logging information and errors
    private static final Logger logger = LogManager.getLogger(b2bFlightPOM.class);

    
	private static final String ONEWAY = "One-Way";
	private static final String HALFROUNDTRIP = "Half-Round-Trip";
	private static final String ROUNDWAY = "Round-Way";
	private static final String MUTICITY = "Multicity";



    // Web elements representing various fields and buttons on the flight search page
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[1]")
    private WebElement classElement; // WebElement for selecting the class of service

    
    
    @FindBy(xpath = "//div[@id='Flight_From_0']//input[@id='myTextField']")
    private WebElement originField; // WebElement for the origin input field
    
    @FindBy(xpath = "(//input[@id='myTextField'])[2]")
    private WebElement searchorigin; // WebElement for searching the origin

    @FindBy(xpath = "//div[@id='Flight_To_0']//input[@id='myTextField']")
    private WebElement destinationField; // WebElement for the destination input field
    
    @FindBy(xpath = "(//input[@id='myTextField'])[3]")
    private WebElement searchDestination; // WebElement for searching the destination

    @FindBy(xpath = "(//div[@id='flightData'])[1]")
    private WebElement originName; // WebElement for displaying the selected origin name

    @FindBy(xpath = "(//div[@id='flightData'])[1]")
    private WebElement destinationName; // WebElement for displaying the selected destination name

    @FindBy(xpath = "(//div[@class='theme2_flight_autocomplete_name__Cj0JV'])[1]")
    private WebElement internationaldestination; // WebElement for selecting international destination

    @FindBy(xpath = "//div[@class='theme4_calendar_wid_container__ooJdT' and label[contains(text(),'Departure')]]//div[@class='theme4_calendar_wid_main__BOEyJ']//input[@type='text']")
    private WebElement departureCalander; // WebElement for selecting departure date
    
    @FindBy(xpath = "(//div[@class='theme4_flight_search_column__1Xt5Y theme4_flight_search_depart_going_date__ssCDO'])[2]//div[@class='theme4_calendar_wid_main__BOEyJ']")
    private WebElement returnCalander; // WebElement for selecting return date
    
    @FindBy(xpath = "//input[@type='radio' and @value='oneWay']")
    private WebElement oneWayRadioButton; // WebElement for the one-way radio button
    
    @FindBy(xpath = "//input[@type='radio' and @value='roundTrip']")
    private WebElement roundTrip; // WebElement for the round trip radio button
    
    @FindBy(xpath = "//input[@value='Multicity']")
    private WebElement multicity; // WebElement for the multicity option

    @FindBy(xpath = "//div[@class='theme4_calendar_head_right_side__o16VX']//span[@class='theme4_calendar_head_icon__Y4clh']//*[name()='svg']")
    private WebElement nextMonthLable; // WebElement for the button to navigate to the next month in the calendar

    @FindBy(xpath = "(//span[contains(text(),'26')])[1]")
    private WebElement selectDate; // WebElement for selecting a specific date

    @FindBy(xpath = "(//span[normalize-space()='30'])[1]")
    private WebElement selectRetunDate; // WebElement for selecting return date

    @FindBy(xpath = "(//*[name()='svg'][@class='h-5 w-5'])[1]")
    private WebElement navigateoncalender; // WebElement for navigating on the calendar

    @FindBy(xpath = "//button[normalize-space()='Done']")
    private WebElement apply; // WebElement for applying the selected date

    @FindBy(xpath = "//label[normalize-space()='Premium Economy']")
    private WebElement premiumEconomy; // WebElement for selecting premium economy class
    
    @FindBy(xpath = "//label[normalize-space()='First Class']")
    private WebElement firstClass; // WebElement for selecting first class
    
    @FindBy(xpath = "//label[normalize-space()='Business']")
    private WebElement businessClass; // WebElement for selecting business class
    
    @FindBy(xpath = "//label[normalize-space()='Economy']")
    private WebElement economy; // WebElement for selecting economy class

    @FindBy(xpath = "(//div[normalize-space()='First Class'])[2]")
    private WebElement firstClass1; // WebElement for selecting first class in a different section
    
    @FindBy(xpath = "(//div[normalize-space()='Business'])[2]")
    private WebElement businessClass1; // WebElement for selecting business class in a different section
    
    @FindBy(xpath = "//div[contains(@class,'theme4_flight_trav_title__h1a56')]")
    private WebElement passanger; // WebElement for passenger details
    
    @FindBy(xpath = "(//*[name()='svg'][@id='plus'])[1]")
    private WebElement adults; // WebElement for increasing the number of adults
    
    @FindBy(xpath = "(//*[name()='svg'][@id='plus'])[2]")
    private WebElement child; // WebElement for increasing the number of children
    
    @FindBy(xpath = "(//*[name()='svg'][@id='plus'])[3]")
    private WebElement infent; // WebElement for increasing the number of infants
    
    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement flightSearch; // WebElement for initiating the flight search
    
    @FindBy(xpath = "//label[normalize-space()='One Way']")
    private WebElement selectOneWay; // WebElement for selecting one-way flight
    
    @FindBy(xpath = "//label[normalize-space()='Round Trip']")
    private WebElement selectRoundWay; // WebElement for selecting round-trip flight
    
    @FindBy(css = "div[class='theme5_flt_pasngrFlx__KkydQ'] div[class='theme5_flt_trav_label__kc5Sd']")
    private WebElement validateClass; // WebElement for validating the selected class
    
    @FindBy(xpath = "//div[@class='infinite-scroll-component ']//div[1]//div[1]//div[2]//div[1]//div[1]//div[2]//button[1]")
    private WebElement book; // WebElement for booking the flight

    @FindBy(xpath = "//div[@class='theme4_fare_detail_box__9WckK']")
    private WebElement fareDetailsSection; // WebElement for fare details section

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/span[1]")
    private WebElement stopes; // WebElement for displaying the number of stops

    @FindBy(name = "Continue Booking")
    private WebElement continuBook; // WebElement for continuing the booking process

    @FindBy(xpath = "(//a[normalize-space()='Flight Search'])[1]")
    private WebElement flighSearch; // WebElement for navigating to flight search

    @FindBy(xpath = "//input[@id='markup']")
    private WebElement markUpRadio; // WebElement for markup option

    @FindBy(xpath = "//input[@id='markdown']")
    private WebElement markDownRadio; // WebElement for markdown option

    @FindBy(xpath = "//p[text()='Local Taxes (if applicable)']")
    private WebElement localTaxTextLocator; // WebElement for local taxes text

    @FindBy(xpath = "//div[@class='theme4_flight_base_ticket_price__OWEX3']//input[@placeholder='Enter Amount']")
    private WebElement localTaxLocator; // WebElement for entering local tax amount

    @FindBy(xpath = "//input[@value='Multicity']")
    private WebElement selectmulticity; // WebElement for selecting multicity option

    @FindBy(xpath = "//span[contains(text(),'Flights')]")
    private WebElement clickFlight; // WebElement for clicking on the flights tab

    @FindBy(xpath="//div[@class='MuiBox-root jss1']//span[3]")
    private WebElement dragStart; // WebElement for starting point of a drag operation

    @FindBy(xpath="//div[@class='MuiBox-root jss1']//span[4]")
    private WebElement dragEnd; // WebElement for end point of a drag operation
    
    
 // Web element representing the advance search button with an image icon
    @FindBy(xpath="//button[@id='advanceSearchButton']//img") 
    private WebElement advanceSearchButton;

    // Web element representing the dropdown for RBD (Revenue Booking Designator) classes, usually used for selecting flight classes
    @FindBy(xpath="//div[@class='theme4_icon_Rbd_advInputnw__UB2ho']//span[@class='theme4_dropdown_Flx__4d_Xw']//span//*[name()='svg']")
    private WebElement rbdClasses;

    // Web element for displaying the error message related to RBD classes for return flights
    @FindBy(xpath="//div[@id='rbdCabinErrMsg1']//span[@class='theme4_dropdown_Flx__4d_Xw']")
    private WebElement retunRBDClasses;

    // Web element for the cabin selection icon, typically indicates the type of cabin class (e.g., economy, business)
    @FindBy(xpath="//div[@class='theme4_flight_cabin_arrowMn__7tLFb']//*[name()='svg']")
    private WebElement cabin;

    // Web element representing the selected cabin details for the return flight
    @FindBy(xpath="//div[@id='Flight_cabin_1']//div[@class='theme4_cabin_cont_flx__BtMbR']")
    private WebElement retunCabin;   
    
 // Web element for the input field where the user can select a supplier
    @FindBy(xpath="//input[@placeholder='Select Supplier']")
    private WebElement supplier;

    // Web element representing the dropdown for selecting the departure time
    @FindBy(xpath="//div[@class='theme4_dropdown_container__BqGlp']//div//span[@class='theme4_dropdown_Flx__4d_Xw']")
    private WebElement departureTime;

    // Web element representing the dropdown for selecting the return departure time (for round trips)
    @FindBy(xpath="(//span[@class='theme4_dropdown_Flx__4d_Xw'])[5]")
    private WebElement returnDepartureTime;
    
 // Web element representing the starting point of the trip duration filter
    @FindBy(xpath="//div[@class='theme4_filter_trip_duration__gkOGQ']//span[3]")
    private WebElement durationStart;

    // Web element representing the ending point of the trip duration filter
    @FindBy(xpath="//div[@class='theme4_filter_trip_duration__gkOGQ']//span[4]")
    private WebElement durationEnd;




 // XPath constants for locating input fields
    private static final String ORIGIN_INPUT_XPATH = "//div[@id='Flight_From_0']//input[@id='myTextField']";
    private static final String DESTINATION_INPUT_XPATH = "//div[@id='Flight_To_0']//input[@id='myTextField']";
   
    
    
    // Web element for displaying the flight duration
    @FindBy(xpath = "//div[@class='theme4_filter_trip_duration__gkOGQ']//span[3]")
    private WebElement duration;

    // Constructor that initializes the web elements using PageFactory
    public b2bFlightPOM(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Method to click on the flight module and wait for the next element to be visible
    public void clickFlightModule() throws InterruptedException{
        clickFlight.click(); // Clicks the flight module
        Thread.sleep(2000); // Pause to allow for suggestions to load

        
    }

    // Method to select the city based on the type of trip (Round-Way, One-Way, Multicity)
    public void selectthecity(WebDriver driver, String way, String origin, String destination) throws InterruptedException {
        // Check if the trip is of type Round-Way, Half-Round-Trip, or One-Way
        if (way.equalsIgnoreCase(ROUNDWAY) || way.equalsIgnoreCase(HALFROUNDTRIP) || way.equalsIgnoreCase(ONEWAY)) {
            handleTripSelection(driver, way, origin, destination); // Handle selection for the trip
        } else if (way.equalsIgnoreCase(MUTICITY)) {
            handleMulticitySelection(driver, origin, destination); // Handle selection for multicity trips
        }
    }

    // Private method to handle the selection of round-trip or one-way trips
    private void handleTripSelection(WebDriver driver, String way, String origin, String destination) {
        // Click the round-trip radio button if applicable
        if (way.equalsIgnoreCase(ROUNDWAY) || way.equalsIgnoreCase(HALFROUNDTRIP)) {
            roundTrip.click();
        }
        // Wait for the origin input field to be visible and send the origin city
        waitForElement(driver, By.xpath(ORIGIN_INPUT_XPATH), 2);
        sendKeysWithAutoSuggest(driver, ORIGIN_INPUT_XPATH, origin); // Handle auto-suggest for the origin
        
        // Wait for the destination input field to be visible and send the destination city
        waitForElement(driver, By.xpath(DESTINATION_INPUT_XPATH), 2);
        sendKeysWithAutoSuggest(driver, DESTINATION_INPUT_XPATH, destination); // Handle auto-suggest for the destination
    }

    // Private method to handle multicity trip selection
    private void handleMulticitySelection(WebDriver driver, String origin, String destination) {
        multicity.click(); // Click the multicity radio button
        waitForElement(driver, By.xpath(ORIGIN_INPUT_XPATH), 2); // Wait for the origin field
        sendKeysWithAutoSuggest(driver, ORIGIN_INPUT_XPATH, origin); // Handle auto-suggest for the origin
        
        // Example hardcoded value for the middle city; replace with a variable if needed
        sendKeysWithAutoSuggest(driver, DESTINATION_INPUT_XPATH, "MCT"); // Send hardcoded value for middle city
        
        // Wait for the destination input field to be visible and send the destination city
        waitForElement(driver, By.xpath(DESTINATION_INPUT_XPATH), 2);
        sendKeysWithAutoSuggest(driver, DESTINATION_INPUT_XPATH, destination); // Handle auto-suggest for the destination
    }

    // Private method to send keys to an input field with auto-suggest functionality
    private void sendKeysWithAutoSuggest(WebDriver driver, String xpath, String input) {
        try {
            // Locate the element again just before sending keys to avoid stale reference
            WebElement element = driver.findElement(By.xpath(xpath));
            element.sendKeys(input); // Send the input value to the field
            Thread.sleep(1000); // Pause to allow for suggestions to load
            commonMethodes.Autosuggest(driver, input); // Trigger the auto-suggest method
        } catch (Exception e) {
            // Log any exceptions encountered during interaction
        	logger.error("Error while sending keys to {}", xpath, e);        }
    }

    // Private method to wait for an element to become visible
    private void waitForElement(WebDriver driver, By locator, int seconds) {
        // Create a WebDriverWait instance with a specified timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); // Wait until the element is visible
    }
    
 // Method to select travel dates based on the type of trip (one-way, round-way, or multicity)
    public void selectDatefortrip(WebDriver driver, String way, String month, String rmonth, String departureDate,
            String returnDate, boolean searchType) throws InterruptedException {

        // Create a Random object to generate random dates
        Random random = new Random();

        // Define ranges for random date selection
        int min = 1; // Minimum day for the first half of the month
        int max = 15; // Maximum day for the first half of the month
        int min1 = 16; // Minimum day for the second half of the month
        int max1 = 30; // Maximum day for the second half of the month

        // Generate a random departure date in the range of 1-15
        int randomNumberInRange = random.nextInt(max - min) + min;
        // Generate a random return date in the range of 16-30
        int randomNumberInRange1 = random.nextInt(max1 - min1) + min1;

        // Convert random numbers to strings for use in date selection
        String strNumber = String.valueOf(randomNumberInRange);
        String strNumber1 = String.valueOf(randomNumberInRange1);

        // Log the current journey type for debugging purposes
        logger.info("Current Journey is --- {}", way);

        // Check the search type to determine how to proceed with date selection
        if (searchType) {
            // Handle selection for round-trip, half-round-trip, or multicity
            if (way.equalsIgnoreCase(ROUNDWAY) || way.equalsIgnoreCase(HALFROUNDTRIP) || way.equalsIgnoreCase(MUTICITY)) {
                // Wait for the departure calendar to be visible before selecting a date
                commonMethodes.waitForElementToBeVisible(driver, departureCalander, 1);
                Thread.sleep(1000); // Allow time for the calendar to load
                
                // Select the departure date based on the randomly generated day
                selectDate(driver, month, strNumber, way);
                Thread.sleep(1000); // Wait after selecting the departure date
                
                // Wait for the return calendar to be visible
                commonMethodes.waitForElementToBeVisible(driver, returnCalander, 3);
                Thread.sleep(500); // Allow time for the calendar to load
                commonMethodes.scrollDown1(driver); // Scroll down if necessary
                Thread.sleep(500); // Wait for scrolling to complete
                
                // Select the return date based on the randomly generated day
                selectDate(driver, rmonth, strNumber1, way);
            } else { // Handle one-way trips
                // Wait for the departure calendar to be visible before selecting a date
                commonMethodes.waitForElementToBeVisible(driver, departureCalander, 1);
                Thread.sleep(1000); // Allow time for the calendar to load
                
                // Select the departure date based on the randomly generated day
                selectDate(driver, month, strNumber, way);
                Thread.sleep(1000); // Wait after selecting the departure date
            }

        } else if (way.equalsIgnoreCase(ROUNDWAY) || way.equalsIgnoreCase(HALFROUNDTRIP) || way.equalsIgnoreCase(MUTICITY)) {
            // If not searching by type, still handle selection for round-trip, half-round-trip, or multicity
            commonMethodes.waitForElementToBeVisible(driver, departureCalander, 1);
            Thread.sleep(1000); // Allow time for the calendar to load
            
            // Select the departure date based on the randomly generated day
            selectDate(driver, month, strNumber, way);
            Thread.sleep(1000); // Wait after selecting the departure date

            // Wait for the return calendar to be visible and select the return date
            commonMethodes.waitForElementToBeVisible(driver, returnCalander, 3);
            selectDate(driver, rmonth, strNumber1, way); // Select the return date
        } else {
            // Handle one-way trips again if none of the previous conditions were met
            commonMethodes.waitForElementToBeVisible(driver, departureCalander, 1);
            Thread.sleep(1000); // Allow time for the calendar to load
            
            // Select the departure date based on the randomly generated day
            selectDate(driver, month, strNumber, way);
            Thread.sleep(1000); // Wait after selecting the departure date
        }

        // Final pause to ensure all actions have completed
        Thread.sleep(1000);
    }


 // Method to get the index of a matching month element in a list of WebElements
    public static int getIndexOfMatchingElement(List<WebElement> elements, String month) {
        // Iterate through the list of elements to find a match
        for (int i = 0; i < elements.size(); i++) {
            // Check if the text of the current element matches the month (case-insensitive)
            if (elements.get(i).getText().equalsIgnoreCase(month)) {
                return i; // Return the index if a match is found
            }
        }
        return -1; // Return -1 if no matching element is found
    }

    // Method to select a date from a calendar based on the trip type and desired date
    private void selectDate(WebDriver driver, String month, String date, String way) throws InterruptedException {
        logger.info("Trip type is " + way); // Log the trip type

        int index; // Variable to store the index of the matching month
        while (true) {
            logger.info("Checking while loop"); // Log entry into the loop
            // Get the currently displayed month and year from the calendar
            String text = driver.findElement(By.xpath("//h3")).getText();
            logger.info("While current month is " + text); // Log the current month being checked

            // Locate the month/year labels in the calendar header
            List<WebElement> monthYearLabels = driver
                    .findElements(By.xpath("//div[@class='theme4_calendar_head_center_side__4_Yqx']//h3"));

            // Check if the desired month is found in the displayed labels
            boolean isMonthFound = monthYearLabels.stream().anyMatch(ele -> ele.getText().equalsIgnoreCase(month));

            logger.info("While given input month is " + month); // Log the input month
            logger.info("isMonthFound status is " + isMonthFound); // Log the status of month found

            // Get the index of the matching month using the helper method
            index = getIndexOfMatchingElement(monthYearLabels, month);
            logger.info("Index value is " + index); // Log the index value

            if (isMonthFound) {
                break; // Exit the loop if the month is found
            } else {
                // If the month is not found, click the next button to move forward in the calendar
                logger.info(driver.findElements(By.xpath(
                        "//div[@class='theme4_calendar_head_right_side__o16VX']//span[@class='theme4_calendar_head_icon__Y4clh']//*[name()='svg']"))
                        .size()); // Log the number of next buttons found
                commonMethodes.waitForElementToBeVisible(driver, nextMonthLable, 3); // Wait for the next month label to be visible
            }
        }

        // After finding the correct month, select the date based on the index
        if (index == 0) { // If the desired month is in the first calendar view
            // Locate all available dates in the left-side calendar
            List<WebElement> leftSideDates = driver.findElements(By.xpath(
                    "//div[@class='theme4_calendar_whole_body__ZTJsd'][1]//div[@class='theme4_calendar_day_list__MByr8'][1]//div[@class='theme4_day_cell_center__bpS9l' or 'theme4_day_cell_center__bpS9l theme4_selected_calendar_date__z_ZjS']//span[@class='']"));
            logger.info("User given date is option 1: " + date); // Log the user’s desired date

            // Stream through the list to find the desired date and click it if found
            leftSideDates.stream().filter(ele -> ele.getText().contentEquals(date)).findFirst().ifPresent(element -> {
                // Scroll to the date element to bring it into view
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30)); // Create a wait for element to be clickable
                wait1.until(ExpectedConditions.elementToBeClickable(element)); // Wait until the element is clickable
                element.click(); // Click on the date element
            });

        } else { // If the desired month is in the second calendar view
            // Locate all available dates in the right-side calendar
            List<WebElement> rightSideDates = driver.findElements(By.xpath(
                    "//div[@class='theme4_calendar_whole_body__ZTJsd'][2]//div[@class='theme4_calendar_day_list__MByr8'][1]//div[@class='theme4_day_cell_center__bpS9l' or 'theme4_day_cell_center__bpS9l theme4_selected_calendar_date__z_ZjS']//span[@class='']"));
            logger.info("User given date is option 2: " + date); // Log the user’s desired date

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Create a wait for up to 30 seconds

            // Stream through the list to find the desired date and click it if found
            rightSideDates.stream().filter(ele -> ele.getText().contentEquals(date)).findFirst().ifPresent(element -> {
                // Scroll to the date element to bring it into view
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30)); // Create another wait for element to be clickable
                wait2.until(ExpectedConditions.elementToBeClickable(element)); // Wait until the element is clickable
                element.click(); // Click on the date element
            });
        }
    }

 // Method to select a travel class based on user input
    public void selectClassforTrip(WebDriver driver, String way, String Classess) throws InterruptedException {

        // Check if the selected class is "Economy"
        if (Classess.equalsIgnoreCase("Economy")) {
            logger.info("The selected Class is :" + economy.getText()); // Log the selected class
            WebElement element1 = economy; // Reference to the Economy class element
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1); // Click on the Economy class element
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", apply); // Click on the apply button

        // Check if the selected class is "Business"
        } else if (Classess.equalsIgnoreCase("Business")) {
            logger.info("The selected Class is :" + businessClass.getText()); // Log the selected class
            WebElement element1 = businessClass; // Reference to the Business class element
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1); // Click on the Business class element
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", apply); // Click on the apply button

        // Check if the selected class is "First Class"
        } else if (Classess.equalsIgnoreCase("First Class")) {
            logger.info("The selected Class is :" + firstClass.getText()); // Log the selected class
            WebElement element1 = firstClass; // Reference to the First Class element
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1); // Click on the First Class element
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", apply); // Click on the apply button

        // Check if the selected class is "Premium Economy"
        } else if (Classess.equalsIgnoreCase("Premium Economy")) {
            logger.info("The selected Class is :" + premiumEconomy.getText()); // Log the selected class
            WebElement element1 = premiumEconomy; // Reference to the Premium Economy element
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1); // Click on the Premium Economy element
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", apply); // Click on the apply button
        }
    }

    // Method to select a travel class and validate the selection based on the trip type
    public void selectClassforTripandValidaetheclass(WebDriver driver, String way, String Classess) throws InterruptedException {

        // Check if the trip type is ROUNDWAY
        if (way.contentEquals(ROUNDWAY)) {
            // Handle class selection for Round-Way trips
            if (Classess.equalsIgnoreCase("Economy")) {
                commonMethodes.waitForElementToBeVisible(driver, apply, 2); // Wait for the apply button to be visible
                logger.info("We select Economy class"); // Log the selected class

            // Check if the selected class is "Business"
            } else if (Classess.equalsIgnoreCase("Business")) {
                businessClass.click(); // Click on the Business class option
                commonMethodes.waitForElementToBeVisible(driver, apply, 2); // Wait for the apply button to be visible
                logger.info("The selected Class is :" + businessClass); // Log the selected class

            // Check if the selected class is "First Class"
            } else if (Classess.equalsIgnoreCase("First Class")) {
                firstClass.click(); // Click on the First Class option
                commonMethodes.waitForElementToBeVisible(driver, apply, 2); // Wait for the apply button to be visible
                logger.info("The selected Class is :" + firstClass); // Log the selected class

            // Check if the selected class is "Premium Economy"
            } else if (Classess.equalsIgnoreCase("Premium Economy")) {
                premiumEconomy.click(); // Click on the Premium Economy option
                commonMethodes.waitForElementToBeVisible(driver, apply, 2); // Wait for the apply button to be visible
                logger.info("The selected Class is :" + premiumEconomy); // Log the selected class
            }
        } else if (way.equals(ONEWAY)) { // Handle class selection for One-Way trips
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)", ""); // Scroll down the page
            // Check if the selected class is "Economy"
            if (Classess.equalsIgnoreCase("Economy")) {
                commonMethodes.waitForElementToBeVisible(driver, apply, 2); // Wait for the apply button to be visible
                logger.info("We select Economy class"); // Log the selected class

                flightSearch.click(); // Click on the flight search button
                Thread.sleep(4000); // Wait for 4 seconds

                String text = classElement.getText(); // Get the text of the class element
                Assert.assertEquals(text, "Economy"); // Validate that the selected class is Economy

            // Check if the selected class is "Business"
            } else if (Classess.equalsIgnoreCase("Business")) {
                businessClass.click(); // Click on the Business class option
                commonMethodes.waitForElementToBeVisible(driver, apply, 2); // Wait for the apply button to be visible
                flightSearch.click(); // Click on the flight search button

                Thread.sleep(4000); // Wait for 4 seconds

                logger.info("The selected Class is :" + businessClass); // Log the selected class
                String text = classElement.getText(); // Get the text of the class element
                Assert.assertEquals(text, "Business"); // Validate that the selected class is Business

            // Check if the selected class is "First Class"
            } else if (Classess.equalsIgnoreCase("First Class")) {
                firstClass.click(); // Click on the First Class option
                commonMethodes.waitForElementToBeVisible(driver, apply, 2); // Wait for the apply button to be visible
                flightSearch.click(); // Click on the flight search button

                Thread.sleep(4000); // Wait for 4 seconds

                logger.info("The selected Class is :" + firstClass); // Log the selected class
                String text = classElement.getText(); // Get the text of the class element
                Assert.assertEquals(text, "First Class"); // Validate that the selected class is First Class

            // Check if the selected class is "Premium Economy"
            } else if (Classess.equalsIgnoreCase("Premium Economy")) {
                premiumEconomy.click(); // Click on the Premium Economy option
                commonMethodes.waitForElementToBeVisible(driver, apply, 2); // Wait for the apply button to be visible
                flightSearch.click(); // Click on the flight search button

                Thread.sleep(4000); // Wait for 4 seconds
                logger.info("The selected Class is :" + premiumEconomy); // Log the selected class
                String text = classElement.getText(); // Get the text of the class element
                Assert.assertEquals(text, "Premium Economy"); // Validate that the selected class is Premium Economy
            }
        }
    }

 // Method to select the number of passengers for the trip based on input strings
    public void Selectpassangerfortrip(WebDriver driver, String AdultString, String childString, String InfentString)
            throws InterruptedException {

        // Scroll down to ensure passenger selection elements are visible
        commonMethodes.scrollDown2(driver);
        Thread.sleep(500); // Wait for a short period to allow scrolling to finish
        commonMethodes.waitForElementToBeVisible(driver, passanger, 2); // Wait for the passenger element to be visible

        // Convert input strings for the number of adults, children, and infants into integers
        Integer adult = Integer.valueOf(AdultString); // Number of adults
        Integer Child = Integer.valueOf(childString); // Number of children
        Integer Infent = Integer.valueOf(InfentString); // Number of infants
        Thread.sleep(500); // Allow time for UI to respond

        // Loop to select the specified number of adult passengers
        for (int i = 1; i < adult; i++) {
            commonMethodes.waitForElementToBeVisible(driver, adults, 10); // Wait for adult selection element to be visible
        }
        Thread.sleep(500); // Allow time for UI updates

        // Loop to select the specified number of child passengers
        for (int i = 0; i < Child; i++) {
            commonMethodes.waitForElementToBeVisible(driver, child, 10); // Wait for child selection element to be visible
        }
        Thread.sleep(500); // Allow time for UI updates

        // Loop to select the specified number of infant passengers
        for (int i = 0; i < Infent; i++) {
            commonMethodes.waitForElementToBeVisible(driver, infent, 10); // Wait for infant selection element to be visible
        }
        Thread.sleep(1000); // Allow time for UI updates
    }

    // Method to click the search button to find flights
    public void click_Search(WebDriver driver, String way) throws InterruptedException {
        flightSearch.click(); // Click on the flight search button
    }

    // Method to select the departure time from the available options
    public void selectDepartureTimeFrom(WebDriver driver) throws InterruptedException {

        // Create an explicit wait to wait for the popup containing departure options
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Airlines']")));
        
        // Locate the departure time element within the popup
        WebElement elemnet = popup.findElement(By.xpath("(//div[@id='onwardDetails-departure'])[1]"));
        Thread.sleep(500); // Allow time for the element to be fully loaded

        // Scroll to the departure time element and click it
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elemnet);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elemnet);
    }

    // Method to select an airline from the available options for the onward journey
    public void selectAirlineFromOnwards(WebDriver driver) throws InterruptedException {
        
        // Create an explicit wait to wait for the popup containing airline options
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Airlines']")));
        
        // Locate the first airline checkbox within the popup
        WebElement elemnet = popup.findElement(By.xpath("((//div[@class='theme4_airline_inner__s_mmh'])[1]//label[@class='theme4_checkbox_common__tRblA'])[1]"));
        Thread.sleep(500); // Allow time for the element to be fully loaded

        // Scroll to the airline checkbox element and click it
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elemnet);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elemnet);
    }

 // Method to select an airline for the return journey
    public void selectAirlineFromReturns(WebDriver driver) throws InterruptedException {
        
        // Create an explicit wait to wait for the airlines popup to become visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        // Locate the popup containing airline options
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Airlines']")));
        
        // Find the first airline checkbox in the return section of the popup
        WebElement elemnet = popup.findElement(By.xpath("((//div[@class='theme4_airline_inner__s_mmh'])[2]//label[@class='theme4_checkbox_common__tRblA'])[1]"));
        Thread.sleep(500); // Wait briefly to ensure the UI is responsive
        
        // Scroll to the airline checkbox element and click it
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elemnet);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elemnet);
    }

    // Method to select the layover option for the onward journey
    public void selectLayoverOnward(WebDriver driver) throws InterruptedException {
        
        // Create an explicit wait for the airlines popup to become visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        // Locate the popup containing airline options
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Airlines']")));
        
        // Find the first layover checkbox in the onward section of the popup
        WebElement elemnet = popup.findElement(By.xpath("(//div[@class='theme4_airport_inner__H4y1H'])[1]//label[@class='theme4_checkbox_common__tRblA'][1]"));
        Thread.sleep(500); // Wait briefly to ensure the UI is responsive
        
        // Scroll to the layover checkbox element and click it
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elemnet);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elemnet);
    }

    // Method to select the layover option for the return journey
    public void selectLayoverreturns(WebDriver driver) throws InterruptedException {
        
        // Create an explicit wait for the airlines popup to become visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        // Locate the popup containing airline options
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Airlines']")));
        
        // Find the first layover checkbox in the return section of the popup
        WebElement elemnet = popup.findElement(By.xpath("(//div[@class='theme4_airport_inner__H4y1H'])[2]//label[@class='theme4_checkbox_common__tRblA'][1]"));
        Thread.sleep(500); // Wait briefly to ensure the UI is responsive
        
        // Scroll to the layover checkbox element and click it
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elemnet);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elemnet);
    }

    // Method to click the book button for the selected flight
    public void clickBook(WebDriver driver, String way, String Flight) throws InterruptedException {
        // Click the book button using JavaScript to ensure it works with dynamically loaded elements
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", book);
        Thread.sleep(5000); // Wait for 5 seconds to allow the booking process to initialize
    }

    // Method to click the advance booking button
    public void clickAdvancebooking(WebDriver driver) throws InterruptedException {
        
        // Create an explicit wait for the advance search button to become visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // Locate the advance search button popup
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='advanceSearchButton']//img")));
        
        // Click the advance search button using JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", advanceSearchButton);
        Thread.sleep(1000); // Wait briefly to ensure the UI is responsive
    }

	
	
	
 // Method to select RBD classes based on the type of trip (One-Way or Round-Way)
    
    public void SelectRBDClases(WebDriver driver, String RBD, String way) throws InterruptedException {
    	
        // Check if the trip type is One-Way
    	
        if (way.contains(ONEWAY)) {
            // Click on the RBD classes dropdown
            rbdClasses.click();
            Thread.sleep(500); // Wait for the dropdown to become responsive
            logger.info("The Current RBD is: " + RBD);
            
            // Set up an explicit wait for the popup containing RBD options
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));   
            WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name-input']")));
            
            // Find all checkboxes and RBD names
            List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
            List<WebElement> RBDName = driver.findElements(By.xpath("//span[@class='theme4_advTitle__GzPon']"));
            
            // Check if there are any RBD names available
            if (RBDName.size() > 0) {
                // Iterate through the RBD names to find a match
                for (int i = 0; i < RBDName.size(); i++) {
                    WebElement searchText = RBDName.get(i);
                    String current_dt = searchText.getText();
                    // If the current RBD matches the input, click the corresponding checkbox
                    if (current_dt.equalsIgnoreCase(RBD)) {
                        checkbox.get(i).click();
                        rbdClasses.click(); // Close the dropdown
                        break; // Exit loop once the desired RBD is selected
                    }
                }
            } else {
                logger.info("The Current RBD is not available");
            }
        } 
        // Check if the trip type is Round-Way, Half-Round-Trip, or Multicity
        else if (way.contains(ROUNDWAY) || way.contains(HALFROUNDTRIP) || way.contains(MUTICITY)) {
            rbdClasses.click();
            Thread.sleep(500);
            logger.info("The Current RBD is: " + RBD);
            
            // Set up an explicit wait for the popup containing RBD options
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));   
            WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name-input']")));
            
            // Find all checkboxes and RBD names
            List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
            List<WebElement> RBDName = driver.findElements(By.xpath("//span[@class='theme4_advTitle__GzPon']"));
            
            // Check if there are any RBD names available
            if (RBDName.size() > 0) {
                // Iterate through the RBD names to find a match
                for (int i = 0; i < RBDName.size(); i++) {
                    WebElement searchText = RBDName.get(i);
                    String current_dt = searchText.getText();
                    // If the current RBD matches the input, click the corresponding checkbox
                    if (current_dt.equalsIgnoreCase(RBD)) {
                        checkbox.get(i).click();
                        rbdClasses.click(); // Close the dropdown
                        break; // Exit loop once the desired RBD is selected
                    }
                }
            } else {
                logger.info("The Current RBD is not available");
            }

            Thread.sleep(1000); // Allow some time for UI to settle

            // Click on the return RBD classes dropdown
            retunRBDClasses.click();
            Thread.sleep(500);
            logger.info("The Current RBD is: " + RBD);
            
            // Find all checkboxes and RBD names for the return trip
            List<WebElement> checkbox1 = driver.findElements(By.xpath("//input[@type='checkbox']"));
            List<WebElement> RBDName1 = driver.findElements(By.xpath("//span[@class='theme4_advTitle__GzPon']"));

            // Check if there are any RBD names available for return trip
            if (RBDName1.size() > 0) {
                // Iterate through the RBD names to find a match for return trip
                for (int i = 0; i < RBDName1.size(); i++) {
                    WebElement searchText = RBDName1.get(i);
                    String current_dt = searchText.getText();
                    // If the current RBD is 'D', click the corresponding checkbox
                    if (current_dt.equalsIgnoreCase("D")) {
                        checkbox1.get(i).click();
                        rbdClasses.click(); // Close the dropdown
                        break; // Exit loop once the desired RBD is selected
                    }
                }
            } else {
                logger.info("The Current RBD is not available");
            }
        }

        Thread.sleep(1000); // Allow some time for UI to settle
    }

    
    
    
    
    // Method to select cabin class based on trip type
    
    public void SelectCabin(WebDriver driver, String Cabinclass, String way) throws InterruptedException {
        // Check if the trip type is One-Way
        if (way.contains(ONEWAY)) {
            cabin.click(); // Click on the cabin class dropdown
            Thread.sleep(500);
            
            logger.info("The current Cabin class is: " + Cabinclass);
            
            // Find all radio buttons for cabin classes
            List<WebElement> rediobutton = driver.findElements(By.xpath("//div[@class='theme4_flight_cabin_class_list__tLDeD']//input[@type='radio']"));
            List<WebElement> cabinclasses = driver.findElements(By.xpath("//label[@class='theme4_flight_cabin_class_ele__hsTDk theme4_CabinLabel__9y5cf']"));

            // Check if there are any cabin classes available
            if (cabinclasses.size() > 0) {
                // Iterate through the cabin classes to find a match
                for (int i = 0; i < cabinclasses.size(); i++) {
                    WebElement searchText = cabinclasses.get(i);
                    String current_dt = searchText.getText();
                    // If the current cabin class matches the input, click it
                    if (current_dt.equalsIgnoreCase(Cabinclass)) {
                        cabinclasses.get(i).click();
                        break; // Exit loop once the desired cabin class is selected
                    }
                }
            } else {
                logger.info("The Current cabin is not available");
            }
        }
        // Check if the trip type is Round-Way, Half-Round-Trip, or Multicity
        else if (way.contains(ROUNDWAY) || way.contains(HALFROUNDTRIP) || way.contains(MUTICITY)) {
            cabin.click(); // Click on the cabin class dropdown
            Thread.sleep(500);
            
            logger.info("The current Cabin class is: " + Cabinclass);
            
            // Find all cabin classes
            List<WebElement> cabinclasses = driver.findElements(By.xpath("//div[@class='theme4_flight_cabin_class_list__tLDeD']//label[@class='theme4_flight_cabin_class_ele__hsTDk theme4_CabinLabel__9y5cf']"));

            // Check if there are any cabin classes available
            if (cabinclasses.size() > 0) {
                // Iterate through the cabin classes to find a match
                for (int i = 0; i < cabinclasses.size(); i++) {
                    WebElement searchText = cabinclasses.get(i);
                    String current_dt = searchText.getText();
                    // If the current cabin class matches the input, click it
                    if (current_dt.equalsIgnoreCase(Cabinclass)) {
                        cabinclasses.get(i).click();
                        break; // Exit loop once the desired cabin class is selected
                    }
                }
            } else {
                logger.info("The Current cabin is not available");
            }

            Thread.sleep(2000); // Allow some time for UI to settle
            
            // Click on the return cabin class dropdown
            retunCabin.click();
            Thread.sleep(500);
            logger.info("The Current Cabin is: " + Cabinclass);
            Thread.sleep(500);
            
            // Find all cabin classes for the return trip
            List<WebElement> cabinclasses1 = driver.findElements(By.xpath("//div[@class='theme4_flight_cabin_class_list__tLDeD']//label[@class='theme4_flight_cabin_class_ele__hsTDk theme4_CabinLabel__9y5cf']"));

            // Check if there are any cabin classes available for return trip
            if (cabinclasses1.size() > 0) {
                // Iterate through the cabin classes to find a match for return trip
                for (int i = 0; i < cabinclasses1.size(); i++) {
                    WebElement searchText = cabinclasses1.get(i);
                    String current_dt = searchText.getText();
                    // If the current cabin class matches the input, click it
                    if (current_dt.equalsIgnoreCase(Cabinclass)) {
                        cabinclasses1.get(i).click();
                        break; // Exit loop once the desired cabin class is selected
                    }
                }
            } else {
                logger.info("The Current cabin is not available");
            }
        }
        
        Thread.sleep(1000); // Allow some time for UI to settle
    }

	
	
	public void SelectSupplier(WebDriver driver,String Suppliers) throws InterruptedException {
		
		
		
		supplier.click();
		Thread.sleep(500);
		logger.info("The Currrant Supplier is :"+Suppliers);
        
        commonMethodes.scrollDown1(driver);
			   	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));   	 
			   	 WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name-input']")));
			   	 		
					//All Checkbookes
					List<WebElement> checkbox = driver.findElements(By.xpath("//div[@class='multiSelectDropDown_dropdown_container__eVuyi']//input[@type='checkbox']"));

					// All RBD Names
					List<WebElement> Suppliername= driver.findElements(By.xpath("//span[@class='multiSelectDropDown_advTitle__Wk02T']"));

					
					
					if (Suppliername.size() > 0) {
						// Iterate through the list and find the matching fare type
						for (int i = 0; i < Suppliername.size(); i++) {
							WebElement searchText = Suppliername.get(i);
							String current_dt = searchText.getText();
							logger.info("The Suppliesr check :"+current_dt);
							if (current_dt.equalsIgnoreCase(Suppliers)) {
								Suppliername.get(i).click();
								commonMethodes.scrollDown1(driver);
								supplier.click();
								break;
							}
						}
					} else {
						logger.info("The Current Supplier is not available");
					}
					
			     
		Thread.sleep(1000);
	}
	
	
public void SelectDepartureTime(WebDriver driver,String Departure,String way) throws InterruptedException {
	
		
	if(way.contains(ONEWAY))
	{		
	departureTime.click();
	Thread.sleep(500);
	logger.info("The Currrant Departure Time is :"+Departure);
	// All RBD Names
	List<WebElement> AllDeparture= driver.findElements(By.xpath("//ul[@class='theme4_dropdown_value_container__UAQJN']//span[@class='theme4_advTitle__GzPon']"));
	if (AllDeparture.size() > 0) {
		// Iterate through the list and find the matching fare type
		for (int i = 0; i < AllDeparture.size(); i++) {
			WebElement searchText = AllDeparture.get(i);
			String current_dt = searchText.getText();
			logger.info("The Departure check :"+current_dt);
			if (current_dt.equalsIgnoreCase(Departure)) {
				AllDeparture.get(i).click();
				break;
			}
		}
	} else {
		logger.info("The Current Supplier is not available");
	}
	
	}
	else if(way.contains(ROUNDWAY)||way.contains(HALFROUNDTRIP)||way.contains(MUTICITY))
	{		
		departureTime.click();
		Thread.sleep(500);
		logger.info("The Currrant Departure Time is :"+Departure);
		// All RBD Names
		List<WebElement> AllDeparture= driver.findElements(By.xpath("//ul[@class='theme4_dropdown_value_container__UAQJN']//span[@class='theme4_advTitle__GzPon']"));
		if (AllDeparture.size() > 0) {
			// Iterate through the list and find the matching fare type
			for (int i = 0; i < AllDeparture.size(); i++) {
				WebElement searchText = AllDeparture.get(i);
				String current_dt = searchText.getText();
				logger.info("The Departure check :"+current_dt);
				if (current_dt.equalsIgnoreCase(Departure)) {
					AllDeparture.get(i).click();
					break;
				}
			}
		} else {
			logger.info("The Current Supplier is not available");
		}
		Thread.sleep(1000);

		returnDepartureTime.click();
		Thread.sleep(500);
	    logger.info("The Currrant Departure Time is :"+Departure);
		// All RBD Names
		List<WebElement> AllDeparture1= driver.findElements(By.xpath("//ul[@class='theme4_dropdown_value_container__UAQJN']//span[@class='theme4_advTitle__GzPon']"));
		if (AllDeparture1.size() > 0) {
			// Iterate through the list and find the matching fare type
			for (int i = 0; i < AllDeparture1.size(); i++) {
				WebElement searchText = AllDeparture1.get(i);
				String current_dt = searchText.getText();
				logger.info("The Departure check :"+current_dt);
				if (current_dt.equalsIgnoreCase(Departure)) {
					AllDeparture1.get(i).click();
					break;
				}
			}
		} else {
			logger.info("The Current Supplier is not available");
		}
		
		
	}

	
	
	
	
					
			     
		Thread.sleep(1000);
	}

public void checksearchresult(WebDriver driver) throws InterruptedException {
    // Wait for 1 second before proceeding
    Thread.sleep(1000);
    
    // Initialize WebDriverWait with a timeout of 100 seconds
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
    
    // Wait for the 'Search' button to be visible
    WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']")));
    
    // Scroll down to ensure the element is in view
    commonMethodes.scrollDown2(driver);

    // Find the heading element that shows search results
    WebElement ele = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[2]/div[3]/h1[1]"));

    // Check if the search result indicates '0 Results'
    if (ele.getText().contentEquals("0 Results")) {
        // If there are no results, find and click the 'Reset filter' button
        WebElement refresh = driver.findElement(By.xpath("//button[normalize-space()='Reset filter']"));

        // Scroll the reset button into view and click it
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", refresh);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", refresh);
    }
    
    // Wait for 1 second after resetting filters
    Thread.sleep(1000);
}

public void selectFareTypeFlight(WebDriver driver, String fareType, Boolean SearchType, String way) throws InterruptedException {
    // Log the current fare type and trip type
    logger.info("Current fare Type is :" + fareType);
    logger.info("Current Trip Type is :" + way);

    // If the search type is true, wait for the search button to be visible
    if (SearchType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']")));
        Thread.sleep(500);
        commonMethodes.scrollDown3(driver);
        // Wait for the 'Airlines' element to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Airlines']")));
    } else {
        // Handle different trip types for searching flights
        if (way.contains(ONEWAY) || way.contains(ROUNDWAY) || way.contains(MUTICITY)) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
                WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='theme4_btn_primary__aMZOB theme4_booknow_btn_mg__f0haC'][normalize-space()='Book'])[1]")));
                Thread.sleep(100);
                commonMethodes.scrollDown2(driver);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // Log error and fail the test case if no results found
                System.err.println("Error: No results found" + fareType);
                Assert.fail("Error: No results found " + fareType);
                driver.close();
            }
        }
    }

    // Handle the selection of fare types based on trip type
    if (way.contains(ONEWAY) || way.contains(ROUNDWAY) || way.contains(MUTICITY)) {
        // Find all refundable and non-refundable flight elements
        List<WebElement> FareType = driver.findElements(By.xpath("//div[@class='theme4_refundflight__Tk_cD']"));
        // Find all 'Book' buttons
        List<WebElement> BookButton = driver.findElements(By.xpath("//button[@class='theme4_btn_primary__aMZOB theme4_booknow_btn_mg__f0haC']"));

        // Check if there are any flights found
        if (FareType.size() > 0) {
            boolean isMatchFound = false; // Flag to check if a fare type match is found

            // Iterate through fare types and find a match
            for (int i = 0; i < FareType.size(); i++) {
                WebElement searchText = FareType.get(i);
                String current_dt = searchText.getText();
                if (current_dt.equalsIgnoreCase(fareType)) {
                    logger.info("Fare type match condition true for: " + current_dt);

                    // Click the appropriate book button based on the match
                    if (i == 0) {
                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", BookButton.get(i));
                    } else {
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", BookButton.get(i));
                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", BookButton.get(i));
                    }

                    isMatchFound = true; // Set the flag to true if a match is found
                    break;
                }
            }

            // Log error and fail the test case if no matching fare type found
            if (!isMatchFound) {
                logger.error("Error: No matching fare type found for: " + fareType);
                Assert.fail("Error: No matching fare type found for: " + fareType);
                driver.close();
            }
        }

        // Optional wait to observe the click action
        Thread.sleep(5000);
    } else if (way.contains(HALFROUNDTRIP)) {
        // Handle the case for half-round trips
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement radio1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='theme4_leftWd__BLl63']//div[1]//div[1]//div[1]//div[2]//input[1]")));
        Thread.sleep(1000);
        
        // Select refundable or non-refundable options based on fare type
        if (fareType.contentEquals("Refundable")) {
            WebElement elemnet = radio1.findElement(By.xpath("((//div[@class='theme4_depart_from__IwDfX'])[5]//label[@class='theme4_checkbox_common__tRblA'])[1]"));
            Thread.sleep(500);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elemnet);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elemnet);
            Thread.sleep(2000);
        } else if (fareType.contentEquals("Non Refundable")) {
            WebElement elemnet = radio1.findElement(By.xpath("((//div[@class='theme4_depart_from__IwDfX'])[5]//label[@class='theme4_checkbox_common__tRblA'])[2]"));
            Thread.sleep(500);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elemnet);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elemnet);
            Thread.sleep(2000);
        }
        
        // Click the relevant options to finalize the selection
        driver.findElement(By.xpath("//div[@class='theme4_leftWd__BLl63']//div[1]//div[1]//div[1]//div[2]//input[1]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[@class='theme4_rightWd__kjlGu']//div[1]//div[1]//div[1]//div[2]//input[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Book Now']")).click();
        
        // Optional wait for 5 seconds
        Thread.sleep(5000);
    }
}

public void selectFareTypeFlighthalfroundtrip(WebDriver driver, String fareType) throws InterruptedException {
    // Initialize WebDriverWait for 100 seconds
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
    WebElement radio1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='theme4_leftWd__BLl63']//div[1]//div[1]//div[1]//div[2]//input[1]")));
    Thread.sleep(1000);
    
    // Select refundable or non-refundable options based on fare type
    if (fareType.contentEquals("Refundable")) {
        WebElement elemnet = radio1.findElement(By.xpath("((//div[@class='theme4_depart_from__IwDfX'])[5]//label[@class='theme4_checkbox_common__tRblA'])[1]"));
        Thread.sleep(500);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elemnet);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elemnet);
        Thread.sleep(2000);
    } else if (fareType.contentEquals("Non Refundable")) {
        WebElement elemnet = radio1.findElement(By.xpath("((//div[@class='theme4_depart_from__IwDfX'])[5]//label[@class='theme4_checkbox_common__tRblA'])[2]"));
        Thread.sleep(500);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elemnet);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elemnet);
    }}

public void select_supplier(WebDriver driver) throws InterruptedException {
    // Initialize WebDriverWait to wait for elements
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    
    // Wait for the supplier input field to be visible and assign it to a variable
    WebElement supplierCheckBox = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Select Supplier']")));
    
    // Scroll into view for the supplier checkbox
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", supplierCheckBox);

    // Click the supplier checkbox to open the dropdown
    supplierCheckBox.click();

    // Find all checkbox elements for suppliers
    List<WebElement> checkBoxList = driver.findElements(
            By.xpath("//ul[@class='multiSelectDropDown_dropdown_value_container__vWFcB']//li//span[2]"));
    int checkBoxListSize = checkBoxList.size(); // Get the number of checkboxes

    // Find all supplier name elements
    List<WebElement> supplierNames = driver.findElements(
            By.xpath("//ul[@class='multiSelectDropDown_dropdown_value_container__vWFcB']//li//span[2]"));
    int supplierNameSize = supplierNames.size(); // Get the number of supplier names

    // Iterate through supplier names to find the desired supplier
    for (int i = 0; i < supplierNameSize; i++) {
        String name = supplierNames.get(i).getText(); // Get the current supplier name

        // Check if the current supplier matches the target supplier
        if (name.equalsIgnoreCase("galileobah_37TN")) {
            logger.info("Supplier Name Match Found!"); // Log a match
            checkBoxList.get(i).click(); // Click the checkbox for the supplier
            Thread.sleep(3000); // Wait for the action to complete
            break; // Exit the loop after clicking
        } else {
            logger.info("Supplier Name Match Not Found."); // Log if no match is found
        }
    }
}

public void selectFareType(WebDriver driver, String fareType) throws InterruptedException {
    // Check if the fare type is Refundable
    if (fareType.equalsIgnoreCase("Refundable")) {
        // Wait for the appropriate button to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(),'Book')])[2]")));
        
        // Locate the Refundable label and scroll to it
        WebElement Refundable = checkbox.findElement(By.xpath("//label[normalize-space()='Refundable']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Refundable);
        
        // Click the Refundable checkbox
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Refundable);
    } else { // For Non-Refundable fare type
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(),'Book')])[2]")));
        
        // Locate the Non-Refundable label and scroll to it
        WebElement NonRefundable = checkbox.findElement(By.xpath("//label[normalize-space()='Non - Refundable']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", NonRefundable);
        
        // Click the Non-Refundable checkbox
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", NonRefundable);
    }
}

public void loaderLoading(WebDriver driver, String markType) throws InterruptedException {
    // Click on the book button to initiate the loading process
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", book);

    // Check if the mark type is "markup" or not
    if (markType.equalsIgnoreCase("markup")) {
        // Click on the markup radio button
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", "//input[@id='markup']");
    } else {
        // Click on the markdown radio button
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", "//input[@id='markdown']");
    }
}

public void selectMarkType(WebDriver driver, boolean markType) throws InterruptedException {
    // Wait for the markdown radio button to be visible
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
    WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='markdown']")));
    
    // Scroll down to ensure the element is in view
    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,100)", "");

    // Check if the mark type is true (markdown)
    if (markType) {
        // Click on the markdown radio button
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", markDownRadio);
    }
}

public void selectStops(WebDriver driver, String noStops) throws InterruptedException {
    logger.info("------ User select number of stops ----------");

    // Wait for the search button to be visible
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
    WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']")));
    Thread.sleep(1000); // Pause for a moment
    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)", ""); // Scroll down the page
    Thread.sleep(1000); // Pause for a moment

    // Select the appropriate number of stops based on user input
    if (noStops.equalsIgnoreCase("0")) {
        WebElement selectStops = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='0']")));
        selectStops.click(); // Click the checkbox for 0 stops
        Thread.sleep(1000); // Wait for the action to complete
    } else if (noStops.equalsIgnoreCase("1")) {
        WebElement selectStops = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='1']")));
        selectStops.click(); // Click the checkbox for 1 stop
        Thread.sleep(1000); // Wait for the action to complete
    } else if (noStops.equalsIgnoreCase("2+")) {
        WebElement selectStops = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='2+']")));
        selectStops.click(); // Click the checkbox for 2 or more stops
        Thread.sleep(1000); // Wait for the action to complete
    }
}

			
		

		
	


	
	
public void HandelThePriceChangeAlert(WebDriver driver) {
    try {
        // Log the action of handling the Price Change Alert Popup
        logger.info("------ User handle the Price Change Alert Popup ----------");

        // Initialize WebDriverWait to wait for the alert popup to become visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait until the alert popup is visible
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='theme4_alertbutton__BBU3G']")));
        // Click on the alert popup to close it
        popup.findElement(By.xpath("//div[@class='theme4_alertbutton__BBU3G']")).click();
    } catch (Exception e) {
        // Log any exceptions that occur during this process
        e.printStackTrace();
    }
}

public void selectPriceRange1(WebDriver driver, int low, int high) throws InterruptedException {
    try {
        Thread.sleep(5000); // Pause to allow for page load or other operations (ideally replace with explicit wait)
        // Log the low and high price range values
        logger.info("---- Price Range Low-High value is ---- " + low + " " + high);

        // Initialize WebDriverWait to wait for the price filter elements to become visible
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
        // Find the minimum price slider
        WebElement minPriceSlider = wait1.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='MuiBox-root jss1']//span[3]")));
        
        // Find the maximum price slider
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement maxPriceSlider = wait2.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='MuiBox-root jss1']//span[4]")));

        // Get the width of the minimum and maximum sliders
        int minSlider = minPriceSlider.getSize().width;
        int maxSlider = maxPriceSlider.getSize().width;

        // Log the dimensions of the sliders
        logger.info("min-max slider value are" + " " + minSlider + " " + "maxSlider" + maxSlider);

        // Create an Actions object to perform drag-and-drop operations
        Actions move = new Actions(driver);
        // Move the min slider to the right by a factor of its width (11 times)
        move.dragAndDropBy(minPriceSlider, minSlider * 11, 0).perform();
        // Move the max slider to the left by a factor of its width (101 times)
        move.dragAndDropBy(maxPriceSlider, maxSlider * 101, 0).perform();

        // Wait for the filtered results to be visible after applying the price range
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        WebElement filteredResults = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='theme4_tile_main__Eivwa']")));

        // Verify that the filtered results are displayed
        assert (filteredResults.isDisplayed());
    } catch (Exception e) {
        // Log any exceptions that occur during this process
        logger.info("selectPriceRange error :" + e);
    }
}

public void selectPriceRange2(WebDriver driver, int low, int high) throws InterruptedException {
    try {
        Thread.sleep(5000); // Pause to allow for page load or other operations (ideally replace with explicit wait)
        // Log the low and high price range values
        logger.info("---- Price Range Low-High value is ---- " + low + " " + high);

        // Initialize WebDriverWait to wait for the price filter sliders to become visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        // Find the minimum price slider element
        WebElement minPriceSlider = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='MuiBox-root jss1']//span[3]")));
        
        // Find the maximum price slider element
        WebElement maxPriceSlider = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='MuiBox-root jss1']//span[4]")));

        // Get the width of the minimum price slider
        int sliderWidth = minPriceSlider.getSize().width;
        logger.info("Slider width: " + sliderWidth);

        // Calculate offsets for dragging the sliders based on the input price range
        int minSliderOffset = (int) (sliderWidth * (low / 100.0)); // Calculate offset for the minimum price
        int maxSliderOffset = (int) (sliderWidth * (high / 100.0)) - sliderWidth; // Adjust for the maximum slider

        // Scroll sliders into view if necessary
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", minPriceSlider);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", maxPriceSlider);

        // Use Actions to drag the sliders to the calculated positions
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(minPriceSlider, minSliderOffset, 0).perform(); // Adjust the minimum price slider
        actions.dragAndDropBy(maxPriceSlider, maxSliderOffset, 0).perform(); // Adjust the maximum price slider

        // Wait for the filtered results to appear after applying the price range
        WebElement filteredResults = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='theme4_tile_main__Eivwa']")));

        // Verify that filtered results are displayed
        if (filteredResults.isDisplayed()) {
            logger.info("Filtered results displayed successfully.");
        } else {
            logger.info("Filtered results not displayed.");
        }
    } catch (Exception e) {
        // Log any exceptions that occur during this process
        logger.info("selectPriceRange error: " + e);
    }
}

public void selectDynamicPriceRange(WebDriver driver) throws InterruptedException {
    // Initialize WebDriverWait to wait for elements to load
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
    
    // Wait for the 'Search' button to be visible and store the element
    WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']")));
    
    Thread.sleep(500); // Pause to ensure the page is fully loaded
    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,350)", ""); // Scroll down the page
    Thread.sleep(500); // Wait for scrolling to complete
    
    // Wait for the price filter slider to be visible
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='MuiBox-root jss1']//span[3]")));
    Thread.sleep(500); // Wait for the slider to be interactable
    
    // Get the width of the starting drag element (min price)
    dragStart.getLocation(); // This line may not be necessary as it does not store the location
    
    int xside = dragStart.getSize().width; // Get the width of the starting drag element
    int xside1 = dragEnd.getSize().width; // Get the width of the ending drag element (not used in the method)

    // Create an Actions object to perform drag-and-drop actions
    Actions act = new Actions(driver);
    // Drag the starting slider by a calculated width (6 times the width of the starting element)
    act.dragAndDropBy(dragStart, xside * 6, 0).build().perform();
    
    Thread.sleep(1000); // Pause to allow the slider movement to complete
}

public void selectDynamicTimeRange(WebDriver driver) throws InterruptedException {
    // Initialize WebDriverWait to wait for elements to load
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
    
    // Wait for the 'Search' button to be visible and store the element
    WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']")));
    
    Thread.sleep(500); // Pause to ensure the page is fully loaded
    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,350)", ""); // Scroll down the page
    Thread.sleep(500); // Wait for scrolling to complete
    
    // Wait for the time duration filter slider to be visible
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='theme4_filter_trip_duration__gkOGQ']//span[3]")));
    Thread.sleep(500); // Wait for the slider to be interactable
    
    // Get the width of the starting duration drag element (not used)
    durationStart.getLocation(); // This line may not be necessary as it does not store the location
    
    int xside = durationStart.getSize().width; // Get the width of the starting duration element
    int xside1 = durationEnd.getSize().width; // Get the width of the ending duration element (not used in the method)

    // Create an Actions object to perform drag-and-drop actions
    Actions act = new Actions(driver);
    // Drag the starting duration slider by a calculated width (6 times the width of the starting element)
    act.dragAndDropBy(durationStart, xside * 6, 0).build().perform();
    
    Thread.sleep(1000); // Pause to allow the slider movement to complete
}

public void enterLocalTaxes(WebDriver driver, String localTax) throws InterruptedException {
    // Log the local tax value being entered
    logger.info("---- enterLocalTaxes value is ----" + localTax);
    
    // Click on the local tax input field and enter the tax value
    localTaxLocator.click();
    localTaxLocator.sendKeys(localTax);
}

public void selectPercentOrFlat(WebDriver driver, boolean isPercentToggle, String Percentage) throws InterruptedException {
    // Log whether the selection is for a percentage or a flat rate
    logger.info("Is Percentage : " + isPercentToggle);
    
    // If the selection is not a percentage
    if (!isPercentToggle) {
        Thread.sleep(500); // Wait for UI to stabilize
        driver.findElement(By.xpath("//div[@class='theme4_btnDay___Bbbt']")).click(); // Click to select flat rate
        Thread.sleep(500); // Wait for UI to respond
        driver.findElement(By.xpath("//button[normalize-space()='Reset']")).click(); // Click reset button
        Thread.sleep(500); // Wait for reset to complete
        driver.findElement(By.xpath("//input[@id='markValue']")).sendKeys(Percentage); // Enter the flat value
        Thread.sleep(500); // Wait for the value to be set
    }
    // If the selection is for a percentage
    else if (isPercentToggle) {
        Thread.sleep(500); // Wait for UI to stabilize
        driver.findElement(By.xpath("//button[normalize-space()='Reset']")).click(); // Click reset button
        Thread.sleep(500); // Wait for reset to complete
        driver.findElement(By.xpath("//input[@id='markValue']")).sendKeys(Percentage); // Enter the percentage value
        Thread.sleep(500); // Wait for the value to be set
    }
}

public void enterFlatValue(WebDriver driver, String flat) throws InterruptedException {
    // Log the flat value being entered
    logger.info("---- enterFlatValue value is ----" + flat);
    
    // Initialize WebDriverWait to wait for the input field to be visible
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    // Wait for the input field and click it
    WebElement percentageValueElement = wait
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='markValue']")));
    
    percentageValueElement.click(); // Click the input field
    percentageValueElement.sendKeys(flat); // Enter the flat value
}

public void waitLoadingLogo(WebDriver driver) throws InterruptedException {
    // Initialize WebDriverWait to wait until the loading logo is invisible
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    // Wait for the loading logo to disappear
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
            "//img[@src='https://services-api.vetravel.io/shared/api/media/6543a1e263f366794276a368/989707634DDBHLoader.gif']")));
}

public void waitDataLoadingBar(WebDriver driver) throws InterruptedException {
    // Initialize WebDriverWait to wait until the data loading bar is invisible
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    // Wait for the data loading bar to disappear
    wait.until(ExpectedConditions
            .invisibilityOfElementLocated(By.xpath("//div[@class='theme4_loader_main__MBAGK undefined']")));
}


public void checkFareDetails(WebDriver driver) throws InterruptedException {
    // Pause for a second to allow elements to load
    Thread.sleep(1000);

    // Scroll to the fare details section (commented out for now)
    // ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)", fareDetailsSection);

    // Create a map to hold fare details with labels and their corresponding amounts
    Map<String, Double> fareDetails = new HashMap<>();

    // Array of expected fare labels to extract information
    String[] fareLabels = {
        "Base Fare", 
        "My Earning (Incl. of Taxes)", 
        "Taxes", 
        "Seats", 
        "Meals", 
        "Baggage", 
        "Platform Fees", 
        "GST"
    };

    // Get list of fare labels from the UI
    List<WebElement> labelList = driver.findElements(By.xpath(
        "//div[@class='theme4_fare_detail_box__9WckK']//div[@class='theme4_flight_base_fare__pLY6w']//div[1]//p"));
    int labelSize = labelList.size();

    // Get list of corresponding fare prices
    List<WebElement> priceList = driver.findElements(By.xpath(
        "//div[@class='theme4_fare_detail_box__9WckK']//div[@class='theme4_flight_base_fare__pLY6w']//div[2]//p"));
    int priceSize = priceList.size();

    // Get list of labels for taxes and other services
    List<WebElement> labelListOne = driver.findElements(By.xpath(
        "//div[@class='theme4_fare_detail_box__9WckK']//div[@class='theme4_taxes_gst_service__9W1Da']//div[1]//p"));
    int labelSizeOne = labelListOne.size();

    // Get list of prices for taxes and other services
    List<WebElement> priceListOne = driver.findElements(By.xpath(
        "//div[@class='theme4_fare_detail_box__9WckK']//div[@class='theme4_taxes_gst_service__9W1Da']//div[2]//p"));
    int priceSizeOne = priceListOne.size();

    // Extract fare details based on labels and their corresponding prices
    for (int i = 0; i < labelSize; i++) {
        for (String label : fareLabels) {
            String currentLabel = labelList.get(i).getText();
            if (currentLabel.equalsIgnoreCase(label)) {
                // Parse the price and store it in the fareDetails map
                fareDetails.put(label, Double.parseDouble(priceList.get(i).getText().trim().replace(",", "")));
            }
        }
    }

    // Extract additional fare details for taxes and services
    for (int i = 0; i < labelSizeOne; i++) {
        for (String label : fareLabels) {
            String currentLabel = labelListOne.get(i).getText();
            if (currentLabel.equalsIgnoreCase(label)) {
                fareDetails.put(label, Double.parseDouble(priceListOne.get(i).getText().trim().replace(",", "")));
            }
        }
    }

    // Check if local taxes are applicable and add to fare details if present
    if (driver.findElements(By.xpath("//p[normalize-space()='Local Taxes (if applicable)']")).size() > 0) {
        WebElement localTaxElement = driver.findElement(By.xpath(
            "//div[@class='theme4_flight_base_ticket_price__OWEX3']//input[@placeholder='Enter Amount']"));
        logger.info("Local taxes if applicable: " + localTaxElement.getText());
        fareDetails.put("Local Taxes (if applicable)", Double.parseDouble(localTaxElement.getAttribute("value").trim().replace(",", "")));
    }

	double finalTotalAmount = fareDetails.values().stream().mapToDouble(Double::doubleValue).sum();

	// Print the fare details and total amount
	System.out.println("Fare Details:");
	fareDetails.forEach((label, value) -> System.out.println(label + ": " + value));
	System.out.println("Final Total Amount: " + finalTotalAmount);

	// this line check total amount calculation
	if (driver.findElements(By.xpath("//b[normalize-space()='Total Amount']")).size() > 0) {

		WebElement totalElement = driver.findElement(By.xpath("//span[@id='final_flight_amt']"));
		double totalAmt = Double.parseDouble(totalElement.getText().trim().replace(",", ""));
		

		System.out.println("Final Amount after all calculation" + finalTotalAmount);
		System.out.println("Total amount is " + totalAmt);

		  BigDecimal value = new BigDecimal(finalTotalAmount);
	        value = value.setScale(3, RoundingMode.HALF_UP);
		        System.out.println("finalTotalAmount : " + value);
		        
		        BigDecimal value1 = new BigDecimal(totalAmt);
		        value1 = value1.setScale(3, RoundingMode.HALF_UP);
			        System.out.println("totalAmt  : " + value1);
			
			        double Diff = finalTotalAmount-totalAmt;
			        System.out.println("The Value Differance is :"+Diff);

		assertEquals(value, value1,"The final calculated amount"+value+" and total amount "+value1+" to paid are not matching getting differance "+Diff+" The test cases is failed ");

    }
}


}

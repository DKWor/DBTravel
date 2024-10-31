package pageobjectclass; // Defines the package name for this class.

// Import necessary classes from Java and Selenium libraries.
import java.io.IOException; // For handling IO exceptions.
import java.math.BigDecimal; // For performing precise mathematical calculations.
import java.math.RoundingMode; // For defining rounding behavior in calculations.
import java.time.Duration; // For representing a duration of time.
import java.util.Iterator; // For iterating over collections.
import java.util.List; // For using List data structures.
import java.util.Random; // For generating random numbers.
import java.util.Set; // For using Set data structures.

// Import logging classes for logging information.
import org.apache.logging.log4j.LogManager; // For managing loggers.
import org.apache.logging.log4j.Logger; // For logging messages in the application.

// Import Selenium classes for web automation.
import org.openqa.selenium.By; // For locating elements on a web page.
import org.openqa.selenium.JavascriptExecutor; // For executing JavaScript in the browser.
import org.openqa.selenium.Keys; // For simulating keyboard keys.
import org.openqa.selenium.WebDriver; // For controlling the web browser.
import org.openqa.selenium.WebElement; // For interacting with web elements.
import org.openqa.selenium.interactions.Actions; // For simulating complex user interactions.
import org.openqa.selenium.support.FindBy; // For finding web elements using annotations.
import org.openqa.selenium.support.PageFactory; // For initializing page objects.
import org.openqa.selenium.support.ui.ExpectedConditions; // For waiting until a condition is met.
import org.openqa.selenium.support.ui.WebDriverWait; // For waiting for a specified time.
import org.testng.Assert; // For assertion methods in test cases.

import utils.commonMethodes; // Importing common methods used across tests.


public class pomHotelExceldata { // Class for handling hotel data and interactions in the hotel booking system

    // Logger instance for logging events and messages
    private static final Logger logger = LogManager.getLogger(pomHotelExceldata.class);

    // WebElements representing various fields on the hotel booking webpage

    @FindBy(xpath="//input[@id='email']") // Locator for the email input field
    private WebElement email;

    @FindBy(xpath="//input[@id='pass']") // Locator for the password input field
    private WebElement pass;

    @FindBy(xpath="//button[normalize-space()='Sign In']") // Locator for the Sign In button
    private WebElement login;

    @FindBy(xpath="//span[@class='Desktop_serv_flx__tLpIp']//li[@class='Desktop_inactive__VefRT']") // Locator for clicking on the hotel service
    private WebElement clickHotel;

    @FindBy(xpath="(//input[@id='myTextField'])[1]") // Locator for the city search input field
    private WebElement searchCity;

    @FindBy(xpath="(//input[@id='myTextField'])[1]") // Locator for the city name input (duplicate of searchCity)
    private WebElement searchCityname;

    @FindBy(xpath="(//div[@id='hotelData'])[1]") // Locator for selecting a city from the dropdown
    private WebElement selectCity;

    @FindBy(xpath="(//input[@id='myTextField'])[2]") // Locator for the calendar input field
    private WebElement calander;

    @FindBy(xpath="(//span[@class='theme4_vt_country_select_container__vp3GT'])[1]") // Locator for the nationality selection dropdown
    private WebElement selectNationality;

    @FindBy(xpath="//span[normalize-space()='Indian']") // Locator for selecting 'Indian' nationality
    private WebElement indian;

    @FindBy(xpath="(//div[@class='theme4_hotel_search_column__a47HJ theme4_hotel_search_accomodation__20HyS'])[1]") // Locator for passenger information section
    private WebElement passanger;

    @FindBy(xpath="//tbody/tr/td[2]/div[1]/span[2]//*[name()='svg']") // Locator for increasing the number of adults
    private WebElement adult1;

    @FindBy(xpath="//tbody/tr/td[2]/div[1]/span[1]//*[name()='svg']") // Locator for decreasing the number of adults
    private WebElement adultsubtract;

    @FindBy(xpath="//tbody/tr/td[3]/div[1]/span[2]//*[name()='svg']") // Locator for increasing the number of children
    private WebElement child;

    @FindBy(xpath="//input[@placeholder='Child 1 Age']") // Locator for inputting the age of the first child
    private WebElement room1chilage1;

    @FindBy(xpath="//input[@placeholder='Child 2 Age']") // Locator for inputting the age of the second child
    private WebElement room1chilage2;

    @FindBy(xpath="//input[@placeholder='Child 3 Age']") // Locator for inputting the age of the third child
    private WebElement room1chilage3;

    @FindBy(xpath="//input[@placeholder='Child 4 Age']") // Locator for inputting the age of the fourth child
    private WebElement room1chilage4;

    @FindBy(xpath="(//div[@class='theme4_age_list_ele__qEwZi'])[3]") // Locator for selecting the age of children in room 1
    private WebElement childAgeRoom1;

    // Additional WebElements for more functionalities would follow...



	
    // WebElements for adding and managing rooms in the hotel booking process

    @FindBy(xpath="//p[normalize-space()='ADD ROOM']") // Locator for the 'Add Room' button for the second room
    private WebElement addRoom2;

    @FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/span[2]/*[name()='svg'][1]") // Locator for increasing the number of adults in the second room
    private WebElement room2Adult;

    @FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/span[2]/*[name()='svg'][1]") // Locator for increasing the number of children in the second room
    private WebElement room2child;

    @FindBy(xpath="(//input[@placeholder='Child 1 Age'])[2]") // Locator for the age input of the first child in the second room
    private WebElement room2chilage1;

    @FindBy(xpath="(//input[@placeholder='Child 2 Age'])[2]") // Locator for the age input of the second child in the second room
    private WebElement room2chilage2;	

    @FindBy(xpath="(//*[name()='svg'][@id='Layer_1'])[6]") // Locator for adding another child in the second room
    private WebElement room2chilage3;

    @FindBy(xpath="(//div[@class='theme4_age_list_ele__qEwZi'])[2]") // Locator for selecting the age of children in the second room
    private WebElement room2selectAge;

    @FindBy(xpath="//p[normalize-space()='ADD ROOM']") // Locator for the 'Add Room' button for the third room
    private WebElement addRoom3;

    @FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/span[2]/*[name()='svg'][1]") // Locator for increasing the number of adults in the third room
    private WebElement room3Adult;

    @FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/span[2]/*[name()='svg'][1]") // Locator for increasing the number of children in the third room
    private WebElement room3child;

    @FindBy(xpath="(//*[name()='svg'][@id='Layer_1'])[7]") // Locator for adding another child in the third room
    private WebElement room3chilage1;

    @FindBy(xpath="(//*[name()='svg'][@id='Layer_1'])[8]") // Locator for adding another child in the third room
    private WebElement room3chilage2;	

    @FindBy(xpath="(//*[name()='svg'][@id='Layer_1'])[9]") // Locator for adding another child in the third room
    private WebElement room3chilage3;

    @FindBy(xpath="(//div[@class='theme5_age_list_ele__xy8s7'])[4]") // Locator for selecting the age of children in the third room
    private WebElement room3selectAge;

    @FindBy(xpath="//p[normalize-space()='ADD ROOM']") // Locator for the 'Add Room' button for the fourth room
    private WebElement addRoom4;

    @FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/div[4]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/span[2]") // Locator for increasing the number of adults in the fourth room
    private WebElement room4Adult;

    @FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/div[4]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/span[2]/*[name()='svg'][1]") // Locator for increasing the number of children in the fourth room
    private WebElement room4child;

    @FindBy(xpath="(//*[name()='svg'][@id='Layer_1'])[10]") // Locator for adding another child in the fourth room
    private WebElement room4chilage1;

    @FindBy(xpath="(//*[name()='svg'][@id='Layer_1'])[11]") // Locator for adding another child in the fourth room
    private WebElement room4chilage2;	

    @FindBy(xpath="(//*[name()='svg'][@id='Layer_1'])[12]") // Locator for adding another child in the fourth room
    private WebElement room4chilage3;

    @FindBy(xpath="(//div[@class='theme5_age_list_ele__xy8s7'])[4]") // Locator for selecting the age of children in the fourth room
    private WebElement room4selectAge;

    @FindBy(xpath="(//p[normalize-space()='ADD ROOM'])[1]") // Locator for the 'Add Room' button for the fifth room
    private WebElement addRoom5;

    @FindBy(xpath="(//*[name()='svg'][@id='Layer_1'])[31]") // Locator for increasing the number of adults in the fifth room
    private WebElement room5Adult;

    @FindBy(xpath="(//*[name()='svg'][@id='Layer_1'])[33]") // Locator for increasing the number of children in the fifth room
    private WebElement room5child;

    @FindBy(xpath="(//*[name()='svg'][@id='Layer_1'])[34]") // Locator for adding another child in the fifth room
    private WebElement room5chilage1;

    @FindBy(xpath="(//*[name()='svg'][@id='Layer_1'])[35]") // Locator for adding another child in the fifth room
    private WebElement room5chilage2;	

    @FindBy(xpath="(//*[name()='svg'][@id='Layer_1'])[36]") // Locator for adding another child in the fifth room
    private WebElement room5chilage3;

    @FindBy(xpath="(//div[@class='theme2_age_list_ele__CRcn3'])[4]") // Locator for selecting the age of children in the fifth room
    private WebElement room5selectAge;

 // WebElements for selecting child age, finalizing the booking, and inputting traveler details

    @FindBy(xpath="(//*[name()='svg'][@id='Layer_1'])[8]") // Locator for selecting the age of the second child
    private WebElement selectchaildAge2;

    @FindBy(xpath="(//div[@class='theme2_age_list_ele__CRcn3'])[4]") // Locator for the age input for the second child
    private WebElement childAge2;

    @FindBy(xpath="//input[@value='Done']") // Locator for the 'Done' button to confirm selections
    private WebElement done;

    @FindBy(xpath="//button[normalize-space()='Search']") // Locator for the 'Search' button to initiate the hotel search
    private WebElement search;

    @FindBy(xpath="(//button[@class='theme4_srp_desktop_btn__a_Cdn theme4_srp_tab_btn__K3_7j'][normalize-space()='Select'])[1]") // Locator for selecting the first hotel from search results
    private WebElement selectHotel;

    @FindBy(xpath="(//button[@class='theme4_srp_desktop_btn__aQOWM theme4_srp_tab_btn__slXIC'][normalize-space()='Select'])[1]") // Locator for selecting the first room from the hotel
    private WebElement selectRoom;

    @FindBy(xpath="(//button[normalize-space()='Continue'])[1]") // Locator for the 'Continue' button to proceed with booking
    private WebElement continueBooking;

    @FindBy(xpath="//button[normalize-space()='Continue']") // Locator for another 'Continue' button in the booking process
    private WebElement continubutton;

    @FindBy(xpath="//span[@class='theme2_ax_checkmark__qkZ7Y']") // Locator for the checkbox to accept terms and conditions
    private WebElement chekmarkterms;

    @FindBy(xpath="//button[@id='payment_btn']") // Locator for the button to proceed to payment
    private WebElement proceedpayment;

    // WebElements for selecting adults for each room

    @FindBy(xpath="(//input[@placeholder='Select Traveller'])[1]") // Locator for selecting the traveler for the first room
    private WebElement adultFoeRoom1;

    @FindBy(xpath="(//input[@placeholder='Select Traveller'])[2]") // Locator for selecting the traveler for the second room
    private WebElement adultFoeRoom2;

    @FindBy(xpath="(//input[@placeholder='Select Traveller'])[3]") // Locator for selecting the traveler for the third room
    private WebElement adultFoeRoom3;

    @FindBy(xpath="(//input[@placeholder='Select Traveller'])[4]") // Locator for selecting the traveler for the fourth room
    private WebElement adultFoeRoom4;

    // WebElements for selecting adults based on the room booking

    @FindBy(xpath="(//div[@class='theme5_name_contbx__3LUKU'])[1]") // Locator for selecting the first adult's name
    private WebElement selectAdult1;

    @FindBy(xpath="(//div[@class='theme5_name_contbx__3LUKU'])[2]") // Locator for selecting the second adult's name
    private WebElement selectAdult2;

    @FindBy(xpath="(//div[@class='theme5_name_contbx__3LUKU'])[3]") // Locator for selecting the third adult's name
    private WebElement selectAdult3;

    @FindBy(xpath="(//div[@class='theme5_name_contbx__3LUKU'])[4]") // Locator for selecting the fourth adult's name
    private WebElement selectAdult4;

    // WebElements for entering PAN numbers for each adult

    @FindBy(xpath="(//input[@id='pan_no_0'])[1]") // Locator for the PAN input field for the first adult
    private WebElement passPAN1;

    @FindBy(xpath="(//input[@id='pan_no_1'])[1]") // Locator for the PAN input field for the second adult
    private WebElement passPAN2;

    @FindBy(xpath="(//input[@id='pan_no_2'])[1]") // Locator for the PAN input field for the third adult
    private WebElement passPAN3;

    @FindBy(xpath="(//input[@id='pan_no_3'])[1]") // Locator for the PAN input field for the fourth adult
    private WebElement passPAN4;


    // WebElements for the first guest's details
    @FindBy(xpath="(//input[@id='title_0'])[1]") // Locator for the title input field for the first guest
    private WebElement title1; 

    @FindBy(xpath="(//div[normalize-space()='Mr'])[1]") // Locator for selecting 'Mr' as the title for the first guest
    private WebElement mr1;

    @FindBy(xpath="(//input[@id='first_name_0'])[1]") // Locator for the first name input field for the first guest
    private WebElement firstname01;

    @FindBy(xpath="(//input[@placeholder='Last Name'])[1]") // Locator for the last name input field for the first guest
    private WebElement lastName1;

    @FindBy(xpath="(//input[@id='email_0'])[1]") // Locator for the email input field for the first guest
    private WebElement email01;

    @FindBy(xpath="(//input[@id='phone_no_0'])[1]") // Locator for the phone number input field for the first guest
    private WebElement phoneno01;

    @FindBy(xpath="(//input[@id='pan_no_0'])[1]") // Locator for the PAN number input field for the first guest
    private WebElement panno01;

    // WebElements for the second guest's details
    @FindBy(xpath="(//img[@class='theme5_dropimg_traveller__ejmfq'])[3]") // Locator for the title input field for the second guest
    private WebElement title2;

    @FindBy(xpath="(//div[normalize-space()='Mr'])[1]") // Locator for selecting 'Mr' as the title for the second guest
    private WebElement mr2;

    @FindBy(xpath="(//input[@id='first_name_1'])[1]") // Locator for the first name input field for the second guest
    private WebElement firstname02;

    @FindBy(xpath="(//input[@placeholder='Last Name'])[2]") // Locator for the last name input field for the second guest
    private WebElement lastName2;

    @FindBy(xpath="(//input[@id='email_1'])[1]") // Locator for the email input field for the second guest
    private WebElement email02;

    @FindBy(xpath="(//input[@id='phone_no_1'])[1]") // Locator for the phone number input field for the second guest
    private WebElement phoneno02;

    @FindBy(xpath="(//input[@id='pan_no_1'])[1]") // Locator for the PAN number input field for the second guest
    private WebElement panno02;

    // WebElements for the third guest's details
    @FindBy(xpath="(//img[@class='theme5_dropimg_traveller__ejmfq'])[5]") // Locator for the title input field for the third guest
    private WebElement title3;

    @FindBy(xpath="(//div[normalize-space()='Mr'])[1]") // Locator for selecting 'Mr' as the title for the third guest
    private WebElement mr3;

    @FindBy(xpath="(//input[@id='first_name_2'])[1]") // Locator for the first name input field for the third guest
    private WebElement firstname03;

    @FindBy(xpath="(//input[@placeholder='Last Name'])[3]") // Locator for the last name input field for the third guest
    private WebElement lastName3;

    @FindBy(xpath="(//input[@id='email_2'])[1]") // Locator for the email input field for the third guest
    private WebElement email03;

    @FindBy(xpath="(//input[@id='phone_no_2'])[1]") // Locator for the phone number input field for the third guest
    private WebElement phoneno03;

    @FindBy(xpath="(//input[@id='pan_no_2'])[1]") // Locator for the PAN number input field for the third guest
    private WebElement panno03;

    // WebElements for the fourth guest's details
    @FindBy(xpath="(//img[@class='theme5_dropimg_traveller__ejmfq'])[7]") // Locator for the title input field for the fourth guest
    private WebElement title4;

    @FindBy(xpath="(//div[normalize-space()='Mr'])[1]") // Locator for selecting 'Mr' as the title for the fourth guest
    private WebElement mr4;

    @FindBy(xpath="(//input[@id='first_name_3'])[1]") // Locator for the first name input field for the fourth guest
    private WebElement firstname04;

    @FindBy(xpath="(//input[@placeholder='Last Name'])[4]") // Locator for the last name input field for the fourth guest
    private WebElement lastName4;

    @FindBy(xpath="(//input[@id='email_3'])[1]") // Locator for the email input field for the fourth guest
    private WebElement email04;

    @FindBy(xpath="(//input[@id='phone_no_3'])[1]") // Locator for the phone number input field for the fourth guest
    private WebElement phoneno04;

    @FindBy(xpath="(//input[@id='pan_no_3'])[1]") // Locator for the PAN number input field for the fourth guest
    private WebElement panno04;
    
    
 // WebElement for the alert button to continue
    @FindBy(xpath="(//button[contains(text(),'Continue')])[1]") 
    private WebElement continueAlertButton; 

    // WebElement for accessing advanced search options
    @FindBy(xpath="(//button[@type='button'])[3]") 
    private WebElement advancedSearch; 

    // WebElement for selecting the fare type
    @FindBy(xpath="(//div[@class='theme4_adv_flx__TVnxV'])[1]") 
    private WebElement selectFareType; 

    // WebElements for room type selection: refundable and non-refundable
    @FindBy(xpath="(//input[@name='room_type'])[1]") 
    private WebElement refundable; 

    @FindBy(xpath="(//input[@name='room_type'])[2]") 
    private WebElement nonrefundable; 

    // WebElements for percentage discount selection
    @FindBy(xpath="//span[@id='percent']") 
    private WebElement selectpercent; 

    @FindBy(xpath="//label[normalize-space()='Mark Down']") 
    private WebElement selectMarkdown; 

    // WebElements for input fields related to percentage and local taxes
    @FindBy(xpath="//input[@id='0']") 
    private WebElement passpercent; 

    @FindBy(xpath="//input[@id='inputId']") 
    private WebElement passlocaltaxes; 

    // WebElements for breakfast selection options
    @FindBy(xpath="(//div[@class='theme4_adv_main_bx__K7XQ5'])[2]") 
    private WebElement selectBrekfast; 

    @FindBy(xpath="(//input[@name='breakfast'])[2]") 
    private WebElement withBrekfast; 

    @FindBy(xpath="(//input[@name='breakfast'])[3]") 
    private WebElement withoutBrekfast; 

    // WebElement for selecting star ratings
    @FindBy(xpath="(//div[@class='theme4_adv_main_bx__K7XQ5'])[3]") 
    private WebElement selectStarRating; 

    // WebElements for various options like free breakfast and free cancellation
    @FindBy(xpath="(//span[@class='theme4_ax_checkmark__bNgax'])[1]") 
    private WebElement freeBreakfast; 

    @FindBy(xpath="(//span[@class='theme4_ax_checkmark__bNgax'])[2]") 
    private WebElement freeCancellation; 

    @FindBy(xpath="(//span[@class='theme4_ax_checkmark__bNgax'])[3]") 
    private WebElement selectstar; 

    // WebElements for draggable temperature range selection
    @FindBy(xpath="(//span[@aria-label='Temperature range'])[1]") 
    private WebElement dragStart; 

    @FindBy(xpath="(//span[@aria-label='Temperature range'])[2]") 
    private WebElement dragEnd; 

    // WebElements for selecting amenities, vacation type, and property type
    @FindBy(xpath="(//span[@class='theme4_ax_checkmark__bNgax'])[8]") 
    private WebElement amenities; 

    @FindBy(xpath="(//span[@class='theme4_ax_checkmark__bNgax'])[45]") 
    private WebElement vacationType; 

    @FindBy(xpath="(//span[@class='theme4_ax_checkmark__bNgax'])[51]") 
    private WebElement propertyType; 

    // WebElements for calendar inputs for departure and return dates
    @FindBy(xpath = "//div[@class='theme4_calendar_wid_main__oD3NA']//input[@id='myTextField']") 
    private WebElement departureCalander; 

    @FindBy(xpath = "//div[@class='theme4_calendar_wid_main__oD3NA']//input[@id='myTextField']") 
    private WebElement returnCalander; 

    // WebElement for the next month label in the calendar
    @FindBy(xpath = "//div[@class='theme4_calendar_head_right_side__1vhml']//span[@class='theme4_calendar_head_icon__x6qAQ']//*[name()='svg']") 
    private WebElement nextMonthLable; 

    // WebElement for displaying the hotel name
    @FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/h1[1]") 
    private WebElement hotelName; 
	

 // Constructor to initialize the page elements
    public pomHotelExceldata(WebDriver driver) {	
        PageFactory.initElements(driver, this);	
    }

    // Method for validating login based on the environment
    public void validLogin(String environment, WebDriver driver) throws InterruptedException, IOException {
        switch (environment.toLowerCase()) { // Switch case for different environments
            case "prodb2b2": 
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100)); // Initialize WebDriverWait
                WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']"))); // Wait for email input field
                email.sendKeys(commonMethodes.readDataFromPropertyFile("usernameB2B2")); // Enter username
                Thread.sleep(100); // Wait for a short duration
                pass.sendKeys(commonMethodes.readDataFromPropertyFile("passB2B2")); // Enter password
                Thread.sleep(100); // Wait for a short duration
                login.click(); // Click on the login button
                Thread.sleep(5000); // Wait for the login process to complete
                break;
              
            case "prodb2b": 
                WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(100));
                WebElement popup1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']"))); // Wait for email input field
                email.sendKeys(commonMethodes.readDataFromPropertyFile("usernameB2B")); // Enter username
                Thread.sleep(100); // Wait for a short duration
                pass.sendKeys(commonMethodes.readDataFromPropertyFile("passB2B")); // Enter password
                Thread.sleep(100); // Wait for a short duration
                login.click(); // Click on the login button
                Thread.sleep(5000); // Wait for the login process to complete
                break;
              
            case "uatb2b":
                WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(100));
                WebElement popup2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']"))); // Wait for email input field
                email.sendKeys(commonMethodes.readDataFromPropertyFile("usernameB2BUAT")); // Enter username
                Thread.sleep(100); // Wait for a short duration
                pass.sendKeys(commonMethodes.readDataFromPropertyFile("passB2BUAT")); // Enter password
                Thread.sleep(100); // Wait for a short duration
                login.click(); // Click on the login button
                Thread.sleep(5000); // Wait for the login process to complete
                break;
              
            default:
                throw new IllegalArgumentException("Unsupported environment: " + environment); // Throw exception for unsupported environments
        }
    }

    // Method for selecting nationality
    public void selecttheNationality(WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='theme4_vt_country_select_container__vp3GT'])[1]"))); // Wait for country select popup
        Thread.sleep(1000); // Wait for a short duration
        popup.click(); // Click to open country selection
        Thread.sleep(2000); // Wait for options to load

        // List of country suggestions
        List<WebElement> autosuggest = driver.findElements(By.xpath("//div[@class='theme4_country_name_code__J6kfh']"));
        for (WebElement Country : autosuggest) { // Iterate through the suggested countries
            logger.info(Country.getText()); // Log the country name
            if (Country.getText().contains("Indian")) { // Check for "Indian"
                Country.click(); // Click on "Indian"
                break; // Exit loop after selection
            }
        }
        Thread.sleep(1000); // Wait for a short duration after selection
    }

    // Method for selecting advanced search options
    public void selectAdvancedSearch(WebDriver driver) throws InterruptedException {
        advancedSearch.click(); // Click on advanced search button
        Thread.sleep(500); // Wait for a short duration
    }

    // Method for selecting fare type based on user input
    public void selecttheFareType(WebDriver driver, String Fare_Type) throws InterruptedException {
        selectFareType.click(); // Click on fare type selection
        Thread.sleep(500); // Wait for a short duration
        
        // Conditional selection of fare type
        if (Fare_Type.contentEquals("Refundable")) {
            refundable.click(); // Click on refundable option
            Thread.sleep(500); // Wait for a short duration
        } else {
            nonrefundable.click(); // Click on non-refundable option
            Thread.sleep(500); // Wait for a short duration
        }
    }
	
 // Method to select breakfast options
    public void selecttheBrekfastoption(WebDriver driver) throws InterruptedException {
        selectBrekfast.click(); // Click on the breakfast selection option
        Thread.sleep(500); // Wait for half a second to ensure the action is completed
        withBrekfast.click(); // Click on the option for breakfast included
        Thread.sleep(500); // Wait for half a second after selection
    }

    // Method to select hotel star ratings based on user input
    public void selecttherating(WebDriver driver, String STAR_RATING) throws InterruptedException {
        Thread.sleep(500); // Wait for half a second to ensure the UI is ready
        selectStarRating.click(); // Click on the star rating selection element
        Thread.sleep(500); // Wait for the star rating options to appear
        
        // Retrieve all checkbox elements representing star ratings
        List<WebElement> starrating = driver.findElements(By.xpath("//input[@type='checkbox']"));
        
        // Iterate through each star rating checkbox
        for (WebElement rating : starrating) {
            String Star = rating.getAttribute("id"); // Get the ID of the current star rating checkbox
            
            if (Star.equals(STAR_RATING)) { // Check if the current rating matches the desired rating
                rating.click(); // Click on the matching star rating checkbox
            } else {
                // If the current rating does not match, click all checkboxes (possibly to uncheck others)
                for (WebElement checkbox : starrating) {
                    checkbox.click(); // Click to check or uncheck each checkbox
                }
            }
        }
    }

    // Method to click on a hotel selection
    public void clickOnHotel(WebDriver driver) throws InterruptedException {
        clickHotel.click(); // Click on the hotel element to proceed
        Thread.sleep(1000); // Wait for one second to ensure the action is completed
    }

    // Method to search and select a city for hotel booking
    public void searchselectCity(WebDriver driver, String city) throws InterruptedException {
        searchCity.click(); // Click on the city search input field
        Thread.sleep(1000); // Wait for one second to ensure the input field is ready
        searchCityname.sendKeys(city); // Enter the city name into the search field
        Thread.sleep(2000); // Wait for two seconds to allow search results to load

        // Initialize WebDriverWait to wait for the autocomplete suggestions to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='theme4_hotel_autocomplete_name__d_Rwx']"))); // Wait for the popup to appear
        
        // Retrieve all suggested city names
        List<WebElement> autosuggest = driver.findElements(By.xpath("//div[@class='theme4_hotel_autocomplete_name__d_Rwx']"));
        
        // Iterate through the list of suggested cities
        for (WebElement Citys : autosuggest) {
            logger.info(Citys.getText()); // Log the name of the city suggestion
            
            // Check if the suggestion matches the desired city
            if (Citys.getText().contains(city)) {
                // Click on the matching city suggestion using JavaScript to ensure proper interaction
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Citys);
                break; // Exit the loop after clicking the city
            }
            
            Thread.sleep(200); // Wait for a short duration before the next iteration
        }

        // Log the selected city name for verification
        logger.info("The city name is :" + city);
    }

	
	
	
 // Method to select dates for a trip, using the WebDriver to interact with the web elements.
    public void SelectDatefortrip(WebDriver driver, String month, String rmonth, String departureDate,
                                   String returnDate) throws InterruptedException {
        
        // Create a Random object to generate random numbers.
        Random random = new Random();

        // Define ranges for generating random departure and return dates.
        int min = 1; // Minimum value for departure date
        int max = 15; // Maximum value for departure date
        int min1 = 16; // Minimum value for return date
        int max1 = 30; // Maximum value for return date

        // Generate random dates within the specified ranges.
        int randomNumberInRange = random.nextInt(max - min) + min; // Random departure date
        int randomNumberInRange1 = random.nextInt(max1 - min1) + min1; // Random return date
        
        // Convert the random numbers to string for usage.
        String strNumber = String.valueOf(randomNumberInRange);
        String strNumber1 = String.valueOf(randomNumberInRange1);

        // Wait for the departure calendar element to be visible.
        commonMethodes.waitForElementToBeVisible(driver, departureCalander, 1);
        Thread.sleep(1000); // Sleep for a brief moment to allow UI to settle.
        
        // Select the departure date using the selectDate method.
        selectDate(driver, month, departureDate);

        Thread.sleep(1000); // Sleep for a brief moment to allow UI to settle.
        
        // Wait for the return calendar element to be visible.
        commonMethodes.waitForElementToBeVisible(driver, returnCalander, 3);
        Thread.sleep(500); // Sleep for a brief moment to allow UI to settle.
        
        // Select the return date using the selectDate method.
        selectDate(driver, rmonth, returnDate);

        Thread.sleep(1000); // Sleep for a brief moment to allow UI to settle.
    }

    // Method to get the index of a matching month element from a list of WebElements.
    public static int getIndexOfMatchingElement(List<WebElement> elements, String month) {
        // Iterate through the list of elements to find the month.
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equalsIgnoreCase(month)) { // Check if the month matches.
                return i; // Return the index of the matching month.
            }
        }
        return -1; // Return -1 if no matching element is found.
    }

    // Method to select a date from the calendar.
    private void selectDate(WebDriver driver, String month, String date) throws InterruptedException {

        // Infinite loop until the desired month is found in the calendar.
        int index;
        while (true) {
            logger.info("checking while loop");
            String text = driver.findElement(By.xpath("//h3")).getText(); // Get the current displayed month.
            logger.info("while current month is " + text);

            // Find all month/year labels in the calendar header.
            List<WebElement> monthYearLabels = driver
                    .findElements(By.xpath("//div[@class='theme4_calendar_head_center_side__nSZEn']//h3"));

            // Check if the desired month is found in the labels.
            boolean isMonthFound = monthYearLabels.stream().anyMatch(ele -> ele.getText().equalsIgnoreCase(month));

            logger.info("while given input month is " + month);
            logger.info("isMonthFound status is " + isMonthFound);

            // Get the index of the matching month.
            index = getIndexOfMatchingElement(monthYearLabels, month);
            logger.info("index value is " + index);

            // If the desired month is found, exit the loop.
            if (isMonthFound) {
                break;
            } else {
                // If not found, click the button to move to the next month.
                logger.info(driver.findElements(By.xpath(
                        "//div[@class='theme4_calendar_head_right_side__o16VX']//span[@class='theme4_calendar_head_icon__Y4clh']//*[name()='svg']"))
                        .size());
                commonMethodes.waitForElementToBeVisible(driver, nextMonthLable, 3);
            }
        }

        // Check if the desired month is the first in the calendar.
        if (index == 0) {
            // Select a date from the left side of the calendar.
            List<WebElement> letftSideDates = driver.findElements(By.xpath(
                    "//div[@class='theme4_calendar_whole_body__8QLJU'][1]//div[@class='theme4_calendar_day_list__fSlRj']//div[@class='theme4_day_cell_center__uTvYe']//span[@class='']"));
            logger.info("user given date is 1 option " + date);

            // Filter the left side dates to find the matching date and click it.
            letftSideDates.stream().filter(ele -> ele.getText().contentEquals(date)).findFirst().ifPresent(element -> {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); // Scroll to the element.
                WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30)); // Wait for the element to be clickable.
                wait1.until(ExpectedConditions.elementToBeClickable(element));
                element.click(); // Click on the element.
            });

        } else {
            // Select a date from the right side of the calendar.
            List<WebElement> rightSideDates = driver.findElements(By.xpath(
                    "//div[@class='theme4_calendar_whole_body__8QLJU'][2]//div[@class='theme4_calendar_day_list__fSlRj']//div[@class='theme4_day_cell_center__uTvYe']//span[@class='']"));

            logger.info("user given date is 2 option " + date);
            
            // Filter the right side dates to find the matching date and click it.
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Wait for up to 30 seconds

            rightSideDates.stream().filter(ele -> ele.getText().contentEquals(date)).findFirst().ifPresent(element -> {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); // Scroll to the element.
                WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30)); // Wait for the element to be clickable.
                wait2.until(ExpectedConditions.elementToBeClickable(element));
                element.click(); // Click on the element.
            });
        }
    }


	
	public void selectRoomPass(WebDriver driver,String AdultString,String childString,String RoomString) throws InterruptedException
	{
		commonMethodes.waitForElementToBeVisible(driver, passanger, 1);
		String stringadult =AdultString;
		Integer adult = Integer.valueOf(stringadult);
		logger.info("No of  Adult is :"+stringadult);
		
		String stringchild = childString;
		Integer Child = Integer.valueOf(stringchild);
		logger.info("No of  Child is :"+stringchild);

		String stringRoom=RoomString;
		Integer Room = Integer.valueOf(stringRoom);
		Thread.sleep(500);
		logger.info("No of  Room is :"+stringRoom);

		
		if(Room==1)
		{
			
		if(adult<=1)
		{for (int i = 0; i < adult; i++) 
		{
						 adultsubtract.click();	
							
				        }}
		
	 else if(adult>=2)
	{for (int i = 0; i < adult-1; i++) 
					 {
						 adult1.click();	
							
				        }}
		
		for (int i = 0; i < Child; i++) {
		child.click(); 
			
        }
		
		if(Child==1)
		{
			room1chilage1.click();
			Thread.sleep(100);
			WebElement element1 = childAgeRoom1;
			((JavascriptExecutor) driver).executeScript("document.querySelector('div[class=\"theme4_hotel_room_list_main__jYmrt\"]').scrollTop=100");
			Thread.sleep(100);
			element1.click();
			Thread.sleep(300);
			
		}
		else if(Child==2)
		{
			room1chilage1.click();
			Thread.sleep(100);
			WebElement element1 = childAgeRoom1;
			((JavascriptExecutor) driver).executeScript("document.querySelector('div[class=\"theme4_hotel_room_list_main__jYmrt\"]').scrollTop=100");
			Thread.sleep(100);
			element1.click();
			Thread.sleep(100);
			room1chilage2.click();
			Thread.sleep(100);
			childAgeRoom1.click();
			
		}
		else if(Child==3)
		{
			room1chilage1.click();
			Thread.sleep(100);
			WebElement element1 = childAgeRoom1;
			((JavascriptExecutor) driver).executeScript("document.querySelector('div[class=\"theme4_hotel_room_list_main__jYmrt\"]').scrollTop=100");
			Thread.sleep(100);
			element1.click();
			room1chilage2.click();
			Thread.sleep(100);
			childAgeRoom1.click();
			Thread.sleep(100);
			room1chilage3.click();
			Thread.sleep(100);
			childAgeRoom1.click();

		}
		
		Thread.sleep(500);
		WebElement element1 = done;
		//((JavascriptExecutor) driver).executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(100);
		element1.click();
		Thread.sleep(1000);
		
		}
			
		else if(Room==2)
		{
			if(adult<=1)
			{for (int i = 0; i < adult; i++) 
			{
							 adultsubtract.click();	
								
					        }}
			
		 else if(adult>=2)
		{for (int i = 0; i < adult-1; i++) 
		{adult1.click();	}}
			Thread.sleep(200);

			for (int i = 0; i < Child; i++) 
			{
			child.click(); 
			Thread.sleep(200);
}
			if(Child==1)
			{
				room1chilage1.click();
				Thread.sleep(100);
				WebElement element1 = childAgeRoom1;
				((JavascriptExecutor) driver).executeScript("document.querySelector('div[class=\"theme4_hotel_room_list_main__jYmrt\"]').scrollTop=100");
				Thread.sleep(100);
				element1.click();
				Thread.sleep(300);
				
			}
			else if(Child==2)
			{
				room1chilage1.click();
				Thread.sleep(100);
				WebElement element1 = childAgeRoom1;
				((JavascriptExecutor) driver).executeScript("document.querySelector('div[class=\"theme4_hotel_room_list_main__jYmrt\"]').scrollTop=100");
				Thread.sleep(100);
				element1.click();
				Thread.sleep(100);
				room1chilage2.click();
				Thread.sleep(100);
				childAgeRoom1.click();
				
			}
			else if(Child==3)
			{
				room1chilage1.click();
				Thread.sleep(100);
				WebElement element1 = childAgeRoom1;
				((JavascriptExecutor) driver).executeScript("document.querySelector('div[class=\"theme4_hotel_room_list_main__jYmrt\"]').scrollTop=100");
				Thread.sleep(100);
				element1.click();
				room1chilage2.click();
				Thread.sleep(100);
				childAgeRoom1.click();
				Thread.sleep(100);
				room1chilage3.click();
				Thread.sleep(100);
				childAgeRoom1.click();

			}
			
			addRoom2.click();
			Thread.sleep(100);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)", "");
			Thread.sleep(500);

		
		for (int i = 0; i < adult-1; i++) 
						 {
			room2Adult.click();	
								
					        }
			
	   for (int i = 0; i < Child; i++) {
			
			room2child.click();
			
			Thread.sleep(100);			

	        }

	   
	   if(Child==1)
		{
			room1chilage1.click();
			Thread.sleep(1000);
			WebElement element1 = childAgeRoom1;
			((JavascriptExecutor) driver).executeScript("document.querySelector('div[class=\"theme4_hotel_room_list_main__jYmrt\"]').scrollTop=500");
			Thread.sleep(500);
			element1.sendKeys(Keys.ENTER);
			Thread.sleep(500);
			
		}
		else if(Child==2)
		{
			room1chilage1.click();
			Thread.sleep(1000);
			WebElement element1 = childAgeRoom1;
			((JavascriptExecutor) driver).executeScript("document.querySelector('div[class=\"theme4_hotel_room_list_main__jYmrt\"]').scrollTop=500");
			Thread.sleep(500);
			element1.click();
			Thread.sleep(500);
			room1chilage2.click();
			Thread.sleep(500);
			childAgeRoom1.click();
			Thread.sleep(500);
	
		}
		else if(Child==3)
		{
			room1chilage1.click();
			Thread.sleep(1000);
			WebElement element1 = childAgeRoom1;
			((JavascriptExecutor) driver).executeScript("document.querySelector('div[class=\"theme4_hotel_room_list_main__jYmrt\"]').scrollTop=500");
			Thread.sleep(100);
			element1.click();
			Thread.sleep(500);
			room1chilage2.click();
			Thread.sleep(500);
			childAgeRoom1.click();
			Thread.sleep(500);
			room1chilage3.click();
			Thread.sleep(500);
			childAgeRoom1.click();
			Thread.sleep(500);

		}
		Thread.sleep(500);
		WebElement element1 = done;
	((JavascriptExecutor) driver).executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(100);
		element1.click();
		Thread.sleep(1000);
		
	   
		}
		else if(Room==3)
		{

			if(adult<=1)
			{for (int i = 0; i < adult; i++) 
			{
							 adultsubtract.click();	
								
					        }}
			
		 else if(adult>=2)
		{for (int i = 0; i < adult-1; i++) 
		{adult1.click();	}}
			Thread.sleep(200);

			for (int i = 0; i < Child; i++) 
			{
			child.click(); 
			Thread.sleep(200);
}
			if(Child==1)
			{
				room1chilage1.click();
				Thread.sleep(100);
				WebElement element1 = childAgeRoom1;
				((JavascriptExecutor) driver).executeScript("document.querySelector('div[class=\"theme4_hotel_room_list_main__jYmrt\"]').scrollTop=100");
				Thread.sleep(100);
				element1.click();
				Thread.sleep(300);
				
			}
			else if(Child==2)
			{
				room1chilage1.click();
				Thread.sleep(100);
				WebElement element1 = childAgeRoom1;
				((JavascriptExecutor) driver).executeScript("document.querySelector('div[class=\"theme4_hotel_room_list_main__jYmrt\"]').scrollTop=100");
				Thread.sleep(100);
				element1.click();
				Thread.sleep(100);
				room1chilage2.click();
				Thread.sleep(100);
				childAgeRoom1.click();
				
			}
			else if(Child==3)
			{
				room1chilage1.click();
				Thread.sleep(100);
				WebElement element1 = childAgeRoom1;
				((JavascriptExecutor) driver).executeScript("document.querySelector('div[class=\"theme4_hotel_room_list_main__jYmrt\"]').scrollTop=100");
				Thread.sleep(100);
				element1.click();
				room1chilage2.click();
				Thread.sleep(100);
				childAgeRoom1.click();
				Thread.sleep(100);
				room1chilage3.click();
				Thread.sleep(100);
				childAgeRoom1.click();

			}
			
			addRoom2.click();
			Thread.sleep(100);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)", "");
			Thread.sleep(500);

		
		for (int i = 0; i < adult-1; i++) 
						 {
			room2Adult.click();	
								
					        }
			
	   for (int i = 0; i < Child; i++) {
			
			room2child.click();
			
			Thread.sleep(100);			

	        }

	   
	   if(Child==1)
		{
			room1chilage1.click();
			Thread.sleep(1000);
			WebElement element1 = childAgeRoom1;
			((JavascriptExecutor) driver).executeScript("document.querySelector('div[class=\"theme4_hotel_room_list_main__jYmrt\"]').scrollTop=500");
			Thread.sleep(500);
			element1.sendKeys(Keys.ENTER);
			Thread.sleep(500);
			
		}
		else if(Child==2)
		{
			room1chilage1.click();
			Thread.sleep(1000);
			WebElement element1 = childAgeRoom1;
			((JavascriptExecutor) driver).executeScript("document.querySelector('div[class=\"theme4_hotel_room_list_main__jYmrt\"]').scrollTop=500");
			Thread.sleep(500);
			element1.click();
			Thread.sleep(500);
			room1chilage2.click();
			Thread.sleep(500);
			childAgeRoom1.click();
			Thread.sleep(500);
	
		}
		else if(Child==3)
		{
			room1chilage1.click();
			Thread.sleep(1000);
			WebElement element1 = childAgeRoom1;
			((JavascriptExecutor) driver).executeScript("document.querySelector('div[class=\"theme4_hotel_room_list_main__jYmrt\"]').scrollTop=500");
			Thread.sleep(100);
			element1.click();
			Thread.sleep(500);
			room1chilage2.click();
			Thread.sleep(500);
			childAgeRoom1.click();
			Thread.sleep(500);
			room1chilage3.click();
			Thread.sleep(500);
			childAgeRoom1.click();
			Thread.sleep(500);

		}
	
   
			
	   
		addRoom3.click();
		
		
	for (int i = 0; i < adult-1; i++) 
					 {
		room3Adult.click();	
							
				        }
		
  for (int i = 0; i < Child; i++) {
	   room3child.click(); 
			
       }
		
  
  if(Child==1)
	{
		room1chilage1.click();
		Thread.sleep(1000);
		WebElement element1 = childAgeRoom1;
		((JavascriptExecutor) driver).executeScript("document.querySelector('div[class=\"theme4_hotel_room_list_main__jYmrt\"]').scrollTop=500");
		Thread.sleep(500);
		element1.click();
		Thread.sleep(500);
		
	}
	else if(Child==2)
	{
		room1chilage1.click();
		Thread.sleep(1000);
		WebElement element1 = childAgeRoom1;
		((JavascriptExecutor) driver).executeScript("document.querySelector('div[class=\"theme4_hotel_room_list_main__jYmrt\"]').scrollTop=500");
		Thread.sleep(500);
		element1.click();
		Thread.sleep(500);
		room1chilage2.click();
		Thread.sleep(500);
		childAgeRoom1.click();
		Thread.sleep(500);

	}
	else if(Child==3)
	{
		room1chilage1.click();
		Thread.sleep(1000);
		WebElement element1 = childAgeRoom1;
		((JavascriptExecutor) driver).executeScript("document.querySelector('div[class=\"theme4_hotel_room_list_main__jYmrt\"]').scrollTop=500");
		Thread.sleep(100);
		element1.click();
		Thread.sleep(500);
		room1chilage2.click();
		Thread.sleep(500);
		childAgeRoom1.click();
		Thread.sleep(500);
		room1chilage3.click();
		Thread.sleep(500);
		childAgeRoom1.click();
		Thread.sleep(500);

	}
	   
	   
	   
		Thread.sleep(500);
		WebElement element1 = done;
		//((JavascriptExecutor) driver).executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(100);
		element1.click();
		Thread.sleep(1000);
		
	   
		
			
			
		}
		else if(Room==4)
		{

			if(adult<=1)
			{for (int i = 0; i < adult; i++) 
			{
							 adultsubtract.click();	
								
					        }}
			
		 else if(adult>=2)
		{for (int i = 0; i < adult-1; i++) 
		        {adult1.click();	}}
			Thread.sleep(200);

			for (int i = 0; i < Child; i++) 
			{
			child.click(); 
			Thread.sleep(200);
}
			if(Child==1)
			{
				room1chilage1.click();
				Thread.sleep(100);
				WebElement element1 = childAgeRoom1;
				((JavascriptExecutor) driver).executeScript("document.querySelector('div[class=\"theme4_hotel_room_list_main__jYmrt\"]').scrollTop=100");
				Thread.sleep(100);
				element1.click();
				Thread.sleep(300);
				
			}
			else if(Child==2)
			{
				room1chilage1.click();
				Thread.sleep(100);
				WebElement element1 = childAgeRoom1;
				((JavascriptExecutor) driver).executeScript("document.querySelector('div[class=\"theme4_hotel_room_list_main__jYmrt\"]').scrollTop=100");
				Thread.sleep(100);
				element1.click();
				Thread.sleep(100);
				room1chilage2.click();
				Thread.sleep(100);
				childAgeRoom1.click();
				
			}
			else if(Child==3)
			{
				room1chilage1.click();
				Thread.sleep(100);
				WebElement element1 = childAgeRoom1;
				((JavascriptExecutor) driver).executeScript("document.querySelector('div[class=\"theme4_hotel_room_list_main__jYmrt\"]').scrollTop=100");
				Thread.sleep(100);
				element1.click();
				room1chilage2.click();
				Thread.sleep(100);
				childAgeRoom1.click();
				Thread.sleep(100);
				room1chilage3.click();
				Thread.sleep(100);
				childAgeRoom1.click();

			}
			
			addRoom2.click();
			Thread.sleep(100);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)", "");
			Thread.sleep(500);

		
		for (int i = 0; i < adult-1; i++) 
						 {
			room2Adult.click();	
								
					        }
			
	   for (int i = 0; i < Child; i++) {
			
			room2child.click();
			
			Thread.sleep(100);			

	        }

	   
	   if(Child==1)
		{
			room1chilage1.click();
			Thread.sleep(1000);
			WebElement element1 = childAgeRoom1;
			((JavascriptExecutor) driver).executeScript("document.querySelector('div[class=\"theme4_hotel_room_list_main__jYmrt\"]').scrollTop=500");
			Thread.sleep(500);
			element1.sendKeys(Keys.ENTER);
			Thread.sleep(500);
			
		}
		else if(Child==2)
		{
			room1chilage1.click();
			Thread.sleep(1000);
			WebElement element1 = childAgeRoom1;
			((JavascriptExecutor) driver).executeScript("document.querySelector('div[class=\"theme4_hotel_room_list_main__jYmrt\"]').scrollTop=500");
			Thread.sleep(500);
			element1.click();
			Thread.sleep(500);
			room1chilage2.click();
			Thread.sleep(500);
			childAgeRoom1.click();
			Thread.sleep(500);
	
		}
		else if(Child==3)
		{
			room1chilage1.click();
			Thread.sleep(1000);
			WebElement element1 = childAgeRoom1;
			((JavascriptExecutor) driver).executeScript("document.querySelector('div[class=\"theme4_hotel_room_list_main__jYmrt\"]').scrollTop=500");
			Thread.sleep(100);
			element1.click();
			Thread.sleep(500);
			room1chilage2.click();
			Thread.sleep(500);
			childAgeRoom1.click();
			Thread.sleep(500);
			room1chilage3.click();
			Thread.sleep(500);
			childAgeRoom1.click();
			Thread.sleep(500);

		}
	
   
			
	   
		addRoom3.click();
		
		
	for (int i = 0; i < adult-1; i++) 
					 {
		room3Adult.click();	
							
				        }
		
  for (int i = 0; i < Child; i++) {
	   room3child.click(); 
			
       }
		
  
  if(Child==1)
	{
		room1chilage1.click();
		Thread.sleep(1000);
		WebElement element1 = childAgeRoom1;
		((JavascriptExecutor) driver).executeScript("document.querySelector('div[class=\"theme4_hotel_room_list_main__jYmrt\"]').scrollTop=500");
		Thread.sleep(500);
		element1.click();
		Thread.sleep(500);
		
	}
	else if(Child==2)
	{
		room1chilage1.click();
		Thread.sleep(1000);
		WebElement element1 = childAgeRoom1;
		((JavascriptExecutor) driver).executeScript("document.querySelector('div[class=\"theme4_hotel_room_list_main__jYmrt\"]').scrollTop=500");
		Thread.sleep(500);
		element1.click();
		Thread.sleep(500);
		room1chilage2.click();
		Thread.sleep(500);
		childAgeRoom1.click();
		Thread.sleep(500);

	}
	else if(Child==3)
	{
		room1chilage1.click();
		Thread.sleep(1000);
		WebElement element1 = childAgeRoom1;
		((JavascriptExecutor) driver).executeScript("document.querySelector('div[class=\"theme4_hotel_room_list_main__jYmrt\"]').scrollTop=500");
		Thread.sleep(100);
		element1.click();
		Thread.sleep(500);
		room1chilage2.click();
		Thread.sleep(500);
		childAgeRoom1.click();
		Thread.sleep(500);
		room1chilage3.click();
		Thread.sleep(500);
		childAgeRoom1.click();
		Thread.sleep(500);

	}
	   
	   
	addRoom4.click();
	
	
for (int i = 0; i < adult-1; i++) 
				 {
	room4Adult.click();	
						
			        }
	
for (int i = 0; i < Child; i++) {
 room4child.click(); 
		
 }
	
if(Child==1)
	{
		room1chilage1.click();
		Thread.sleep(1000);
		WebElement element1 = childAgeRoom1;
		((JavascriptExecutor) driver).executeScript("document.querySelector('div[class=\"theme4_hotel_room_list_main__jYmrt\"]').scrollTop=500");
		Thread.sleep(500);
		element1.sendKeys(Keys.ENTER);
		Thread.sleep(500);
		
	}
	else if(Child==2)
	{
		room1chilage1.click();
		Thread.sleep(1000);
		WebElement element1 = childAgeRoom1;
		((JavascriptExecutor) driver).executeScript("document.querySelector('div[class=\"theme4_hotel_room_list_main__jYmrt\"]').scrollTop=500");
		Thread.sleep(500);
		element1.click();
		Thread.sleep(500);
		room1chilage2.click();
		Thread.sleep(500);
		childAgeRoom1.click();
		Thread.sleep(500);

	}
	else if(Child==3)
	{
		room1chilage1.click();
		Thread.sleep(1000);
		WebElement element1 = childAgeRoom1;
		((JavascriptExecutor) driver).executeScript("document.querySelector('div[class=\"theme4_hotel_room_list_main__jYmrt\"]').scrollTop=500");
		Thread.sleep(100);
		element1.click();
		Thread.sleep(500);
		room1chilage2.click();
		Thread.sleep(500);
		childAgeRoom1.click();
		Thread.sleep(500);
		room1chilage3.click();
		Thread.sleep(500);
		childAgeRoom1.click();
		Thread.sleep(500);

	}
	   
		Thread.sleep(500);
		WebElement element1 = done;
		//((JavascriptExecutor) driver).executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(100);
		element1.click();
		Thread.sleep(1000);
		
	   
		
			
			
		
		}
		else if(Room==5)
		{



			if(adult<=1)
			{for (int i = 0; i < adult; i++) 
			{
							 adultsubtract.click();	
								
					        }}
			
		 else if(adult>=2)
		{for (int i = 0; i < adult-2; i++) 
						 {
							 adult1.click();	
								
					        }}
			
			for (int i = 0; i < Child; i++) {
			child.click(); 
				
	        }
			
			if(Child==1)
			{
				room1chilage1.click();
				Thread.sleep(100);
				childAgeRoom1.click();
			}
			else if(Child==2)
			{
				room1chilage1.click();
				Thread.sleep(100);
				childAgeRoom1.click();
				Thread.sleep(100);
				room1chilage2.click();
				Thread.sleep(100);
				childAgeRoom1.click();
				
			}
			else if(Child==3)
			{
				room1chilage1.click();
				Thread.sleep(100);
				childAgeRoom1.click();
				Thread.sleep(100);
				room1chilage2.click();
				Thread.sleep(100);
				childAgeRoom1.click();
				Thread.sleep(100);
				room1chilage3.click();
				Thread.sleep(100);
				childAgeRoom1.click();

			}	
			
			addRoom2.click();
			
		
		for (int i = 0; i < adult-1; i++) 
						 {
			room2Adult.click();	
								
					        }
			
	   for (int i = 0; i < Child; i++) {
		   room2child.click(); 
				
	        }
			
	   if(Child==1)
		{
		   room2chilage1.click();
			Thread.sleep(100);
			room2selectAge.click();
		}
		else if(Child==2)
		{
			room2chilage1.click();
			Thread.sleep(100);
			room2selectAge.click();
			Thread.sleep(100);
			room2chilage2.click();
			Thread.sleep(100);
			room2selectAge.click();
			
		}
		else if(Child==3)
		{
			room2chilage1.click();
			Thread.sleep(100);
			room2selectAge.click();
			Thread.sleep(100);
			room2chilage2.click();
			Thread.sleep(100);
			room2selectAge.click();
			Thread.sleep(100);
			room2chilage3.click();
			Thread.sleep(100);
			room2selectAge.click();

		}	
	   
		addRoom3.click();
		
		
	for (int i = 0; i < adult-1; i++) 
					 {
		room3Adult.click();	
							
				        }
		
  for (int i = 0; i < Child; i++) {
	   room3child.click(); 
			
       }
		
  if(Child==1)
	{
	   room3chilage1.click();
		Thread.sleep(100);
		room3selectAge.click();
	}
	else if(Child==2)
	{
		room3chilage1.click();
		Thread.sleep(100);
		room3selectAge.click();
		Thread.sleep(100);
		room3chilage2.click();
		Thread.sleep(100);
		room3selectAge.click();
		
	}
	else if(Child==3)
	{
		room3chilage1.click();
		Thread.sleep(100);
		room3selectAge.click();
		Thread.sleep(100);
		room3chilage2.click();
		Thread.sleep(100);
		room3selectAge.click();
		Thread.sleep(100);
		room3chilage3.click();
		Thread.sleep(100);
		room3selectAge.click();

	}	
	   
	addRoom4.click();
	
	
for (int i = 0; i < adult-1; i++) 
				 {
	room4Adult.click();	
						
			        }
	
for (int i = 0; i < Child; i++) {
 room4child.click(); 
		
 }
	
if(Child==1)
{
 room4chilage1.click();
	Thread.sleep(100);
	room4selectAge.click();
}
else if(Child==2)
{
	room4chilage1.click();
	Thread.sleep(100);
	room4selectAge.click();
	Thread.sleep(100);
	room4chilage2.click();
	Thread.sleep(100);
	room4selectAge.click();
	
}
else if(Child==3)
{
	room4chilage1.click();
	Thread.sleep(100);
	room4selectAge.click();
	Thread.sleep(100);
	room4chilage2.click();
	Thread.sleep(100);
	room4selectAge.click();
	Thread.sleep(100);
	room4chilage3.click();
	Thread.sleep(100);
	room4selectAge.click();

} 
	   
addRoom5.click();


for (int i = 0; i < adult-1; i++) 
			 {
room5Adult.click();	
					
		        }

for (int i = 0; i < Child; i++) {
room5child.click(); 
	
}

if(Child==1)
{
room5chilage1.click();
Thread.sleep(100);
room5selectAge.click();
}
else if(Child==2)
{
room5chilage1.click();
Thread.sleep(100);
room5selectAge.click();
Thread.sleep(100);
room5chilage2.click();
Thread.sleep(100);
room5selectAge.click();

}
else if(Child==3)
{
room5chilage1.click();
Thread.sleep(100);
room5selectAge.click();
Thread.sleep(100);
room5chilage2.click();
Thread.sleep(100);
room5selectAge.click();
Thread.sleep(100);
room5chilage3.click();
Thread.sleep(100);
room5selectAge.click();

} 
		Thread.sleep(500);
		WebElement element1 = done;
		//((JavascriptExecutor) driver).executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(100);
		element1.click();
		Thread.sleep(100);
		
	   
		
			
			
		
			
		}
		
	
  
	}
	
	
	
	
	
	
	
	
	
	
	public void clickSearch(WebDriver driver) throws InterruptedException
	{
	    // Define the search element to be clicked
	    WebElement element = search;
	    
	    // Scroll up the view to ensure the search element is in view
	    commonMethodes.scrollUp(driver);
	    
	    // Pause for a short duration to allow the page to load
	    Thread.sleep(500);	
	    
	    // Click on the search element
	    element.click();
	}

	public void clickQuickfilter(WebDriver driver) throws InterruptedException
	{
	    // Initialize WebDriverWait for waiting for elements to be visible
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	    
	    // Wait until the specific popup element is visible
	    WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@class='theme4_ax_hotels_result_number__S7di4'])[1]")));
	    
	    // Scroll the view to the free breakfast filter
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", freeBreakfast);
	    
	    // Click on the free breakfast filter
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", freeBreakfast);
	}

	public void clickStarRating(WebDriver driver) throws InterruptedException
	{
	    try {
	        // Initialize WebDriverWait for waiting for elements to be visible
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	        
	        // Wait until the specific popup element is visible
	        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@class='theme4_ax_hotels_result_number__S7di4'])[1]")));
	        
	        // Scroll the view to the star rating element
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectstar);
	        
	        // Click on the star rating filter
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectstar);
	        
	    } catch (Exception e) {
	        // Log if the element is not available for selecting the hotel
	        logger.info("The element is not available for select Hotel");
	    }
	}

	public void clickPriceRange(WebDriver driver) throws InterruptedException
	{
	    try {
	        // Initialize WebDriverWait for waiting for elements to be visible
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	        
	        // Wait until the specific popup element is visible
	        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@class='theme4_ax_hotels_result_number__S7di4'])[1]")));
	        
	        // Scroll to the drag start element to set price range
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dragStart);
	        
	        // Short pause before interacting with the element
	        Thread.sleep(500);
	        
	        // Get the width of the drag start and drag end elements
	        int xside = dragStart.getSize().width;
	        int xside1 = dragEnd.getSize().width;
	        
	        // Create an Actions object for drag and drop
	        Actions act = new Actions(driver);
	        
	        // Perform drag and drop action to set the price range
	        act.dragAndDropBy(dragStart, xside * 6, 0).build().perform();
	        
	        // Short pause after the action
	        Thread.sleep(500);
	        
	    } catch (Exception e) {
	        // Log if the element is not available for selecting the hotel
	        logger.info("The element is not available for select Hotel");
	    }
	}

	public void clickPriceAmenities(WebDriver driver) throws InterruptedException
	{
	    try {
	        // Initialize WebDriverWait for waiting for elements to be visible
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	        
	        // Wait until the specific popup element is visible
	        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@class='theme4_ax_hotels_result_number__S7di4'])[1]")));
	        
	        // Scroll to the amenities element
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", amenities);
	        
	        // Click on the amenities filter
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", amenities);
	        
	    } catch (Exception e) {
	        // Log if the element is not available for selecting the hotel
	        logger.info("The element is not available for select Hotel");
	    }
	}

	public void clickPriceVacationTypefilter(WebDriver driver) throws InterruptedException
	{
	    try {
	        // Initialize WebDriverWait for waiting for elements to be visible
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	        
	        // Wait until the specific popup element is visible
	        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@class='theme4_ax_hotels_result_number__S7di4'])[1]")));
	        
	        // Scroll to the vacation type filter
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", vacationType);
	        
	        // Click on the vacation type filter
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", vacationType);
	        
	    } catch (Exception e) {
	        // Log if the element is not available for selecting the hotel
	        logger.info("The element is not available for select Hotel");
	    }
	}

	public void clickPricePropertyTypefilter(WebDriver driver) throws InterruptedException
	{
	    try {
	        // Initialize WebDriverWait for waiting for elements to be visible
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	        
	        // Wait until the specific popup element is visible
	        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@class='theme4_ax_hotels_result_number__S7di4'])[1]")));
	        
	        // Scroll to the property type filter
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", propertyType);
	        
	        // Click on the property type filter
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", propertyType);
	        
	    } catch (Exception e) {
	        // Log if the element is not available for selecting the hotel
	        logger.info("The element is not available for select Hotel");
	    }
	}

	public void clickSearchForRounttrip(WebDriver driver) throws InterruptedException
	{
	    // Wait for the search element to be visible
	    commonMethodes.waitForElementToBeVisible(driver, search, 1);
	    
	    // Pause for 5 seconds to allow the page to load
	    Thread.sleep(5000);
	}

	public void selectHotel(WebDriver driver) throws InterruptedException
	{
	    try {
	        // Initialize WebDriverWait for waiting for elements to be visible
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	        
	        // Wait until the specific popup element is visible
	        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@class='theme4_ax_hotels_result_number__S7di4'])[1]")));
	        
	        // Scroll to the select hotel element and click it
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectHotel);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectHotel);
	        
	    } catch (Exception e) {
	        // Log the error if no matching fare type is found
	        logger.error("Error: No matching fare type found for");
	        
	        // Fail the test case and close the driver
	        Assert.fail("Error: No matching fare type found for: ");
	        driver.close();
	    }
	}

	public void handelRoomnotavailablePopup(WebDriver driver) throws InterruptedException
	{
	    try {
	        // Initialize WebDriverWait for waiting for elements to be visible
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
	        // Wait until the specific popup element is visible
	        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='theme4_alertbutton__8zRK0']")));
	        
	        // Click on the close button of the popup
	        driver.findElement(By.xpath("//div[@class='ModalPopupComponent_modal_close__fOtZP']//*[name()='svg']")).click();
	        
	    } catch (Exception e) {
	        // Log if the popup is not available
	        logger.info("The popup is not Available");
	    }
	}

	public void selectRoom(WebDriver driver, String FareType) throws InterruptedException
	{
		
		

	    Set<String> handel = driver.getWindowHandles();  
	    Iterator<String> it = handel.iterator();   
	    String parantwindow = it.next();
	    String childwindow = it.next(); 
	    driver.switchTo().window(childwindow);
	    Thread.sleep(500);
	    


		   	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		   	 WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@alt='calender'])[1]")));
		     Thread.sleep(500);

		     String Name = hotelName.getText();
		     System.out.println("The Currant Hotel Name is :"+Name);
		     
		     Thread.sleep(500);

		     ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,850)", "");
		     Thread.sleep(500);
		     //selectRoom.click();
		    // Thread.sleep(2000);
		     
		  // Locate the list of rooms
		     List<WebElement> rooms = driver.findElements(By.xpath("//*[text()='Starting From']"));

		     System.out.println("Number of rooms: " + rooms.size());

		     boolean ticketFound = false;

		     // Define a loop control variable for the main room iteration
		     boolean continueIteration = true;

		     while (continueIteration) {
		         // Iterate through each room
		         for (WebElement room : rooms) {
		             ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", room);
		             room.click();
		           //  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'theme4_fully_refundable__BXoIe')]"))); // Ensure the room details are fully expanded

		             // Re-locate the select buttons and tickets after expanding room details
		             List<WebElement> selectors = driver.findElements(By.xpath("//button[@class='theme4_srp_desktop_btn__aQOWM theme4_srp_tab_btn__slXIC'][normalize-space()='Select']"));
		             List<WebElement> tickets = driver.findElements(By.xpath("//div[@class='theme4_fully_refundable__BXoIe']//p[1]"));

		             // Interact with the tickets
		             for (int i = 0; i < tickets.size(); i++) {
		                 WebElement ticket = tickets.get(i);
		                 WebElement selectButton = selectors.get(i);

		                 String text = ticket.getText();
		                 System.out.println("The ticket Fare Type is: " + text);
		                 System.out.println("The ticket Fare Type from the excel sheet is: " + FareType);

		                 if (text.equals(FareType)) {
		                     try {
		                    	 
		                         if (i == 0) {
		                             // Directly click the select button if i == 0
			 							((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectors.get(i));
		                         } else {
		                        	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",selectors.get(i));
		 							((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectors.get(i));
		                         }
		                         ticketFound = true;
		                         continueIteration = false; // Stop the outer loop
		                         break; // Exit the  inner loop if the ticket is found
		                     } catch (Exception e) {
		                         System.out.println("Failed to click the select button: " + e.getMessage());
		                     }
		                 }
		             }

		             if (ticketFound) {
		                 break; // Exit the outer loop if the ticket is found
		             }
		         }

		         if (!ticketFound) {// Store the flag to check if the first XPath has been used
		        	 boolean firstXPathUsed = false;

		        	 while (!ticketFound && continueIteration) {
		        	     try {
		        	         String nextButtonXPath;

		        	         if (!firstXPathUsed) {
		        	             // Use the first XPath only once
		        	             nextButtonXPath = "//div[@class='theme4_hotel_room_types__2d_mQ theme4_hotel_details_body__Y607w']//img[@alt='arrow']";
		        	             firstXPathUsed = true;
		        	         } else {
		        	             // Use the second XPath for all subsequent clicks
		        	             nextButtonXPath = "(//img[@alt='arrow'])[3]";
		        	         }

		        	         try {
		        	             WebElement nextButton = driver.findElement(By.xpath(nextButtonXPath));
		        	             ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		        	             nextButton.click();

		        	             try {
		        	                 // Wait for the new elements to load after clicking the next button
		        	                 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[text()='Starting From']")));

		        	                 // Re-locate the list of rooms after clicking next
		        	                 List<WebElement> room = driver.findElements(By.xpath("//*[text()='Starting From']"));

		        	                 System.out.println("Number of rooms after clicking next: " + room.size());
		        	             } catch (Exception e) {
		        	                 System.out.println("Failed to find rooms after clicking next: " + e.getMessage());
		        	                 continueIteration = false; // Stop the loop if rooms are not found after clicking next
		        	             }
		        	         } catch (Exception e) {
		        	             System.out.println("Failed to find or click the next button using XPath: " + nextButtonXPath);
		        	             continueIteration = false; // Stop the loop if next button is not found or fails to click
		        	         }

		        	     } catch (Exception e) {
		        	         System.out.println("Exception occurred: " + e.getMessage());
		        	         continueIteration = false; // Stop the loop in case of an exception
		        	     }
		        	 }
	}
		     }

		     if (ticketFound) {
		         System.out.println("Ticket matching the Fare Type found and clicked.");
		     } else {
		   	 
		    	 System.err.println("The matching ticket is not found "+FareType);
			     // Fail the test case
			        Assert.fail("Error: The matching ticket is not found  for :"+FareType);
			        driver.close();		     }
	     

		    }
	
	
	// Method to add a percentage markup based on whether it is a markdown
	public void AddMarkupinpercentage(WebDriver driver, boolean isMark_Down) throws InterruptedException {
	    // Check if it is a markdown operation
	    if (isMark_Down) {
	        // Initialize WebDriverWait to wait for a maximum of 100 seconds for the popup to become visible
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	        // Wait until the specific popup element is visible
	        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/h2[1]")));
	        
	        // Sleep for 500 milliseconds to allow for UI updates
	        Thread.sleep(500);
	        
	        // Scroll to the selectMarkdown element and click it
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectMarkdown);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectMarkdown);
	        
	        // Sleep for 1000 milliseconds to ensure the click action is registered and UI is updated
	        Thread.sleep(1000);
	    }
	}

	// Method to add a fixed type markup based on percentage or flat value
	public void AddMarkupinFixedtype(WebDriver driver, boolean ispersent, String percentflatvalue) throws InterruptedException {     
	    // Check if the markup is based on percentage
	    if (ispersent) {
	        // Initialize WebDriverWait to wait for a maximum of 100 seconds for the popup to become visible
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	        // Wait until the specific popup element is visible
	        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/h2[1]")));
	        
	        // Scroll to the selectpercent element and click it
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectpercent);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectpercent);   
	        
	        // Enter the percentage flat value into the input field
	        passpercent.sendKeys(percentflatvalue); 
	    } else {
	        // Same waiting mechanism for the case where it is not a percentage
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/h2[1]")));
	        
	        // Scroll to the selectpercent element (not clicked in this case)
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectpercent);
	        
	        // Enter the percentage flat value into the input field
	        passpercent.sendKeys(percentflatvalue); 
	    }
	}
	
	// Method to add local taxes by sending a specified tax value to the input field
	public void Addlocaltaxes(WebDriver driver, String LOCAL_TAX) throws InterruptedException {
	    // Initialize WebDriverWait to wait for a maximum of 100 seconds for the popup to become visible
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	    
	    // Wait until the specific popup element is visible
	    WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/h2[1]")));
	    
	    // Scroll to the passlocaltaxes input field to ensure it's in view
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", passlocaltaxes);
	    
	    // Send the specified local tax value to the input field
	    passlocaltaxes.sendKeys(LOCAL_TAX);
	}

	// Method to calculate the total amount displayed on the review page
	public void calculatetheAmountOnReviewPage(WebDriver driver) throws InterruptedException {

	    // Scroll down to the fare detail section to ensure it's in view
	    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)", "");

	    // Initialize a map to store fare details and their corresponding values
	    java.util.Map<String, Double> fareDetails = new java.util.HashMap<>();

	    // Array of fare labels to match with extracted values
	    String[] fareLabels = { "Hotel Charges", "My Earning (Incl. of Taxes)", "Taxes", "Seats", "Mealss",
	            "Baggage", "Platform Fees:", "GST:" };

	    // Retrieve Hotel Charges and their amounts
	    List<WebElement> labelList = driver.findElements(By.xpath("//div[@class='theme4_booking_summary_grid_container__nXlBT']//p[normalize-space()='Hotel Charges']"));
	    int labelSize = labelList.size();
	    List<WebElement> priceList = driver.findElements(By.xpath("//div[@class='theme4_booking_summary_grid_container__nXlBT']//div[@class='theme4_person_count__JUIb8']"));
	    int priceSize = priceList.size();

	    // Retrieve Taxes and their amounts
	    List<WebElement> labelList1 = driver.findElements(By.xpath("//div[@class='theme4_booking_summary_grid_container__nXlBT']//div[@class='theme4_taxes_1__uDttO']"));
	    int labelSize1 = labelList1.size();
	    List<WebElement> priceList1 = driver.findElements(By.xpath("//div[@class='theme4_booking_summary_grid_container__nXlBT']//div[@class='theme4_tax_amount__dKcnP']"));
	    int priceSize1 = priceList1.size();

	    // Retrieve My Earnings (Incl. of Taxes) and their amounts
	    List<WebElement> labelList2 = driver.findElements(By.xpath("(//div[@class='theme4_booking_summary_grid_container__nXlBT']//div[@class='theme4_hotel_base_ticket_fare__rDSQG'])[2]"));
	    int labelSize2 = labelList2.size();
	    List<WebElement> priceList2 = driver.findElements(By.xpath("//div[@class='theme4_booking_summary_grid_container__nXlBT']//div[@class='theme4_flight_base_ticket_price__5HTvF']"));
	    int priceSize2 = priceList2.size();

	    // Loop through the label lists and populate fareDetails map with their corresponding amounts
	    for (int i = 0; i < labelSize; i++) {
	        for (String label : fareLabels) {
	            String currentLabel = labelList.get(i).getText();
	            if (currentLabel.equalsIgnoreCase(label)) {
	                fareDetails.put(label, Double.parseDouble(priceList.get(i).getText().trim().replace(",", "")));
	            }
	        }
	    }

	    for (int i = 0; i < labelSize1; i++) {
	        for (String label : fareLabels) {
	            String currentLabel = labelList1.get(i).getText();
	            if (currentLabel.equalsIgnoreCase(label)) {
	                fareDetails.put(label, Double.parseDouble(priceList1.get(i).getText().trim().replace(",", "")));
	            }
	        }
	    }

	    for (int i = 0; i < labelSize2; i++) {
	        for (String label : fareLabels) {
	            String currentLabel = labelList2.get(i).getText();
	            if (currentLabel.equalsIgnoreCase(label)) {
	                fareDetails.put(label, Double.parseDouble(priceList2.get(i).getText().trim().replace(",", "")));
	            }
	        }
	    }

	    // Check if local taxes are applicable and add to fareDetails if present
	    if (driver.findElements(By.xpath("//p[normalize-space()='Local Taxes (if applicable)']")).size() > 0) {
	        double localTax = Double.parseDouble(driver.findElement(By.xpath(
	                "//div[@class='theme4_booking_summary_grid_container__nXlBT']//input[@id='inputId']"))
	                .getAttribute("value"));

	        fareDetails.put("Local Taxes (if applicable)", localTax);
	    }

	    // Calculate the total amount by summing the values in fareDetails
	    double finalTotalAmount = fareDetails.values().stream().mapToDouble(Double::doubleValue).sum();

	    // Log the fare details and total amount
	    logger.info("Fare Details:");
	    fareDetails.forEach((label, value) -> logger.info(label + ": " + value + " INR "));
	    logger.info("Final Total Amount: " + finalTotalAmount + " INR ");

	    // Verify the total amount displayed on the review page
	    if (driver.findElements(By.xpath("//div[@class='theme4_booking_summary_grid_container__nXlBT']//p[normalize-space()='Total :']")).size() > 0) {
	        double totalAmt = Double.parseDouble(driver.findElement(By.xpath("//div[@class='theme4_booking_summary_grid_container__nXlBT']//div[@class='theme4_total_amount_1__p6YOz']")).getText().trim().replace(",", "").replace("INR", ""));
	        logger.info("Final Amount after all calculation: " + finalTotalAmount);
	        logger.info("Total amount is: " + totalAmt);

	        // Compare finalTotalAmount with the displayed total amount and log the values
	        BigDecimal value = new BigDecimal(finalTotalAmount).setScale(3, RoundingMode.HALF_UP);
	        logger.info("finalTotalAmount: " + value);
	        
	        BigDecimal value1 = new BigDecimal(totalAmt).setScale(3, RoundingMode.HALF_UP);
	        logger.info("totalAmt: " + value1);

	        // Calculate the difference between calculated total and displayed total
	        double Diff = finalTotalAmount - totalAmt;
	        logger.info("The Value Difference is: " + Diff);

	        // Assert that both amounts are equal
	        Assert.assertEquals(value1, value);
	    }
	}

	
	public void selectAdultForRoom(WebDriver driver, String RoomString) throws InterruptedException {
	    Integer room = Integer.valueOf(RoomString);
	    Thread.sleep(500);
	    
	    // Handle potential pop-up
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='theme5_alertbutton__AHGSE']")));
	        popup.click();
	    } catch (Exception e) {
	        logger.info("Pop-up not present");
	    }
	    
	    // Process room selection
	    commonMethodes.scrollDown(driver);
	    Thread.sleep(300);

	    for (int i = 1; i <= room; i++) {
	        WebElement element = getElementForRoom(i);
	        Thread.sleep(500);
	        element.click();
	        selectAdult(i);
	    }
	}

	private WebElement getElementForRoom(int roomNumber) {
	    switch (roomNumber) {
	        case 1:
	            return adultFoeRoom1;
	        case 2:
	            return adultFoeRoom2;
	        case 3:
	            return adultFoeRoom3;
	        case 4:
	            return adultFoeRoom4;
	        default:
	            throw new IllegalArgumentException("Invalid room number: " + roomNumber);
	    }
	}

	private void selectAdult(int roomNumber) throws InterruptedException {
	    Thread.sleep(100); // Adjust as needed for timing
	    switch (roomNumber) {
	        case 1:
	            selectAdult1.click();
	            passPAN1.sendKeys("HHJPK4757B");
	            break;
	        case 2:
	            selectAdult2.click();
	            passPAN2.sendKeys("HHJPK4757C");
	            break;
	        case 3:
	            selectAdult3.click();
	            passPAN3.sendKeys("HHJPK4757D");
	            break;
	        case 4:
	            selectAdult4.click();
	            passPAN4.sendKeys("HHJPK4757E");
	            break;
	        default:
	            throw new IllegalArgumentException("Invalid room number for adult selection: " + roomNumber);
	    }
	}

	public void selectAdultForRoomWithoutLogin(WebDriver driver, String roomString) throws InterruptedException {
	    // Convert roomString to Integer for easier handling
	    Integer room = Integer.valueOf(roomString);
	    Thread.sleep(500); // Allow time for any UI elements to load

	    // Loop through the number of rooms and fill details for each adult
	    for (int i = 1; i <= room; i++) {
	        commonMethodes.scrollDown(driver); // Scroll down to make sure elements are visible
	        Thread.sleep(500); // Allow time for scrolling effect
	        fillAdultDetails(driver, i); // Call method to fill details for the current room
	    }
	}

	// Helper method to fill adult details based on room number
	private void fillAdultDetails(WebDriver driver, int roomNumber) throws InterruptedException {
	    // Set the common details for the first adult based on the room number
	    switch (roomNumber) {
	        case 1:
	            // Fill details for the first adult in room 1
	            fillDetails(title1, mr1, firstname01, lastName1, email01, phoneno01, panno01, 
	                        "Digambar", "Karande", "bhwbdbwwb@gmail.com", "1561485648451", "HHJPK4959B");
	            break;
	        case 2:
	            // Fill details for the first adult in room 2
	            fillDetails(title1, mr1, firstname01, lastName1, email01, phoneno01, panno01, 
	                        "Digambar", "Karande", "bhwbdbwwb@gmail.com", "1561485648451", "HHJPK4959B");
	            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)", ""); // Scroll down for second adult
	            Thread.sleep(500); // Allow time for scrolling effect
	            // Fill details for the second adult in room 2
	            fillDetails(title2, mr2, firstname02, lastName2, email02, phoneno02, panno02, 
	                        "Omkar", "Karande", "bhwbdbwwb@gmail.com", "1561485648451", "HHJPK4959C");
	            break;
	        case 3:
	            // Fill details for the first adult in room 3
	            fillDetails(title1, mr1, firstname01, lastName1, email01, phoneno01, panno01, 
	                        "Digambar", "Karande", "bhwbdbwwb@gmail.com", "1561485648451", "HHJPK4959D");
	            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)", ""); // Scroll down for second adult
	            Thread.sleep(500); // Allow time for scrolling effect
	            // Fill details for the second adult in room 3
	            fillDetails(title2, mr2, firstname02, lastName2, email02, phoneno02, panno02, 
	                        "Omkar", "Karande", "bhwbdbwwb@gmail.com", "1561485648451", "HHJPK4959E");
	            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)", ""); // Scroll down for third adult
	            Thread.sleep(500); // Allow time for scrolling effect
	            // Fill details for the third adult in room 3
	            fillDetails(title3, mr3, firstname03, lastName3, email03, phoneno03, panno03, 
	                        "Vinod", "Karande", "bhwbdbwwb@gmail.com", "1561485648451", "HHJPK4959F");
	            break;
	        case 4:
	            // Fill details for the first adult in room 4
	            fillDetails(title1, mr1, firstname01, lastName1, email01, phoneno01, panno01, 
	                        "Digambar", "Karande", "bhwbdbwwb@gmail.com", "1561485648451", "HHJPK4959B");
	            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)", ""); // Scroll down for second adult
	            Thread.sleep(500); // Allow time for scrolling effect
	            // Fill details for the second adult in room 4
	            fillDetails(title2, mr2, firstname02, lastName2, email02, phoneno02, panno02, 
	                        "Omkar", "Karande", "bhwbdbwwb@gmail.com", "1561485648451", "HHJPK4959C");
	            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)", ""); // Scroll down for third adult
	            Thread.sleep(500); // Allow time for scrolling effect
	            // Fill details for the third adult in room 4
	            fillDetails(title3, mr3, firstname03, lastName3, email03, phoneno03, panno03, 
	                        "Vinod", "Karande", "bhwbdbwwb@gmail.com", "1561485648451", "HHJPK4959D");
	            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)", ""); // Scroll down for fourth adult
	            Thread.sleep(500); // Allow time for scrolling effect
	            // Fill details for the fourth adult in room 4
	            fillDetails(title4, mr4, firstname04, lastName4, email04, phoneno04, panno04, 
	                        "Vinyak", "Karande", "bhwbdbwwb@gmail.com", "1561485648451", "HHJPK4959E");
	            break;
	        default:
	            // Handle invalid room numbers
	            throw new IllegalArgumentException("Invalid room number: " + roomNumber);
	    }
	}

	// Helper method to fill individual adult details in the form
	private void fillDetails(WebElement title, WebElement mr, WebElement firstName, WebElement lastName, 
	                         WebElement email, WebElement phoneNo, WebElement panNo, 
	                         String firstNameValue, String lastNameValue, 
	                         String emailValue, String phoneNoValue, String panNoValue) throws InterruptedException {
	    title.click(); // Click on the title dropdown
	    Thread.sleep(100); // Allow time for interaction
	    mr.click(); // Click on the 'Mr.' option
	    Thread.sleep(100); // Allow time for interaction
	    firstName.sendKeys(firstNameValue); // Enter first name
	    Thread.sleep(100); // Allow time for input
	    lastName.sendKeys(lastNameValue); // Enter last name
	    Thread.sleep(100); // Allow time for input
	    email.sendKeys(emailValue); // Enter email
	    Thread.sleep(100); // Allow time for input
	    phoneNo.sendKeys(phoneNoValue); // Enter phone number
	    Thread.sleep(100); // Allow time for input
	    panNo.sendKeys(panNoValue); // Enter PAN number
	    Thread.sleep(300); // Allow time for input and processing
	}

	
	public void clickOnContinueButton(WebDriver driver) throws InterruptedException {
	    Thread.sleep(500); // Allow time for UI elements to load

	    // Scroll down to ensure the continue button is visible
	    commonMethodes.scrollDown(driver);
	    Thread.sleep(500); // Allow time for scrolling effect
	    commonMethodes.scrollDown(driver); // Scroll down again if necessary
	    // Thread.sleep(500); // Additional wait can be added if needed

	    continueBooking.click(); // Click on the continue booking button
	    Thread.sleep(500); // Allow time for the action to complete
	}

	public void clickContinueButtonAndProceedPayment(WebDriver driver, String roomString) throws InterruptedException {
	    // Convert roomString to Integer for easier handling
	    String stringRoom = roomString;
	    Integer room = Integer.valueOf(stringRoom);
	    Thread.sleep(500); // Allow time for UI elements to load

	    // Handle actions based on the number of rooms
	    if (room == 1) {
	        Thread.sleep(500); // Additional wait

	        commonMethodes.scrollDown2(driver); // Scroll down specifically for the continue button
	        Thread.sleep(500); // Allow time for scrolling effect
	        continubutton.click(); // Click on the continue button

	        // Handle potential pop-up that might appear after clicking continue
	        try {
	            // Wait for the pop-up button to be visible
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(),'Continue')])[1]")));
	            popup.findElement(By.xpath("(//button[contains(text(),'Continue')])[1]")).click(); // Click the pop-up's continue button
	        } catch (Exception e) {
	            logger.info("Pop-up not present"); // Log if the pop-up does not appear
	        }
	        Thread.sleep(15000); // Allow time for processing after clicking continue

	    } else if (room == 2) {
	        // Similar actions for room 2
	        WebElement element = continubutton; // Reference to the continue button
	        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,350)", ""); // Scroll down for visibility
	        Thread.sleep(500); // Allow time for scrolling effect
	        element.click(); // Click the continue button

	        // Handle potential pop-up that might appear after clicking continue
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(),'Continue')])[1]")));
	            popup.findElement(By.xpath("(//button[contains(text(),'Continue')])[1]")).click(); // Click the pop-up's continue button
	        } catch (Exception e) {
	            logger.info("Pop-up not present"); // Log if the pop-up does not appear
	        }
	        Thread.sleep(15000); // Allow time for processing after clicking continue

	    } else if (room == 3) {
	        // Similar actions for room 3
	        WebElement element = continubutton;
	        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,350)", ""); // Scroll down for visibility
	        Thread.sleep(500); // Allow time for scrolling effect
	        element.click(); // Click the continue button

	        // Handle potential pop-up that might appear after clicking continue
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(),'Continue')])[1]")));
	            popup.findElement(By.xpath("(//button[contains(text(),'Continue')])[1]")).click(); // Click the pop-up's continue button
	        } catch (Exception e) {
	            logger.info("Pop-up not present"); // Log if the pop-up does not appear
	        }
	        Thread.sleep(15000); // Allow time for processing after clicking continue

	    } else if (room == 4) {
	        // Similar actions for room 4
	        WebElement element = continubutton;
	        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,350)", ""); // Scroll down for visibility
	        Thread.sleep(500); // Allow time for scrolling effect
	        element.click(); // Click the continue button

	        // Handle potential pop-up that might appear after clicking continue
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(),'Continue')])[1]")));
	            popup.findElement(By.xpath("(//button[contains(text(),'Continue')])[1]")).click(); // Click the pop-up's continue button
	        } catch (Exception e) {
	            logger.info("Pop-up not present"); // Log if the pop-up does not appear
	        }
	        Thread.sleep(15000); // Allow time for processing after clicking continue
	    }
	}

	
	
	
	
	
	
	
	

}

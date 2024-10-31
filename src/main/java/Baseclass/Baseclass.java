package baseclass;

import java.io.IOException;  // To handle IOExceptions

import org.apache.logging.log4j.LogManager;  // For logging messages
import org.apache.logging.log4j.Logger;      // Logger class for logging

import org.openqa.selenium.WebDriver;  // WebDriver interface for controlling the browser
import org.openqa.selenium.chrome.ChromeDriver;  // ChromeDriver implementation for Chrome browser
import org.openqa.selenium.chrome.ChromeOptions;  // ChromeOptions to set Chrome-specific options
import org.openqa.selenium.edge.EdgeDriver;  // EdgeDriver implementation for Edge browser
import org.openqa.selenium.edge.EdgeOptions;  // EdgeOptions to set Edge-specific options
import org.openqa.selenium.firefox.FirefoxDriver;  // FirefoxDriver implementation for Firefox browser
import org.openqa.selenium.firefox.FirefoxOptions;  // FirefoxOptions to set Firefox-specific options

import com.aventstack.extentreports.ExtentReports;  // For reporting test results (Extent Reports)

import io.github.bonigarcia.wdm.WebDriverManager;  // WebDriverManager to manage driver binaries automatically
import utils.commonMethodes;  // Import custom utility class for common methods

// Baseclass extends the utility class CommonMethodes, providing basic setup for WebDriver across multiple browsers
public class Baseclass extends commonMethodes {

	 protected static WebDriver driver; // WebDriver instance that will be used throughout the class
    ExtentReports extent;  // ExtentReports instance for generating reports
    private static final Logger logger = LogManager.getLogger(Baseclass.class);  // Logger instance for logging information
    
    // Define constant for allowing cross-origin requests
    private static final String REMOTE_ALLOW_ORIGINS = "--remote-allow-origins=*";
    
    private static final String HEAD_LESS = "--headless=new";



    // Method to launch a browser and navigate to the desired environment's URL
    public static void launchBrowser(String environment) throws IOException {
        
        // Variable to store the URL based on the environment passed
        String url;
        
        // Switch case to determine the correct URL for the environment specified
        switch (environment.toLowerCase()) {
            case "uatb2b":
                // Fetch UATB2B URL from the property file
                url = commonMethodes.readDataFromPropertyFile("UATB2BURL");
                break;
            case "prodb2b2":
                // Fetch PRODB2BURL2 from the property file
                url = commonMethodes.readDataFromPropertyFile("PRODB2BURL2");
                break;
            case "prodb2b":
                // Fetch PRODB2B URL from the property file
                url = commonMethodes.readDataFromPropertyFile("PRODB2BURL");
                break;
            default:
                // Log an error and throw an exception if the environment is unsupported
                logger.error("Unsupported environment: {}", environment);
                throw new IllegalArgumentException("Unsupported environment: " + environment);
        }

        // Fetch the browser type from the properties file and convert it to lowercase for consistency
        String browser = commonMethodes.readDataFromPropertyFile("browser").toLowerCase();
        logger.info("Launching browser: {}", browser);  // Log the browser being used

        // Switch case to initialize the correct WebDriver based on the browser type
        switch (browser) {
            case "chrome":
                // Set up ChromeDriver using WebDriverManager to manage driver binaries
                WebDriverManager.chromedriver().setup();
                // Create an instance of ChromeOptions to configure Chrome-specific settings
                ChromeOptions chromeOptions = new ChromeOptions();
                // Check if headless mode is enabled in the properties file, and set the option if true
                if (commonMethodes.readDataFromPropertyFile("headless").equalsIgnoreCase("true")) {
                    chromeOptions.addArguments(HEAD_LESS);
                }
                // Allow cross-origin requests, which can be required in certain testing scenarios
                chromeOptions.addArguments(REMOTE_ALLOW_ORIGINS);
                // Initialize the Chrome WebDriver with the configured options
                driver = new ChromeDriver(chromeOptions);
                break;
                
            case "firefox":
                // Set up FirefoxDriver using WebDriverManager
                WebDriverManager.firefoxdriver().setup();
                // Create an instance of FirefoxOptions to configure Firefox-specific settings
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                // Allow cross-origin requests and disable popup blocking
                firefoxOptions.addArguments(REMOTE_ALLOW_ORIGINS, "--disable-popup-blocking");
                // Initialize the Firefox WebDriver with the configured options
                driver = new FirefoxDriver(firefoxOptions);
                break;
                
            case "edge":
                // Set up EdgeDriver using WebDriverManager
                WebDriverManager.edgedriver().setup();
                // Create an instance of EdgeOptions to configure Edge-specific settings
                EdgeOptions edgeOptions = new EdgeOptions();
                // Allow cross-origin requests and disable popup blocking
                edgeOptions.addArguments(REMOTE_ALLOW_ORIGINS, "--disable-popup-blocking");
                // Initialize the Edge WebDriver with the configured options
                driver = new EdgeDriver(edgeOptions);
                break;
                
            default:
                // Log an error and throw an exception if the browser type is unsupported
                logger.error("Unsupported browser: {}", browser);
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        // Maximize the browser window to ensure the application behaves as expected in full-screen mode
        driver.manage().window().maximize();
        // Navigate to the specified URL
        driver.get(url);
        // Log that the browser and URL were successfully launched
        logger.info("Successfully launched the {} URL with {} browser.", environment, browser);
    }

 
}

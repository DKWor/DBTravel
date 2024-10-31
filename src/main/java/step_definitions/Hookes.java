package step_definitions;

import org.openqa.selenium.OutputType; // Provides an option to capture screenshots in different formats
import org.openqa.selenium.TakesScreenshot; // Interface that captures screenshots
import org.openqa.selenium.remote.ScreenshotException;

import baseclass.Baseclass;
import io.cucumber.java.After; // Annotation for methods that run after each scenario
import io.cucumber.java.AfterAll; // Annotation for methods that run after all scenarios
import io.cucumber.java.Before; // Annotation for methods that run before each scenario
import org.apache.logging.log4j.LogManager; // For logging
import org.apache.logging.log4j.Logger; // Logger class for logging

// The Hookes class extends Baseclass to access WebDriver and common methods
public class Hookes extends Baseclass {

    // Logger instance for logging information and errors
    private static final Logger logger = LogManager.getLogger(Hookes.class);

    // @Before: Method runs before scenarios tagged with "@SmokeTest"
    @Before("@SmokeTest")
    public void fightbooking() {
        // This will be executed before any test scenario with "@SmokeTest" tag
        logger.info("Select the origin and destination as per requirements");
    }

 // @After: Executes after each test scenario, with order 1 meaning it runs before lower order methods (higher numbers run first)
    @After(order = 1)
    public void takeScreenshotOfFailedTestCase(io.cucumber.java.Scenario scenario) throws ScreenshotException {
        // If the scenario fails, this block captures a screenshot and attaches it to the report
        if (scenario.isFailed()) {
            try {
                // TakesScreenshot allows capturing a screenshot of the current page
                TakesScreenshot ts = (TakesScreenshot) driver;
                // Captures the screenshot in byte format
                byte[] src = ts.getScreenshotAs(OutputType.BYTES);
                // Attaches the screenshot to the scenario in the report (in PNG format)
                scenario.attach(src, "image/png", "screenshot");
                logger.info("Screenshot taken for failed scenario: {}", scenario.getName());
            } catch (Exception e) {
                // Throw the custom exception if any error occurs while taking the screenshot
                throw new ScreenshotException("Failed to take screenshot for scenario: " + scenario.getName(), e);
            }
        }
    }


    // @After: This method will run after each scenario, with order 0 (lower order = runs later)
    @After(order = 0)
    public void closeBrowser() {
        // Closes the browser window after every test scenario
        driver.quit();
        logger.info("Browser closed after test scenario.");
    }

    // @AfterAll: This method runs after all test scenarios are completed (static because it applies to all tests)
    @AfterAll
    public static void sendEmailAfterAllTests() throws Exception {
        // Sends an email report once all scenarios are executed
        EmailReport sm = new EmailReport(); // Creates an instance of the Emailreport class
        // Calls the mail method to send the test execution report
        sm.mail();
        logger.info("Email report sent after all tests.");
    }
}

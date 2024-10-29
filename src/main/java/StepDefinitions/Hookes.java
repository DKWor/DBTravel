package StepDefinitions;

import org.openqa.selenium.OutputType; // Provides an option to capture screenshots in different formats
import org.openqa.selenium.TakesScreenshot; // Interface that captures screenshots
import com.aventstack.extentreports.gherkin.model.Scenario; // Used for managing test scenarios in Extent Reports
import Baseclass.Baseclass; // Imports Baseclass for shared setup and driver handling
import io.cucumber.java.After; // Annotation for methods that run after each scenario
import io.cucumber.java.AfterAll; // Annotation for methods that run after all scenarios
import io.cucumber.java.Before; // Annotation for methods that run before each scenario

// The Hookes class extends Baseclass to access WebDriver and common methods
public class Hookes extends Baseclass {

	// @Before: Method runs before scenarios tagged with "@SmokeTest"
	@Before("@SmokeTest")
	public void Flightbooking() {
		// This will be executed before any test scenario with "@SmokeTest" tag
		System.out.println("Select the origin and destination as per requirements");
	}

	// @After: Executes after each test scenario, with order 1 meaning it runs before lower order methods (higher numbers run first)
	@After(order = 1)
	public void TakscreenshotOfFailureTestCases(io.cucumber.java.Scenario scenario) throws Exception {
		// If the scenario fails, this block captures a screenshot and attaches it to the report
		if (scenario.isFailed()) {
			// TakesScreenshot allows capturing a screenshot of the current page
			TakesScreenshot ts = (TakesScreenshot) driver;
			// Captures the screenshot in byte format
			byte[] src = ts.getScreenshotAs(OutputType.BYTES);
			// Attaches the screenshot to the scenario in the report (in PNG format)
			scenario.attach(src, "image/png", "screenshot");
		}
	}

	// @After: This method will run after each scenario, with order 0 (lower order = runs later)
	@After(order = 0)
	public void closeBrowser() {
		// Closes the browser window after every test scenario
		driver.quit();
	}

	// @AfterAll: This method runs after all test scenarios are completed (static because it applies to all tests)
	@AfterAll
	public static void sendEmailAfterAllTests() throws Exception {
		// Sends an email report once all scenarios are executed
		Emailreport sm = new Emailreport(); // Creates an instance of the Emailreport class
		// Calls the mail method to send the test execution report
		sm.mail();
	}
}

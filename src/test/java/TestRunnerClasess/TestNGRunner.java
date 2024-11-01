package TestRunnerClasess;

import java.io.IOException; // Handles input/output exceptions
import javax.mail.MessagingException; // Handles exceptions specific to JavaMail API
import javax.mail.internet.AddressException; // Handles exceptions related to incorrect email addresses

import io.cucumber.testng.AbstractTestNGCucumberTests; // Provides TestNG integration with Cucumber
import io.cucumber.testng.CucumberOptions; // Allows configuration of Cucumber options, like feature locations, glue code, etc.

import step_definitions.EmailReport;

// @CucumberOptions: Annotation to configure Cucumber framework for the test runner

@CucumberOptions(
 	    
	  	   
features={"src\\test\\java\\Features"},	
glue="StepDefinitions",
monochrome = true,
tags="@sanity_Hotel_B2B_PROD",
plugin= {"pretty",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"timeline:test-output-thread/",
		"rerun:target/failedrerun.txt" 
	         	              
                                                                                                                                                                                                                                                                                                                                                     	                                                                                                            	                                                                                                                                          	      
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          	                                                  	                              
}                         
)    
    
public class TestNGRunner extends AbstractTestNGCucumberTests {

	//@AfterClass annotation commented out - Optional: You can use this to perform actions after all tests are run
		public static void SendingMail()  {

			// Runtime instance to add a shutdown hook
			Runtime r = Runtime.getRuntime();

			// Adds a shutdown hook to send an email with the report after test execution
			r.addShutdownHook(new Thread() {
				@Override
				public void run() {
					EmailReport sm = new EmailReport();
					try {
						// Call the mail method to send the report
						sm.mail();
						System.out.println("Report has been sent");
					} catch (Exception e) {
						// Prints stack trace in case of exceptions
						e.printStackTrace();
						System.out.println(e);
					}
				}
			});
		}
	}
//tags="@sanity_Hotel_B2B_PROD or @sanity_Flight_B2B_PROD or @sanity_Hotel_B2B_UAT or @sanity_Flight_B2B_UAT",


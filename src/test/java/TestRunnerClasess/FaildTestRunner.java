package TestRunnerClasess;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.annotations.AfterClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import step_definitions.EmailReport;

@CucumberOptions(
 	    
	  	  
features={"@target/failedrerun.txt"},	
glue="StepDefinitions",monochrome = true,
tags="@sanity_Hotel_B2B_PROD or @sanity_Flight_B2B_PROD or @sanity_Hotel_B2B_UAT or @sanity_Flight_B2B_UAT",
plugin= {"pretty",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"timeline:test-output-thread/",
		"rerun:target/failedrerun.txt"
	   	        
                                                                                                                                                                                                                                                                                                               
                                                                                                                                                                                                                                                     	                                                  	                              
}          
) 
public class FaildTestRunner extends AbstractTestNGCucumberTests {
	


	@AfterClass
	public static void SendingMail()  {

		Runtime r = Runtime.getRuntime();
		r.addShutdownHook(new Thread() {
			@Override
			public void run() {
				EmailReport sm = new EmailReport();
				try {
					sm.mail();
					System.out.println("Report has been sent");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e);
				}

			}
		});

	}


	
}

package TestRunnerClasess;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.cucumber.core.cli.Main;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class Dbtravlejar extends AbstractTestNGCucumberTests {
 
    public static void main(String[] args) {
        // Initialize Extent Reports
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/report.html");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("MainWithHooks Execution Report");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        ExtentTest test = extent.createTest("Main Method Execution");
 
        try {
            // Before hook
            System.out.println("Before Main.main execution");
            test.info("Before Main.main execution");

            // Main method execution
            Main.main(new String[] {
                    "-g", "StepDefinitions",
                    "test-classes/",
                    "-t", "@sanity_Hotel_B2B_UAT or @sanity_Flight_B2B_UAT",
                    "-p", "pretty",
                    "-p", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                    "-p", "timeline:test-output-thread/"
            }); 

            // Log success
            test.pass("Main.main executed successfully");

        } catch (Exception e) {
            // Exception handling
            e.printStackTrace();
            System.out.println("Main method exception: " + e);
            test.fail("Main method exception: " + e.getMessage());
        }

        // After hook
        System.out.println("After Main.main execution");
        test.info("After Main.main execution");

        // Finalize the report
        extent.flush();
    }
}  

package utils;

import java.io.File; // Used for file handling
import java.io.FileInputStream; // Reads data from a file input stream
import java.io.IOException; // Handles IO exceptions
import java.time.Duration; // Handles time durations
import java.util.List; // Used for handling lists of elements
import java.util.Properties; // Used for reading from property files
import java.util.concurrent.TimeUnit; // Handles timeouts


import org.apache.poi.EncryptedDocumentException; // Handles encrypted document exceptions
import org.apache.poi.ss.usermodel.Sheet; // Represents an Excel sheet
import org.apache.poi.ss.usermodel.WorkbookFactory; // Creates workbook from Excel files
import org.openqa.selenium.*; // WebDriver and Selenium utilities
import org.openqa.selenium.interactions.Actions; // Used for performing complex actions like scrolling
import org.openqa.selenium.support.ui.ExpectedConditions; // Used for explicit waits
import org.openqa.selenium.support.ui.WebDriverWait; // Manages waiting for elements

public class CommonMethods {

	static String resourcePath = null; // Stores the resource path
	static Boolean isflag = false; // Flag to indicate resource path type



	// Scrolls to make a specific element visible on the page
	public static void scrollingView(WebDriver driver, WebElement element) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	// Method for implicitly waiting for elements to load
	public static void wait1(WebDriver driver, int wait) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
	}

	// Reads data from an Excel sheet (specified row and cell)
	public static String readExcelSheet(int row, int cell) throws EncryptedDocumentException, IOException {
	    // Your code to read from the Excel sheet would go here.
		File myfile = new File("C:\\Users\\ADMIN\\libs\\UPSTOK.xlsx"); // File path
		Sheet sheet = WorkbookFactory.create(myfile).getSheet("Sheet1"); // Access the first sheet
	    return sheet.getRow(row).getCell(cell).getStringCellValue(); // Immediately return the cell value

	}

	// Reads data from a property file based on the given key
	public static String readDataFromPropertyFile(String email) throws IOException {
		Properties prop = new Properties(); // Creates a Properties object
		FileInputStream myfile = new FileInputStream(System.getProperty("user.dir") + resoursePath() + "myproperty.properties"); // Property file path
		prop.load(myfile); // Loads the properties file
		return prop.getProperty(email); // Directly return the value for the given key
	}


	// Waits for an element to be visible and clickable, then clicks it
	public static void waitForElementToBeVisible(WebDriver driver, WebElement element ,int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(element));
		element1.click();
	}
	// Method to return the path to the Excel file
	public static String getExcelPath()   {
	    return System.getProperty("user.dir") + resoursePath() + "dbtravel.xlsx";
	}

	// Scrolls to a specific element using Actions
	public static void scrollToElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform(); // Scrolls to the specified element
	}

	public static void scrollUp4(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -400);");
	}	
	

	public static void scrollDown1(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 100);");
	}

	public static void scrollUp1(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -100);");
	}
	
	public static void scrollDown2(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200);");
	}

	public static void scrollUp2(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -200);");
	}
	
	public static void scrollDown3(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 300);");
	}

	public static void scrollUp3(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -300);");
	}
	

	
	
	// Scrolls down the page by 500 pixels
	public static void scrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");
	}

	// Scrolls up the page by 500 pixels
	public static void scrollUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -500);");
	}

	// Validates if the scrolling happened in the given direction
	public static boolean validateScrolling(WebDriver driver, String direction) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Get the current scroll position
		long initialScrollPosition = (long) js.executeScript("return window.scrollY;");

		// Scrolls based on the direction provided
		if (direction.equalsIgnoreCase("down")) {
			js.executeScript("window.scrollBy(0, 500);");
		} else if (direction.equalsIgnoreCase("up")) {
			js.executeScript("window.scrollBy(0, -500);");
		}

		// Pauses execution for 2 seconds
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Gets the new scroll position after scrolling
		long scrolledPosition = (long) js.executeScript("return window.scrollY;");

		// Checks if scrolling happened in the expected direction
		return (direction.equalsIgnoreCase("down") && scrolledPosition > initialScrollPosition)
				|| (direction.equalsIgnoreCase("up") && scrolledPosition < initialScrollPosition);
	}

	// Navigates to the next page
	public static void nextPage(WebDriver driver) {
		driver.navigate().forward();
	}

	// Navigates to the previous page
	public static void backPage(WebDriver driver) {
		driver.navigate().back();
	}

	// Refreshes the current page
	public static void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	// Waits for a specified amount of time
	public static void waitfForElements(WebDriver driver, int tvalue) {
		driver.manage().timeouts().implicitlyWait(tvalue, TimeUnit.SECONDS);
	}

	// Returns the resource path based on the isflag value
	public static String resoursePath()   {
		if (isflag) {
			resourcePath = "/";
		} else {
			resourcePath = "/src/test/resources/";
		}
		return resourcePath;
	}

	// Handles selecting a city from an auto-suggest list
	public static void autosuggest(WebDriver driver, String city) {
		// Finds all the auto-suggest options
		List<WebElement> orn = driver.findElements(By.xpath("//div[@class='theme4_flight_autocomplete_tag__Fhkr6']"));

		if (!orn.isEmpty()) {
			for (WebElement searchText : orn) {
				String text = searchText.getText();
				if (text.equalsIgnoreCase(city)) {
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchText); // Clicks the matching city
					break;
				}
			}
		} else {
			System.out.println("The origin city is not available: " + city);
		}
	}
}

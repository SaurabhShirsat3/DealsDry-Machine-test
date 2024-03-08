package UI_Testing;


	import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.text.SimpleDateFormat;
	import java.util.Date;

	public class UI_Testing {

	    public static void main(String[] args) {
	        // Set the path to the ChromeDriver executable
	        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

	        // Create a new ChromeDriver instance
	        WebDriver driver = new ChromeDriver();

	        // Define the list of devices and resolutions
	        String[] devices = {"Desktop", "Mobile"};
	        String[] resolutionsDesktop = {"1920x1080", "1366x768", "1536x864"};
	        String[] resolutionsMobile = {"360x640", "414x896", "375x667"};

	        // Loop through devices and resolutions
	        for (String device : devices) {
	            String[] resolutions = (device.equals("Desktop")) ? resolutionsDesktop : resolutionsMobile;

	            for (String resolution : resolutions) {
	                // Set the window size based on the resolution
	                String[] dimensions = resolution.split("x");
	                int width = Integer.parseInt(dimensions[0]);
	                int height = Integer.parseInt(dimensions[1]);
	                driver.manage().window().setSize(new org.openqa.selenium.Dimension(width, height));

	                // Open the website
	                driver.get("https://www.getcalley.com/");

	                // Take a screenshot and save it in the specified folder structure
	                String folderPath = "screenshots/" + device + "/" + resolution + "/";
	                String screenshotPath = folderPath + "Screenshot-" + getDateTime() + ".png";
	                ((ChromeDriver) driver).getScreenshotAs(OutputType.FILE).renameTo(new File(screenshotPath));
	            }
	        }

	        // Close the browser
	        driver.quit();
	    }

	    // Helper method to get the current date and time for screenshot naming
	    private static String getDateTime() {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
	        return dateFormat.format(new Date());
	    }
	}




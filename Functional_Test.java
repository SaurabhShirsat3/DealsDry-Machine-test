package Functional_Test;


	import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import java.io.File;

	public class Functional_Test {

	    public static void main(String[] args) {
	        // Set the path to the ChromeDriver executable
	        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

	        // Create a new ChromeDriver instance
	        WebDriver driver = new ChromeDriver();
	        //WebDriverWait wait = new WebDriverWait(driver, 10);

	        try {
	            // Open the web application
	            driver.get("https://demo.dealsdray.com/");

	            // Log in with provided credentials
	            WebElement usernameInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-username")));
	            WebElement passwordInput = driver.findElement(By.id("login-password"));
	            WebElement loginButton = driver.findElement(By.id("login-button"));

	            usernameInput.sendKeys("prexo.mis@dealsdray.com");
	            passwordInput.sendKeys("prexo.mis@dealsdray.com");
	            loginButton.click();

	            // Upload XLS file
	            WebElement fileInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("file-upload")));
	            fileInput.sendKeys(new File("C:\\Users\\saura\\OneDrive\\Desktop\\Resume\\test.xlsx").getAbsolutePath());

	            // Wait for the upload to complete (adjust this wait as needed)
	            Thread.sleep(5000);

	            // Capture video of the running process (you might need external tools for this)
	            // ...

	            // Take screenshot of the final output page
	            File screenshotFile = ((ChromeDriver) driver).getScreenshotAs(OutputType.FILE);
	            FileUtils.copyFile(screenshotFile, new File("path/to/final-output-screenshot.png"));

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Close the browser
	            driver.quit();
	        }
	    }
	}




package lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testing {

    public static void main(String[] args) {
        // Set the path for your ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path/to/your/chromedriver");

        // Initialize WebDriver (you can choose Chrome, Firefox, etc.)
        WebDriver driver = new ChromeDriver();

        // Open a website
        driver.get("https://www.google.com");

        // Print the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Close the browser
        driver.quit();
    }
}

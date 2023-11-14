import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Project-4 - ProjectName : com-saucedemo
 * BaseUrl = https://www.saucedemo.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Navigate to baseUrl
 * 11. Refresh the page.
 * 12. Close the browser.
 */
public class ComSauceDemo {
    static String browser = "Chrome";
    static String baseUrl = "https://www.saucedemo.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException{
        // 1. Setup chrome browser.
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }


        // 2. Open URL.
        driver.get(baseUrl);
        Thread.sleep(4000);

        // Maximize the window
        driver.manage().window().maximize();

        // we give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // 3. Print the title of the page.
        String title = driver.getTitle();
        System.out.println(title);

        // 4. Print the current url.
        System.out.println("The Current Url " + driver.getCurrentUrl());

        // 5. Print the page source.
        System.out.println(driver.getPageSource());

        // 6. Enter the email to email field.
        WebElement emailField = driver.findElement(By.id("user-name"));
        emailField.sendKeys("standard_user");
        Thread.sleep(4000);

        // 7. Enter the password to password field.
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        Thread.sleep(4000);

        // 8. Click on Login Button.
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        Thread.sleep(4000);

        // 9. Print the current url.
        System.out.println("Get Current Url " + driver.getCurrentUrl());
        Thread.sleep(4000);

        // 10. Navigate to baseUrl
        driver.navigate().to(baseUrl);
        Thread.sleep(4000);

        // 11. Refresh the page.
        driver.navigate().refresh();

        // 12. Close the browser.
        driver.quit();

    }
}


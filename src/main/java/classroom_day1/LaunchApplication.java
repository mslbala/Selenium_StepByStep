package classroom_day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LaunchApplication {
    public static void main(String[] args) {

        //set up
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//main//resources//drivers/chromedriver.exe");

        //to open blank chrome browser
        driver = new ChromeDriver();

        //manages the browser
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

        //to launch any url
        driver.get("http://way2automation.com/way2auto_jquery/index.php");

        //to access and work on elements
        driver.findElement(By.name("name")).sendKeys("Bala");
        driver.findElement(By.name("phone")).sendKeys("9876543210");
        driver.findElement(By.name("email")).sendKeys("hjk@jkl.com");
        driver.findElement(By.name("username")).sendKeys("bala123");


    }

}

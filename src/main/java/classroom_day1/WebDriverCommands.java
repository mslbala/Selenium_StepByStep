package classroom_day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverCommands {

    WebDriver driver;

    public void browserSetup() {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//main//resources//drivers/chromedriver.exe");
        driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        //https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebDriver.Timeouts.html
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);

        //to launch the url
        driver.get("http://www.seleniumframework.com/Practiceform/");
    }

    public void sumbitForm() {

        //fill form
        driver.findElement(By.name("name")).sendKeys("banotepadla");
        driver.findElement(By.name("email")).sendKeys("444gg@tet.com");
        driver.findElement(By.name("telephone")).sendKeys("9876543210");
        driver.findElement(By.cssSelector("input[name='country']")).sendKeys("Sweden");
        driver.findElement(By.xpath("//a[text()='Submit']")).click();


    }

    public static void main(String[] args) {
        WebDriverCommands webDriverCommands = new WebDriverCommands();
        webDriverCommands.browserSetup();
        webDriverCommands.sumbitForm();

    }

}

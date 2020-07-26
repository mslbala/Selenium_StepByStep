package classroom_day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HandlingMultipleWindows {
    WebDriver driver;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//main//resources//drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get("https://www.naukri.com/");
    }

    public void handleMultipleWindows() throws InterruptedException {
        //to get current window handle
        String currentWindowHandleId = driver.getWindowHandle();
        System.out.println("Current window handle id-->" + currentWindowHandleId);

        //to get the list of all windows opened by the driver
        Set<String> windowHandlesIDs = driver.getWindowHandles();

        int i = 0;
        for (String eachWindowId : windowHandlesIDs) {
            System.out.println("Window Handle id " + i + "======" + eachWindowId);
            if (!currentWindowHandleId.equals(eachWindowId)) {
                driver.switchTo().window(eachWindowId);
                driver.close();
                driver.switchTo().window(currentWindowHandleId);
            }
            i++;
        }


    }


    public static void main(String[] args) throws InterruptedException {
        HandlingMultipleWindows handleAlertsObject = new HandlingMultipleWindows();
        handleAlertsObject.setUp();
        handleAlertsObject.handleMultipleWindows();


    }

}

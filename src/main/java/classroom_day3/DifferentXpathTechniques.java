package classroom_day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DifferentXpathTechniques {
    WebDriver driver;

    public void browserSetup() {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//main//resources//drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
        driver.get("https://accounts.lambdatest.com/register");
    }

    public void sendValuesByXpath(String fieldName, String xpath, String value) {
        try {
            System.out.println("Trying to fill " + fieldName + " with value " + value);
            driver.findElement(By.xpath(xpath)).sendKeys(value);
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("Exception while trying to send values:" + e.getMessage());
        }

    }


    public void tryDifferentXpathTechniquesPart1() {

        //Absolute xpath
        sendValuesByXpath("full Name", "/html/body/div[1]/div/div/div[2]/div/form/div[1]/input", "Absolute xpath");

        //Relative xpath
        sendValuesByXpath("full Name", "//input[@name='name']", "Relative xpath");

        //Other dynamic xpaths
//        1.//input[@type='email']
//        2.//*[@placeholder='Email*']---->any tag
//        3.//input[@class='form-control '][@placeholder='Email*']-->Multiple attributes chained

        //AND and OR
        sendValuesByXpath("password", "//input[@type='password' and @name='password']", "Test@1234");
//        sendValuesByXpath("password", "//input[@type='password' or @name='password']", "Test@1234");

        //Contains
        sendValuesByXpath("organisation Name", "//input[contains(@name,'organization')]", "Accenture");

        //Starts-with
        sendValuesByXpath("phone Number", "//*[starts-with(@placeholder,'Phone')]", "786543210");

        //Text
        driver.findElement(By.xpath("//*[text()='Free Sign Up']")).click();

        //Contains Text
        driver.findElement(By.xpath("//*[contains(text(),'Free Sign Up')]")).click();
    }

    public void tryDifferentXpathTechniquesPart2() {

        //using index
        sendValuesByXpath("full Name", "(//div[@class='form-group']//input)[1]", "index xpath");

        //Relative xpath
        sendValuesByXpath("full Name", "//div[@class='form-group']//input[@name='name']", "multiple xpaths chained");

    }

    public void tryDifferentXpathTechniquesPart3() {
        driver.get("https://www.lambdatest.com/");

        //XPATH Axes:
//        XPath axes comes in handy when the exact element tagname or its attribute value are dynamic and cannot be used to locate an element.
//        In this case locating element after traversing through child/sibling or parent will be easy approach.

        //Following:This XPath axes helps to locate element following the current node
        driver.findElement(By.xpath("//ul[@class='navbar-nav']//following::li[1]")).click();
        sendValuesByXpath("password", "//input[@type='password' or @name='password']", "Test@1234");

        //Following-sibling. In case of following siblings, all following nodes of the context node, that shares the same parent, are applicable.
        // In this case all siblings are referred to as children of the parent node.
        // So if you are referencing one of the children and wish to navigate to other children of the same parent that follows it, following sibling does the business.
        driver.get("https://accounts.lambdatest.com/register");
        sendValuesByXpath("email", "//input[@name='name']/../following-sibling::div//input", "Following-sibling");

        //Preceding-sibling
        sendValuesByXpath("company name", "//input[@name='phone']/../preceding-sibling::div//input", "Amazon");
        sendValuesByXpath("company name", "//input[@name='phone']/../preceding::input[2]", "Password");

        //Preceding
        sendValuesByXpath("password", "//input[@name='phone']/../preceding::input[2]", "Precding");


        //Parent-the parent element is located through its child element.
        sendValuesByXpath("password", "//input[@name='phone']/..", "Parebt");

        //Descendant
        //*[@name='name' and @type='text']/../../descendant::div[3]
        sendValuesByXpath("password", "//*[@name='name' and @type='text']/../../descendant::div[3]//input", "Descendant");
    }

    public static void main(String[] args) {
        DifferentXpathTechniques differentXpathTechniques = new DifferentXpathTechniques();
        differentXpathTechniques.browserSetup();
        differentXpathTechniques.tryDifferentXpathTechniquesPart1();
        differentXpathTechniques.tryDifferentXpathTechniquesPart2();
        differentXpathTechniques.tryDifferentXpathTechniquesPart3();

    }

}

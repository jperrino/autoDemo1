package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class DriverManager
{
    WebDriver driver;
    String browser;

    private WebDriver createDriver()
    {
        switch(browser.toLowerCase())
        {
            case "ff":
                System.setProperty("webdriver.gecko.driver",
                        ".\\drivers\\firefoxDriver\\geckodriver.exe");
                FirefoxOptions ffOptions = new FirefoxOptions();
                ffOptions.setAcceptInsecureCerts(true);
                return new FirefoxDriver(ffOptions);
            case "chrome":
                System.setProperty("webdriver.chrome.driver",
                        ".\\drivers\\chromeDriver\\chromedriver.exe");
                ChromeOptions crOptions = new ChromeOptions();
                crOptions.addArguments("disable-infobars");
                return new ChromeDriver(crOptions);
            default:
                System.out.println("Invalid driver");
                return null;
        }
    }

    public WebDriver getDriver()
    {
        if(driver == null)
        {
            driver = createDriver();
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public void setBrowser(String browser)
    {
        this.browser = browser;
    }

    public void closeDriver()
    {
        if(driver != null)
        {
            driver.quit();
            driver = null;
        }
    }

}

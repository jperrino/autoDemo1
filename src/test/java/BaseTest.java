import driver.DriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class BaseTest
{
    DriverManager manager;

    @BeforeTest
    @Parameters("browser")
    public void initDriver(String browser)
    {
        manager = new DriverManager();
        manager.setBrowser(browser);
    }

    @DataProvider(name="searchData")
    public Object[][] dataProvider()
    {
        Object[][] data =
                {
                        {"github", "https://github.com/"},
                        {"maven", "https://maven.apache.org/"},
                        {"w3schools", "https://www.w3schools.com/"}
                };

        return data;
    }

    @AfterTest
    public void tearDown()
    {
        manager.closeDriver();
    }
}

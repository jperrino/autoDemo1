import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.GooglePage;
import pageObjects.ResultPage;

public class Test1 extends BaseTest
{
    GooglePage googlePage;
    ResultPage resultPage;

    @BeforeTest(dependsOnMethods = "initDriver")
    public void initTest()
    {
        googlePage = new GooglePage(manager);
        resultPage = new ResultPage(manager);
    }

    @BeforeMethod
    public void goHome(){
        manager.getDriver().
                navigate().
                to("http://www.google.com");
    }

    @Test(dataProvider = "searchData")
    public void test1(String title, String link)
    {
        googlePage.search_txtb().setText(title);
        googlePage.search_txtb().submit();
        googlePage.result_link(link).submit();
        Assert.assertTrue(resultPage.
                        getTitle().
                        toLowerCase().
                        contains(title),
                "Result Page Title is different from expected");
    }
}

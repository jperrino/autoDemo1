package pageObjects;

import driver.DriverManager;
import org.openqa.selenium.By;

public class ResultPage extends BasePageObject
{
    public ResultPage(DriverManager manager)
    {
        super(By.xpath(""), manager);
    }
}

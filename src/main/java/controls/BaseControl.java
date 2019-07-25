package controls;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BaseControl
{
    protected By by;
    protected DriverManager manager;

    public BaseControl(By by, DriverManager manager)
    {
        this.by = by;
        this.manager = manager;
    }

    protected WebElement webElement()
    {
        return this.manager.getDriver().findElement(this.by);
    }
}

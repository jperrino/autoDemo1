package controls;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Link extends BaseControl
{
    public Link(By by, DriverManager manager) {
        super(by, manager);
    }

    public String getText()
    {
        return webElement().getAttribute("href");
    }

    public void click()
    {
        webElement().click();
    }

    public void submit()
    {
        webElement().sendKeys(Keys.ENTER);
    }


}

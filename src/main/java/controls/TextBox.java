package controls;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class TextBox extends BaseControl
{
    public TextBox(By by, DriverManager manager)
    {
        super(by, manager);
    }

    public String getText()
    {
        return webElement().getAttribute("value");
    }

    public void setText(String text)
    {
        webElement().clear();
        webElement().sendKeys(text);
    }

    public void submit()
    {
        webElement().sendKeys(Keys.ENTER);
    }
}

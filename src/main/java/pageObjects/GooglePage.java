package pageObjects;

import controls.Button;
import controls.Link;
import controls.TextBox;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class GooglePage extends BasePageObject
{
    public GooglePage(DriverManager manager)
    {
        super(By.xpath(""), manager);
    }

    public TextBox search_txtb()
    {
        try
        {
            return new TextBox(By.name("q"), super.manager);
        }
        catch(NoSuchElementException e)
        {
            System.out.println("Element "+ this.getClass().getEnclosingMethod() +" not found");
            return null;
        }
    }

    public Button search_btn()
    {
        try
        {
            return new Button(By.name("btnK"), super.manager);
            //xpath("//*[@value='Google Search']")
        }
        catch(NoSuchElementException e)
        {
            System.out.println("Element "+ this.getClass().getEnclosingMethod() +" not found");
            return null;
        }
    }

    public Link result_link(String link)
    {
        try
        {
            return new Link(By.xpath("//a[@href='"+link+"']"), super.manager);
        }
        catch(NoSuchElementException e)
        {
            System.out.println("Element "+ this.getClass().getEnclosingMethod() +" not found");
            return null;
        }
    }
}

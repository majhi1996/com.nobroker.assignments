package pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class Searchpage 
{	
	public AndroidDriver<AndroidElement> driver;
	public WebDriverWait w;
	public TouchAction ta;
	
	public String expectedlocation="Bangalore";
	
	@AndroidFindBy(xpath="//*[contains(@resource-id,'text1')]")
	public AndroidElement dropdown;
	
	@AndroidFindBy(xpath="//*[@text='Bangalore']")
	public AndroidElement bangalorecity;
	
	@AndroidFindBy(xpath="//*[contains(@resource-id,'localityAutoCompleteTxt')]")
	public AndroidElement searchbox;
	
	@AndroidFindBy(xpath="//*[@text='Include nearby properties']")
	public AndroidElement checkbox;

	@AndroidFindBy(xpath="//*[@text='2 BHK']")
	public AndroidElement twobhk;
	
	@AndroidFindBy(xpath="//*[@text='3 BHK']")
	public AndroidElement threebhk;
	
	@AndroidFindBy(xpath="//*[@text='SEARCH']")
	public AndroidElement searchbutton;
	
	public Searchpage(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickOnDropdown()
	{
		dropdown.click();
	}
	
	public void selectBangalore()
	{
		bangalorecity.click();
	}
	
	public void enterLocation(String city)
	{
		searchbox.sendKeys(city);
	}
	
	public void tap(int x, int y)
	{
		ta=new TouchAction(driver);
		ta.tap(PointOption.point(x,y)).perform();
	}
	
	public void selectCheckbox()
	{
		checkbox.click();
	}
	
	public void selectBHK()
	{
		twobhk.click();
		threebhk.click();
	}
	
	public void clickSearchButton()
	{
		searchbutton.click();
	}
}

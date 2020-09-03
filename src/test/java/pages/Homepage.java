package pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Homepage 
{
	public AndroidDriver<AndroidElement> driver;
	public WebDriverWait w;
	
	@AndroidFindBy(xpath="//*[@text='Continue']")
	public AndroidElement continuebutton;
	
	@AndroidFindBy(xpath="//*[@text='DENY']")
	public AndroidElement denybutton;
	
	@AndroidFindBy(xpath="//*[@text='Buy']")
	public AndroidElement buytext;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Search up')]")
	public AndroidElement searchbox;
	
	public Homepage(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}	
	
	public void clickContinue()
	{
		continuebutton.click();
	}
	
	public void clickDeny()
	{
		denybutton.click();
	}
	
	public void clickBuy()
	{
		buytext.click();
	}
	
	public void clickSearch()
	{
		searchbox.click();
	}
}
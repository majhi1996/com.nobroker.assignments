package pages;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Propertylistingpage 
{
	public AndroidDriver<AndroidElement> driver;
	public TouchAction ta;	
	
	@AndroidFindBy(xpath="//*[@text='Request for Photos']")
	public AndroidElement cameraicon;
			
	@AndroidFindBy(xpath="//*[contains(@resource-id,'property_thumbnail')]")
	public AndroidElement fourthproperty;
	
	@AndroidFindBy(xpath="//*[@text='Check Eligibility']")
	public AndroidElement checkeligibilitybutton;
	
	@AndroidFindBy(xpath="//*[@text='Wrong Info']")
	public AndroidElement wronginfobutton;	
	
	public Propertylistingpage(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void scroll()
	{		
		int hgt=driver.manage().window().getSize().getHeight();
		int wth=driver.manage().window().getSize().getWidth();
		int x1=(int)(wth/2);
		int x2=(int)(wth/2);
		int y1=(int)(hgt*0.9);
		int y2=(int)(hgt*0.3);
		ta=new TouchAction(driver);		
		for(int i=0;i<3;i++)
		{
			WaitOptions wo=new WaitOptions();
			wo.withDuration(Duration.ofSeconds(3));
			ta.press(PointOption.point(x1,y1)).waitAction(wo).moveTo(PointOption.point(x2,y2)).release().perform();
		}
	}
	
	public void scrollIntoView()
	{
		int hgt=driver.manage().window().getSize().getHeight();
		int wth=driver.manage().window().getSize().getWidth();
		int x1=(int)(wth/2);
		int x2=(int)(wth/2);
		int y1=(int)(hgt*0.9);
		int y2=(int)(hgt*0.3);
		ta=new TouchAction(driver);		
		while(2>1)
		{
			try
			{
				wronginfobutton.isDisplayed(); 
				break;							
			}
			catch(Exception e)
			{
				WaitOptions wo=new WaitOptions();
				wo.withDuration(Duration.ofSeconds(3));
				ta.press(PointOption.point(x1,y1)).waitAction(wo).moveTo(PointOption.point(x2,y2)).release().perform();
			}
		}
	}	
	
	public void clickfourthproperty()
	{
		fourthproperty.click();
	}
	
	public void clickWrongInfoButton()
	{
		wronginfobutton.click();
	}
}
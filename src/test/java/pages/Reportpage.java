package pages;


import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Reportpage 
{	
	public AndroidDriver<AndroidElement> driver;
	public WebDriverWait w;
	
	public String expectedmsg="Thank you for the feedback";
	public String addnotetext="Add a note"; 
	
	@AndroidFindBy(xpath="//*[@class='android.widget.CheckBox']")
	public List<AndroidElement> allcheckbox;
	
	@AndroidFindBy(xpath="//*[@text='Report']")
	public AndroidElement reportbutton;
	
	@AndroidFindBy(xpath="//*[@text='What is the correct location?']")
	public AndroidElement location;
	
	@AndroidFindBy(xpath="//*[@text='3 BHK']") 
	public AndroidElement threebhk;
	
	@AndroidFindBy(xpath="//*[@text='4+ BHK']")
	public AndroidElement fourplusbhk;
	
	@AndroidFindBy(xpath="//*[@text='Save Changes']")
	public AndroidElement savebutton;
	
	@AndroidFindBy(xpath="(//*[@class='android.widget.TextView'])[1]")
	public AndroidElement feedback;
	
	public Reportpage(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickReport()
	{
		reportbutton.click();
	}
	
	public void clickbhkdropdown()
	{
		threebhk.click();
	}
	
	public void clickfourplusbhk()
	{
		fourplusbhk.click();
	}
	
	public void addNote(String text)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\""+addnotetext+"\"))").sendKeys(text);
	}
	
	public void clickSave()
	{
		savebutton.click();
	}
	
	public String getoutputtext()
	{
		String text=feedback.getText();
		return(text);
	}	
}
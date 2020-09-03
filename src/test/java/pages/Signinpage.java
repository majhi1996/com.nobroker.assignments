package pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Signinpage 
{
	public AndroidDriver<AndroidElement> driver;
	public WebDriverWait w;
	
	@AndroidFindBy(xpath="//*[@text='Enter Phone Number']")
	public AndroidElement phonetextbox;
	
	@AndroidFindBy(xpath="//*[@text='Trying to auto log in…']")
	public AndroidElement autologintext;
	
	@AndroidFindBy(xpath="//*[contains(@resource-id,'rb_signup_pwd')]")
	public AndroidElement havepasswordradiobutton;
	
	@AndroidFindBy(xpath="//*[@text='Enter Password']") 
	public AndroidElement passwordtextbox;
	
	@AndroidFindBy(xpath="//*[@text='Continue']")
	public AndroidElement continuebutton;
	
	public Signinpage(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void enterPhoneNumber(String phoneNumber)
	{
		phonetextbox.sendKeys(phoneNumber);
	}
	
	public void selectRadioButton()
	{
		havepasswordradiobutton.click();
	}
	
	public void enterPassword(String password)
	{
		passwordtextbox.sendKeys(password);
	}
	
	public void clickContinueButton()
	{
		continuebutton.click();
	}
}

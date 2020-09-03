package tests;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import pages.Homepage;
import pages.Propertylistingpage;
import pages.Reportpage;
import pages.Searchpage;
import pages.Signinpage;
import utilities.TestUtility;

public class Runner 
{
	public AndroidDriver<AndroidElement> driver;	
	public WebDriverWait w;
	public TestUtility tu;	
	public Properties p;
	public KeyEvent k; 
	
	@BeforeTest
	public void startExecution() throws Exception
	{
		SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
		Date d=new Date();
		String s=sf.format(d);
		File f=new File("D:\\AppiumFolder\\com.nobroker.assignment\\src\\test\\resources\\properties\\data.properties");
		FileInputStream fi=new FileInputStream(f);
		p=new Properties();
		p.load(fi);		
		tu=new TestUtility();
		URL u=tu.startAppiumServer();		
		DesiredCapabilities dc=tu.defineDesiredCapabilities(p);		
		while(2>1)
		{
			try
			{
				driver = new AndroidDriver<AndroidElement>(u, dc);
				break;
			}
			catch(Exception e)
			{				
			}
		}		
	}
		
	@Test(priority=1)
	public void homepage() throws Exception
	{
		Homepage hp=new Homepage(driver);
		w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.elementToBeClickable(hp.continuebutton));
		hp.clickContinue();
		for(int i=1;i<=3;i++)
		{
			w.until(ExpectedConditions.elementToBeClickable(hp.denybutton));
			hp.clickDeny();
		}
		w.until(ExpectedConditions.elementToBeClickable(hp.buytext));
		hp.clickBuy();
		w.until(ExpectedConditions.elementToBeClickable(hp.searchbox));
		hp.clickSearch();
	}
	
	@Test(priority=2)
	public void search() throws Exception
	{
		Searchpage sp=new Searchpage(driver);
		w.until(ExpectedConditions.visibilityOf(sp.dropdown));
		String actuallocation=sp.dropdown.getText();
		if(actuallocation.equals(sp.expectedlocation))
		{
			Reporter.log("Bangalore is already selected");
		}
		else
		{
			Reporter.log("Bangalore is not selected"); 
			sp.clickOnDropdown();
			w.until(ExpectedConditions.visibilityOf(sp.bangalorecity));
			sp.selectBangalore();
		}
		w.until(ExpectedConditions.visibilityOf(sp.searchbox));
		sp.enterLocation(p.getProperty("location1"));
		Thread.sleep(3000);
		sp.tap(257,823);
		sp.enterLocation(p.getProperty("location2")); 
		Thread.sleep(3000);
		sp.tap(257,823); 		
		w.until(ExpectedConditions.visibilityOf(sp.checkbox));
		sp.selectCheckbox();
		sp.selectBHK();
		sp.clickSearchButton(); 
	}
	
	@Test(priority=3)
	public void propertylist()  
	{		
		 Propertylistingpage pp=new Propertylistingpage(driver);		 
		 w.until(ExpectedConditions.visibilityOf(pp.cameraicon));
		 pp.scroll();
		 pp.clickfourthproperty();
		 w.until(ExpectedConditions.visibilityOf(pp.checkeligibilitybutton));
		 pp.scrollIntoView();
		 pp.clickWrongInfoButton();	
	}	
	
	@Test(priority=4)
	public void signin()
	{
		Signinpage sip=new Signinpage(driver);
		w.until(ExpectedConditions.visibilityOf(sip.phonetextbox));
		sip.enterPhoneNumber(p.getProperty("phonenumber"));
		w.until(ExpectedConditions.visibilityOf(sip.autologintext));
		k=new KeyEvent(AndroidKey.BACK);
		driver.pressKey(k);
		w.until(ExpectedConditions.elementToBeClickable(sip.havepasswordradiobutton));
		sip.selectRadioButton();
		w.until(ExpectedConditions.visibilityOf(sip.passwordtextbox));
		sip.enterPassword(p.getProperty("password")); 
		driver.hideKeyboard();
		sip.clickContinueButton();
	}
	
	@Test(priority=5)
	public void report() throws Exception
	{
		Reportpage rp=new Reportpage(driver);
		w.until(ExpectedConditions.visibilityOf(rp.reportbutton));
		List<AndroidElement> l=rp.allcheckbox; 
		for(int i=0;i<l.size();i++)
		{
			l.get(i).click();
		}
		rp.clickReport();
		w.until(ExpectedConditions.visibilityOf(rp.location));
		driver.pressKey(k);
		driver.hideKeyboard();
		w.until(ExpectedConditions.elementToBeClickable(rp.threebhk));
		rp.clickbhkdropdown();
		w.until(ExpectedConditions.elementToBeClickable(rp.fourplusbhk));
		rp.clickfourplusbhk();
		rp.addNote(p.getProperty("note"));
		rp.clickSave();
		w.until(ExpectedConditions.visibilityOf(rp.feedback));
		String actualmsg=rp.getoutputtext();
		if(actualmsg.equals(rp.expectedmsg))
		{
			Reporter.log("Test Passed");
		}
		else
		{
			Reporter.log("Test Failed");
			tu.screenshot();
		}
	}
	
	@AfterTest
	public void stopExecution() throws Exception
	{
		tu.closeapp(driver);
		tu.stopAppiumServer();	
	}	
}

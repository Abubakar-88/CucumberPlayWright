package base;

import org.testng.Assert;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.WaitForSelectorOptions;
import com.microsoft.playwright.options.SelectOption;


import utils.PlaywrightDriver;

public class BasePage {
	
	
	public static Page page;
 public static utils.ExcelReader reader;
	
	
	public BasePage() {
		
		page = PlaywrightDriver.getPage();


		
	}

	
	public void click(String locatorKey) {

		try {
			page.locator(PlaywrightDriver.OR.getProperty(locatorKey)).click();
		} catch (Throwable t) {

			Assert.fail(t.getMessage());
		}
	}
	
	
	public void mouseHover(String locatorKey) {

		try {
			page.hover(PlaywrightDriver.OR.getProperty(locatorKey));
		} catch (Throwable t) {

				Assert.fail(t.getMessage());
		}
	}

	public boolean isElementPresent(String locatorKey) {

		try {
			page.waitForSelector(PlaywrightDriver.OR.getProperty(locatorKey), new WaitForSelectorOptions().setTimeout(2000));

				return true;
		} catch (Throwable t) {

	
			return false;
		}

	}

	public void type(String locatorKey, String value) {
		try {
			page.locator(PlaywrightDriver.OR.getProperty(locatorKey)).fill(value);
		} catch (Throwable t) {

				Assert.fail(t.getMessage());
		}
	}

	
	public void select(String locatorKey, String value) {
		try {
			page.selectOption(PlaywrightDriver.OR.getProperty(locatorKey),new SelectOption().setLabel(value));
			} catch (Throwable t) {

			Assert.fail(t.getMessage());
		}
	}
	public String getText(String locatorKey) {
		try {
			return page.locator(PlaywrightDriver.OR.getProperty(locatorKey)).innerText();
		} catch (Throwable t) {

			return null; // or throw an exception, depending on your requirements
		}
	}




}

package steps;

import java.io.IOException;
import java.nio.file.Paths;

import com.microsoft.playwright.Page;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import utils.PlaywrightDriver;

public class Hooks {
	
	
	public Page page;
	
	@Before
	public void setUp() throws IOException, InvalidFormatException {
		
		PlaywrightDriver.setupDriver();
		
	}
	
	@After
	public void tearDown(Scenario scenario) {
		
		if(scenario.isFailed()) {
			
			page = PlaywrightDriver.getPage();
			byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./screenshot/screenshot.png")));
			scenario.attach(screenshot, "image/png", "screenshot");
		
		
		}
		
		PlaywrightDriver.closeBrowser();
		PlaywrightDriver.quitPlaywright();
	}

}

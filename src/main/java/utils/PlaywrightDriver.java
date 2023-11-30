package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class PlaywrightDriver {
	
	
	public static PlaywrightDriver playwrightDriver;
	private Playwright playwright;
	public Browser browser;
	public Page page;
	public static Properties OR = new Properties();
	public static Properties config = new Properties();
	private static FileInputStream fis;
	public static ExcelReader excelReader;
//	public static List<Map<String,String>> testData;
	
	

	private static ThreadLocal<Playwright> pw = new ThreadLocal<>();
	private static ThreadLocal<Browser> br = new ThreadLocal<>();
	private static ThreadLocal<Page> pg = new ThreadLocal<>();
	
	public static Playwright getPlaywright() {

		return pw.get();
	}

	public static Browser getBrowser() {

		return br.get();
	}

	public static Page getPage() {

		return pg.get();
	}
	
	
	private PlaywrightDriver()  {
		excelReader = new ExcelReader();
//		testData = excelReader.getData(System.getProperty("user.dir") + "\\src\\main\\resources\\testData\\loginData.xlsx", "loginTestData");
		
		try {
			fis = new FileInputStream("./src/main/resources/properties/OR.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			OR.load(fis);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			fis = new FileInputStream("./src/main/resources/properties/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		playwright = Playwright.create();
		pw.set(playwright);
		
		
		if(config.getProperty("browser").equals("chrome")) {
			
			browser = getPlaywright().chromium()
			.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
			
		}else if(config.getProperty("browser").equals("firefox")) {
			
			browser = getPlaywright().firefox()
			.launch(new BrowserType.LaunchOptions().setChannel("firefox").setHeadless(false));
			
		}
		
		br.set(browser);
		page = getBrowser().newPage();
		pg.set(page);
	}
	
	
	public static void setupDriver() throws IOException, InvalidFormatException {
		
		playwrightDriver = new PlaywrightDriver();
	}
	
	
	public static void openPage(String url) {
		
		
		getPage().navigate(url);
	}
	
	
	public static void closeBrowser() {
		
		getBrowser().close();
		getPage().close();
	}
	

	
	
	public static void quitPlaywright() {
		
		
		if(getPage()!=null) {
			
			getPlaywright().close();
			
		}
		
	}

}

package Package1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;

public class AutoClass1 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		//System.out.println("My First Java Statement");
		
		//For Chrome Driver
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//For Firefox Driver
		//System.setProperty("webdriver.gecko.driver", "E:\\Selenium Java\\geckodriver-v0.28.0-win64\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		//For Internet explorer
		//System.setProperty("webdriver.ie.driver", "E:\\Selenium Java\\IEDriverServer_Win32_3.150.1\\IEDriverServer.exe");
		//WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get("https://www.aceblend.com/");
		String pageTitle = driver.getTitle();
		System.out.println("Page Title: "+pageTitle);
		
		System.out.println(driver.getCurrentUrl());
		driver.navigate().to("https://www.selenium.dev/downloads/");
		driver.navigate().back();
		
		driver.quit();
		WebDriver driver2 = new ChromeDriver();
		driver2.get("https://www.aceblend.com/");
		
	}
}

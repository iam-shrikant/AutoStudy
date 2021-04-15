package Package1;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;


	
public class TakeScreenShot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.guru99.com/top-100-selenium-interview-questions-answers.html");
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileFilter.copyFile(src, new File("C://screenshot.png"));
		try {
			FileHandler.copy(src, new File("D://screenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

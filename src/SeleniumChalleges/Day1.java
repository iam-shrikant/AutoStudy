package SeleniumChalleges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.worldometers.info/world-population/");
		driver.manage().window().maximize();		
		
		int count = 20;
		System.out.println("Today \t ||This Year        ");
		while(count>1) {
			String currentWorldPopulation = driver.findElement(By.cssSelector(".maincounter-number")).getText();
			
			String birthsToday            = driver.findElement(By.xpath("//span[@rel='births_today']")).getText();
			String deathsToday            = driver.findElement(By.xpath("//span[@rel='dth1s_today']")).getText();
			String absoluteGrowthToday    = driver.findElement(By.xpath("//span[@rel='absolute_growth']")).getText();
			
			String births_this_year       = driver.findElement(By.xpath("//span[@rel='births_this_year']")).getText();
			String dth1s_this_year        = driver.findElement(By.xpath("//span[@rel='dth1s_this_year']")).getText();
			String absolute_growth_year   = driver.findElement(By.xpath("//span[@rel='absolute_growth_year']")).getText();
			
			System.out.println("=======================================================");
			System.out.println("Current World Population: "+currentWorldPopulation);
			System.out.println("-------------------------------------------------------");
			System.out.println("Births today \t \t || Births this year");
			System.out.println(birthsToday+" \t \t || "+births_this_year);  
			System.out.println("-------------------------------------------------------");
			
			System.out.println("-------------------------------------------------------");
			System.out.println("Deaths today \t \t || Deaths this year");
			System.out.println(deathsToday+" \t \t || "+dth1s_this_year);  
			System.out.println("-------------------------------------------------------");
			
			System.out.println("-------------------------------------------------------");
			System.out.println("Population Growth today || Population Growth this ear");
			System.out.println(absoluteGrowthToday+" \t \t || "+absolute_growth_year);  
			System.out.println("-------------------------------------------------------");			
			count--;
		}
		driver.close();		
	}

}

package SeleniumChalleges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2 {
	WebDriver driver;
	
	public void setConfig() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.noon.com/uae-en/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public ArrayList<String> sectionName(String sectionName) throws InterruptedException {
		String xpathSection = "//*[text()='"+sectionName+"']/parent::div/parent::div/following-sibling::div";
		String xpathSectionBlock = xpathSection+"/div[contains(@class,'swiper-container-horizontal')]/div/div";
		String xpathSectionNextButton = xpathSection+"/div[2]";
		
		//System.out.println(xpathSection);
		
		while(driver.findElements(By.xpath(xpathSection)).isEmpty()) {			
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("window.scrollBy(0,500)");
		}		
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath(xpathSection))).build().perform();
		ArrayList<String> productName = new ArrayList<String>();
		
		boolean condition = driver.findElement(By.xpath(xpathSectionNextButton)).isDisplayed();
		
		int totalProd = driver.findElements(By.xpath(xpathSectionBlock)).size();		
		int noOfProductinSlide = 7;
		int noOfSlids = 1;
		
		noOfSlids = totalProd/noOfProductinSlide;
		if(totalProd % noOfProductinSlide != 0) {
			noOfSlids +=1;
		}
		
		for(int i = 0;i < noOfSlids;i++) {
			List<WebElement> recom = driver.findElements(By.xpath(xpathSectionBlock));		 
			for(WebElement e :recom) {			
				String prodName = e.findElement(By.xpath(".//a/div")).getAttribute("title");
				//System.out.println("prodName: "+prodName);
				if(!prodName.isEmpty() && !productName.contains(prodName)) {
					productName.add(prodName);
				}				
			}						
			condition = driver.findElement(By.xpath(xpathSectionNextButton)).isDisplayed();		
			
			if(condition) {
				driver.findElement(By.xpath(xpathSectionNextButton)).click();
				Thread.sleep(1000);
			}
		}		
		
		Collections.sort(productName);
		return productName;
	}
	
	public void tearDown() {
		driver.close();
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ArrayList<String> recommendedProducts = new ArrayList<String>();
		ArrayList<String> mobileTablets = new ArrayList<String>();
		ArrayList<String> topElectronic = new ArrayList<String>();
		
		Day2 day2 = new Day2();
		day2.setConfig();
		recommendedProducts = day2.sectionName("Recommended For You");
		//mobileTablets = day2.sectionName("Save big on mobiles & tablets");		
		//topElectronic = day2.sectionName("Top picks in electronics");
		
		System.out.println("---------Recommanded products--------------");
		for(String rp :recommendedProducts) {
			System.out.println(rp);
		}	
		
		System.out.println("---------Save big on mobiles & tablets--------------");
		for(String mt :mobileTablets) {
			System.out.println(mt);
		}	
		
		System.out.println("---------Top picks in electronics--------------");
		for(String e :topElectronic) {
			System.out.println(e);
		}
		
		day2.tearDown();
	}
}

package RealTimeProblems;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ValidateProductSortByPrice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.myntra.com/men-tshirts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//input[@value='Dog Tshirts']"))).click().build().perform();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//input[@value='Dog Tshirts']")).click();
		
		//a.moveToElement().
		
		List<WebElement> productResult = driver.findElements(By.cssSelector(".product-base"));
		
		//System.out.println(productResult.size());
		
		//for(WebElement prod : productResult) {
			//System.out.println(prod.findElement(By.xpath("//div[@class='product-price']")).getText());
		//}
		
		//*[@id="desktopSearchResults"]/div[2]/section/ul/li[1]/a/div[2]/div[1]/span
		
		  for(int i = 1;i<=productResult.size();i++) { 
			  //String productPrice = productResult.get(i).getText();
			  //String productPrice = productResult.get(i).findElement(By.xpath("//a/div[@class='product-productMetaInfo']/div[@class='product-price']")).getText();
			  String productPrice = driver.findElement(By.xpath("//li[@class='product-base']["+i+"]/a/div[@class='product-productMetaInfo']/div[@class='product-price']")).getText();
			  System.out.println(productPrice); 
			  
			
		  }
		 
	}

}

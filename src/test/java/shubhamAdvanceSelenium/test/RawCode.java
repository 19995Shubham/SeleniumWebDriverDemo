package shubhamAdvanceSelenium.test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;

public class RawCode {

	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		WebElement radio2 = driver.findElement(By.cssSelector("input[value='radio2']"));
		//radio2.click();
		
	    List<WebElement> radioButton =	driver.findElements(By.xpath("//*[@id=\"radio-btn-example\"]//input"));
	    
	   
	    for(int i =0; i<radioButton.size(); i++) {
	    	 
	    	WebElement local_radio = radioButton.get(i);
	    	
	    	String value = local_radio.getAttribute("value");
	    	System.out.println(value);
//	    	String text = local_radio.getText();
//	    	System.out.println(text);
//	    	
	    	if(value.equalsIgnoreCase("Radio1")) {
	    		local_radio.click();
	    	}
			
		} 
		
		//https://rahulshettyacademy.com/client
		
//	    String productName = "ZARA COAT 3";
//		driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
//		driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
//		driver.findElement(By.id("login")).click();
//		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
//			List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
//		
//	WebElement prod =	products.stream().filter(product->
//		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
//		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
//		
//		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//		//ng-animating
//		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
//		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
//		
//		List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));		
//	Boolean match = 	cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
//	Assert.assertTrue(match);
//	driver.findElement(By.cssSelector(".totalRow button")).click();
//	
//	Actions a = new Actions(driver);
//	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
//	
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//	
//	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
//	driver.findElement(By.cssSelector(".action__submit")).click();
//	
//	String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
//	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//	driver.close();
//
	}
}

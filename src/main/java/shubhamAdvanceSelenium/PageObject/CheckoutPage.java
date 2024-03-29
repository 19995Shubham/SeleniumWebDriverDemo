package shubhamAdvanceSelenium.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shubhamAdvacneSelenium.AbstractComponent.AbstractComponent;

public class CheckoutPage extends AbstractComponent{

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".action__submit")
	 private WebElement submit;

	@FindBy(css = "[placeholder='Select Country']")
	private WebElement country;

	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	private WebElement selectCountry;

	private By results = By.cssSelector(".ta-results");

	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		//waitForElementToAppear(By.cssSelector(".ta-results"));
		selectCountry.click();
	}
	
	public ConfirmationPage submitOrder()
	{

		//WebElement ele = driver.findElement(By.cssSelector(".action__submit"));

		javaScriptScroll().executeScript("arguments[0].click()", submit); 
		
		//submit.click();
		return new ConfirmationPage(driver);
		
		
		/*
		 *    // Create an instance of JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down by 500 pixels vertically
        js.executeScript("window.scrollBy(0,500)");

        // Alternatively, you can scroll to a specific element
        // WebElement element = driver.findElement(By.id("elementId"));
        // js.executeScript("arguments[0].scrollIntoView();", element);
*/
		
		
	}
}

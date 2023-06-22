package shubhamAdvanceSelenium.stepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import shubhamAdvanceSelenium.PageObject.CartPage;
import shubhamAdvanceSelenium.PageObject.CheckoutPage;
import shubhamAdvanceSelenium.PageObject.ConfirmationPage;
import shubhamAdvanceSelenium.PageObject.LandingPage;
import shubhamAdvanceSelenium.PageObject.ProductCatalogue;
import shubhamAdvanceSelenium.TestComponents.BaseTest;

public class StepDefinitionImpl extends BaseTest{
  
	LandingPage landingPage;
	ProductCatalogue productCatalogue;
	ConfirmationPage confirmationPage;
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		
	  landingPage = launchApplication();
	 
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String userName,String password) {
         productCatalogue = landingPage.loginApplication(userName,password);
	}
	
	@When("^I add product (.+) to cart$")
	public void  I_add_product_to_cart(String productName) throws InterruptedException{
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
	}
	
	@When("^Checkout (.+) and submit the order$")
	public void Checkout_and_submit_the_order(String productName) {
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
	    confirmationPage = checkoutPage.submitOrder();
	}
	
	@Then("{string} message is display on confirmationPage")
	public void message_is_display_on_confirmation_page(String string) {
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.quit();
	}

}

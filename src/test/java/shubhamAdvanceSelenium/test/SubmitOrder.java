package shubhamAdvanceSelenium.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import shubhamAdvanceSelenium.PageObject.CartPage;
import shubhamAdvanceSelenium.PageObject.CheckoutPage;
import shubhamAdvanceSelenium.PageObject.ConfirmationPage;
import shubhamAdvanceSelenium.PageObject.OrderPage;
import shubhamAdvanceSelenium.PageObject.ProductCatalogue;
import shubhamAdvanceSelenium.TestComponents.BaseTest;

public class SubmitOrder extends BaseTest {

	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {

		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry(input.get("country"));
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(input.get("confirmMessage")));

	}

	@Test(dependsOnMethods = { "submitOrder" })
	public void OrderHistoryTest() {
		// "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("stripathia8@gmail.com", "Shubham@123456789");
		OrderPage ordersPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));

	}

	// Extent Reports -

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//shubhamAdvanceSelenium//data//PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}

//	 @DataProvider
//	  public Object[][] getData()
//	  {
//	    return new Object[][]  {{"anshika@gmail.com","Iamking@000","ZARA COAT 3"}, {"shetty@gmail.com","Iamking@000","ADIDAS ORIGINAL" } };
//	    
//	  }
//	HashMap<String,String> map = new HashMap<String,String>();
//	map.put("email", "anshika@gmail.com");
//	map.put("password", "Iamking@000");
//	map.put("product", "ZARA COAT 3");
//	
//	HashMap<String,String> map1 = new HashMap<String,String>();
//	map1.put("email", "shetty@gmail.com");
//	map1.put("password", "Iamking@000");
//	map1.put("product", "ADIDAS ORIGINAL");

}

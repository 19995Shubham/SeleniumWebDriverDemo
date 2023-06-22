package shubhamAdvanceSelenium.test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import shubhamAdvanceSelenium.PageObject.CartPage;
import shubhamAdvanceSelenium.PageObject.ProductCatalogue;
import shubhamAdvanceSelenium.TestComponents.BaseTest;

public class ErrorValidation extends BaseTest {

	@Test(groups = {"ErrorHandling"}, retryAnalyzer = shubhamAdvanceSelenium.TestComponents.Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException {

		landingPage.loginApplication("stripathi8@gmail.com", "Shubham@12345678");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}

	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException {

		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("rahulshetty@gmail.com", "Iamking@000");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);

	}

}
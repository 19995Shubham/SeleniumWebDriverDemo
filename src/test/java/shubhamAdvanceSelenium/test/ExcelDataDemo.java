
package shubhamAdvanceSelenium.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import shubhamAdvanceSelenium.PageObject.CartPage;
import shubhamAdvanceSelenium.PageObject.CheckoutPage;
import shubhamAdvanceSelenium.PageObject.ConfirmationPage;
import shubhamAdvanceSelenium.PageObject.ProductCatalogue;
import shubhamAdvanceSelenium.TestComponents.BaseTest;

public class ExcelDataDemo extends BaseTest {
	DataFormatter formatter = new DataFormatter();

	@Test(dataProvider = "driveTest")
	public void testCaseData(String email, String password, String productName) throws InterruptedException {
		System.out.println(email + password + productName);

		ProductCatalogue productCatalogue = landingPage.loginApplication(email, password);
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@DataProvider(name = "driveTest")
	public Object[][] getData() throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\ShubhamT.INTERRAIT\\Documents\\excelDriven.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheetAt(0);

		int rowCount = sheet.getPhysicalNumberOfRows();

		XSSFRow row = sheet.getRow(0);

		int columnCount = row.getLastCellNum();

		Object data[][] = new Object[rowCount - 1][columnCount];

		for (int i = 0; i < rowCount - 1; i++)

		{

			row = sheet.getRow(i + 1);

			for (int j = 0; j < columnCount; j++)

			{

				XSSFCell cell = row.getCell(j);

				data[i][j] = formatter.formatCellValue(cell);

			}

		}

		return data;

	}
}

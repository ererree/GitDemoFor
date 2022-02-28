package StepDefinationPKG;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjectPKG.CheckOutPage;
import PageObjectPKG.LandingPage;
import UtilsPKG.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckOutStepDefinations {

	public WebDriver driver;
	public String landingprodcutname;
	public String offerpageprodname;
	TestContextSetup testcontextsetup;

	// constrcutor
	public CheckOutStepDefinations(TestContextSetup testcontextsetup) {
		this.testcontextsetup = testcontextsetup;

	}


	@Then("^user proceeds to checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout_and_validate_the_items_in_checkout_page(String names) throws InterruptedException {

		CheckOutPage checkoutpage = new CheckOutPage(testcontextsetup.driver);

		checkoutpage.CheckOutItems();
		Thread.sleep(3000);

	}

	@And("^Verify user has to apply Promocode and place the order$")
	public void verify_user_has_to_apply_promocode_and_place_the_order() {
		CheckOutPage checkoutpage = new CheckOutPage(testcontextsetup.driver);

		Assert.assertTrue(checkoutpage.verifyPromoButton());
		Assert.assertTrue(checkoutpage.verifyPlaceOrderButton());
	}

	@And("Added {string} Items of selected product to cart")
	public void added_something_items_of_selected_product_to_cart(String quantity) throws InterruptedException {
		LandingPage landingPage = new LandingPage(testcontextsetup.driver);

		landingPage.AddNoOfItemCount(quantity);
		Thread.sleep(3000);
	}
}

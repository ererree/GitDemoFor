package StepDefinationPKG;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjectPKG.LandingPage;
import PageObjectPKG.OffersPage;
import UtilsPKG.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OfferPageStepDefination {

	public WebDriver driver;
	public String landingprodcutname;
	public String offerpageprodname;
	TestContextSetup testcontextsetup;

	public OfferPageStepDefination(TestContextSetup testcontextsetup) {
		this.testcontextsetup = testcontextsetup;

	}

	@Then("^user searched for same shortname (.+) in offer page$")
	public void user_searched_for_same_shortname_in_offer_page(String strArg1) throws InterruptedException {

		switchToOffersPage();
		OffersPage offersPage = new OffersPage(testcontextsetup.driver);

		offersPage.SearchItemOffers(strArg1);
		// testcontextsetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(strArg1);
		Thread.sleep(3000);
		offerpageprodname = offersPage.getProductNameOffers();
		System.out.println("Value of offerpageprodname is ==" + offerpageprodname);
		System.out.println("Test Case 3 is Passed>>>>>>>>>>>>");

	}

	public void switchToOffersPage() {
		LandingPage landingPage = new LandingPage(testcontextsetup.driver);
		landingPage.selectTopDeals();
		Set<String> s1 = testcontextsetup.driver.getWindowHandles();
		Iterator<String> l1 = s1.iterator();
		String parentwindow = l1.next();
		String chaildwindow = l1.next();
		testcontextsetup.driver.switchTo().window(chaildwindow);

	}

	@And("Validate the product name in offerspage matches with landing page")
	public void validate_the_product_name_in_offerspage_matches_with_landing_page() {
		Assert.assertEquals(offerpageprodname, testcontextsetup.landingprodcutname);

		System.out.println("Test Case 4 is Passed>>>>>>>>>>>>");
	}
}

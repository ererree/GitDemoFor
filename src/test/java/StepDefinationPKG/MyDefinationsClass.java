package StepDefinationPKG;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjectPKG.LandingPage;
import UtilsPKG.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class MyDefinationsClass {

	public WebDriver driver;
	public String landingprodcutname;
	public String offerpageprodname;
	TestContextSetup testcontextsetup;

	// constrcutor
	public MyDefinationsClass(TestContextSetup testcontextsetup) {
		this.testcontextsetup = testcontextsetup;

	}

	
	@Given("User is on Greencart landing page")
	public void user_is_on_greencart_landing_page() {
		System.setProperty("webdriver.chrome.driver", "D:\\Chrome 97\\chromedriver.exe");
		testcontextsetup.driver = new ChromeDriver();
		testcontextsetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		//Assert.assertTrue(landingPage.getTitleOfLanding().contains("GreenKart"));
		
		System.out.println("Test Case 1 is Passed>>>>>>>>>>>>");

	}

	@When("^user searched with shortname (.+) and extracted actual name of that product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_that_product(String shortname)
			throws InterruptedException {
		LandingPage landingPage = new LandingPage(testcontextsetup.driver);

		landingPage.SearchItem(shortname);

		Thread.sleep(3000);
		testcontextsetup.landingprodcutname = landingPage.getProductName().split("-")[0].trim();
		System.out.println("Value of landingprodcutname is ==" + testcontextsetup.landingprodcutname);
		System.out.println("Test Case 2 is Passed>>>>>>>>>>>>");

	}

}

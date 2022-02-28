package PageObjectPKG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {

	public WebDriver driver;
	By Search = By.xpath("//input[@type='search']");
	By ProductName = By.cssSelector("tr td:nth-child(1)");

	
	public OffersPage(WebDriver driver) {
		this.driver=driver;
	}

	public void SearchItemOffers(String name) {

		driver.findElement(Search).sendKeys(name);
	}
	
	public String getProductNameOffers()
	
	{
		return(driver.findElement(ProductName).getText());
		
	}
}

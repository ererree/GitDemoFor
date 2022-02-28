package PageObjectPKG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {

	// Consturctor
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver driver;
	By cart = By.cssSelector("img[alt='Cart']");
	By checkoutButton = By.xpath("//*[@id='root']/div/header/div/div[3]/div[2]/div[2]/button");
	By Promocodebutton=By.cssSelector(".promoBtn");
	By PlaceOrderbutton=By.xpath("//button[contains(text(),'Place Order')]");

	public void CheckOutItems() {

		driver.findElement(cart).click();
		driver.findElement(checkoutButton).click();
	}

	public Boolean verifyPromoButton()	
	{
		return driver.findElement(Promocodebutton).isDisplayed();
	}
	
	public Boolean verifyPlaceOrderButton()	
	{
		return driver.findElement(PlaceOrderbutton).isDisplayed();
	}
}

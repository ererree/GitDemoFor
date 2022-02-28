package PageObjectPKG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

	public WebDriver driver;
	By Search = By.xpath("//input[@type='search']");
	By ProductName = By.xpath("//*[@id=\'root\']/div/div[1]/div/div/h4");
    By TopDeals=By.xpath("//*[@id=\'root\']/div/header/div/div[3]/a[2]");
	By ItemCount=By.cssSelector(".increment");
	By addToCartButton=By.xpath("//button[contains(text(),'ADD TO CART')]");
	
	
    
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}

	public void SearchItem(String name) {

		driver.findElement(Search).sendKeys(name);
	}
	
	public String getProductName()
	
	{
		return(driver.findElement(ProductName).getText());
		
	}
	
	public void selectTopDeals()
	
	{
		
		driver.findElement(TopDeals).click();
	}
	public String getTitleOfLanding()
	{
		return driver.getTitle();
		
	}
	
	public void AddNoOfItemCount(String count)
	{
		int c=Integer.parseInt(count);  
		for(int i=0;i<c-1;i++)
		{
			driver.findElement(ItemCount).click();
		}
		driver.findElement(addToCartButton).click();
	}
}

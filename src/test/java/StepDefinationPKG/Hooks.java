package StepDefinationPKG;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import UtilsPKG.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks {

	public TestContextSetup  testcontextsetup;
	public Hooks(TestContextSetup testcontextsetup) {
		this.testcontextsetup = testcontextsetup;

	}
	@After
	public void afterScenario()
	{
		System.out.println("code changed for Git Test");
		testcontextsetup.driver.quit();
		
	}
	
@AfterStep
public void AddScreenSHot(Scenario scenario) throws IOException
{
	WebDriver driver=testcontextsetup.driver;
	if(scenario.isFailed())
	{
	File sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	byte[] filecontent=FileUtils.readFileToByteArray(sourcePath);
	scenario.attach(filecontent, "image/jpg", "image");
	}
	//System.out.println("I am Here");
}
}

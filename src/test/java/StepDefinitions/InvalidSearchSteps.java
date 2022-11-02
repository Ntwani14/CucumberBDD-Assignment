package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.InvalidSearchPage;

public class InvalidSearchSteps {
	
	WebDriver driver = null;
	InvalidSearchPage InvalidSearch;
	
	@Given("I opened the browser")
	public void I_opened_the_browser() {
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is:"+projectPath);
		
		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/webDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.navigate().to(" https://www.amazon.in/");
	   
	}
	@When("I enters text in search box")
	public void I_enters_text_in_search_box() {
		
		InvalidSearch = new InvalidSearchPage(driver);
		InvalidSearch.enterTxtInSearchBox();
	
	}
	@Then("I clicks on search button")
	public void I_clicks_on_search_button() {
		
		InvalidSearch = new InvalidSearchPage(driver);
		InvalidSearch.ClickSearchButton();
			driver.close();
			
	}
	
	@And("text must not be searched")
	public void text_must_not_be_searched() {
		
		InvalidSearch = new InvalidSearchPage(driver);
		InvalidSearch.pageSource();
		
		//driver.close();
		driver.quit();
	}

}

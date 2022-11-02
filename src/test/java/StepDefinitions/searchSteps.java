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
import pages.SearchPage;
import pages.SearchPage;

public class searchSteps {
	
	WebDriver driver;;
	SearchPage search;
	
	@Before
	public void BrowserSetup() {
		System.out.println("=====I AM Before Hook ====");
	}
	
	@After
	public void tearDown() {
		System.out.println("=====I AM After HOOK ====");
	}
	
	@Given("I launched the browser")
	public void user_launched_the_browser() {
		
		//System.out.println("===== I AM BeforeStep HOOK =====");
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is:"+projectPath);
		
		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/webDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.navigate().to("https://www.Amazon.in/");
	   
	}
	@When("I enter text to be searched in search box")
	public void I_enter_text_to_be_searched_in_search_box() {
		
		search = new SearchPage(driver);
		search.enterTxtInSearchBox();
		
	}
	@Then("clicks on search button")
	public void clicks_on_search_button() {
		
		search = new SearchPage(driver);
		search.ClickSearchButton();
	  
	}
	@And("text must be searched")
	public void text_must_be_searched() {
		
		//System.out.println("===== I AM AfterStep HOOK =====");
		search = new SearchPage(driver);
		search.DisplayedSearchedTxt();
		
		
		driver.close();
		driver.quit();
	}
}

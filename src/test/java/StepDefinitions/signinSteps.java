package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.*;
import pages.SigninPage;

public class signinSteps {
	
	WebDriver driver = null;
	
	SigninPage signin;
	
	@BeforeStep
	public void BrowserSetup() {
		System.out.println("=====I AM BeforeStep Hook ====");
	}
	
	@AfterStep
	public void tearDown() {
		System.out.println("=====I AM AfterStep HOOK ====");
	}
	
	@Given("browser is open")
	public void browser_is_open() {
		
		System.out.println("Inside Step - browser is open");
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is:"+projectPath);
		
		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/webDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		
	}

	@And("user on amazon welcome page")
	public void user_on_amazon_welcome_page() {
		
		System.out.println("Inside Step - user on amazon welcome page");
		driver.navigate().to("https://www.amazon.in/");
		
	   
	}

	@And("clicks on Hello-signin hyper link")
	public void clicks_on_Hello_signin_hyper_link() {
		
		System.out.println("Inside Step - clicks on Hello-signin hyper link");
		signin = new SigninPage(driver);
		signin.clickSigninHyperLink();
		
	}
	

	@When("^user enters (.*)$")
	public void user_enters_email_or_phone_number(String emailOrPhoneNumber) {
		
		System.out.println("Inside Step - user enters valid email or phone number");
		
		signin = new SigninPage(driver);
		signin.enterEmailOrPhoneNumber(emailOrPhoneNumber);
	}

	@And("clicks on continue button")
	public void clicks_on_continue_button() {
		
		System.out.println("Inside Step - clicks on continue button");
		signin = new SigninPage(driver);
		signin.clickContinueButton();
	}

	@And("^enters valid(.*)$")
	public void enters_valid_password(String password) {
		
		signin = new SigninPage(driver);
		System.out.println("Inside Step - user enters valid password");
		signin.enterPassword(password);
	}

	@Then("clicks on sign-in button")
	public void clicks_on_sign_in_button() {
	   
		System.out.println("Inside Step - clicks on sign-in button");
		signin = new SigninPage(driver);
		signin.clickSigninBrutton();
	}

	@And("user is navigated to home page")
	public void user_is_navigated_to_home_page() {
		
		System.out.println("Inside Step - user is navigated to home page");
		signin = new SigninPage(driver);
		signin.navigatedToHomePage();
		
		driver.close();
		driver.quit();
	   
	}
}

package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.InvalidSignInPage;

public class InvalidSigninSteps {
	
	WebDriver driver = null;
	InvalidSignInPage InvalidSignin;

	@Given("browser is opened")
	public void browser_is_opened() {
		
		System.out.println("Inside Step - browser is opened");
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is:"+projectPath);
		
		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/webDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		
	}

	@And("I am on amazon welcome page")
	public void I_am_on_amazon_welcome_page() {
		
		System.out.println("Inside Step - I am on amazon welcome page");
		
		driver.navigate().to(" https://www.amazon.in/");
		
	   
	}

	@And("I click on Hello-signin partial link")
	public void I_click_on_Hello_signin_partial_link() {
		
		System.out.println("Inside Step - I click on Hello-signin partial link");
		
		InvalidSignin = new InvalidSignInPage(driver);
		InvalidSignin.signinPartialLink();
	}
	

	@When("^I enter valid (.*)$")
	public void I_enter_valid_email(String email) {
		
		System.out.println("Inside Step - I enter valid email");
		
		InvalidSignin = new InvalidSignInPage(driver);
		InvalidSignin.entervalidEmail(email);

	}

	@And("I click on continue button")
	public void clicks_on_continue_button() {
		
		System.out.println("Inside Step - clicks on continue button");
		
		InvalidSignin.ClickContinueButton();
	}

	@And("^enters invalid (.*)$")
	public void enters_invalid_password(String password) {
		
		
		System.out.println("Inside Step - enters invalid password");
		
		InvalidSignin = new InvalidSignInPage(driver);
	    InvalidSignin.enterInvalidPassword(password);
	}

	@Then("click on sign-in button")
	public void click_on_sign_in_button() {
	   
		System.out.println("Inside Step - click on sign-in button");
		InvalidSignin = new InvalidSignInPage(driver);
		InvalidSignin.ClickContinueButton();
		
	}

	@And("I must get an error message")
	public void uI_must_get_an_error_message() {
		
		
		System.out.println("Inside Step - I must get an error message");
		InvalidSignin = new InvalidSignInPage(driver);
		InvalidSignin.getErrorMessage();
		
		driver.close();
		driver.quit();
	   
	}

}

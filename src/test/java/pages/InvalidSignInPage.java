package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InvalidSignInPage {
	
	WebDriver driver;
	
	By click_SigninPLink = By.id("nav-link-accountList-nav-line-1");
	By enterEmail = By.xpath("//input[@type='email']");
	By click_Continue = By.id("continue");
	By enterPassword = By.id("ap_password");
	By click_signinBtn = By.id("signInSubmit");
	By getErrorMsg = By.xpath("//body/div/div[1]");
	
	
	public InvalidSignInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void signinPartialLink() {
		
		  driver.findElement(click_SigninPLink).click();
	}
	
	public void entervalidEmail(String email) {
		
		driver.findElement(enterEmail).sendKeys(email);
	}
	
	public void ClickContinueButton() {
		driver.findElement(click_Continue).click();
	}
	
	public void enterInvalidPassword(String password) {
		driver.findElement(enterPassword).sendKeys(password);
	}
	
	public void clickOnSingninButton() {
		driver.findElement(click_signinBtn);
	}
	
	public void getErrorMessage() {
		driver.findElement(getErrorMsg).isDisplayed();
	}

}

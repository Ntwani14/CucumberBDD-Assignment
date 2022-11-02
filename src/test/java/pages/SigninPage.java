package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SigninPage {

	WebDriver driver;

	By click_signinHyperLink = By.id("nav-link-accountList-nav-line-1");

	By txt_emailOrPhoneNum = By.xpath("//input[@type='email']");

	By click_continueButton = By.id("continue");

	By txt_password = By.id("ap_password");

	By click_signinButton = By.id("signInSubmit");

	By homePageDisplayedText = By.xpath("//span[normalize-space()='& Orders']");


	public SigninPage(WebDriver driver) {

		this.driver = driver;
	}

	public void clickSigninHyperLink() {

		driver.findElement(click_signinHyperLink).click();
	}

	public void enterEmailOrPhoneNumber(String emailOrPhoneNumber) {

		driver.findElement(txt_emailOrPhoneNum).sendKeys(emailOrPhoneNumber);
	}

	public void clickContinueButton() {

		driver.findElement(click_continueButton).click();
	}

	public void enterPassword(String password) {

		driver.findElement(txt_password).sendKeys(password);
	}

	public void clickSigninBrutton() {

		driver.findElement(click_signinButton).click();
	}

	public void navigatedToHomePage() {

		driver.findElement(homePageDisplayedText).isDisplayed();
	}


}

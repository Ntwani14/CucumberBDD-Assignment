package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InvalidSearchPage {
	
	WebDriver driver;

	By txt_box = By.id("twotabsearchtextbox");
	By search_button = By.id("nav-search-submit-button");

	public InvalidSearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterTxtInSearchBox() {
		
	driver.findElement(txt_box).sendKeys("Laptop Bags");

	}

	public void ClickSearchButton() {
		
		driver.findElement(search_button).click();

	}

	public void pageSource() {
		
		driver.getPageSource().contains("//a[@aria-label='Amazon']");;

	}

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

	WebDriver driver;

	By txt_box = By.xpath("//input[@aria-label='Search']");
	By search_button = By.id("nav-search-submit-button");
	By searched_txt = By.xpath("//span[normalize-space()='Department']");

	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterTxtInSearchBox() {
		
	driver.findElement(txt_box).sendKeys("Office tables");

	}

	public void ClickSearchButton() {
		
		driver.findElement(search_button).click();

	}

	public void DisplayedSearchedTxt() {
		
		driver.findElement(searched_txt).isDisplayed();

	}

}

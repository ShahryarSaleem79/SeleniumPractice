package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class AutoSuggestiveDropdown {

	private WebDriver driver;

	@FindBy(id = "autosuggest")
	WebElement autosuggestdropdown;

	@FindBy(xpath = "//a[@class='ui-corner-all']")
	List<WebElement> countryList;

	public AutoSuggestiveDropdown(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void searchCountry(String country) {
		autosuggestdropdown.clear();
		autosuggestdropdown.sendKeys(country);
		System.out.println(autosuggestdropdown.getAttribute("type"));
	}

	public void listofCountries() {
		for (WebElement country : countryList) {
			System.out.println("Number of countries displayed:  "+ country.getText());
		}
	}

	public int numofCountries() {
		return countryList.size();
	}
	
	
	public void clickCountry(String countryName) {
		for (WebElement country : countryList) {
			if (country.getText().equals(countryName)) {
				country.click();

			}
		}
	}

}

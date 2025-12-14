package tests;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.AutoSuggestiveDropdown;

public class AutoSuggestedDropdownTest extends BaseTest {
	
	//protected WebDriver driver=null;
	
	
	@Test
	@Parameters({"country","countryName"})
	public void countryname(String country, String countryName) {
		AutoSuggestiveDropdown dropdown = new AutoSuggestiveDropdown(driver);
		dropdown.searchCountry(country);
		System.out.println("Total countries:"+ dropdown.numofCountries());
		dropdown.listofCountries();
		dropdown.clickCountry(countryName);
	}
	


}

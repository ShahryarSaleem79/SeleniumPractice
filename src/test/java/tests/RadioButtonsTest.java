package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.RadioButtons;

public class RadioButtonsTest extends BaseTest {
	
	//protected WebDriver driver = null;
	@Test
	public void radioButtonTest() {
		RadioButtons radioButton = new RadioButtons(driver);
		radioButton.checkifEnabled();
		
	}
	
	
	
	

}

package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.Checkboxes;

public class CheckboxesTest extends BaseTest {
	
	@Test
	public void verifyCheckBox() {
		Checkboxes checkbox = new Checkboxes(driver);
		checkbox.getallCheckboxes();
		
		
	}
	
	
	
	

}

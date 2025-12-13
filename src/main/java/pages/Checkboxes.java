package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkboxes {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//input[@type='checkbox']")
	List<WebElement> checkboxes;
	
	//Senior Citizen Checkbox
	@FindBy(id="ctl00_mainContent_chk_SeniorCitizenDiscount")
	WebElement checkboxseniorCitizen;

	// Contructor
	public Checkboxes(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	public void getallCheckboxes() {
		for (WebElement checkbox : checkboxes) {
			String checkboxName = checkbox.getAttribute("name");
			System.out.println("CheckBox name is:   " + checkboxName);
			checkboxseniorCitizen.click();
			if(checkbox.isSelected()) {
			System.out.println("checkbox selected is   :"+ checkboxName);
		}
			else {
				System.out.println("No Checkbox is selected");
			}
	}

}
}

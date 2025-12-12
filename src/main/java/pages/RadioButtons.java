package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtons {

	private WebDriver driver;
	
	@FindBy(xpath="//input[@type='radio']")
	List<WebElement> radiobuttons;
	
	public RadioButtons(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions on Radio button: verify "OneWay" radio button is selected when the page loads
	public void checkifEnabled() {
		for (WebElement radiobutton : radiobuttons) {
			if(radiobutton.isSelected()) {
				System.out.println("Selected radio button is:   "+ radiobutton.getAttribute("value"));
			}
			
		}
	}
}

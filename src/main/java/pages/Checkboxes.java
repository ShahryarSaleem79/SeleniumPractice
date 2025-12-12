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
	
	@FindBy(xpath="//input[@type='checkbox']")
	List<WebElement> checkboxes;
	
	//Contructor
	public Checkboxes(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	public void getallCheckboxes() {
		for (WebElement checkbox : checkboxes) {
			System.out.println(checkbox.getAttribute("value"));
		}
	}
	

}

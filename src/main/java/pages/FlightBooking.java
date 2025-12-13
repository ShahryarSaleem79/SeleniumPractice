package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class FlightBooking {

	private WebDriver driver;
	protected WebDriverWait wait;
	
	@FindBy(id = "ctl00_mainContent_ddl_originStation1_CTXT")
	WebElement fromCity;
	//Depart city
	@FindBy(xpath="//div[@id='ctl00_mainContent_ddl_originStation1_CTNR']/div/table/tbody/tr/td/div/div/div/ul/li")
	List<WebElement> departureCities;
	//Arrival city
	@FindBy(xpath="//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']/div/table/tbody/tr/td/div/div/div/ul/li")
	List<WebElement> arrivalCities;
//	//datepicker button
//	@FindBy(xpath="//button[@class='ui-datepicker-trigger'][1]")
//	WebElement datepickerDeparture;
	//Datepicker
	@FindBy(xpath="//div[@class='ui-datepicker-title']")
	List<WebElement> monthandyear;
	//Depart Date
	@FindBy(xpath="//div[@class='ui-datepicker-group ui-datepicker-group-first']/table/tbody/tr/td")
	List<WebElement> departureDates;
	//View Depart date
	@FindBy(id="view_fulldate_id_1")
	WebElement selectedDate;
	//Passenger
	@FindBy(id="divpaxinfo")
	WebElement passengerSelect;
	// currency
	@FindBy(id="ctl00_mainContent_DropDownListCurrency")
	WebElement currency;
	//search button
	@FindBy(id="ctl00_mainContent_btn_FindFlights")
	WebElement searchButton;
	
	
	//constructor declaration
	public FlightBooking(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	//Actions
	//Select Departure city
	public void selectdeparturcityBox(String DepCity) {
		fromCity.click();
		for(WebElement departureCity : departureCities) {
			System.out.println(departureCity.getText());
			if(departureCity.getText().equals(DepCity)) {
				departureCity.click();
				break;
			}
		}
	}
	
	public void selectarrivalcityBox(String arrCity) {
		wait.until(ExpectedConditions.visibilityOfAllElements(arrivalCities));
		for (WebElement arrivalCity : arrivalCities) {
			System.out.println(arrivalCity.getText());
			if(arrivalCity.getText().equals(arrCity));
			arrivalCity.click();
			break;
		}
	}
	
	//click on the datepicker
	
//	public void clickdatepicker() {
//		datepickerDeparture.click();
//	}
	
	//get the month and year to have a starting point
	public void getmonthandyear() {
		for(WebElement mmyy: monthandyear) {
			System.out.println("Month and Date are:   "+ mmyy.getText());
		}
	}
	//select departure date
	public int sizedepartDate() {
		return departureDates.size();
	}
	
	public void selectdepartDate(String date) {
		wait.until(ExpectedConditions.visibilityOfAllElements(departureDates));
		for (WebElement departDate: departureDates ) {
			//System.out.println("Calendar Dates are:    "+ departDate.getText());
			if(departDate.getText().equals(date)) {
				departDate.click();
			}
			
		}
	}
	
	public void checkselectedDate(String displayedDate) {
		Assert.assertEquals(selectedDate.getText(), displayedDate); 
		System.out.println("Departure Date selected is:    "+ selectedDate.getText());
	}
	
	
//	public void selectPassenger() {
//		passengerSelect.click();
//	}
	
	public void selectCurrency(String curr) {
		wait.until(ExpectedConditions.visibilityOf(currency));
		Select currencydropdown = new Select(currency);
		currencydropdown.selectByValue(curr);
	}
	
	public void validateCurrency() {
		Assert.assertEquals(currency.getAttribute("value"), "INR");
	}
	
	public void clickSearch() {
		searchButton.click();
	}
	
}

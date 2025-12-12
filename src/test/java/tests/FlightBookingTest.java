package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.FlightBooking;

public class FlightBookingTest extends BaseTest {
	@Test
	@Parameters({"depCity","arrCity", "date", "displayedDate", "curr"})
	public void checkMMYY(String depCity, String arrCity, String date, String departedDate, String curr) {
		try {
		FlightBooking flightbooking = new FlightBooking(driver);
		flightbooking.selectdeparturcityBox(depCity);
		flightbooking.selectarrivalcityBox(arrCity);
		flightbooking.getmonthandyear();
		flightbooking.selectdepartDate(date);
		flightbooking.checkselectedDate(departedDate);
		flightbooking.selectCurrency(curr);
		flightbooking.validateCurrency();
		flightbooking.clickSearch();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
}

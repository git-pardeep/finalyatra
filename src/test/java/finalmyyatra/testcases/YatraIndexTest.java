package finalmyyatra.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import finalmyyatra.base.BaseClass;
import finalmyyatra.pages.YatraIndex;

public class YatraIndexTest extends BaseClass {
	private YatraIndex yatraindex;
	@BeforeMethod
	public void setUp() {
		launchBrowser();
	}
	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}
	@Test
	public void titleConfirm() {
		String actualtitle= "Flight, Cheap Air Tickets , Hotels, Holiday, Trains Package Booking - Yatra.com";
		
		String expectedtitle= yatraindex.title();
		Assert.assertEquals(actualtitle, expectedtitle,"not matched");
	}
	@Test
	public void searchFlight() throws InterruptedException {
		yatraindex = new YatraIndex();
		yatraindex.searchCity();
	
	}

}

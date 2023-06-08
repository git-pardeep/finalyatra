package finalmyyatra.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import finalmyyatra.base.BaseClass;
import finalmyyatra.pages.YatraIndex;
import finalmyyatra.utilities.Log;
import finalmyyatra.utilities.ReadExcelFile;

public class YatraIndexTest extends BaseClass {
	private YatraIndex yatraindex;
	@BeforeMethod
	public void setUp() {
		launchBrowser();
	}
	@AfterMethod
	public void tearDown() {
		getDriver().close();
	}
	@Test
	public void titleConfirm() {
		String actualtitle= "Flight, Cheap Air Tickets , Hotels, Holiday, Trains Package Booking - Yatra.com";
		String expectedtitle= yatraindex.title();
		Assert.assertEquals(actualtitle, expectedtitle,"not matched");
	}
	@Test(dataProvider="test",dataProviderClass=ReadExcelFile.class)
	public void searchFlight(String org,String dpr) throws InterruptedException {
		yatraindex = new YatraIndex();
		Log.startTest("Test Start searchflight");
		yatraindex.searchCity(org,dpr);
		Log.endTest("end Test searchflight");
	
	}

}

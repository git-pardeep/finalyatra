package finalmyyatra.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import finalmyyatra.base.BaseClass;
import finalmyyatra.pages.YatraIndex;
import finalmyyatra.pages.YatraSearchDate;
import finalmyyatra.utilities.Log;
import finalmyyatra.utilities.ReadExcelFile;

public class YatraSearchDateTest extends BaseClass{
	private YatraIndex yatraindex;
	private YatraSearchDate yatrasearchdate;
	@BeforeMethod
	public void setUp() {
		launchBrowser();
	}
	@AfterMethod
	public void tearDown() {
		getDriver().close();
	}
	@Test(dataProvider="test",dataProviderClass=ReadExcelFile.class)
	public void dateCheck(String org , String dpr, String dt) throws InterruptedException {
		yatraindex=new YatraIndex();
		Log.startTest("Test Start date check");
		yatrasearchdate= yatraindex.searchCity(org, dpr);
		yatrasearchdate.searchdate(dt);
		Log.startTest("Test end datecheck ");
	}
}

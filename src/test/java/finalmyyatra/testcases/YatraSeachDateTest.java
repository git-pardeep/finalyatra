package finalmyyatra.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import finalmyyatra.base.BaseClass;
import finalmyyatra.pages.YatraIndex;
import finalmyyatra.pages.YatraSearchDate;

public class YatraSeachDateTest extends BaseClass{
	YatraIndex yatraindex;
	 YatraSearchDate yatrasearchdate;
	 @BeforeMethod
	public void setUp() {
		launchBrowser();
	}
	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}
	@Test
	public void dateCheck() throws InterruptedException {
		yatraindex=new YatraIndex();
		yatraindex.searchCity();
//		yatrasearchdate= yatraindex.searchCity();
//		yatrasearchdate.searchdate();
	}

}

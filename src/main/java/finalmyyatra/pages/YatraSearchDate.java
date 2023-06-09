package finalmyyatra.pages;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import finalmyyatra.base.BaseClass;

public class YatraSearchDate extends BaseClass {
	Actions act = new Actions(getDriver());
	@FindBy(xpath = "//input[@value='Search Flights']")
	private WebElement searchbtn;
	@FindBy(xpath = "//input[@id='BE_flight_origin_date']")
	private WebElement date;
	@FindBy(xpath = "//div[@id='monthWrapper']//td[@class!='inActiveTD']")
	private List<WebElement> srcdate;

	public YatraSearchDate() {
		PageFactory.initElements(getDriver(), this);
	}

	public void searchdate(String dt1) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();

		System.out.println("search date");
		date.click();
		Thread.sleep(1000);
		int lsitsize = srcdate.size();
		Thread.sleep(1000);
		System.out.println(lsitsize);
		for (WebElement dt : srcdate) {
			String text =dt.getAttribute("data-date");
			System.out.println(text);
//			if (dt.getAttribute("data-date").equalsIgnoreCase("09/07/2023"))
				if (dt.getAttribute("data-date").equalsIgnoreCase(dt1)){
				System.out.println("eneter date select");
				js.executeScript("arguments[0].scrollIntoView();", dt);

				Thread.sleep(1000);
				act.moveToElement(dt).click();
				Thread.sleep(1000);
				System.out.println("date click succedully : " + dt.getAttribute("data-date"));
				Thread.sleep(1000);
				break;
			}
//			searchbtn.click();
		}
	}
}

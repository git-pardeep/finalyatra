package finalmyyatra.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import finalmyyatra.base.BaseClass;

public class YatraSearchDate extends BaseClass {
	@FindBy(xpath="//div[@class='ripple-parent search-height demo-icon icon-go']//input[@id='BE_flight_flsearch_btn']")
	private WebElement searchbtn;
	@FindBy(xpath="//input[@id='BE_flight_origin_date']") private WebElement date;
	@FindBy(xpath="//div[@id='monthWrapper']//td[@class!='inActiveTD']") private List<WebElement> searchdate;
	public YatraSearchDate() {
		PageFactory.initElements(getDriver(), this);
	}
	public void searchdate() {
		for (WebElement dt:searchdate) {
			String text=dt.getAttribute("data-date");
			System.out.println(text);
		}
		
		
	}
}

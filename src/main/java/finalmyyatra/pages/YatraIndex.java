package finalmyyatra.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import finalmyyatra.base.BaseClass;

public class YatraIndex extends BaseClass{
	@FindBy(id="BE_flight_origin_city") private WebElement depart;
	@FindBy(id="BE_flight_arrival_city") private WebElement going;
	@FindBy(xpath="//div[@class='ripple-parent search-height demo-icon icon-go']//input[@id='BE_flight_flsearch_btn']")
	private WebElement searchbtn;
	@FindBy(xpath="//input[@id='BE_flight_origin_date']") private WebElement date;
	@FindBy(xpath="//div[@id='monthWrapper']//td[@class!='inActiveTD']") private WebElement searchdate;
	public YatraIndex() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String title() {
	String title=getDriver().getTitle();
	System.out.println(title);
	return title;
	}
	public void searchCity() throws InterruptedException {
		depart.click();
		Thread.sleep(1000);
		depart.sendKeys("Mumbai");
		Thread.sleep(1000);
		depart.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		going.click();
		Thread.sleep(1000);
		going.sendKeys("kolkata");
		Thread.sleep(1000);
		going.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		searchbtn.click();
		Thread.sleep(2000);
	}
	public void searchdate() {
		
	}

}

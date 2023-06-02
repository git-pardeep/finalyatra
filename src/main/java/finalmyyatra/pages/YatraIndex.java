package finalmyyatra.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import finalmyyatra.base.BaseClass;

public class YatraIndex extends BaseClass{
	@FindBy(id="BE_flight_origin_city") private WebElement depart;
	@FindBy(id="BE_flight_arrival_city") private WebElement going;
	
	
	public YatraIndex() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String title() {
	String title=getDriver().getTitle();
	System.out.println(title);
	return title;
	}
	public YatraSearchDate searchCity() throws InterruptedException {
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
		return new YatraSearchDate();
	}
	

}

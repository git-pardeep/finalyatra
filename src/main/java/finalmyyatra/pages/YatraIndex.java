package finalmyyatra.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import finalmyyatra.action.Action;
import finalmyyatra.base.BaseClass;

public class YatraIndex extends BaseClass{
	@FindBy(id="BE_flight_origin_city") private WebElement depart;
	@FindBy(id="BE_flight_arrival_city") private WebElement going;
	Action act = new Action();
	
	public YatraIndex() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String title() {
	String title=getDriver().getTitle();
	System.out.println(title);
	return title;
	}
	public YatraSearchDate searchCity(String org,String dpr) throws InterruptedException {
//		depart.click();
//		Thread.sleep(1000);
//		depart.sendKeys("Mumbai");
//		act.explicitlyWait(depart, 30);
		act.fluentWait(depart, 5, 2);
		depart.sendKeys(org);
		Thread.sleep(2000);
		depart.sendKeys(Keys.ENTER);
//		going.click();
//		Thread.sleep(1000);
//		going.sendKeys("kolkata");
//		act.explicitlyWait(going, 30);
		act.fluentWait(going, 5,2);
		going.sendKeys(dpr);
		Thread.sleep(1000);
		going.sendKeys(Keys.ENTER);
	
		return new YatraSearchDate();
	}
	

}

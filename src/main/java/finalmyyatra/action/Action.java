package finalmyyatra.action;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import finalmyyatra.base.BaseClass;

public class Action extends BaseClass{
	
	public void explicitlyWait(WebElement ele, int sec) {
		WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable((ele)));
	}
	public void fluentWait(WebElement ele, int sec, int poling) {
		Wait wait=new FluentWait(getDriver())
				.withTimeout(Duration.ofSeconds(sec))
				.pollingEvery(Duration.ofSeconds(poling))
				.ignoring(NoSuchElementException.class);
		
	}

}

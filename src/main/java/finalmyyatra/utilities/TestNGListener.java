package finalmyyatra.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;

import finalmyyatra.base.BaseClass;

public class TestNGListener extends ExtentManager implements ITestListener {
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		Log.info("test on test start" + result.getName());
		test = extent.createTest("test started" + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Success of test cases and its details are : " + result.getName());
		Log.info("Success of test cases and its details are" + result.getName());
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "pass the test is " + result.getName());
		}
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Failure of test cases and its details are : " + result.getName());
		Log.info("Failure of test cases and its details are : " + result.getName());
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "test is fail :" + result.getName());
			Date date = new Date();
			String timestamp = date.toString().replace(" ", "-");

			File takescreenshot = ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(takescreenshot, new File(System.getProperty("user.dir") + "\\Screenshot\\"
						+ timestamp + " " + result.getName() + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Skip of test cases and its details are : " + result.getName());
		Log.info("Skip of test cases and its details are :" + result.getName());
		if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Skip of test cases and its details are :" + result.getName());
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Failure of test cases and its details are : " + result.getName());
		Log.info("Failure of test cases and its details are : " + result.getName());

	}

	public void onStart(ITestContext context) {
		Log.info("test onStart :" + context.getName());
		// TODO Auto-generated method stub
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Log.info("test onFinish :" + context.getName());
	}

}

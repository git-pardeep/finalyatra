package finalmyyatra.utilities;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
	public static ExtentReports extent;
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentTest test;
	public static void setExtent() throws IOException {
		htmlreporter =new ExtentHtmlReporter(System.getProperty("user.dir")+"\\test-output\\extentreport\\MyReport.html");
		htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"\\extent-config.xml");
		htmlreporter.config().setReportName("Myatra Report");
		htmlreporter.config().setDocumentTitle("Automation Test");
		extent= new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Host name", "Pardeep");
		extent.setSystemInfo("Project name", "Yatra");
		extent.setSystemInfo("system", "Win 11");
	}
	public static void endExtent() {
		extent.flush();
	}

}

package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports createInstance(String fileName) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setReportName("API Automation Report");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        return extent;
    }
}

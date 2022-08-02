package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    public static final ExtentReports report = new ExtentReports();;

    public synchronized static ExtentReports createExtentReports(){


        String reportName = DateUtil.getTimeStamp() + ".html";
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") +"\\reports\\" + reportName);
        report.attachReporter(htmlReporter);

        report.setSystemInfo("OS", "Windows 10");
        report.setSystemInfo("Environment", "UAT");
        report.setSystemInfo("Build Number", "10.8.1");
        report.setSystemInfo("Browser", "Chrome");

        htmlReporter.config().setDocumentTitle("Automation Results");
        htmlReporter.config().setReportName("All Headlines UI Test Report");
        htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");


        return report;
    }
}

package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance(){
        if(extent == null){
            ExtentSparkReporter spark =
                    new ExtentSparkReporter("reports/ExtentReport.html");
            spark.config().setReportName("ParaBank Automation Report");
            spark.config().setDocumentTitle("QA Automation Portfolio");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Project", "Parabank Automation");
            extent.setSystemInfo("Environment", "Docker Local");
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("Framework", "Selenium + TestNG");
            extent.setSystemInfo("Java version", "17");
            extent.setSystemInfo("Operating System", System.getProperty("os.name"));
            extent.setSystemInfo("Tester", "Septian Al Basit");


        }
        return extent;
    }
}

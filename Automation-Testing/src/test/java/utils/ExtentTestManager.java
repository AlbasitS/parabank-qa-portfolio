package utils;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static void setTest(ExtentTest extentTest){
        test.set(extentTest);
    }

    public static ExtentTest getTest(){
        return test.get();
    }

    //======= Helper Methods =======
    public static void info(String message){
        getTest().info(message);
    }

    public static void pass(String message){
        getTest().pass(message);
    }

    public static void fail(String message){
        getTest().fail(message);
    }
}

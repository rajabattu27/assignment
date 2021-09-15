package com.web.framework;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.Objects;

public class ExtentConfig {

    private static ExtentReports extentReports;

    private static final ThreadLocal<ExtentTest> extentParent = new ThreadLocal<>();
    private static final ThreadLocal<ExtentTest> extentChild = new ThreadLocal<>();

    static {
        if (Objects.isNull(extentReports)) {
            extentReports = new ExtentReports();
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("target/ExtentReports/extent-results.html");
            extentReports.attachReporter(extentSparkReporter);
        }
    }

    public static ExtentReports getExtentReport() {
        return extentReports;
    }

    public static ThreadLocal<ExtentTest> getExtentParent() {
        return extentParent;
    }

    public static ThreadLocal<ExtentTest> getExtentChild() {
        return extentChild;
    }

    public void createTest(String testName) {
        getExtentParent().set(getExtentReport().createTest(testName));
    }

    public void createChildTest(String testName) {
        getExtentChild().set(getExtentParent().get().createNode(testName));
    }
}



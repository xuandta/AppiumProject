package com.automation.library;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onFinish(ITestContext result) {

    }

    @Override
    public void onStart(ITestContext result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
    	System.err.println("[FAIL]  "+result.getName());
//        System.out.println("Đây là test case bị fail: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
       	System.out.println("[SKIP]  "+result.getName());
//        System.out.println("Đây là test case bị bỏ qua: " + result.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
       	System.out.println("[PASS]  "+result.getName());
    }
}
package com.examples.selenium;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by New on 2/7/2017.
 */
public class TestNGListener implements ITestListener {
    private PrintWriter out;
    public void onTestStart(ITestResult result) {
    }


    public void onTestSuccess(ITestResult result) {
        this.updateJenkinsStatus(result, "sucesso");
    }


    public void onTestFailure(ITestResult result) {
        this.updateJenkinsStatus(result, "falha");
    }


    public void onTestSkipped(ITestResult result) {
        this.updateJenkinsStatus(result, "skiped");
    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        this.updateJenkinsStatus(result, "FailedButWithinSuccessPercentage");
    }


    public void onStart(ITestContext context) {
        try{

            this.out = new PrintWriter(new BufferedWriter(new FileWriter("target/teststream.txt", false)));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void onFinish(ITestContext context) {
        this.out.close();
    }

    public void updateJenkinsStatus(ITestResult result, String status){
            out.println("{\"metodo\":\"["+ result.getName() +"]\", \"status\":\"["+ status +"]\", "
                    + "\"classe\":\"["+ result.getTestClass().getName() +"]\", \"descricao\":\"["+ result.getName() +"]\"}");
    }

}

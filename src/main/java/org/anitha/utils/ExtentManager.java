package org.anitha.utils;
import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

    private static ThreadLocal<ExtentTest> test=new ThreadLocal<>();
    
    public static void setTest(ExtentTest test1)
    {
        test.set(test1);
    }
    public static ExtentTest getTest(){
        return test.get();
    }
    public static void removeTest(){
        test.remove();
    }
}

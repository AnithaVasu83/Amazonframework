package org.anitha.tests;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver=new ThreadLocal<>();
    public static WebDriver getDriver(){
        return driver.get();
    }
    public static void setDriver(WebDriver driver1) {
        driver.set(driver1);
    }
    public static void unload(){
        driver.remove();
    }
}



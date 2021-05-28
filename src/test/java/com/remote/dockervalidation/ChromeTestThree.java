package com.remote.dockervalidation;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeTestThree {

    public static RemoteWebDriver webDriver;
    public static String HUB_URL = "http://localhost:4444/wd/hub";

    @Test
    public void TestThree() throws MalformedURLException{

//        DesiredCapabilities dc = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");

        URL url= new URL(HUB_URL);
        webDriver = new RemoteWebDriver(url,options);

        webDriver.get("https://www.google.co.in/");
        System.out.println(webDriver.getTitle());
    }

}

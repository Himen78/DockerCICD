package com.remote.dockervalidation;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class StandaloneTest {

    public static RemoteWebDriver webDriver;
    public static String HUB_URL = "http://localhost:4444/wd/hub";

    public static void main(String[] args) throws MalformedURLException {

//        DesiredCapabilities dc = DesiredCapabilities.chrome();
        DesiredCapabilities dc = DesiredCapabilities.firefox();
        URL url= new URL(HUB_URL);
        webDriver = new RemoteWebDriver(url,dc);

        webDriver.get("https://www.google.co.in/");
        System.out.println(webDriver.getTitle());

    }

}

package com.remote.dockervalidation;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ChromeTestOne {

    public static RemoteWebDriver webDriver;
    public static String HUB_URL = "http://localhost:4444/wd/hub";

    @BeforeTest
    public void dockerStart() throws IOException, InterruptedException {

        File file = new File("output.txt");
        if(file.delete())
        {
            System.out.println("File is deleted successfully..!!!");
        }
        StartDocker startDocker = new StartDocker();
        startDocker.startDockerFile();
    }

    @Test
    public void TestOne() throws MalformedURLException {

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

    @AfterTest
    public void dockerStop() throws IOException, InterruptedException {
        StopDocker stopDocker = new StopDocker();
        stopDocker.stopDockerFile();
    }

}

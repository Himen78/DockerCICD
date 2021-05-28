package com.remote.dockervalidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class StopDocker {

    public void stopDockerFile() throws IOException, InterruptedException {

        boolean flag = false;
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("cmd /c start DockerDown.bat");

        String f ="output.txt";

        Calendar cal=Calendar.getInstance();//2:44 15th second
        cal.add(Calendar.SECOND, 45);//2:44   45seconds
        long stopnow=cal.getTimeInMillis();
        Thread.sleep(3000);

        while(System.currentTimeMillis()<stopnow)
        {
            if(flag)
            {
                break;
            }

            BufferedReader reader=new BufferedReader(new FileReader(f));
            String currentLine=reader.readLine();
            while(currentLine!=null && !flag)

            {

                if(currentLine.contains("selenium-hub exited"))
                {
                    System.out.println("found my text");
                    flag=true;//14th seconds
                    break;
                }

                currentLine=reader.readLine();
            }
            reader.close();

        }
        Assert.assertTrue(flag);
    }

}

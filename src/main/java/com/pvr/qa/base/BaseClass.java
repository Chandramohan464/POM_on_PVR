package com.pvr.qa.base;

import com.pvr.qa.util.TestUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;
    public static Properties prop;
    public static Logger logger = LogManager.getLogger(BaseClass.class);

    public BaseClass(){

        prop = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/java/com/pvr/qa/config/config.properties")) {
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initialize(){

        logger.info("Initializing WebDriver and opening the browser.");
        String browser = prop.getProperty("browser").toLowerCase();
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);



        String url = prop.getProperty("url");
        driver.get(url);
    }
}

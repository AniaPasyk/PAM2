package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;



public class TestUtilities {

    protected WebDriver driver;
    protected Logger log = LogManager.getLogger();


    protected void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException var4) {
            var4.printStackTrace();

        }

    }

}


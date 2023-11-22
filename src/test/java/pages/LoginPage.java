package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.TestArguments;

import java.util.Properties;

public class LoginPage extends BasePageObject {

    private String pageUrl = "https://pam-uat.roche.com/prm/security/login.xhtml";

    private By userNameInput = By.id("username:username:username");
    private By passwordInput = By.id("password:password:password");
    private By loginButton = By.id("j_id_16");

    //private WebDriver driver;

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);

    }

    /**
     * Get URL variable from PageObject
     */
    public String getPageUrl() {
        return pageUrl;
    }


    /**
     * Open page with it's url
     */
    public void openPage() {
        log.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page Opened!");
    }


    public PricingPage logIn() {
        TestArguments.getUsername();
        type(TestArguments.getUsername(), userNameInput);
        type(TestArguments.getPassword(), passwordInput);
        click(loginButton);
        return new PricingPage(this.driver, this.log);

    }

}
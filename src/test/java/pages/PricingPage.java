package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PricingPage extends BasePageObject {

    private By addArrangementButton = By.xpath("//div[@class='col-md-4 text-right']//a[2]");

    //private WebDriver driver;

    public PricingPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public NewArrangementScopePage startNewArrangement() {
        log.info("Clicking on '+Add Arrangment' to start new Commerrcial Arrangment");
        this.click(this.addArrangementButton);
        return new NewArrangementScopePage(this.driver, this.log);
    }


    //private By logOutButton = ".."





}

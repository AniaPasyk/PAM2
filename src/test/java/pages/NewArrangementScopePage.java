package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static java.lang.Thread.sleep;

public class NewArrangementScopePage extends BasePageObject {

    private By nameInput = By.id("form:j_id_4g_21:f_name");
    private By soldToScope = By.id("form:j_id_4g_2c:f_geographicalScopeType");
    private By intervalCheckBox = By.xpath("//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']");
    private By caProductSelect = By.id("form:product:product:f_product");
    //private By indicationSelect = By.id("form:j_id_4g_5p:indication:f_indication");

    private By nextButton = By.xpath("//button[@id='form:j_id_4g_1w_next']");

    //private WebDriver driver;

    public NewArrangementScopePage(WebDriver driver, Logger log) {
        super(driver, log);

    }

    public void fillCAName(String caName) {
        type(caName, nameInput);
    }

    public void selectSoldTo(String i) {
        log.info("Selecting option " + i + " from dropdown");
        WebElement soldTo = this.find(this.soldToScope); // zmiana z lokatora z webelement
        Select soldToScope = new Select(soldTo);
        soldToScope.selectByValue("" + i);

    }

    public String getSelectedSoldTo() {
        WebElement soldTo = this.find(this.soldToScope); // zmiana z lokatora z webelement
        Select soldToScope = new Select(soldTo);
        String selectedSoldToOption = soldToScope.getFirstSelectedOption().getText();
        this.log.info(selectedSoldToOption + " is selected in dropdown");
        return selectedSoldToOption;
    }

    public void checkNoInterval() {
        click(intervalCheckBox);
    }


    public void selectProduct(String i) {
        log.info("Selecting option " + i + " from dropdown");
        WebElement caProductElement = this.find(this.caProductSelect); // zmiana z lokatora z webelement
        Select productSelect = new Select(caProductElement);
        productSelect.selectByVisibleText("" + i);

    }

    public String getSelectedProduct() {
        WebElement caProductElement = this.find(this.caProductSelect); // zmiana z lokatora z webelement
        Select productSelect = new Select(caProductElement);
        String selectedProduct = productSelect.getFirstSelectedOption().getText();
        this.log.info(selectedProduct + " is selected in dropdown");
        return selectedProduct;
    }

    public void goToReimbursementCondition() {
        click(nextButton);
        sleep(500);
        click(nextButton);

    }

    public CADetailsPage goToCADetails() {
        sleep(500);
        click(nextButton);
        return new CADetailsPage(this.driver, this.log);
    }





}


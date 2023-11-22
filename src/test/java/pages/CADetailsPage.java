package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CADetailsPage extends BasePageObject {

    By newRuleButton = By.id("form:j_id_4g_8u:j_id_4g_8w:branches:1:j_id_4g_97");
    By selectRuleType = By.id("form:j_id_4g_8u:j_id_4g_9b:selectedRule_input");
    By confirmSelRuleType = By.id("form:j_id_4g_8u:j_id_4g_9b:j_id_4g_9f_f");
    By expandListOfRuleType = By.id("form:j_id_4g_8u:j_id_4g_9b:selectedRule_label");
    By ruleTypeListLi = By.xpath("//div[@id='form:j_id_4g_8u:j_id_4g_9b:selectedRule_panel']/div/ul/li");
    By ruleTypeList = By.xpath("//div[@id='form:j_id_4g_8u:j_id_4g_9b:selectedRule_panel']/div/ul");

    By expandDropDownRule = By.xpath("//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right");
    By percentDiscountRule = By.xpath("//li[@data-label='Percent Discount']");

    By payerLevel = By.xpath("//li[@data-label='Payer']");
    //konkretny dropdown
    By levelRule = By.id("form:j_id_4g_8u:j_id_4g_9b:j_id_4g_9g_1_1:j_id_4g_9g_1_8:j_id_4g_9g_1_c:groupingLevel_input");

    //dropdown label
    By expandLevelRuleLabel = By.id("form:j_id_4g_8u:j_id_4g_9b:j_id_4g_9g_1_1:j_id_4g_9g_1_8:j_id_4g_9g_1_c:groupingLevel");

    By levelList = By.xpath("//div[@id='form:j_id_4g_8u:j_id_4g_9b:j_id_4g_9g_1_1:j_id_4g_9g_1_8:j_id_4g_9g_1_c:groupingLevel_panel']/div/ul");

    By discountInput = By.id("form:j_id_4g_8u:j_id_4g_9b:j_id_4g_9g_1_1:j_id_4g_9g_1_o:0:j_id_4g_9g_1_r:discount:discount_input");


    public CADetailsPage(WebDriver driver, Logger log) {
        super(driver, log); //WYWOŁUJEMY TO CO BYŁO BasePageObject i nie musimy dzieki temi mieć webdriver driver; i loga
    }

    public void setRuleType(String ruleType) { //pętla wybierania tresholdów
        click(newRuleButton);

        click(expandListOfRuleType);

        WebElement ruleTypesWebEl = this.find(this.ruleTypeList);
        List<WebElement> ruleTypesList = ruleTypesWebEl.findElements(By.tagName("li"));

        for (WebElement ruleTypes : ruleTypesList) {
            System.out.println(ruleTypes.getText());
            if (ruleTypes.getText().equals(ruleType)) {
                System.out.println("Selected Rule: " + ruleType);
                ruleTypes.click();
                break;
            }
        }
        sleep(1000);
        click(confirmSelRuleType);

    }

    public void setThresholds(String level) {
       click(expandLevelRuleLabel);

       WebElement levelRuleWebEl = this.find(this.levelList); //zmieniam levelRule na webElement
       List<WebElement> levelRule1 = levelRuleWebEl.findElements(By.tagName("li")); //znajduje li w liście (bo znajdowało tylko jedną

       for (WebElement ruleLevels : levelRule1) {
           System.out.println(ruleLevels.getText());
            if(ruleLevels.getText().equalsIgnoreCase(level)) {
               ruleLevels.click();
               break;
            }
        }
    }

    public void setDiscount(String discountValue) {
        //discountInput.clear();

        //wyczyścisz najpier zawartość inputa
        type(discountValue, discountInput);
    }




    }







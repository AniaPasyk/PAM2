package tests;

import org.testng.annotations.Test;
import pages.CADetailsPage;
import pages.LoginPage;
import pages.NewArrangementScopePage;
import pages.PricingPage;
import utils.TestUtilities;

public class CreateNewCA extends TestUtilities {

    @Test
    public void createNewCA() {
        log.info("Starting Create New Commercial Arrangement test");
        LoginPage loginPage = new LoginPage(driver, log);
        loginPage.openPage();
        PricingPage pricingPage = loginPage.logIn();
        NewArrangementScopePage newArrangementScopePage = pricingPage.startNewArrangement();
        newArrangementScopePage.fillCAName("Test Automation");
        newArrangementScopePage.selectSoldTo("NATIONAL");
        newArrangementScopePage.checkNoInterval();
        newArrangementScopePage.selectProduct("Herceptin");
        newArrangementScopePage.goToReimbursementCondition();
        CADetailsPage caDetails = newArrangementScopePage.goToCADetails();
        caDetails.setRuleType("Percent Discount"); //todo tu dropdown jest ukryty - znaleźć rozwiązanie
        caDetails.setThresholds("Payer");
        caDetails.setDiscount("50");


    }

}

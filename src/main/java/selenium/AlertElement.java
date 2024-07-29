package selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertElement {
    private static final Logger LOG = Logger.getLogger(AlertElement.class);

    private final WebElementWaits webElementWaits;

    public AlertElement(WebDriver driver, WebDriverWait wait) {
        webElementWaits = new WebElementWaits(driver, wait);
    }

    /**
     * switch to alert popup
     *
     * @return Alert object
     */
    public Alert switchAlert() {
        return webElementWaits.waitUntilAlertIsPresent();
    }

    /**
     * get alert text
     *
     * @param alert alert
     * @return alert text
     */
    public String getAlertText(Alert alert) {
        return alert.getText();
    }

    /**
     * accept alert
     *
     * @param alert alert
     */
    public void acceptAlert(Alert alert) {
        alert.accept();
    }

    /**
     * dismiss alert message
     *
     * @param alert alert
     */
    public void dismissAlert(Alert alert) {
        alert.dismiss();
    }

    /**
     * send keys to alert
     *
     * @param alert alert
     * @param value String value
     */
    public void sendKeys(Alert alert, String value) {
        alert.sendKeys(value);
    }

    /**
     * switch to alert popup and return the alert message
     *
     * @return alert text message
     */
    public String getAlertMessage() {
        return getAlertText(switchAlert());
    }

    /**
     * check if the alert is present
     *
     * @return true if the alert is present otherwise false
     */
    public boolean isAlertPresent() {
        try {
            switchAlert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    /**
     * switch to the alert and enter the alert text and accept the alert
     *
     * @param alertText alert text
     */
    public void sendTextAcceptAlertPopUp(String alertText) {
        Alert alert = switchAlert();
        String alertTextPopUp = getAlertText(alert);
        sendKeys(alert, alertText);
        acceptAlert(alert);
        LOG.info("Accepting Alert PopUp: " + alertTextPopUp);
    }

    /**
     * Accepting the alert popup by passing true or declining the alert popup by passing false
     *
     * @param acceptNextAlert accept next alert
     * @return the alert text
     */
    public String closeAlertAndGetItsText(boolean acceptNextAlert) {
        Alert alert = switchAlert();
        String alertTextPopUp = getAlertText(alert);
        if (acceptNextAlert) {
            LOG.info("Accepting Alert PopUp: " + alertTextPopUp);
            acceptAlert(alert);
        } else {
            LOG.info("Declining Alert PopUp: " + alertTextPopUp);
            dismissAlert(alert);
        }

        return alertTextPopUp;
    }
}

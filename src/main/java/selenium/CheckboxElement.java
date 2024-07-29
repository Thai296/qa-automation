package selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxElement {
    private static final Logger LOG = Logger.getLogger(CheckboxElement.class);
    private final WebElementInteractions WebElementInteractions;

    public CheckboxElement(WebDriver driver) {
        WebElementInteractions = new WebElementInteractions(driver);
    }

    /**
     * Mark Checkbox as checked.
     *
     * @param element web element
     */
    public void selectCheckBox(WebElement element) {
        LOG.info("        Selected checkbox: " + WebElementInteractions.getTextFromWebElement(element));
        WebElementInteractions.clickOnElement(element);
    }

    /**
     * check if web element is selected
     *
     * @param element web element
     * @return true if the web element is selected otherwise false
     */
    public boolean isSelected(WebElement element) {
        return element.isSelected();
    }

    /**
     * Check if the checkbox is selected by attribute
     *
     * @param element checkbox element
     * @return true if checkbox is checked
     */
    public boolean isCheckedByAttribute(WebElement element) {
        String checkedValue = WebElementInteractions.getAttributeFromWebElement(element, "checked");
        if (checkedValue.equals("checked") || (checkedValue.equals("true"))) {
            LOG.info("        Checkbox Checked for WebElement: " + element);
            return true;
        } else {
            LOG.error("        Checkbox Unchecked for WebElement: " + element);
            return false;
        }
    }

    /**
     * check if the checkbox has been selected and return true
     *
     * @param element web element
     * @return true if the checkbox is selected
     */
    public boolean isCheckboxSelected(WebElement element) {
        return isSelected(element);
    }

    /**
     * Count the selected checks from the given list of checkbox elements
     *
     * @param elements web elements
     * @return number of selected checkboxes
     */
    public int countSelectedCheckboxes(List<WebElement> elements) {
        int count = 0;
        for (WebElement el : elements) {
            if (isSelected(el)) {
                count++;
            }
        }
        return count;
    }
}

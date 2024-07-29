package selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectDropDown {
    private static final Logger LOG = Logger.getLogger(SelectDropDown.class);
    private final WebElementInteractions webElementInteractions;

    public SelectDropDown(WebDriver driver) {
        webElementInteractions = new WebElementInteractions(driver);
    }

    /**
     * select a dropdown web element and return select object
     *
     * @param element web element
     * @return select object
     */
    public Select selectByElement(WebElement element) {
        return new Select(element);
    }

    /**
     * get first selected option by web element and return web element
     *
     * @param element web element
     * @return the first web element in dropdown list
     */
    public WebElement getFirstSelectedOptionByWebElement(WebElement element) {
        return selectByElement(element).getFirstSelectedOption();
    }

    /**
     * get all selected options by web element and return list of web element
     *
     * @param element web element
     * @return list of element
     */
    public List<WebElement> getAllSelectedOptionsByWebElement(WebElement element) {
        return selectByElement(element).getAllSelectedOptions();
    }

    /**
     * select an option from dropdown list By Value
     *
     * @param element web element
     * @param value   value
     */
    public void selectByValue(WebElement element, String value) {
        selectByElement(element).selectByValue(value);
    }

    /**
     * select an option from dropdown list By Index
     *
     * @param element web element
     * @param index   Index
     */
    public void selectByIndex(WebElement element, int index) {
        selectByElement(element).selectByIndex(index);
    }

    /**
     * select an option from dropdown list By visible text
     *
     * @param element     web element
     * @param visibleText visible Text
     */
    public void selectByVisibleText(WebElement element, String visibleText) {
        selectByElement(element).selectByVisibleText(visibleText);
    }

    /**
     * select list item in dropdown by given text
     *
     * @param dropdown   dropdown web element
     * @param textSelect given text
     */
    public void selectByText(WebElement dropdown, String textSelect) {
        List<WebElement> elements = getAllSelectedOptionsByWebElement(dropdown);

        for (WebElement element : elements) {
            if (webElementInteractions.isWebElementTextMatchesValue(element, textSelect)) {
                webElementInteractions.clickOnElement(element);
                LOG.info("Selected " + textSelect + " from dropdown");
                break;
            }
        }
    }
}

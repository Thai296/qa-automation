package selenium;

import org.openqa.selenium.WebDriver;

public class SwitchToPopUp {
    private final WebDriver driver;
    private final WebDriverInteractions webDriverInteractions;

    public SwitchToPopUp(WebDriver driver) {
        this.driver = driver;
        this.webDriverInteractions = new WebDriverInteractions(driver);
    }

    /**
     * switch to window
     *
     * @param window window
     */
    public void switchToWindow(String window) {
        driver.switchTo().window(window);
    }

    /**
     * switch to window and maximize the window
     *
     * @param window window
     */
    public void switchToWindowAndMaximizeWindow(String window) {
        driver.switchTo().window(window);
        webDriverInteractions.maximizeWindow();
    }

    /**
     * switch to popup window by given url
     *
     * @param url url
     * @return parent page
     */
    public String switchToPopUpByUrl(String url) {
        String parentWindow = webDriverInteractions.getDefaultWindowHandle();

        for (String windowHandle : webDriverInteractions.getDefaultWindowHandles()) {
            switchToWindow(windowHandle);
            if (webDriverInteractions.getCurrentUrl().contains(url)) {
                webDriverInteractions.maximizeWindow();
            }
            break;
        }

        return parentWindow;
    }
}

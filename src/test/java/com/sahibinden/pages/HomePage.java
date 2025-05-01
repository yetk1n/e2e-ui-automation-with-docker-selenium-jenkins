package com.sahibinden.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By aracDegerlemeLink = By.linkText("Araç Değerleme");
    private final By tumunuGosterLabel = By.cssSelector("label.open-categories[for='category-auto360']");
    private final By cookiesAcceptButton = By.cssSelector("#onetrust-accept-btn-handler")
    // Locators for mobile
    private final By servislerTabMobile = By.cssSelector("a[track-label='altbar_servisler']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage(String baseUrl) {
        driver.get(baseUrl);
        waitForPageLoad();
    }

    public void acceptCookiesIfPresent() {
        if (isElementDisplayed(cookiesAcceptButton)) {
            click(cookiesAcceptButton);
        }
    }

    public AracDegerlemePage navigateToAracDegerleme() {
        click(tumunuGosterLabel);
        waitForElementVisible(aracDegerlemeLink);
        click(aracDegerlemeLink);
        return new AracDegerlemePage(driver);
    }

    public MobileServislerPage navigateToMobileServislerTab() {
        click(servislerTabMobile);
        return new MobileServislerPage(driver);
    }
}

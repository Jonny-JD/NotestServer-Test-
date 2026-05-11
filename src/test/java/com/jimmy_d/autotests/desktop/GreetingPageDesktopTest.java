package com.jimmy_d.autotests.desktop;

import com.jimmy_d.autotests.page.GreetingPage;
import com.jimmy_d.autotests.page.MainPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;


class GreetingPageDesktopTest extends BaseTestDesktop {
    private final GreetingPage greetingPage = new GreetingPage();
    private final MainPage mainPage = new MainPage();

    @Test
    void menuButtonsTestUnsigned() {
        greetingPage.open();
        greetingPage.menuButtonsAside.assertButtonsUnsigned();
    }

    @Test
    void connectButtonShouldBeDisplayedAndActive() {
        greetingPage.open();
        var connectButton = greetingPage.connectButton();

        connectButton
                .shouldBe(visible)
                .shouldBe(clickable)
                .click();

        webdriver().shouldHave(urlContaining(mainPage.getUrl()));
    }

}

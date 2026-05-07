package com.jimmy_d.autotests.desktop;

import com.jimmy_d.autotests.desktop.page.GreetingPage;
import com.jimmy_d.autotests.desktop.page.MainPage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;


@Slf4j
class GreetingPageTest extends BaseTest {
    private final GreetingPage greetingPage = new GreetingPage();
    private final MainPage mainPage = new MainPage();

    @Test
    void menuButtonsTestUnsigned() {
        greetingPage.open();
        greetingPage.menuButtons.assertButtonsUnsigned();
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

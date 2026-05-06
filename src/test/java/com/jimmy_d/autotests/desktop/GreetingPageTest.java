package com.jimmy_d.autotests.desktop;

import com.jimmy_d.autotests.desktop.page.GreetingPage;
import com.jimmy_d.autotests.desktop.page.MainPage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


@Slf4j
class GreetingPageTest extends BaseTest {
    private final GreetingPage greetingPage = new GreetingPage();
    private final MainPage mainPage = new MainPage();

    //Unsigned user
    @Test
    void menuButtonUnsignedUserShouldBeVisible() {
        greetingPage.open();

        var expectedButtonNames = Stream.of("discover", "create", "sign in", "sign up")
                .map(String::toUpperCase)
                .sorted()
                .toArray(String[]::new);

        var actualButtons = greetingPage.asideButtons();

        var actualButtonNames = actualButtons.stream()
                .map(elem -> elem
                        .getText()
                        .toUpperCase())
                .sorted()
                .toArray(String[]::new);

        assertArrayEquals(expectedButtonNames, actualButtonNames);

        actualButtons.forEach(button -> {
            button.shouldBe(visible);
        });
    }

    @Test
    void menuButtonUnsignedUserShouldBeActive() {

        var buttons = Map.of(
                "sign-in", "login",
                "discover", "discover",
                "create", "create",
                "sign-up", "register"
        );

        buttons.forEach((id, path) -> {
            greetingPage.open();
            $("[data-testid='%s']".formatted(id)).click();
            webdriver().shouldHave(urlContaining(greetingPage.getUrl() + path));
        });
    }

    @Test
    void connectButtonShouldBeDisplayedAndActive() {
        greetingPage.open();
        var connectButton = greetingPage.connectButton();
        connectButton.shouldBe(visible);
        connectButton.click();
        webdriver().shouldHave(urlContaining(mainPage.getUrl()));
    }

}

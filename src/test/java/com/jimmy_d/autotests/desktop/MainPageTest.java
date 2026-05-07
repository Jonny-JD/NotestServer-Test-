package com.jimmy_d.autotests.desktop;

import com.jimmy_d.autotests.desktop.page.MainPage;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MainPageTest extends BaseTest {

    MainPage mainPage = new MainPage();

    @Test
    void menuButtonsTestUnsigned() {
        mainPage.open();
        mainPage.menuButtons.assertButtonsUnsigned();
    }

    @Test
    void buttonsShouldBeDisplayed() {
        mainPage.open();

        var expectedButtonNames = Stream.of("sign in", "sign up", "discover")
                .map(String::toUpperCase)
                .sorted().toArray(String[]::new);

        var actualButtons = mainPage.mainButtons();

        var actualButtonNames = actualButtons.stream()
                .map(elem -> elem
                        .getText()
                        .toUpperCase())
                .sorted()
                .toArray(String[]::new);

        assertArrayEquals(expectedButtonNames, actualButtonNames);

        actualButtons.forEach(button -> button.shouldBe(visible));
    }

    @Test
    void buttonsShouldBeActive() {
        mainPage.open();

        var buttons = Map.of(
                "sign-in", "login",
                "sign-up", "register",
                "discover", "discover"
        );

        buttons.forEach((id, path) -> {
            mainPage.open();
            $("[data-testid='%s']".formatted(id)).click();
            webdriver().shouldHave(urlContaining("/" + path));
        });
    }

    //Signed user
}

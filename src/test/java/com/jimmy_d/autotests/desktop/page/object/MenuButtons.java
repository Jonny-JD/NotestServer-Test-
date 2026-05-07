package com.jimmy_d.autotests.desktop.page.object;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import java.util.Map;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MenuButtons {
    public final Map<String, String> buttonsUnsigned = Map.of(
            "sign-in", "/login",
            "discover", "/discover",
            "create", "/create",
            "sign-up", "/register"
    );

    public final String[] expectedButtonNamesUnsigned = Stream.of("discover", "create", "sign in", "sign up")
            .map(String::toUpperCase)
            .sorted()
            .toArray(String[]::new);


    public final ElementsCollection actualButtons = $(By.className("aside-interaction-buttons")).findAll("button");

    public void assertButtonsUnsigned() {

        //visibility, clickability check
        actualButtons.forEach(button ->
            button
                    .shouldBe(visible)
                    .shouldBe(clickable)
        );

        //proper naming check
        var actualButtonNames = actualButtons.stream()
                .map(elem -> elem
                        .getText()
                        .toUpperCase())
                .sorted()
                .toArray(String[]::new);

        assertArrayEquals(expectedButtonNamesUnsigned, actualButtonNames);


        //proper navigation check
        buttonsUnsigned.forEach((id, path) -> {
            $("[data-testid='%s']".formatted(id)).click();
            webdriver().shouldHave(urlContaining(path));
        });

    }
}

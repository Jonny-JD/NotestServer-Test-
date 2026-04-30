package com.jimmy_d.autotests.desktop;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


@Slf4j
class MainPageTest extends BaseTest {

    @Test
    void shouldBeTitled() {
        open("/");
        assertEquals("cyber-notes", title());
    }

    @Test
    void menuButtonShouldBeVisible() {
        open("/");

        var aside = $(By.className("aside-interaction-buttons"));

        var expectedButtons = Stream.of("discover", "create", "login", "sign up")
                .map(String::toUpperCase).sorted()
                .toArray(String[]::new);

        var actualButtons = aside.findAll("button")
                .stream()
                .map(elem -> elem.getText().toUpperCase())
                .sorted()
                .toArray(String[]::new);

        aside.findAll("button").forEach(el -> log.info("Button: {}", el.getText()));

        assertArrayEquals(expectedButtons, actualButtons);
    }

}

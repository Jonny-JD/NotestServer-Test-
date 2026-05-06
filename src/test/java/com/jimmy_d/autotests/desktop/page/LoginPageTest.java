package com.jimmy_d.autotests.desktop.page;

import com.jimmy_d.autotests.desktop.BaseTest;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginPageTest extends BaseTest {

    private final LoginPage loginPage = new LoginPage();

    @Test
    void loginFormShouldBeVisible() {
        loginPage.open();
        var fields = loginPage.form.fields();
        var labels = loginPage.form.labels();

        assertEquals(2, fields.size());
        fields.forEach(field -> field.shouldBe(visible));

        var expectedLabels = Stream.of("username", "password")
                .map(String::toUpperCase)
                .sorted()
                .toArray(String[]::new);

        var actualLabels = labels.stream()
                .map(label -> label
                        .getText()
                        .toUpperCase())
                .sorted()
                .toArray(String[]::new);

        assertArrayEquals(expectedLabels, actualLabels);

    }
}

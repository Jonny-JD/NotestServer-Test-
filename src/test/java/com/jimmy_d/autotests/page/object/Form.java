package com.jimmy_d.autotests.page.object;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Form {
    private final SelenideElement form = $(By.tagName("form"));

    public ElementsCollection fields() {
        return form.findAll(By.className("form-cell"));
    }

    public ElementsCollection labels() {
        return form.findAll(By.tagName("label"));
    }

    public SelenideElement submitButton() {
        return form.find("button[type='submit']");
    }

    public void assertBaseForm(String[] expectedFields, String submitButtonText) {

        //Form visibility check
        form.shouldBe(visible);

        fields().forEach(field -> field.shouldBe(visible));

        //Form labels check
        var expectedLabels = Stream.of(expectedFields)
                .map(String::toUpperCase)
                .sorted()
                .toArray(String[]::new);

        var actualLabels = labels().stream()
                .map(label -> label
                        .getText()
                        .toUpperCase())
                .sorted()
                .toArray(String[]::new);

        assertEquals(expectedFields.length, actualLabels.length);
        assertArrayEquals(expectedLabels, actualLabels);

        //Submit button check
        submitButton()
                .shouldBe(visible)
                .shouldBe(clickable)
                .shouldHave(text(submitButtonText.toUpperCase()));
    }
}

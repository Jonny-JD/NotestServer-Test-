package com.jimmy_d.autotests.desktop;

import com.jimmy_d.autotests.desktop.page.CreatePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CreatePageTest extends BaseTest {
    private final CreatePage createPage = new CreatePage();

    @Test
    void createButtonShouldBeVisible() {
        createPage.open();

        var createButton = createPage.optionsBlock.blockForm().submitButton();

        createButton.shouldBe(visible);
        createButton.shouldHave(text("CREATE"));

        createButton.click();
    }

    @Test
    void createFormShouldBeVisibleAndActive() {
        createPage.open();

        var createForm = createPage.optionsBlock.blockForm();

        createForm.header().shouldHave(text("NOTE OPTIONS:"));
        var createFormFields = createPage.optionsBlock.blockForm().fields();
        var createFormLabels = createPage.optionsBlock.blockForm().labels();

        Assertions.assertEquals(2, createFormFields.size());

        createFormFields.forEach(field -> {
            field.shouldBe(visible);
        });

        createFormLabels.forEach(label -> {
            label.shouldBe(visible);
        });

        var expectedLabels = Stream.of("tag:", "title:")
                .map(String::toUpperCase)
                .sorted()
                .toArray(String[]::new);
        var actualLabels = createFormLabels
                .stream()
                .map(elem -> elem
                        .getText()
                        .toUpperCase())
                .sorted()
                .toArray(String[]::new);

        assertArrayEquals(expectedLabels, actualLabels);

    }

    @Test
    void noteCreateTextareaShouldBeVisible() {
        createPage.open();
        createPage.textArea.noteTextInput().shouldBe(visible);
    }
}

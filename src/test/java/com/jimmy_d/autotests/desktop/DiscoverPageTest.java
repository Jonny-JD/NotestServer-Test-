package com.jimmy_d.autotests.desktop;

import com.jimmy_d.autotests.desktop.page.DiscoverPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DiscoverPageTest extends BaseTest {
    private final DiscoverPage discoverPage = new DiscoverPage();

    //Unsigned user

    @Test
    void filterButtonShouldBeVisibleAndActive() {
        discoverPage.open();

        var filterButton = discoverPage.baseFilterButton();

        filterButton.shouldBe(visible);
        filterButton.shouldHave(text("FILTER"));

        filterButton.click();

        discoverPage.optionsBlock.blockForm().form.shouldBe(visible);

    }

    @Test
    void filterFormShouldBeVisibleAndActive() {
        discoverPage.open();

        discoverPage.baseFilterButton().click();

        var filterForm = discoverPage.optionsBlock.blockForm();

        filterForm.header().shouldHave(text("FILTER BY:"));
        var filterFormFields = discoverPage.optionsBlock.blockForm().fields();
        var filterFormLabels = discoverPage.optionsBlock.blockForm().labels();

        Assertions.assertEquals(3, filterFormFields.size());

        filterFormFields.forEach(field -> {
            field.shouldBe(visible);
        });

        filterFormLabels.forEach(label -> {
            label.shouldBe(visible);
        });

        var expectedLabels = Stream.of("tag:", "title:", "author:")
                .map(String::toUpperCase)
                .sorted()
                .toArray(String[]::new);
        var actualLabels = filterFormLabels
                .stream()
                .map(elem -> elem.getText().toUpperCase())
                .sorted()
                .toArray(String[]::new);

        assertArrayEquals(expectedLabels, actualLabels);

    }
}

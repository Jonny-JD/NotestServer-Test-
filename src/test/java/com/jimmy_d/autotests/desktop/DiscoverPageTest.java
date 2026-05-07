package com.jimmy_d.autotests.desktop;

import com.jimmy_d.autotests.desktop.page.DiscoverPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

class DiscoverPageTest extends BaseTest {
    private final DiscoverPage discoverPage = new DiscoverPage();

    @Test
    void menuButtonsTestUnsigned() {
        discoverPage.open();
        discoverPage.menuButtons.assertButtonsUnsigned();
    }

    @Test
    void discoverPageFormTest() {
        discoverPage.open();
        var filterToggleButton = $("[data-testid='filter']");
        filterToggleButton
                .shouldBe(visible)
                .shouldBe(clickable)
                .click();

        var expectedFields = new String[]{"tag:", "title:", "author:"};
        var headerText = "FILTER BY:";
        var submitButtonText = "FILTER";
        discoverPage.optionsBlockForm.blockForm()
                .assertOptionsBlockFormCheck(headerText, expectedFields, submitButtonText);
    }
}

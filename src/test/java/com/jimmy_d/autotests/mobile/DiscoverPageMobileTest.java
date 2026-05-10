package com.jimmy_d.autotests.mobile;

import com.jimmy_d.autotests.page.DiscoverPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

class DiscoverPageMobileTest extends BaseTestMobile {
    private final DiscoverPage discoverPage = new DiscoverPage();

    @Test
    void menuButtonsTestUnsigned() {
        discoverPage.open();
        discoverPage.menuButtonsToggle.assertButtonsUnsigned();
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

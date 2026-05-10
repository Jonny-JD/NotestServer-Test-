package com.jimmy_d.autotests.mobile;

import com.jimmy_d.autotests.page.CreatePage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;

class CreatePageMobileTest extends BaseTestMobile {
    private final CreatePage createPage = new CreatePage();


    @Test
    void menuButtonsTestUnsigned() {
        createPage.open();
        createPage.menuButtonsToggle.assertButtonsUnsigned();
    }

    @Test
    void createPageFormTestUnsigned() {
        createPage.open();
        var expectedFields = new String[]{"tag:", "title:"};
        var headerText = "NOTE OPTIONS:";
        var submitButtonText = "CREATE";
        createPage.optionsBlockForm.blockForm()
                .assertOptionsBlockFormCheck(headerText, expectedFields, submitButtonText);
    }

    @Test
    void noteCreateTextareaShouldBeVisible() {
        createPage.open();
        createPage.textArea.noteTextInput()
                .shouldBe(visible);
    }
}

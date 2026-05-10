package com.jimmy_d.autotests.common;

import com.jimmy_d.autotests.BaseTest;
import com.jimmy_d.autotests.TestFactory;
import com.jimmy_d.autotests.page.DiscoverPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

class NoteCreateTest extends BaseTest {
    private final DiscoverPage discoverPage = new DiscoverPage();

    @Test
    void createGuestNoteTest() {
        var expectedNote = TestFactory.createGuestNote();

        discoverPage.open();
        discoverPage.notesList().shouldBe(visible);
        discoverPage.notesList().find("a").shouldBe(visible).click();

        var actualNoteTitle = $("[data-testid='note-title']");
        var actualNoteTag = $("[data-testid='note-tag']");
        var actualNoteText = $("[data-testid='note-text']");
        var actualNoteAuthor = $("[data-testid='note-author']");

        actualNoteTitle.shouldBe(visible).shouldHave(text(expectedNote.noteTitle()));
        actualNoteTag.shouldBe(visible).shouldHave(text(expectedNote.noteTag()));
        actualNoteText.shouldBe(visible).shouldHave(text(expectedNote.noteText()));
        actualNoteAuthor.shouldBe(visible).shouldHave(text("guest"));


    }
}

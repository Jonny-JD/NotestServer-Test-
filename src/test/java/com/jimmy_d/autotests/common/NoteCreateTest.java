package com.jimmy_d.autotests.common;

import com.codeborne.selenide.Selenide;
import com.jimmy_d.autotests.BaseTest;
import com.jimmy_d.autotests.TestFactory;
import com.jimmy_d.autotests.page.DiscoverPage;
import com.jimmy_d.autotests.page.MyNotesPage;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

class NoteCreateTest extends BaseTest {
    private final DiscoverPage discoverPage = new DiscoverPage();
    private final MyNotesPage myNotesPage = new MyNotesPage();

    @SneakyThrows
    @Test
    void createGuestNoteTest() {

        var expectedNote = TestFactory.createNote();
        $("[data-testid='discover']").shouldBe(visible);
        $("[data-testid='discover']").click();
        Thread.sleep(500);
        Selenide.refresh();

        discoverPage.notesList().findAll("a")
                .findBy(text(expectedNote.noteTitle())).shouldBe(visible)
                .click();

        var actualNoteTitle = $("[data-testid='note-title']");
        var actualNoteTag = $("[data-testid='note-tag']");
        var actualNoteText = $("[data-testid='note-text']");
        var actualNoteAuthor = $("[data-testid='note-author']");

        actualNoteTitle.shouldBe(visible).shouldHave(text(expectedNote.noteTitle()));
        actualNoteTag.shouldBe(visible).shouldHave(text(expectedNote.noteTag()));
        actualNoteText.shouldBe(visible).shouldHave(text(expectedNote.noteText()));
        actualNoteAuthor.shouldBe(visible).shouldHave(text("guest"));

    }

    @SneakyThrows
    @Test
    void createUserNoteTest() {
        var author = TestFactory.registerUser(TestFactory.generateUser());
        TestFactory.loginUser(author);
        $("[data-testid='my-notes']").shouldBe(visible);
        var expectedNote = TestFactory.createNote();
        $("[data-testid='my-notes']").click();
        Thread.sleep(500);
        Selenide.refresh();
        myNotesPage.notesList().shouldBe(visible);
        myNotesPage.notesList().findAll("a").findBy(text(expectedNote.noteTitle())).click();

        var actualNoteTitle = $("[data-testid='note-title']");
        var actualNoteTag = $("[data-testid='note-tag']");
        var actualNoteText = $("[data-testid='note-text']");
        var actualNoteAuthor = $("[data-testid='note-author']");

        actualNoteTitle.shouldBe(visible).shouldHave(text(expectedNote.noteTitle()));
        actualNoteTag.shouldBe(visible).shouldHave(text(expectedNote.noteTag()));
        actualNoteText.shouldBe(visible).shouldHave(text(expectedNote.noteText()));
        actualNoteAuthor.shouldBe(visible).shouldHave(text(author.name()));
    }
}

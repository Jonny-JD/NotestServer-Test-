package com.jimmy_d.autotests;

import com.jimmy_d.autotests.page.CreatePage;
import com.jimmy_d.autotests.page.LoginPage;
import com.jimmy_d.autotests.page.RegisterPage;
import com.jimmy_d.autotests.page.object.Note;

public final class TestFactory {
    private static final String USERNAME = "test";
    private static final String EMAIL = "test@email";
    private static final String PASSWORD = "pass";
    private static final User TEST_USER = new User(USERNAME, EMAIL, PASSWORD);

    private static final String NOTE_TEXT = "test note text";
    private static final String NOTE_TITLE = "test note title";
    private static final String NOTE_TAG = "test note tag";
    private static final Note TEST_NOTE = new Note(NOTE_TEXT, NOTE_TITLE, NOTE_TAG);


    private static final RegisterPage registerPage = new RegisterPage();
    private static final LoginPage loginPage = new LoginPage();
    private static final CreatePage createPage = new CreatePage();

    public static User registerUser() {
        registerPage.open();
        registerPage.usernameField.type(TEST_USER.name());
        registerPage.emailField.type(TEST_USER.email());
        registerPage.passwordField.type(TEST_USER.password());
        registerPage.form.submitButton().click();
        return TEST_USER;
    }

    public static User loginUser() {
        loginPage.open();
        loginPage.usernameField.type(TEST_USER.name());
        loginPage.passwordField.type(TEST_USER.password());
        return TEST_USER;
    }

    public static Note createGuestNote() {
        createPage.open();

        createPage.textArea.noteTextInput().type(NOTE_TEXT);
        createPage.optionsBlockForm.blockForm().fieldInput("tag").type(NOTE_TAG);
        createPage.optionsBlockForm.blockForm().fieldInput("title").type(NOTE_TITLE);

        createPage.optionsBlockForm.blockForm().submitButton().click();

        return TEST_NOTE;
    }

}

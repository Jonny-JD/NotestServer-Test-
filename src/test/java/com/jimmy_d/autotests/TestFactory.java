package com.jimmy_d.autotests;

import com.jimmy_d.autotests.page.CreatePage;
import com.jimmy_d.autotests.page.LoginPage;
import com.jimmy_d.autotests.page.RegisterPage;
import com.jimmy_d.autotests.page.object.Note;

public final class TestFactory {


    public static User generateUser() {
        long ts = System.currentTimeMillis();
        return new User("test" + ts, "test" + ts + "@test.com", "pass");
    }

    public static Note generateNote() {
        long ts = System.currentTimeMillis();
        return new Note("text" + ts, "title" + ts, "tag" + ts
        );
    }

    private static final RegisterPage registerPage = new RegisterPage();
    private static final LoginPage loginPage = new LoginPage();
    private static final CreatePage createPage = new CreatePage();

    public static User registerUser(User user) {
        registerPage.open();
        registerPage.usernameField.type(user.name());
        registerPage.emailField.type(user.email());
        registerPage.passwordField.type(user.password());
        registerPage.form.submitButton().click();
        return user;
    }

    public static void loginUser(User user) {
        loginPage.open();
        loginPage.usernameField.type(user.name());
        loginPage.passwordField.type(user.password());
        loginPage.form.submitButton().click();
    }



    public static Note createNote() {

        var note = generateNote();

        createPage.open();

        createPage.textArea.noteTextInput().type(note.noteText());
        createPage.optionsBlockForm.blockForm().fieldInput("tag").type(note.noteTag());
        createPage.optionsBlockForm.blockForm().fieldInput("title").type(note.noteTitle());

        createPage.optionsBlockForm.blockForm().submitButton().click();

        return note;
    }

}

package com.jimmy_d.autotests.desktop;

import com.jimmy_d.autotests.desktop.page.RegisterPage;
import com.jimmy_d.autotests.desktop.page.object.MenuButtons;
import org.junit.jupiter.api.Test;

class RegisterPageTest extends BaseTest {
    private final RegisterPage registerPage = new RegisterPage();
    private final MenuButtons menuButtons = new MenuButtons();

    @Test
    void menuButtonsTestUnsigned() {
        registerPage.open();
        menuButtons.assertButtonsUnsigned();
    }

    @Test
    void registerFormTest() {
        registerPage.open();
        var fields = new String[]{"username", "email", "password"};
        var submitButtonName = "register";

        registerPage.form.assertBaseForm(fields, submitButtonName);
    }
}

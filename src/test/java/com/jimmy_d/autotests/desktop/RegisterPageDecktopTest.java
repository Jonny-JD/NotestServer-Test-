package com.jimmy_d.autotests.desktop;

import com.jimmy_d.autotests.page.RegisterPage;
import org.junit.jupiter.api.Test;

class RegisterPageDecktopTest extends BaseTestDesktop {
    private final RegisterPage registerPage = new RegisterPage();


    @Test
    void menuButtonsTestUnsigned() {
        registerPage.open();
        registerPage.menuButtonsAside.assertButtonsUnsigned();
    }

    @Test
    void registerFormTest() {
        registerPage.open();
        var fields = new String[]{"username", "email", "password"};
        var submitButtonName = "register";

        registerPage.form.assertBaseForm(fields, submitButtonName);
    }
}

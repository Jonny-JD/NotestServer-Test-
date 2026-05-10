package com.jimmy_d.autotests.mobile;

import com.jimmy_d.autotests.page.RegisterPage;
import org.junit.jupiter.api.Test;

class RegisterPageMobileTest extends BaseTestMobile {
    private final RegisterPage registerPage = new RegisterPage();

    @Test
    void menuButtonsTestUnsigned() {
        registerPage.open();
        registerPage.menuButtonsToggle.assertButtonsUnsigned();
    }

    @Test
    void registerFormTest() {
        registerPage.open();
        var fields = new String[]{"username", "email", "password"};
        var submitButtonName = "register";

        registerPage.form.assertBaseForm(fields, submitButtonName);
    }
}

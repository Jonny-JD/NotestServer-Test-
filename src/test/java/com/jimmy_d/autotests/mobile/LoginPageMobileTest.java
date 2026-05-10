package com.jimmy_d.autotests.mobile;

import com.jimmy_d.autotests.page.LoginPage;
import org.junit.jupiter.api.Test;

class LoginPageMobileTest extends BaseTestMobile {

    private final LoginPage loginPage = new LoginPage();


    @Test
    void menuButtonsTestUnsigned() {
        loginPage.open();
        loginPage.menuButtonsToggle.assertButtonsUnsigned();
    }

    @Test
    void loginFormTest() {
        loginPage.open();
        var fields = new String[]{"username", "password"};
        var submitButtonName = "login";
        loginPage.form.assertBaseForm(fields, submitButtonName);
    }
}

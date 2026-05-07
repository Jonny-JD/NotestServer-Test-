package com.jimmy_d.autotests.desktop;

import com.jimmy_d.autotests.desktop.page.LoginPage;
import org.junit.jupiter.api.Test;

class LoginPageTest extends BaseTest {

    private final LoginPage loginPage = new LoginPage();


    @Test
    void menuButtonsTestUnsigned() {
        loginPage.open();
        loginPage.menuButtons.assertButtonsUnsigned();
    }

    @Test
    void loginFormTest() {
        loginPage.open();
        var fields = new String[]{"username", "password"};
        var submitButtonName = "login";
        loginPage.form.assertBaseForm(fields, submitButtonName);
    }
}

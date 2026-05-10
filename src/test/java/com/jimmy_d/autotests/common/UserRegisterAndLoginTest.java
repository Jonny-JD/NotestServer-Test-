package com.jimmy_d.autotests.common;

import com.jimmy_d.autotests.BaseTest;
import com.jimmy_d.autotests.TestFactory;
import com.jimmy_d.autotests.page.ProfilePage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

class UserRegisterAndLoginTest extends BaseTest {
    private final ProfilePage profilePage = new ProfilePage();

    @Test
    void assertTestRegisterAndLogUser() {
        var user = TestFactory.registerUser(TestFactory.generateUser());
        TestFactory.loginUser(user);
        $("[data-testid='profile']").shouldBe(visible).click();

        profilePage.usernameField.shouldHave(text(user.name()));
        profilePage.emailField.shouldHave(attribute("placeholder", user.email()));
        profilePage.passwordField.shouldHave(text("CHANGE PASSWORD"));

    }
}

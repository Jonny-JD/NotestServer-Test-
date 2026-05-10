package com.jimmy_d.autotests.page;

import com.codeborne.selenide.SelenideElement;
import com.jimmy_d.autotests.page.object.Form;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProfilePage extends BasePage {
    public final Form form;
    public final SelenideElement usernameField;
    public final SelenideElement emailField;
    public final SelenideElement passwordField;

    public ProfilePage() {
        this.form = new Form();
        this.passwordField = $(By.id("set-password"));
        this.usernameField = $(By.id("username"));
        this.emailField = $(By.id("email"));
    }

    @Override
    public String getUrl() {
        return "/profile";
    }
}

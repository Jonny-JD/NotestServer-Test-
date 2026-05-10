package com.jimmy_d.autotests.page;

import com.codeborne.selenide.SelenideElement;
import com.jimmy_d.autotests.page.object.Form;
import com.jimmy_d.autotests.page.object.MenuButtonsAside;
import com.jimmy_d.autotests.page.object.MenuButtonsToggle;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RegisterPage extends BasePage {

    public final Form form;
    public final MenuButtonsAside menuButtonsAside;
    public final MenuButtonsToggle  menuButtonsToggle;
    public final SelenideElement usernameField;
    public final SelenideElement emailField;
    public final SelenideElement passwordField;

    public RegisterPage() {
        this.form = new Form();
        this.menuButtonsAside = new MenuButtonsAside();
        this.menuButtonsToggle = new MenuButtonsToggle();
        this.usernameField = $(By.id("username"));
        this.emailField = $(By.id("email"));
        this.passwordField = $(By.id("password"));
    }

    @Override
    public String getUrl() {
        return "/register";
    }
}

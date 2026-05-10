package com.jimmy_d.autotests.page;

import com.jimmy_d.autotests.page.object.Form;
import com.jimmy_d.autotests.page.object.MenuButtonsAside;
import com.jimmy_d.autotests.page.object.MenuButtonsToggle;

public class RegisterPage extends BasePage {

    public final Form form;
    public final MenuButtonsAside menuButtonsAside;
    public final MenuButtonsToggle  menuButtonsToggle;

    public RegisterPage() {
        this.form = new Form();
        this.menuButtonsAside = new MenuButtonsAside();
        this.menuButtonsToggle = new MenuButtonsToggle();
    }

    @Override
    public String getUrl() {
        return "/register";
    }
}

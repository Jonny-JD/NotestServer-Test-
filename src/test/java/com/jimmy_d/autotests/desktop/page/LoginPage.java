package com.jimmy_d.autotests.desktop.page;

import com.jimmy_d.autotests.desktop.page.object.Form;
import com.jimmy_d.autotests.desktop.page.object.MenuButtons;

public class LoginPage extends BasePage {
    public final Form form;
    public final MenuButtons menuButtons;

    public LoginPage() {
        this.form = new Form();
        this.menuButtons = new MenuButtons();
    }

    @Override
    public String getUrl() {
        return "/login";
    }
}

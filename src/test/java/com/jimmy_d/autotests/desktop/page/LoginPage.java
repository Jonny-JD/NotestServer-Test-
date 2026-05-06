package com.jimmy_d.autotests.desktop.page;

import com.jimmy_d.autotests.desktop.page.object.Form;

public class LoginPage extends BasePage {
    public final Form form;

    public LoginPage() {
        this.form = new Form();
    }

    @Override
    public String getUrl() {
        return "/login";
    }
}

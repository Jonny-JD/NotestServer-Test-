package com.jimmy_d.autotests.desktop.page;

import com.jimmy_d.autotests.desktop.page.object.Form;

public class RegisterPage extends BasePage {

    public final Form form;

    public RegisterPage() {
        this.form = new Form();
    }

    @Override
    public String getUrl() {
        return "/register";
    }
}

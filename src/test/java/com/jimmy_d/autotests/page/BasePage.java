package com.jimmy_d.autotests.page;

import com.codeborne.selenide.Selenide;

public abstract class BasePage {

    public void open() {
        Selenide.open(getUrl());
    }

    public abstract String getUrl();
}

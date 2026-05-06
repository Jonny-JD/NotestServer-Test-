package com.jimmy_d.autotests.desktop.page.object;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class Form {
    private SelenideElement form;

    public ElementsCollection fields() {
        return form.findAll(By.className("form-cell"));
    }

    public SelenideElement submitButton() {
        return form.find("button[type='submit']");
    }

    public ElementsCollection labels() {
        return form.findAll(By.tagName("label"));
    }
}

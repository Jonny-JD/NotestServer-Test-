package com.jimmy_d.autotests.desktop.page.object;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Form {
    private final SelenideElement form = $(By.tagName("form"));

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

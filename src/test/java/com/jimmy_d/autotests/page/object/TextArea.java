package com.jimmy_d.autotests.page.object;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TextArea {

    public SelenideElement noteTextInput() {
        return $(By.id("note-text"));
    }
}

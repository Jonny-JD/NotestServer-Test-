package com.jimmy_d.autotests.desktop.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class GreetingPage extends BasePage {
    @Override
    public String getUrl() {
        return "/";
    }

    public ElementsCollection asideButtons() {
        return $(By.className("aside-interaction-buttons")).findAll("button");
    }

    public SelenideElement connectButton() {
        return $("[data-testid='connect-button']");
    }

}

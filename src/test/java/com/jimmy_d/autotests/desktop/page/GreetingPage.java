package com.jimmy_d.autotests.desktop.page;

import com.codeborne.selenide.SelenideElement;
import com.jimmy_d.autotests.desktop.page.object.MenuButtons;

import static com.codeborne.selenide.Selenide.$;

public class GreetingPage extends BasePage {
    public final MenuButtons menuButtons;

    public GreetingPage() {
        this.menuButtons = new MenuButtons();
    }

    @Override
    public String getUrl() {
        return "/";
    }

    public SelenideElement connectButton() {
        return $("[data-testid='connect-button']");
    }

}

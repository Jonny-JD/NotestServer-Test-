package com.jimmy_d.autotests.page;

import com.codeborne.selenide.SelenideElement;
import com.jimmy_d.autotests.page.object.MenuButtonsAside;
import com.jimmy_d.autotests.page.object.MenuButtonsToggle;

import static com.codeborne.selenide.Selenide.$;

public class GreetingPage extends BasePage {
    public final MenuButtonsAside menuButtonsAside;
    public final MenuButtonsToggle menuButtonsToggle;

    public GreetingPage() {
        this.menuButtonsToggle = new MenuButtonsToggle();
        this.menuButtonsAside = new MenuButtonsAside();
    }

    @Override
    public String getUrl() {
        return "/";
    }

    public SelenideElement connectButton() {
        return $("[data-testid='connect-button']");
    }

}

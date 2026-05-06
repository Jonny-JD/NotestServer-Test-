package com.jimmy_d.autotests.desktop.page;

import com.codeborne.selenide.SelenideElement;
import com.jimmy_d.autotests.desktop.page.object.OptionsBlock;

import static com.codeborne.selenide.Selenide.$;

public class DiscoverPage extends BasePage {
    public final OptionsBlock optionsBlock;

    public DiscoverPage() {
        this.optionsBlock = new OptionsBlock();
    }

    @Override
    public String getUrl() {
        return "/discover";
    }

    public SelenideElement baseFilterButton(){
        return $("[data-testid='filter']");
    }
}

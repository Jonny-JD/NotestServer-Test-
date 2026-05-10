package com.jimmy_d.autotests.page;

import com.codeborne.selenide.ElementsCollection;
import com.jimmy_d.autotests.page.object.MenuButtonsAside;
import com.jimmy_d.autotests.page.object.MenuButtonsToggle;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage{
    public final MenuButtonsAside menuButtonsAside;
    public final MenuButtonsToggle menuButtonsToggle;

    public MainPage() {
        this.menuButtonsAside = new MenuButtonsAside();
        this.menuButtonsToggle = new MenuButtonsToggle();
    }

    @Override
    public String getUrl() {
        return "/main";
    }


    public ElementsCollection mainButtons(){
        return $(By.className("main")).findAll("button");
    }
}

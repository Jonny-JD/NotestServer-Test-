package com.jimmy_d.autotests.desktop.page;

import com.codeborne.selenide.ElementsCollection;
import com.jimmy_d.autotests.desktop.page.object.MenuButtons;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage{
    public final MenuButtons menuButtons;

    public MainPage() {
        this.menuButtons = new MenuButtons();
    }

    @Override
    public String getUrl() {
        return "/main";
    }


    public ElementsCollection mainButtons(){
        return $(By.className("main")).findAll("button");
    }
}

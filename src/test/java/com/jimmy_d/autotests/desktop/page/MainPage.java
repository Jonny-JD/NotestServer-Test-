package com.jimmy_d.autotests.desktop.page;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage{
    @Override
    public String getUrl() {
        return "/main";
    }


    public ElementsCollection mainButtons(){
        return $(By.className("main")).findAll("button");
    }
}

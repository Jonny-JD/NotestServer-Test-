package com.jimmy_d.autotests.page;

import com.codeborne.selenide.SelenideElement;
import com.jimmy_d.autotests.page.object.MenuButtonsAside;
import com.jimmy_d.autotests.page.object.MenuButtonsToggle;
import com.jimmy_d.autotests.page.object.OptionsBlockForm;
import com.jimmy_d.autotests.page.object.TextArea;

import static com.codeborne.selenide.Selenide.$;

public class MyNotesPage extends BasePage{
    public final OptionsBlockForm optionsBlockForm;
    public final TextArea textArea;
    public final MenuButtonsAside menuButtonsAside;
    public final MenuButtonsToggle menuButtonsToggle;

    public SelenideElement notesList() {
        return $("[role='list']");
    }

    public MyNotesPage() {
        this.optionsBlockForm = new OptionsBlockForm();
        this.textArea = new TextArea();
        this.menuButtonsAside = new MenuButtonsAside();
        this.menuButtonsToggle = new MenuButtonsToggle();
    }

    @Override
    public String getUrl() {
        return "/notes/my";
    }
}

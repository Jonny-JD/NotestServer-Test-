package com.jimmy_d.autotests.page;

import com.jimmy_d.autotests.page.object.MenuButtonsAside;
import com.jimmy_d.autotests.page.object.MenuButtonsToggle;
import com.jimmy_d.autotests.page.object.OptionsBlockForm;
import com.jimmy_d.autotests.page.object.TextArea;

public class CreatePage extends BasePage {
    public final OptionsBlockForm optionsBlockForm;
    public final TextArea textArea;
    public final MenuButtonsAside menuButtonsAside;
    public final MenuButtonsToggle menuButtonsToggle;

    public CreatePage() {
        this.optionsBlockForm = new OptionsBlockForm();
        this.textArea = new TextArea();
        this.menuButtonsAside = new MenuButtonsAside();
        this.menuButtonsToggle = new MenuButtonsToggle();
    }

    @Override
    public String getUrl() {
        return "/create";
    }

}

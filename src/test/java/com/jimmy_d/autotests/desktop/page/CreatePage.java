package com.jimmy_d.autotests.desktop.page;

import com.jimmy_d.autotests.desktop.page.object.MenuButtons;
import com.jimmy_d.autotests.desktop.page.object.OptionsBlockForm;
import com.jimmy_d.autotests.desktop.page.object.TextArea;

public class CreatePage extends BasePage {
    public final OptionsBlockForm optionsBlockForm;
    public final TextArea textArea;
    public final MenuButtons menuButtons;

    public CreatePage() {
        this.optionsBlockForm = new OptionsBlockForm();
        this.textArea = new TextArea();
        this.menuButtons = new MenuButtons();
    }

    @Override
    public String getUrl() {
        return "/create";
    }

}

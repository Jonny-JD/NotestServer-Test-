package com.jimmy_d.autotests.desktop.page;

import com.jimmy_d.autotests.desktop.page.object.MenuButtons;
import com.jimmy_d.autotests.desktop.page.object.OptionsBlockForm;

public class DiscoverPage extends BasePage {
    public final OptionsBlockForm optionsBlockForm;
    public final MenuButtons menuButtons;

    public DiscoverPage() {
        this.optionsBlockForm = new OptionsBlockForm();
        this.menuButtons = new MenuButtons();
    }

    @Override
    public String getUrl() {
        return "/discover";
    }

}

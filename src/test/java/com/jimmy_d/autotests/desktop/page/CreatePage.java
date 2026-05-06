package com.jimmy_d.autotests.desktop.page;

import com.jimmy_d.autotests.desktop.page.object.OptionsBlock;
import com.jimmy_d.autotests.desktop.page.object.TextArea;

public class CreatePage extends BasePage {
    public final OptionsBlock optionsBlock;
    public final TextArea textArea;

    public CreatePage() {
        this.optionsBlock = new OptionsBlock();
        this.textArea = new TextArea();
    }

    @Override
    public String getUrl() {
        return "/create";
    }

}

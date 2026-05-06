package com.jimmy_d.autotests.desktop.page.object;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OptionsBlock {

    public BlockForm blockForm() {
        return new BlockForm($(By.className("options-block")));
    }

    public static final class BlockForm {

        public final SelenideElement form;
        private final SelenideElement block;

        private BlockForm(SelenideElement optionsBlock) {
            this.block = optionsBlock;
            this.form = optionsBlock.$(By.tagName("form"));
        }

        public SelenideElement header() {
            return form.$(By.className("options-form-header"));
        }

        public ElementsCollection fields() {
            return form.findAll(By.className("options-form-cell"));
        }

        public SelenideElement submitButton() {
            return block.find("button");
        }

        public ElementsCollection labels() {
            return form.findAll(By.className("options-form-label"));
        }
    }
}

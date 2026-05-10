package com.jimmy_d.autotests.page.object;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class OptionsBlockForm {

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

        public SelenideElement fieldInput(String id) {
            return form.$(By.id(id));
        }

        public void assertOptionsBlockFormCheck(String headerText, String[] expectedFieldNames, String submitButtonText) {

            header().shouldHave(text(headerText.toUpperCase()));
            var formFields = fields();
            var formLabels = labels();

            Assertions.assertEquals(expectedFieldNames.length, formFields.size());

            formFields.forEach(field -> field.shouldBe(visible));

            formLabels.forEach(label -> label.shouldBe(visible));

            var expectedLabels = Stream.of(expectedFieldNames)
                    .map(String::toUpperCase)
                    .sorted()
                    .toArray(String[]::new);

            var actualLabels = formLabels
                    .stream()
                    .map(elem -> elem
                            .getText()
                            .toUpperCase())
                    .sorted()
                    .toArray(String[]::new);

            assertArrayEquals(expectedLabels, actualLabels);
            submitButton()
                    .shouldBe(visible)
                    .shouldBe(clickable)
                    .shouldHave(text(submitButtonText.toUpperCase()));
        }
    }
}

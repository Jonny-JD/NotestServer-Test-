package com.jimmy_d.autotests.desktop;

import com.codeborne.selenide.Configuration;
import com.jimmy_d.autotests.BaseTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

class BaseTestDesktop extends BaseTest {
    @BeforeEach
    void setDisplaySize() {
        Configuration.browserSize = "1366x768";
    }

    @AfterAll
    static void tearDown() {
        closeWebDriver();
    }
}

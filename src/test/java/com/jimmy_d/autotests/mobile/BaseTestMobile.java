package com.jimmy_d.autotests.mobile;

import com.jimmy_d.autotests.BaseTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

class BaseTestMobile extends BaseTest {
    @BeforeEach
    void setDisplaySize() {
        Configuration.browserSize = "390x844";
    }

    @AfterAll
    static void tearDown() {
        closeWebDriver();
    }
}

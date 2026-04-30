package com.jimmy_d.autotests.desktop;

import com.codeborne.selenide.Configuration;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;


@Slf4j
public abstract class BaseTest {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "http://host.docker.internal:5173";
        Configuration.remote = "http://localhost:4444";
        Configuration.browser = "chrome";
        Configuration.timeout = 4000;
    }

}

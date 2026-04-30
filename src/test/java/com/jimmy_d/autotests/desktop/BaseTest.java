package com.jimmy_d.autotests.desktop;

import com.codeborne.selenide.Configuration;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;


@Slf4j
public abstract class BaseTest {

    @BeforeAll
    static void configure() {
        Configuration.remote = System.getenv()
                .getOrDefault("SELENIUM_HUB", "http://localhost:4444");
        Configuration.baseUrl = System.getenv()
                .getOrDefault("APP_URL", "http://host.docker.internal:5173");
        Configuration.browser = "chrome";
        Configuration.timeout = 4000;
    }

}

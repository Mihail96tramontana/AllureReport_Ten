package qa.guru.allurereport;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void testAllureScenariy() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}



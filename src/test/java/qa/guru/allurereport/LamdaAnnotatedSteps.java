package qa.guru.allurereport;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LamdaAnnotatedSteps {

    private final String REPOSITORY = "Mihail96tramontana/AllureReport_Ten";
    private final Integer ISSUE_NUMBER = 1;

    @Test
    public void testLamdaStep(){

        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главую страницу", () -> {
            open("https://github.com/");
        });

        step("Ищем репозиторий по имени", () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("В результатах поиска переходим по ссылке репозитория", () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Открываем таб Issues", () -> {
            $(partialLinkText("Issues")).click();
        });

        step("Проверяем, что существует Issues с номером", () -> {
            $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);
        });
    }

    @Test
    public void testAnnotatedStep(){

        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository();
        steps.openRepositoryLink();
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber();
    }
}
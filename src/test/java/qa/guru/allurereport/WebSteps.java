package qa.guru.allurereport;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Открываем главую страницу")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Ищем репозиторий по имени {repository}")
    public void searchForRepository() {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("Mihail96tramontana/AllureReport_Ten");
        $(".header-search-input").submit();
    }

    @Step("В результатах поиска переходим по ссылке репозитория {repository}")
    public void openRepositoryLink() {
        $(linkText("Mihail96tramontana/AllureReport_Ten")).click();
    }

    @Step("Открываем таб Issues")
    public void openIssueTab() {
        $(partialLinkText("Issues")).click();
    }

    @Step("Проверяем, что существует Issues с номером {issueNumber}")
    public void shouldSeeIssueWithNumber() {
        $(withText("#1")).should(Condition.visible);
    }
}

package qa.guru.allurereport;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    public void openMainPage() {
        open("https://github.com/");
    }

    public void searchForRepository() {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("Mihail96tramontana/AllureReport_Ten");
        $(".header-search-input").submit();
    }

    public void openRepositoryLink() {
        $(linkText("Mihail96tramontana/AllureReport_Ten")).click();
    }

    public void openIssueTab() {
        $(partialLinkText("Issues")).click();
    }

    public void shouldSeeIssueWithNumber() {
        $(withText("#1")).should(Condition.exist);
    }
}

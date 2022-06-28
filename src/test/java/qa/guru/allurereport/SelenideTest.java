package qa.guru.allurereport;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTest extends TestBase{

    @Test
    public void githubTest(){

        open("https://github.com/");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("Mihail96tramontana/AllureReport_Ten");
        $(".header-search-input").submit();

        $(linkText("Mihail96tramontana/AllureReport_Ten")).click();
        $(partialLinkText("Issues")).click();
        $(withText("#1")).should(Condition.exist);
    }
}
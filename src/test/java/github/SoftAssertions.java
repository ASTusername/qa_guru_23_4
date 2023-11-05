package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertions {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void shouldFindSoftAssertionsInWikiPages() {

        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("div.wiki-rightbar").shouldHave(text("SoftAssertions"));
        $("[href='/selenide/selenide/wiki/SoftAssertions']").click();
        $$("h4").get(2).shouldHave(text("Using JUnit5 extend test class"));
    }
}

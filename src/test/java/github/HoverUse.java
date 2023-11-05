package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HoverUse {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void enterprizePageShouldBeRightTitle() {
        open("/");
        $("ul.d-lg-flex.list-style-none").$(byText("Solutions")).hover();
        $("[href='/enterprise']").click();
        $("h1#hero-section-brand-heading").shouldHave(text("The AI-powered\n" +
                "developer platform."));
    }
}

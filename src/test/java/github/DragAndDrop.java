package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDrop {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.fastSetValue = true;
    }

    @Test
    void dragAndDrop() {
        open("/drag_and_drop");
        $("#column-a").shouldHave(exactText("A"));
        $("#column-b").shouldHave(exactText("B"));
        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));

        $("#column-a").shouldHave(exactText("B"));
        $("#column-b").shouldHave(exactText("A"));
    }
}

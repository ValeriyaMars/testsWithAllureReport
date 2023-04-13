package ru.marshenina;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class IssueTestWithSelenide {

    @Test
    public void issueNameTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("qa-guru/qa_guru_14_10");
        $(".header-search-input").submit();
        $(linkText("qa-guru/qa_guru_14_10")).click();
        $("#issues-tab").click();
        $("#issue_2_link").shouldHave(text("Issue for Autotest"));
    }
}

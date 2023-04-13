package ru.marshenina;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class IssueTestWithStepAnnotation {

    private static final String REPOSITORY = "qa-guru/qa_guru_14_10";
    private static final String ISSUE_NAME = "Issue for Autotest";

    @Test
    public void IssueNameTestWithStepAnnotation() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldHaveIssueWithName(ISSUE_NAME);
    }
}

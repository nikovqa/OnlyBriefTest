package ru.nikov.tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.nikov.pages.BriefPage;



public class Tests extends TestBase {
    BriefPage briefPage = new BriefPage();

    @Tag ("normal")
    @Owner( "Nikolay Ovchinnikov" )
    @DisplayName("Проверка анкеты")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void fillQuestionnaireFormTest() {
        briefPage.openPage()
                .fillQuestionnaireForm()
                .verifyUploadedFile()
                .verifyConsentToPersonalDataProcessingExist();
    }
}


package ru.nikov.pages;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class BriefPage {

    Faker faker = new Faker( Locale.ENGLISH);
    public BriefPage openPage() {
        step("Открыть страницу с анкетой 'https://only.digital/projects#brief'", () ->
                open("https://only.digital/projects#brief"));

        return this;
    }

    public BriefPage fillQuestionnaireForm() {
        step("Вводим имя", () ->
                $(byName( "name" )).shouldBe(Condition.visible).setValue( String.valueOf( faker.aquaTeenHungerForce().character())));
        step("Вводим email", () ->
                $(byName( "email" )).shouldBe(Condition.visible).setValue( String.valueOf( faker.internet().emailAddress())));
        step("Кликаем на поле ввода телефона", () ->
                $(".gACqes",2).click());
        step("Вводим телефон", () ->
                $(".gACqes",2).sendKeys(String.valueOf(faker.number().randomNumber(10, true))));
        step("Вводим название компании", () ->
                $(byName("company")).setValue( String.valueOf(faker.company().name())));
        step("Выбираем чекбокс 'сайт'", () ->
                $(".hmtoPs",2).click());
        step("Вводим описание проекта", () ->
                $(".iQiCsE")).sendKeys (String.valueOf(faker.lorem().characters(350)));
        step("Прикрепляем файл", () ->
                $( byName( "files" )).uploadFromClasspath( "cat.png" ));
        step("Выбираем чекбокс '3–5 млн'", () ->
                $(".hmtoPs", 9).click());
        step("Выбираем чекбокс 'Соцсети'", () ->
                $(".hmtoPs", 15).click());
        return this;
    }
    public BriefPage verifyUploadedFile() {
        step("Проверяем файл", () ->
                $( ".uTcON").shouldHave(text("cat.png")));
        return this;


    }    public BriefPage verifyConsentToPersonalDataProcessingExist() {
        step("Проверяем наличие информации о согласии обработки персональных данных", () ->
                $(".ciLLVR").scrollIntoView(false).shouldHave(Condition.text("Нажимая кнопку “Отправить”, " +
                                                                    "я даю согласие на обработку своих персональных данных и соглашаюсь " +
                                                                    "с Условиями использования и Политикой конфиденциальности")));
        return this;
    }
}

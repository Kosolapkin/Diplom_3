package org.example;

public class Resources {

    // Данные для регистрации пользователя
    public static final String name = "Михаил";
    public static final String email = "misha@yandex.ru";
    public static final String valid_password = "qwerty123";
    public static final String wrong_password = "qwe";

    public static final String mainURL = "https://stellarburgers.nomoreparties.site";
    public static final String registerURL = "https://stellarburgers.nomoreparties.site/register";
    public static final String forgotPasswordURL = "https://stellarburgers.nomoreparties.site/forgot-password";
    public static final String loginURL = "https://stellarburgers.nomoreparties.site/login";

    public static final String baseApiUri= "https://stellarburgers.nomoreparties.site/";
    public static final String authApiUri = "api/auth/register";
    public static final String loginApiUri = "api/auth/login";
    public static final String userApiUri = "api/auth/user";

    // Выбор браузера, на котором запустить тесты. Возможны вариант: chrome или yandex
    public static final String browserName = "chrome";
}

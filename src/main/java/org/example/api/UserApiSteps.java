package org.example.api;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.Resources;

import static io.restassured.RestAssured.given;

public class UserApiSteps {

    public static RequestSpecification requestSpecification() {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(Resources.baseApiUri);
    }

    @Step("Создание нового пользователя")
    public ValidatableResponse userCreate(UserCreateAndEditRequest userCreateAndEditRequest) {
        return requestSpecification()
                .body(userCreateAndEditRequest)
                .post(Resources.authApiUri)
                .then();
    }

    @Step("Авторизация пользователя")
    public ValidatableResponse userLogin(UserLoginRequest userLoginRequest) {
        return requestSpecification()
                .body(userLoginRequest)
                .post(Resources.loginApiUri)
                .then();
    }

    @Step("Удаление пользователя без авторизации")
    public ValidatableResponse userDelete(String accessToken) {
        return requestSpecification()
                .header("Authorization", accessToken)
                .delete(Resources.userApiUri)
                .then();
    }

    @Step("Удаление пользователя после авторизации")
    public ValidatableResponse userDeleteAfterLogin(UserLoginRequest userLoginRequest) {
        Response response = userLogin(userLoginRequest)
                .extract().response();
        UserLoginResponse userLoginResponse = response.as(UserLoginResponse.class);
        String accessToken = userLoginResponse.getAccessToken();
        return userDelete(accessToken);
    }

}

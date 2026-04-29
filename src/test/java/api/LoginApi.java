package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import models.User;
import utils.Urls;

import static io.restassured.RestAssured.given;

public class LoginApi {
    @Step("Логинимся в аккаунт для получения токена")
    public Response login(User user) {
        return given()
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post(Urls.BASE + "api/auth/login");
    }
}


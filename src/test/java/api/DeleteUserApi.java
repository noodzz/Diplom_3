package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import utils.Urls;

import static io.restassured.RestAssured.given;

public class DeleteUserApi {
    @Step("Удаляем пользователя")
    public Response deleteUser(String accessToken) {
        return given()
                .header("Authorization", accessToken)
                .when()
                .delete(Urls.BASE + "api/auth/user");
    }
}

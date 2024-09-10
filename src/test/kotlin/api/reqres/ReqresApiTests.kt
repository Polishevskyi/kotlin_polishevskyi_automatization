package api.reqres

import api.BaseApiSpecifications
import io.qameta.allure.Description
import io.qameta.allure.Owner
import io.restassured.RestAssured.given
import io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath
import org.testng.annotations.Test

class ReqresApiTests : BaseApiSpecifications() {

    private val BASE_URL = "https://reqres.in/api/"

    @Test(priority = 1)
    @Owner("Polishevskyi")
    @Description("Test for retrieving a list of users from the second page")
    fun getListUsersTest() {
        configureSpec(requestSpecification(BASE_URL), responseSpecification(200))
        given()
            .get("users?page=2")
            .then()
            .body(matchesJsonSchemaInClasspath("reqres_schemes/get-list-users-schema.json"))
    }

    @Test(priority = 2)
    @Owner("Polishevskyi")
    @Description("Test for retrieving a single user by ID")
    fun getSingleUserTest() {
        configureSpec(requestSpecification(BASE_URL), responseSpecification(200))
        given()
            .get("users/2")
            .then()
            .body(matchesJsonSchemaInClasspath("reqres_schemes/get-single-user-schema.json"))
    }

    @Test(priority = 3)
    @Owner("Polishevskyi")
    @Description("Test for retrieving a non-existent user by ID")
    fun getSingleUserNotFoundTest() {
        configureSpec(requestSpecification(BASE_URL), responseSpecification(404))
        given()
            .get("users/23")
    }

    @Test(priority = 4)
    @Owner("Polishevskyi")
    @Description("Test for retrieving a list of resources")
    fun getListResourceTest() {
        configureSpec(requestSpecification(BASE_URL), responseSpecification(200))
        given()
            .get("unknown")
            .then()
            .body(matchesJsonSchemaInClasspath("reqres_schemes/get-list-resource-schema.json"))
    }

    @Test(priority = 5)
    @Owner("Polishevskyi")
    @Description("Test for retrieving a single resource by ID")
    fun getSingleResourceTest() {
        configureSpec(requestSpecification(BASE_URL), responseSpecification(200))
        given()
            .get("unknown/2")
            .then()
            .body(matchesJsonSchemaInClasspath("reqres_schemes/get-single-resource-schema.json"))
    }

    @Test(priority = 6)
    @Owner("Polishevskyi")
    @Description("Test for retrieving a non-existent resource by ID")
    fun getSingleResourceNotFoundTest() {
        configureSpec(requestSpecification(BASE_URL), responseSpecification(404))
        given()
            .get("unknown/23")
    }

    @Test(priority = 7)
    @Owner("Polishevskyi")
    @Description("Test for creating a new user")
    fun postCreateTest() {
        configureSpec(requestSpecification(BASE_URL), responseSpecification(201))

        val requestBody = mapOf(
            "name" to "morpheus",
            "job" to "leader"
        )

        given()
            .body(requestBody)
            .post("users")
            .then()
            .body(matchesJsonSchemaInClasspath("reqres_schemes/post-create-user-schema.json"))
    }

    @Test(priority = 8)
    @Owner("Polishevskyi")
    @Description("Test for updating an existing user")
    fun putUpdateTest() {
        configureSpec(requestSpecification(BASE_URL), responseSpecification(200))

        val requestBody = mapOf(
            "name" to "morpheus",
            "job" to "zion resident"
        )

        given()
            .body(requestBody)
            .put("users/2")
            .then()
            .body(matchesJsonSchemaInClasspath("reqres_schemes/put-update-schema.json"))
    }

    @Test(priority = 9)
    @Owner("Polishevskyi")
    @Description("Test for partially updating an existing user")
    fun patchUpdateTest() {
        configureSpec(requestSpecification(BASE_URL), responseSpecification(200))

        val requestBody = mapOf(
            "name" to "morpheus",
            "job" to "zion resident"
        )

        given()
            .body(requestBody)
            .patch("users/2")
            .then()
            .body(matchesJsonSchemaInClasspath("reqres_schemes/put-update-schema.json"))
    }

    @Test(priority = 10)
    @Owner("Polishevskyi")
    @Description("Test for deleting a user")
    fun deleteDeleteTest() {
        configureSpec(requestSpecification(BASE_URL), responseSpecification(204))
        given()
            .delete("users/2")
    }

    @Test(priority = 11)
    @Owner("Polishevskyi")
    @Description("Test for successful user registration")
    fun postRegisterSuccessfulTest() {
        configureSpec(requestSpecification(BASE_URL), responseSpecification(200))

        val requestBody = mapOf(
            "email" to "eve.holt@reqres.in",
            "password" to "pistol"
        )

        given()
            .body(requestBody)
            .post("register")
            .then()
            .body(matchesJsonSchemaInClasspath("reqres_schemes/post-register-successful-schema.json"))
    }

    @Test(priority = 12)
    @Owner("Polishevskyi")
    @Description("Test for unsuccessful user registration with missing password")
    fun postRegisterUnsuccessfulTest() {
        configureSpec(requestSpecification(BASE_URL), responseSpecification(400))

        val requestBody = mapOf(
            "email" to "sydney@fife"
        )

        given()
            .body(requestBody)
            .post("register")
            .then()
            .body(matchesJsonSchemaInClasspath("reqres_schemes/post-register-unsuccessful-schema.json"))
    }

    @Test(priority = 13)
    @Owner("Polishevskyi")
    @Description("Test for successful user login")
    fun postLoginSuccessfulTest() {
        configureSpec(requestSpecification(BASE_URL), responseSpecification(200))

        val requestBody = mapOf(
            "email" to "eve.holt@reqres.in",
            "password" to "cityslicka"
        )

        given()
            .body(requestBody)
            .post("login")
            .then()
            .body(matchesJsonSchemaInClasspath("reqres_schemes/post-login-successful-schema.json"))
    }

    @Test(priority = 14)
    @Owner("Polishevskyi")
    @Description("Test for unsuccessful user login with missing password")
    fun postLoginUnsuccessfulTest() {
        configureSpec(requestSpecification(BASE_URL), responseSpecification(400))

        val requestBody = mapOf(
            "email" to "peter@klaven"
        )

        given()
            .body(requestBody)
            .post("login")
            .then()
            .body(matchesJsonSchemaInClasspath("reqres_schemes/post-login-unsuccessful-schema.json"))
    }

    @Test(priority = 15)
    @Owner("Polishevskyi")
    @Description("Test for retrieving users with a delay in response")
    fun getDelayedResponseTest() {
        configureSpec(requestSpecification(BASE_URL), responseSpecification(200))
        given()
            .get("users?delay=3")
            .then()
            .body(matchesJsonSchemaInClasspath("reqres_schemes/get-delayed-response-schema.json"))
    }
}

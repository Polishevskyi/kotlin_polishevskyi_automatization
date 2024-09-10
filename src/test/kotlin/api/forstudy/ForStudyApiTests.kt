package api.forstudy

import api.BaseApiSpecifications
import io.qameta.allure.Description
import io.qameta.allure.Owner
import org.testng.annotations.Test
import io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath
import io.restassured.RestAssured.given
import utils.DataGenerator

class ForStudyApiTests : BaseApiSpecifications() {

    private val BASE_URL = "https://qauto.forstudy.space/api/auth/"

    private val email = DataGenerator.getEmail()
    private val password = DataGenerator.getPassword()

    @Test(priority = 1)
    @Owner("Polishevskyi")
    @Description("Test for successful logout from the application")
    fun getAuthLogoutTest() {
        configureSpec(requestSpecification(BASE_URL), responseSpecification(200))
        given()
            .get("logOut")
            .then()
            .body(matchesJsonSchemaInClasspath("forstudy_schemes/get-auth-logout-schema.json"))
    }

    @Test(priority = 2)
    @Owner("Polishevskyi")
    @Description("Test for successful sign-up to the application")
    fun postAuthSignUpSuccessTest() {
        configureSpec(requestSpecification(BASE_URL), responseSpecification(201))

        val requestBody = mapOf(
            "name" to DataGenerator.getFirstName(),
            "lastName" to DataGenerator.getLastName(),
            "email" to email,
            "password" to password,
            "repeatPassword" to password
        )

        given()
            .body(requestBody)
            .`when`()
            .post("signUp")
            .then()
            .body(matchesJsonSchemaInClasspath("forstudy_schemes/post-auth-signup-success-schema.json"))
    }

    @Test(priority = 3)
    @Owner("Polishevskyi")
    @Description("Test for failed sign-up with already registered email")
    fun postAuthSignUpFailTest() {
        configureSpec(requestSpecification(BASE_URL), responseSpecification(400))

        val requestBody = mapOf(
            "name" to "John",
            "lastName" to "Dou",
            "email" to "test@test.com",
            "password" to "Qwerty12345",
            "repeatPassword" to "Qwerty12345"
        )

        given()
            .body(requestBody)
            .`when`()
            .post("signUp")
            .then()
            .body(matchesJsonSchemaInClasspath("forstudy_schemes/post-auth-signup-fail-schema.json"))
    }

    @Test(priority = 4)
    @Owner("Polishevskyi")
    @Description("Test for successful sign-in to the application")
    fun postAuthSignInSuccessTest() {
        configureSpec(requestSpecification(BASE_URL), responseSpecification(200))

        val requestBody = mapOf(
            "email" to email,
            "password" to password,
            "remember" to "false"
        )

        given()
            .body(requestBody)
            .`when`()
            .post("signIn")
            .then()
            .body(matchesJsonSchemaInClasspath("forstudy_schemes/post-auth-signin-success-schema.json"))
    }

    @Test(priority = 5)
    @Owner("Polishevskyi")
    @Description("Test for failed sign-in with incorrect credentials")
    fun postAuthSignInFailTest() {
        configureSpec(requestSpecification(BASE_URL), responseSpecification(400))

        val requestBody = mapOf(
            "email" to "test@test.com",
            "password" to "Qwerty12345",
            "remember" to "false"
        )

        given()
            .body(requestBody)
            .`when`()
            .post("signIn")
            .then()
            .body(matchesJsonSchemaInClasspath("forstudy_schemes/post-auth-signin-fail-schema.json"))
    }

    @Test(priority = 6)
    @Owner("Polishevskyi")
    @Description("Test for successful password reset request")
    fun postAuthResetPasswordSuccessTest() {
        configureSpec(requestSpecification(BASE_URL), responseSpecification(200))

        val requestBody = mapOf("email" to email)

        given()
            .body(requestBody)
            .`when`()
            .post("resetPassword")
            .then()
            .body(matchesJsonSchemaInClasspath("forstudy_schemes/post-auth-reset-password-success-schema.json"))
    }

    @Test(priority = 7)
    @Owner("Polishevskyi")
    @Description("Test for failed password reset request with invalid email")
    fun postAuthResetPasswordFailTest() {
        configureSpec(requestSpecification(BASE_URL), responseSpecification(400))

        val requestBody = mapOf("email" to "test@test")

        given()
            .body(requestBody)
            .`when`()
            .post("resetPassword")
            .then()
            .body(matchesJsonSchemaInClasspath("forstudy_schemes/post-auth-reset-password-fail-schema.json"))
    }
}

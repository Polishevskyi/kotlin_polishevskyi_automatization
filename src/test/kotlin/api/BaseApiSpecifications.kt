package api

import io.restassured.RestAssured
import io.restassured.builder.RequestSpecBuilder
import io.restassured.builder.ResponseSpecBuilder
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import io.restassured.specification.ResponseSpecification

open class BaseApiSpecifications {

    fun requestSpecification(url: String): RequestSpecification {
        return RequestSpecBuilder()
            .setBaseUri(url)
            .setContentType(ContentType.JSON)
            .build()
    }

    fun responseSpecification(statusCode: Int): ResponseSpecification {
        return ResponseSpecBuilder()
            .expectStatusCode(statusCode)
            .build()
    }

    fun configureSpec(requestSpecification: RequestSpecification, responseSpecification: ResponseSpecification) {
        RestAssured.requestSpecification = requestSpecification
        RestAssured.responseSpecification = responseSpecification
    }
}

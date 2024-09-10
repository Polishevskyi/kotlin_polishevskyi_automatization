package utils

import com.github.javafaker.Faker

object DataGenerator {
    private val faker = Faker()

    fun getFirstName(): String {
        return faker.name().firstName()
    }

    fun getLastName(): String {
        return faker.name().lastName()
    }

    fun getEmail(): String {
        return faker.internet().emailAddress()
    }

    fun getPassword(): String {
        return faker.regexify("[a-zA-Z0-9]{10,16}")
    }
}

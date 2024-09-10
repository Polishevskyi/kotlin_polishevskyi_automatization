plugins {
    kotlin("jvm") version "1.8.0"
    id("io.qameta.allure") version "2.11.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val testngVersion = "7.10.2"
val restAssuredVersion = "5.5.0"
val allureTestngVersion = "2.19.0"
val jsonSchemaValidatorVersion = "5.5.0"
val javafakerVersion = "1.0.2"
val selenideVersion = "7.4.1"
val webdrivermanagerVersion = "5.9.2"

dependencies {
    testImplementation("org.testng:testng:$testngVersion")
    testImplementation("io.rest-assured:rest-assured:$restAssuredVersion")
    testImplementation("io.qameta.allure:allure-testng:$allureTestngVersion")

    implementation("io.rest-assured:json-schema-validator:$jsonSchemaValidatorVersion")
    implementation("com.github.javafaker:javafaker:$javafakerVersion")
    implementation("com.codeborne:selenide:$selenideVersion")
    implementation("io.github.bonigarcia:webdrivermanager:$webdrivermanagerVersion")
}

tasks.test {
    useTestNG()
}

allure {
    autoconfigure = true
    version = allureTestngVersion
}

/*
Commands to run tests and generate Allure reports:
./gradlew test
./gradlew allureReport
./gradlew allureServe
*/

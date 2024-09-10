package web

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import io.github.bonigarcia.wdm.WebDriverManager
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest

abstract class BaseUiTest {

    fun setUp() {
        WebDriverManager.chromedriver().setup()
        Configuration.browser = "chrome"
        Configuration.browserSize = "1920x1080"
        Configuration.headless = false
    }

    @BeforeTest
    fun init() {
        setUp()
    }

    @AfterTest
    fun tearDown() {
        Selenide.closeWebDriver()
    }
}

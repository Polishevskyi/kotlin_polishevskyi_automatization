package pages.citrusPages

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.Selenide.`$x`

class MainPage(url: String) {
    private val appleTab: SelenideElement = `$x`("//img[@alt='Apple']")
    private val supportTab: SelenideElement = `$x`("//a[@href='/support/']")
    private val compareTab: SelenideElement = `$x`("//a[@href='/compare/']//button[1]")

    init {
        Selenide.open(url)
    }

    fun clickOnAppleTab(): ApplePage {
        appleTab.click()
        return ApplePage()
    }

    fun clickOnSupportTab(): SupportPage {
        supportTab.click()
        return SupportPage()
    }

    fun clickOnCompareTab(): ComparePage {
        compareTab.click()
        return ComparePage()
    }
}

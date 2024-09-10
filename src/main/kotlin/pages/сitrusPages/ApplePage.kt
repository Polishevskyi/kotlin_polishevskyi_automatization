package pages.citrusPages

import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.Selenide.`$x`

class ApplePage {
    private val appleBlock: SelenideElement = `$x`("//span[text()='iPhone']")

    fun getTitleAppleBlock(): String {
        return appleBlock.text
    }
}

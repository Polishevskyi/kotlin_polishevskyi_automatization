package pages.citrusPages

import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.Selenide.`$x`

class SupportPage {
    private val supportTitle: SelenideElement = `$x`("//div[@data-anim='false']//p[1]")

    fun getTitleSupportBlock(): String {
        return supportTitle.text
    }
}

package pages.citrusPages

import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.Selenide.`$x`

class ComparePage {
    private val compareTitle: SelenideElement = `$x`("//div[@class='ComparePage_blank__6j0o1']//div[1]")

    fun getTitleCompareBlock(): String {
        return compareTitle.text
    }
}

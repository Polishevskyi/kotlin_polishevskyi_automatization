package pages.ainPages

import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.Selenide.`$x`

class TechnologyTabPage {

    private val technologyTitle: SelenideElement = `$x`("//ul[@class='breadcrumbs']/following-sibling::h1[1]")

    fun getTitleSearchResultPage(): String {
        return technologyTitle.text
    }
}

package pages.ainPages

import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.Selenide.`$x`

class TopByViewsPage {

    private val titleTopByViews: SelenideElement = `$x`("//ul[@class='breadcrumbs']/following-sibling::h1[1]")

    fun getTitleTopByViewsPage(): String {
        return titleTopByViews.text
    }
}

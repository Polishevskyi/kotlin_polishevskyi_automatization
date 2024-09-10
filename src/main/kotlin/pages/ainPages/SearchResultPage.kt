package pages.ainPages

import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.Selenide.`$x`

class SearchResultPage {

    private val firstArticleTitle: SelenideElement = `$x`("//h2[contains(text(),'iPhone 14 не матиме слоту для SIM-карти в США')]")

    fun getTitleSearchResultPage(): String {
        return firstArticleTitle.text
    }
}

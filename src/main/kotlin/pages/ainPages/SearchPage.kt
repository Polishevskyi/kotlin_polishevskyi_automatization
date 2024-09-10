package pages.ainPages

import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.Selenide.`$x`

class SearchPage {

    private val searchField: SelenideElement = `$x`("//input[@placeholder='Пошук']")
    private val searchBtn: SelenideElement = `$x`("//button[@type='submit']//*[name()='svg']")

    fun addTextToSearchField(text: String): SearchPage {
        searchField.click()
        searchField.setValue(text)
        return this
    }

    fun clickOnSearchBtn(): SearchResultPage {
        searchBtn.click()
        return SearchResultPage()
    }
}

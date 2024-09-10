package pages.ainPages

import com.codeborne.selenide.Selenide.`$x`
import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.Selenide

class MainPage(url: String) {

    private val searchField: SelenideElement = `$x`("(//*[name()='rect'])[2]")
    private val technologyBtn: SelenideElement = `$x`("//a[@rel='dofollow'][contains(text(),'Технології')]")
    private val firstTopByViews: SelenideElement = `$x`("//div[@class='side-widget side-widget--top-news']//li[1]//a")

    init {
        Selenide.open(url)
    }

    fun clickOnSearchBtn(): SearchPage {
        searchField.click()
        return SearchPage()
    }

    fun clickOnTechnologyTab(): TechnologyTabPage {
        technologyBtn.click()
        return TechnologyTabPage()
    }

    fun clickOnFirstTopByViewsArticle(): TopByViewsPage {
        firstTopByViews.click()
        return TopByViewsPage()
    }

    fun getTitleTopByViewsMainPage(): String {
        return firstTopByViews.text
    }
}

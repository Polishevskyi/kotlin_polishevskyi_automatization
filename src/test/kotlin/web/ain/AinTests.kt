package web.ain

import pages.ainPages.MainPage
import io.qameta.allure.Description
import io.qameta.allure.Owner
import org.testng.Assert
import org.testng.annotations.Test
import web.BaseUiTest

class AinTests : BaseUiTest() {

    companion object {
        private const val BASE_URL = "https://ain.ua/"
        private const val SEARCH_TEXT = "iPhone 14 не матиме слоту для SIM-карти в США"
        private const val TECHNOLOGY_TITLE = "Технології"
    }

    @Test
    @Owner("Polishevskyi")
    @Description("Test verify text after search")
    fun verifyTitleAfterSearch() {
        Assert.assertTrue(
            MainPage(BASE_URL)
                .clickOnSearchBtn()
                .addTextToSearchField(SEARCH_TEXT)
                .clickOnSearchBtn()
                .getTitleSearchResultPage()
                .contains(SEARCH_TEXT)
        )
    }

    @Test
    @Owner("Polishevskyi")
    @Description("Test verify title after opening Technology tab")
    fun verifyTechnologyTitle() {
        Assert.assertTrue(
            MainPage(BASE_URL)
                .clickOnTechnologyTab()
                .getTitleSearchResultPage()
                .contains(TECHNOLOGY_TITLE)
        )
    }

    @Test
    @Owner("Polishevskyi")
    @Description("Test verify title after opening first Top by Views article")
    fun verifyTopByViewsTitle() {
        Assert.assertEquals(
            MainPage(BASE_URL)
                .clickOnFirstTopByViewsArticle()
                .getTitleTopByViewsPage(),
            MainPage(BASE_URL)
                .getTitleTopByViewsMainPage()
                .trim().replaceFirst("^\\d\\s+".toRegex(), ""),
            "The titles don't match!"
        )
    }
}

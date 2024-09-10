package web.citrus

import io.qameta.allure.Description
import io.qameta.allure.Owner
import org.testng.Assert
import org.testng.annotations.Test
import pages.citrusPages.MainPage
import web.BaseUiTest

class CitrusTests : BaseUiTest() {

    companion object {
        private const val BASE_URL = "https://www.ctrs.com.ua/"
        private const val IPHONE_TITLE = "iPhone"
        private const val SUPPORT_TITLE = "Любий Клієнте!"
        private const val COMPARE_TITLE = "Порівняння не заповнено"
    }

    @Test
    @Owner("Polishevskyi")
    @Description("Test verify iPhone block into Apple tab")
    fun verifyTitleAfterSearch() {
        Assert.assertTrue(MainPage(BASE_URL)
            .clickOnAppleTab()
            .getTitleAppleBlock()
            .contains(IPHONE_TITLE))
    }

    @Test
    @Owner("Polishevskyi")
    @Description("Test verify Support block")
    fun verifySupportTab() {
        Assert.assertTrue(MainPage(BASE_URL)
            .clickOnSupportTab()
            .getTitleSupportBlock()
            .contains(SUPPORT_TITLE))
    }

    @Test
    @Owner("Polishevskyi")
    @Description("Test verify Compare block")
    fun verifyCompareTab() {
        Assert.assertTrue(MainPage(BASE_URL)
            .clickOnCompareTab()
            .getTitleCompareBlock()
            .contains(COMPARE_TITLE))
    }
}

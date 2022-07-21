package br.com.zup.listacompras.produto

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasErrorText
import androidx.test.espresso.matcher.ViewMatchers.withId
import br.com.zup.listacompras.MSG_ERROR_MISSING_DETAIL
import br.com.zup.listacompras.MSG_ERROR_MISSING_NAME
import br.com.zup.listacompras.R
import org.junit.Test

internal class ProdutoFragmentTest {

    @Test
    fun checkValidationProdutoFragment_AllBarEmpty() {
        val scenario = launchFragmentInContainer<ProdutoFragment>()
        onView(withId(R.id.bvAdicionar)).perform(click())
        onView(hasErrorText(MSG_ERROR_MISSING_NAME)).check(matches(withId(R.id.etNomeProduto)))
        onView(hasErrorText(MSG_ERROR_MISSING_DETAIL)).check(matches(withId(R.id.etDetalheProduto)))
    }

    @Test
    fun checkValidationProdutoFragment_snackBarNameIsEmpty() {
        val scenario = launchFragmentInContainer<ProdutoFragment>()
        onView(withId(R.id.etNomeProduto)).perform(typeText("TesteNome"))
        onView(withId(R.id.bvAdicionar))
            .perform(click())
        onView(hasErrorText(MSG_ERROR_MISSING_DETAIL))
            .check(matches(withId(R.id.etDetalheProduto)))
    }

    @Test
    fun checkValidationProdutoFragment_snackBarDetailIsEmpty() {
        val scenario = launchFragmentInContainer<ProdutoFragment>()
        onView(withId(R.id.etDetalheProduto))
            .perform(typeText("TesteDetalhe"))
        closeSoftKeyboard()
        onView(withId(R.id.bvAdicionar))
            .perform(click())
        onView(hasErrorText(MSG_ERROR_MISSING_NAME))
            .check(matches(withId(R.id.etNomeProduto)))
    }
}
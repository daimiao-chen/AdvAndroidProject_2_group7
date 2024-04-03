package jlin2.examples.localtesting

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class LocalTestingUnitTest {
    @Test
    fun correctEmailAddressFormat() {
        assertTrue(EmailValidator.isValidEmail("123@abc.com"))
    }
    @Test
    fun correctEmailAddressSubdomainFormat() {
        assertTrue(EmailValidator.isValidEmail("123@abc.co.ca"))
    }
    /* todo add antoher test */

    @Test
    fun incorrectEmailAddressFormat_null() {
        assertFalse(EmailValidator.isValidEmail(null))
    }
}
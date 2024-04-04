package jlin2.examples.localtesting

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class LocalTestingUnitTest {
   /** Correct email address format, such as 123@abc.com */
    @Test
    fun correctEmailAddressFormat() {
        assertTrue(EmailValidator.isValidEmail("123@abc.com"))
    }
    /** Correct email address subdomain format, such as 123@abc.co.ca  */
    @Test
    fun correctEmailAddressSubdomainFormat() {
        assertTrue(EmailValidator.isValidEmail("123@abc.co.ca"))
    }
    /** Incorrect email address format (incorrect domain), such as 123@abc  */
    @Test
    fun incorrectEmailAddressFormat_incorrectDomain() {
        assertFalse(EmailValidator.isValidEmail("123@abc"))
    }
    /** Incorrect email address format (with double dots), such as 123@abc..com  */
    @Test
    fun incorrectEmailAddressFormat_withDoubleDots() {
        assertFalse(EmailValidator.isValidEmail("123@abc..com"))
    }
    /** Incorrect email address format (without username), such as @abc.com  */
    @Test
    fun incorrectEmailAddressFormat_withoutUsername() {
        assertFalse(EmailValidator.isValidEmail("@abc.com"))
    }
    /** Incorrect email address format (without domain), such as testing123  */
    @Test
    fun incorrectEmailAddressFormat_withoutDomain() {
        assertFalse(EmailValidator.isValidEmail("testing123"))
    }
    /** Incorrect email address format (empty string), such as “”  */
    @Test
    fun incorrectEmailAddressFormat_emptyString() {
        assertFalse(EmailValidator.isValidEmail(""))
    }
    /** Incorrect email address format (null), null */
    @Test
    fun incorrectEmailAddressFormat_null() {
        assertFalse(EmailValidator.isValidEmail(null))
    }
}
package com.bugbee.sandboxshop

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class DiscountCodesTest {

    @Test
    fun `known code returns its percentage`() {
        assertEquals(10, DiscountCodes.percentOff("WELCOME10"))
        assertEquals(25, DiscountCodes.percentOff("VIP25"))
    }

    @Test
    fun `codes are case-insensitive and trimmed`() {
        assertEquals(10, DiscountCodes.percentOff("  welcome10 "))
    }

    @Test
    fun `unknown code gives no discount`() {
        assertEquals(0, DiscountCodes.percentOff("BOGUS"))
    }

    @Test
    fun `applies discount to total`() {
        assertEquals(1800, DiscountCodes.apply(2000, "WELCOME10"))
        assertEquals(1500, DiscountCodes.apply(2000, "VIP25"))
    }

    @Test
    fun `unknown code leaves total unchanged`() {
        assertEquals(2000, DiscountCodes.apply(2000, "NOPE"))
    }

    @Test
    fun `rejects negative totals`() {
        assertThrows(IllegalArgumentException::class.java) {
            DiscountCodes.apply(-1, "WELCOME10")
        }
    }
}

package com.bugbee.sandboxshop

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class PriceFormatterTest {

    @Test
    fun `formats whole dollar amounts`() {
        assertEquals("$20.00", PriceFormatter.format(2000))
    }

    @Test
    fun `formats amounts with cents`() {
        assertEquals("$19.99", PriceFormatter.format(1999))
    }

    @Test
    fun `formats sub-dollar amounts with leading zero`() {
        assertEquals("$0.05", PriceFormatter.format(5))
    }

    @Test
    fun `formats zero`() {
        assertEquals("$0.00", PriceFormatter.format(0))
    }

    @Test
    fun `rejects negative amounts`() {
        assertThrows(IllegalArgumentException::class.java) {
            PriceFormatter.format(-1)
        }
    }
}

package com.bugbee.sandboxshop

import java.util.Locale

/** Formats integer cent amounts as display prices, e.g. 1999 -> "$19.99". */
object PriceFormatter {

    fun format(cents: Int): String {
        require(cents >= 0) { "Price must not be negative" }
        return String.format(Locale.US, "$%d.%02d", cents / 100, cents % 100)
    }
}

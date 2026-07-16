package com.bugbee.sandboxshop

/** Maps promo codes to a percentage discount and applies them to totals. */
object DiscountCodes {

    private val codes = mapOf(
        "WELCOME10" to 10,
        "VIP25" to 25,
    )

    /** Returns the percent discount for [code], or 0 if the code is unknown. */
    fun percentOff(code: String): Int = codes[code.trim().uppercase()] ?: 0

    /** Applies [code] to a total in cents, rounding the discount down. */
    fun apply(cents: Int, code: String): Int {
        require(cents >= 0) { "Price must not be negative" }
        return cents - cents * percentOff(code) / 100
    }
}

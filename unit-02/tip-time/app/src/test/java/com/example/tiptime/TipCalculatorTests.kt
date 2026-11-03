package com.example.tiptime

import java.text.NumberFormat
import org.junit.Assert.assertEquals
import org.junit.Test

class TipCalculatorTests {
    @Test
    fun calculateTwentyPercentTip() {
        val expected = NumberFormat.getCurrencyInstance().format(2.0)
        assertEquals(expected, calculateTip(amount = 10.0, tipPercent = 20.0))
    }

    @Test
    fun calculateRoundedTip() {
        val expected = NumberFormat.getCurrencyInstance().format(2.0)
        assertEquals(expected, calculateTip(amount = 10.0, tipPercent = 15.0, roundUp = true))
    }
}

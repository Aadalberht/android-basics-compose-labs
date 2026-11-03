package com.example.tiptime

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.test.assertExists
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import java.text.NumberFormat
import org.junit.Rule
import org.junit.Test

class TipUITests {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculateTwentyPercentTip() {
        composeTestRule.setContent {
            MaterialTheme { TipTimeLayout() }
        }

        composeTestRule.onNodeWithText("Bill Amount").performTextInput("10")
        composeTestRule.onNodeWithText("Tip Percentage").performTextInput("20")
        val expectedTip = NumberFormat.getCurrencyInstance().format(2.0)
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip").assertExists()
    }
}

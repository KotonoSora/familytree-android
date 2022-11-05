package com.kotonosora.familytree

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.kotonosora.familytree.ui.theme.MyApplicationTheme
import org.junit.Rule
import org.junit.Test

class TipUITests {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        with(composeTestRule) {
            setContent {
                MyApplicationTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                    ) {
                        TipTimeScreen()
                    }
                }
            }
            onNodeWithText("Bill Amount").performTextInput("10")
            onNodeWithText("Tip (%)").performTextInput("20")
            onNodeWithText("Tip amount: $2.00")
                .assertExists("No node with this text was found.")
        }
    }
}
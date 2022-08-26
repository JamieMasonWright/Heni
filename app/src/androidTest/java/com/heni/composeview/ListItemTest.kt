package com.heni.composeview

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.heni.composeview.ui.components.RepoListItem
import org.junit.Rule
import org.junit.Test

class ListItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val name = "Beedrill"
    private val imageUrl =
        "https://avatars.githubusercontent.com/u/262517?v=4"


    @Test
    fun `should_render_repo_item`(): Unit = with(composeTestRule) {

        composeTestRule.setContent {
            RepoListItem(
                name = name,
                imageUrl = imageUrl
            ) {}
        }

        onNodeWithText(name, useUnmergedTree = true).assertIsDisplayed()

    }
}


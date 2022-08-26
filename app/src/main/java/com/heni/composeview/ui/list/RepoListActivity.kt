package com.heni.composeview.ui.list

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.heni.composeview.ui.components.SampleApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RepoListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleApp()
        }
    }
}

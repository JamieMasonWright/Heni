package com.heni.composeview.ui.components

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.heni.composeview.R
import com.heni.composeview.ui.theme.ComposeViewTheme
import com.heni.composeview.ui.theme.Purple700
import com.heni.composeview.viewmodel.RepoViewModel
import java.text.SimpleDateFormat
import java.time.OffsetDateTime
import java.util.*

@Composable
fun SampleApp() {
    ComposeViewTheme {
        val navController = rememberNavController()
        val repoViewModel: RepoViewModel = viewModel()

        NavHost(navController = navController, startDestination = "RepoList") {
            composable("RepoList") { RepoList(navController, repoViewModel) }
            composable("RepoDetails") { DetailsText(navController) }
        }
    }
}

@Composable
fun RepoList(
    navController: NavHostController,
    repoViewModel: RepoViewModel
) {

    val repoList = repoViewModel.repoListStatus.value

    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            topBar = { TopBar() }
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                contentPadding = PaddingValues(top = 8.dp, bottom = 8.dp)
            ) {

                val sortedList = repoList.sortedBy {
                    it.name
                }

                items(sortedList) { repoResponse ->
                    repoResponse.owner?.avatarUrl?.let { it1 ->
                        RepoListItem(name = ""+repoResponse.id+"\n"+repoResponse.fullName+"\n"+repoResponse.size, it1) {
                            navController.currentBackStackEntry?.arguments = Bundle().apply {
                                putString("date", "Create At : "+parseDate(repoResponse.createdAt)
                                        +"\nUpdate At : "+ parseDate(repoResponse.updatedAt)
                                        +"\nPushed At : "+ parseDate(repoResponse.pushedAt))
                        }
                            navController.navigate("RepoDetails")
                        }
                    }
                }
            }
        }
    }
}

@SuppressLint("SimpleDateFormat")
fun parseDate(stringToParse: String?): String? {
    val format = SimpleDateFormat("yyyy.MM.dd HH:mm:ss")
    val date = try {
        val odt =
            OffsetDateTime.parse(stringToParse)
        val instant = odt.toInstant()
        Date.from(instant)
    } catch (e: Exception) {
    }
    return format.format(date)
}

@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = "Sample") }
    )
}

@Composable
fun RepoListItem(
    name: String,
    imageUrl: String,
    onClick: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(bottom = 8.dp),
        border = BorderStroke(1.dp, Purple700),
    ) {
        Row(
            modifier = Modifier
                .clickable {
                    onClick()
                },
            verticalAlignment = Alignment.Bottom
        ) {
            ProfileImage(imageUrl)
            ProfileName(name)
        }
    }
}

@Composable
fun ProfileImage(imageUrl: String) {
    Image(
        painter = rememberImagePainter(data = imageUrl, builder = {
            placeholder(R.drawable.ic_launcher_background)
            scale(Scale.FIT)
        }),
        contentDescription = "Profile image",
        modifier = Modifier
            .height(100.dp)
            .width(100.dp)
            .fillMaxHeight()
            .fillMaxWidth(),
        contentScale = ContentScale.Fit
    )
}

@Composable
fun ProfileName(name: String) {
    Text(
        text = "ID:  $name",
        color = MaterialTheme.colors.secondaryVariant,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, bottom = 8.dp),
        style = MaterialTheme.typography.body1,
        textAlign = TextAlign.Justify,
    )
}

@Composable
fun DetailsText(navController: NavHostController) {
    val date = navController.previousBackStackEntry
        ?.arguments?.getString("date")
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            topBar = { TopBar() }
        ) {
            if (date != null) {
                ProfileName(date)
            }
        }
    }
}

@Preview(name = "Profile Image")
@Composable
fun ProfileImagePreview() {
    Surface {
        ProfileImage(
            imageUrl = ""
        )
    }
}

@Preview(name = "Profile Name")
@Composable
fun ProfileNamePreview() {
    Surface {
        ProfileName(name = "Profile Name")
    }
}

@Preview(name = "List Item")
@Composable
private fun ListItemPreview() {
    RepoListItem(
        name = "mralexgray/-REPONAME",
        imageUrl = ""
    ) {}
}

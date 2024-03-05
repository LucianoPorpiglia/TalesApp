package com.example.storiesapp.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.storiesapp.R
import com.example.storiesapp.components.ActionButton
import com.example.storiesapp.components.CardBook
import com.example.storiesapp.components.PickerView
import com.example.storiesapp.components.ProfileImage
import com.example.storiesapp.components.TitleBar
import com.example.storiesapp.util.TalesPreferences
import com.example.storiesapp.viewModel.BooksViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController, viewModel: BooksViewModel) {

    val books by viewModel.books.collectAsState()

    val leftBooks = books.filterIndexed { index, _ -> index % 2 == 0 }
    val rightBooks = books.filterIndexed { index, _ -> index % 2 != 0 }
    val user = TalesPreferences.getUser()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    TitleBar(
                        text = "Welcome",
                        padding = PaddingValues(start = 0.dp)
                    )
                    Text(
                        modifier = Modifier
                            .padding(top = 35.dp),
                        text = "Username",
                        style = MaterialTheme.typography.titleSmall,

                    )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary
                ),
                actions = {
                    IconButton(
                        modifier = Modifier
                            .height(60.dp)
                            .width(58.dp),
                        onClick = { navController.navigate("ProfileView") },
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.placeholder),
                            contentDescription = "Icon Button"
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            ActionButton(
                onClick = {
                    navController.navigate("MainCharacterView")
                }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(top = 65.dp)

        ) {

            item {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(end = 6.dp)
                ) {

                    Column(
                        modifier = Modifier
                            .padding(start = 6.dp)
                    ) {

                        for (book in leftBooks) {

                            Spacer(modifier = Modifier.padding(4.dp))

                            CardBook(book) {
                                navController.navigate("DetailView/${book.id}")
                            }
                        }
                    }

                    Column(
                        modifier = Modifier
                            .padding(start = 6.dp)
                    ) {

                        for (book in rightBooks) {

                            Spacer(modifier = Modifier.padding(4.dp))

                            CardBook(book) {
                                navController.navigate("DetailView/${book.id}")
                            }
                        }
                    }
                }
            }
        }
    }
}


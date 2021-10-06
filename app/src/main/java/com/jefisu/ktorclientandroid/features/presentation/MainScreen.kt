package com.jefisu.ktorclientandroid.features.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.jefisu.ktorclientandroid.R

@ExperimentalCoilApi
@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel()
) {
    val response = viewModel.state.value

    Surface(color = MaterialTheme.colors.background) {
        LazyColumn {
            items(response.digimons) {
                val painter = rememberImagePainter(
                    data = it.img,
                    builder = {
                        placeholder(R.drawable.ic_image_loading)
                    }
                )
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painter,
                        contentDescription = it.name,
                        modifier = Modifier
                            .size(80.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = it.name, fontSize = 25.sp)
                }
            }
        }

        if (response.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
    }
}
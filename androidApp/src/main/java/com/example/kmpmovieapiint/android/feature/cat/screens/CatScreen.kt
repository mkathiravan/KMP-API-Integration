package com.example.kmpmovieapiint.android.feature.cat.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.kmpmovieapiint.android.R
import com.example.kmpmovieapiint.android.feature.ui.viewModel.CatViewModel
import com.example.kmpmovieapiint.data.model.Cat

@Composable
fun CatScreen(
    viewModel: CatViewModel
) {
    val res = viewModel.catResponse.value

    if (res.isLoading)
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }

    if (res.data.isNotEmpty())
        LazyColumn {
            items(
                res.data,
                key = { it.id!! }
            ) {
                CatEachRow(cat = it)
            }
        }

    if (res.error.isNotEmpty())
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = res.error)
        }

}

@Composable
fun CatEachRow(cat: Cat) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(15.dp)) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current).data(cat.url).crossfade(true)
                    .build(),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                placeholder = painterResource(
                    id = R.drawable.img
                ),
                modifier = Modifier
                    .clip(CircleShape)
                    .size(100.dp)
            )

            Spacer(modifier = Modifier.width(20.dp))
            Column(modifier = Modifier.align(CenterVertically)) {
                Text(text = "Width : ${cat.width}")
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = "Height: ${cat.height}")
            }
        }
    }
}
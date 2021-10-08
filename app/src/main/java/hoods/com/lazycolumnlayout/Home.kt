package hoods.com.lazycolumnlayout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hoods.com.lazycolumnlayout.data.Cat
import hoods.com.lazycolumnlayout.data.CatsRepo
import hoods.com.lazycolumnlayout.data.generateRandomCats

@Composable
fun Home() {
    val cats = remember {
        CatsRepo.getCats()
    }
    Scaffold { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            item {
                Header(text = "Cats Available for adoption")
            }

            items(cats) { cat ->
                CatListItem(cat = cat)

            }
        }

    }
}

@Composable
fun CatListItem(cat: Cat) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Image(painter = painterResource(id = cat.catImage), contentDescription = null, modifier = Modifier.clip(MaterialTheme.shapes.small))
        Column {
            Text(text = cat.name, style = MaterialTheme.typography.h6)
            Text(
                text = cat.gender,
                style = MaterialTheme.typography.body2,
                color = Color.Black.copy(.5f)
            )
            Text(text = cat.gender, style = MaterialTheme.typography.body2)
        }

    }
}

@Preview
@Composable
fun preCatListItem() {
    val cat = remember {
        generateRandomCats()
    }
    CatListItem(cat = cat)
}

@Composable
fun Header(text: String, modifier: Modifier = Modifier) {
    Surface(
        color = MaterialTheme.colors.onSurface.copy(.1f),
        contentColor = MaterialTheme.colors.primary,
        modifier = modifier.semantics { heading() }
    ) {
        Text(
            text = text, style = MaterialTheme.typography.subtitle2, modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}

@Preview
@Composable
fun PrevHome() {
    Home()
}
package hoods.com.lazycolumnlayout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hoods.com.lazycolumnlayout.data.Cat
import hoods.com.lazycolumnlayout.data.generateRandomCats

@Composable
fun Home() {
    Scaffold { innerPadding ->
        LazyColumn(contentPadding = innerPadding){

        }

    }
}

@Composable
fun CatListItem(cat:Cat) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Image(painter = painterResource(id = cat.catImage), contentDescription = null)
        Column {
            Text(text = cat.name, style = MaterialTheme.typography.h6)
            Text(text = cat.gender, style = MaterialTheme.typography.body2, color = Color.Black.copy(.5f))
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
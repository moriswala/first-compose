package com.moriswala.firstcompose.ui.puppies

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moriswala.firstcompose.R
import com.moriswala.firstcompose.model.Puppy
import com.moriswala.firstcompose.model.puppies
import com.moriswala.firstcompose.ui.common.PuppyListItem
import com.moriswala.firstcompose.ui.theme.BlueTheme

@Composable
fun PuppiesList(
    puppies: List<Puppy>,
    selectedPuppy: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    BlueTheme{
        Scaffold(
            Modifier.background(color = MaterialTheme.colors.primarySurface,),
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.app_name),
                            Modifier.padding(top = 40.dp),
                            style = MaterialTheme.typography.h5,)
                    },
                    Modifier.height(100.dp),
                    backgroundColor = MaterialTheme.colors.primarySurface,
                    contentColor = Color.White,
                    elevation = 12.dp
                )
            },
            content = { ScreenBody(puppies, selectedPuppy, modifier) })
    }
}

@Composable
fun ScreenBody(
    puppies: List<Puppy>,
    selectedPuppy: (Long) -> Unit,
    modifier: Modifier = Modifier){
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxWidth()
    ) {
        LazyColumn(modifier) {
            itemsIndexed(puppies) { index, puppy ->
                PuppyView(puppy, index, selectedPuppy)
            }
        }
    }
}

@Composable
fun PuppyView(
    puppy: Puppy,
    index: Int,
    selectedPuppy: (Long) -> Unit
) {
    Row(modifier = Modifier.padding(bottom = 8.dp)) {
        PuppyListItem(
            puppy = puppy,
            onClick = { selectedPuppy(puppy.id) },
            shape = if (index % 2 == 0) RoundedCornerShape(topStart = 24.dp) else RoundedCornerShape(bottomEnd = 24.dp),
            modifier = Modifier.height(96.dp)
        )
    }
}

@Preview(name = "My Puppies")
@Composable
private fun PupiesListPreview() {
    BlueTheme {
        PuppiesList(
            puppies = puppies,
            selectedPuppy = { }
        )
    }
}

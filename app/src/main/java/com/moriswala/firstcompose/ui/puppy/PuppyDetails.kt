package com.moriswala.firstcompose.ui.puppy

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moriswala.firstcompose.R
import com.moriswala.firstcompose.model.Puppy
import com.moriswala.firstcompose.model.PuppyRepo
import com.moriswala.firstcompose.model.puppies
import com.moriswala.firstcompose.ui.common.PuppyListItem
import com.moriswala.firstcompose.ui.theme.BlueTheme
import com.moriswala.firstcompose.ui.theme.PinkTheme
import com.moriswala.firstcompose.utils.NetworkImage
import com.moriswala.firstcompose.utils.scrim
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import dev.chrisbanes.accompanist.insets.statusBarsPadding

@Composable
fun PuppyDetails(
    puppyId: Long,
    selectedPuppy: (Long) -> Unit,
    upPress: () -> Unit
) {
    // Simplified for the sample
    val puppy = remember(puppyId) { PuppyRepo.getPuppy(puppyId) }
    // TODO: Show error if puppy not found.
    PuppyDetails(puppy, selectedPuppy, upPress)
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PuppyDetails(
    puppy: Puppy,
    selectedPuppy: (Long) -> Unit,
    upPress: () -> Unit
) {
    PinkTheme {
        BoxWithConstraints {
            PuppyDescription(puppy, selectedPuppy, upPress)
        }
    }
}

@Composable
private fun PuppyDescription(
    puppy: Puppy,
    selectedPuppy: (Long) -> Unit,
    upPress: () -> Unit
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            item { PuppyDescriptionHeader(puppy, upPress) }
            item { PuppyDescriptionBody(puppy) }
            item { RelatedPuppy(puppy.id, selectedPuppy) }
        }
    }
}

@Composable
private fun PuppyDescriptionHeader(
    puppy: Puppy,
    upPress: () -> Unit
) {
    Box {
        NetworkImage(
            url = puppy.thumbUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .scrim(colors = listOf(Color(0x80000000), Color(0x33000000)))
                .aspectRatio(4f / 3f)
        )
        TopAppBar(
            backgroundColor = Color.Transparent,
            elevation = 0.dp,
            contentColor = Color.White, // always white as image has dark scrim
            modifier = Modifier.statusBarsPadding()
        ) {
            IconButton(onClick = upPress) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = stringResource(R.string.label_back)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
        }

    }
}

@Composable
private fun PuppyDescriptionBody(puppy: Puppy) {
    Text(
        text = puppy.name,
        style = MaterialTheme.typography.h4,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    )
    Text(
        text = stringResource(
            R.string.puppy_price,
            puppy.price
        ),
        color = MaterialTheme.colors.primary,
        style = MaterialTheme.typography.subtitle1,
        textAlign = TextAlign.End,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                top = 36.dp,
                end = 16.dp,
                bottom = 16.dp
            )
    )
    Spacer(modifier = Modifier.height(16.dp))
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
        Text(
            text = stringResource(id = R.string.puppy_desc),
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
    Divider(modifier = Modifier.padding(16.dp))
    Text(
        text = stringResource(id = R.string.what_you_ll_need),
        style = MaterialTheme.typography.h6,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
        Text(
            text = stringResource(id = R.string.needs),
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    top = 16.dp,
                    end = 16.dp,
                    bottom = 32.dp
                )
        )
    }
}

@Composable
private fun RelatedPuppy(
    puppyId: Long,
    selectedPuppy: (Long) -> Unit
) {
    val relatedPuppies = remember(puppyId) { PuppyRepo.getRelated(puppyId) }
    BlueTheme {
        Surface(
            color = MaterialTheme.colors.primarySurface,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.navigationBarsPadding()) {
                Text(
                    text = stringResource(id = R.string.you_ll_also_like),
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 16.dp,
                            vertical = 24.dp
                        )
                )
                LazyRow(
                    contentPadding = PaddingValues(
                        start = 16.dp,
                        bottom = 32.dp,
                        end = 8.dp
                    )
                ) {
                    items(relatedPuppies) { related ->
                        PuppyListItem(
                            puppy = related,
                            onClick = { selectedPuppy(related.id) },
                            titleStyle = MaterialTheme.typography.subtitle1,
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .size(300.dp, 100.dp),

                        )
                    }
                }
            }
        }
    }
}

@Preview(name = "Puppy Details")
@Composable
private fun PuppyDetailsPreview() {
    val puppyId = puppies.first().id
    PuppyDetails(
        puppyId = puppyId,
        selectedPuppy = { },
        upPress = { }
    )
}


@Preview(name = "Related")
@Composable
private fun RelatedPuppiesPreview() {
    val related = puppies.random()
    RelatedPuppy(
        puppyId = related.id,
        selectedPuppy = { }
    )
}

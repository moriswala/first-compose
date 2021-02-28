package com.moriswala.firstcompose.ui.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.moriswala.firstcompose.R
import com.moriswala.firstcompose.model.Puppy
import com.moriswala.firstcompose.ui.theme.FirstComposeTheme
import com.moriswala.firstcompose.utils.NetworkImage

@Composable
fun PuppyListItem(
    puppy: Puppy,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    elevation: Dp = FirstComposeTheme.elevations.card,
    titleStyle: TextStyle = MaterialTheme.typography.subtitle1,
) {
    Surface(
        elevation = elevation,
        modifier = modifier
    ) {
        Card(
            shape = shape,
            border = BorderStroke(width = 1.dp, color = Color.LightGray),

        ) {
            Row(modifier = Modifier.fillMaxSize().clickable(onClick = onClick)) {
                Card(
                    modifier = Modifier.aspectRatio(1f),
                ) {
                    NetworkImage(
                        url = puppy.thumbUrl,
                        contentDescription = null,
                        modifier = Modifier.aspectRatio(1f)
                    )
                }
                Column(
                    modifier = Modifier.padding(
                        start = 16.dp,
                        top = 16.dp,
                        end = 16.dp,
                        bottom = 8.dp
                    )
                ) {
                    Text(
                        text = puppy.name,
                        style = titleStyle,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,

                        modifier = Modifier
                            .weight(1f)
                            .padding(bottom = 4.dp)
                    )
                    Text(
                        text = stringResource(
                            R.string.puppy_price,
                            puppy.price
                        ),
                        color = MaterialTheme.colors.primary,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier
                            .wrapContentWidth(Alignment.Start)
                    )
                }
            }
        }
    }
}

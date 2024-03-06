package com.example.android.colormyviews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.colormyviews.ui.theme.ColorMyViews

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColorMyViews {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.outline
                ) {
                    RootView()
                }
            }
        }
    }
}

@Composable
fun RootView(modifier: Modifier = Modifier) {
    val listOfColor = listOf(
        Color.DarkGray,
        Color.Gray,
        colorResource(android.R.color.holo_green_light),
        colorResource(android.R.color.holo_green_dark),
        colorResource(android.R.color.holo_green_light)
    )
    val mutableColorList = remember {
        mutableStateListOf<Color>().apply {
            repeat(5) {
                add(Color.Transparent)
            }
        }
    }
    val bgColor = remember {
        mutableStateOf(Color.Transparent)
    }
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(bgColor.value)
            .clickable(
                onClick = {
                    bgColor.value = Color.LightGray
                }
            )
    ) {
        Text(
            text = stringResource(id = R.string.box_one),
            textAlign = TextAlign.Center,
            // set the text color
            color = colorResource(id = android.R.color.white),
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .fillMaxWidth()
                .padding(20.dp)
                .width(IntrinsicSize.Max)
                .background(mutableColorList[0])
                .clickable(
                    onClick = {
                        val index = 0
                        mutableColorList[index] = listOfColor[index]
                    }
                )
        )
        // Box == FrameLayout which is required to make IntrinsicSize.Max work
        Box(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Max)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = modifier
                        .align(alignment = Alignment.CenterVertically)
                        .fillMaxHeight()
                        .padding(
                            start = 16.dp
                        )
                        .weight(1f)
                        .background(mutableColorList[1])
                        .clickable(
                            onClick = {
                                val index = 1
                                mutableColorList[index] = listOfColor[index]
                            }
                        )
                ) {
                    Text(
                        text = stringResource(id = R.string.box_two),
                        // set the text color
                        color = colorResource(id = android.R.color.white),
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(2f)
                        .height(IntrinsicSize.Min)
                ) {
                    Text(
                        text = stringResource(id = R.string.box_three),
                        textAlign = TextAlign.Center,
                        // set the text color
                        color = colorResource(id = android.R.color.white),
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(
                                start = 16.dp,
                                end = 16.dp
                            )
                            .background(mutableColorList[2])
                            .clickable(
                                onClick = {
                                    val index = 2
                                    mutableColorList[index] = listOfColor[index]
                                }
                            )
                    )
                    Text(
                        text = stringResource(id = R.string.box_four),
                        textAlign = TextAlign.Center,
                        // set the text color
                        color = colorResource(id = android.R.color.white),
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(
                                start = 16.dp,
                                top = 8.dp,
                                end = 16.dp
                            )
                            .background(mutableColorList[3])
                            .clickable(
                                onClick = {
                                    val index = 3
                                    mutableColorList[index] = listOfColor[index]
                                }
                            )
                    )

                    Text(
                        text = stringResource(id = R.string.box_five),
                        textAlign = TextAlign.Center,
                        // set the text color
                        color = colorResource(id = android.R.color.white),
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(
                                start = 16.dp,
                                top = 8.dp,
                                end = 16.dp
                            )
                            .background(mutableColorList[4])
                            .clickable(
                                onClick = {
                                    val index = 4
                                    mutableColorList[index] = listOfColor[index]
                                }
                            )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ColorMyViewsPreview() {
    ColorMyViews {
        RootView()
    }
}
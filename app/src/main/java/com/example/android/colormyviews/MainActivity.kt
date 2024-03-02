package com.example.android.colormyviews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
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
                    color = MaterialTheme.colorScheme.background
                ) {
                    RootView()
                }
            }
        }
    }
}

@Composable
fun RootView(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxHeight()
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
                // set the background color to the Max Width size
                .background(colorResource(id = R.color.my_green)),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ColorMyViewsPreview() {
    ColorMyViews {
        RootView()
    }
}
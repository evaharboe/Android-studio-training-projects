package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.runtime.getValue

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Preview
@Composable
fun LemonadeApp() {
    AppContent(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}

@Composable
fun AppContent(modifier: Modifier = Modifier) {
    var step by remember {mutableStateOf(1)}

    val imageResource = when (step) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val stepTitle = when (step) {
        1 -> stringResource((R.string.step1_title))
        2 -> stringResource((R.string.step2_title))
        3 -> stringResource((R.string.step3_title))
        else -> stringResource((R.string.step4_title))
    }
    val stepDescription = when (step) {
        1 -> stringResource((R.string.step1_description))
        2 -> stringResource((R.string.step2_description))
        3 -> stringResource((R.string.step3_description))
        else -> stringResource((R.string.step4_description))
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stepTitle,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(64.dp))

        var count = 0

        Button(onClick = {
            if (step == 4) {
                step = 1
                count = 0
            } else if (step == 2) {
                count++
                when (count) {
                    1 -> step = 2
                    2,3 -> step = (2..3).random()
                    else -> step = 4
                }
            } else {
                    step++
            } }) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = step.toString()
            )
        }

        Spacer(modifier = Modifier.height(64.dp))
        Text(
            text = stepDescription,
            fontSize = 20.sp
        )
    }
}

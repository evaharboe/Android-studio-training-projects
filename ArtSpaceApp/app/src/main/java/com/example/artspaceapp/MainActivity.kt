package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceAppTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    ArtSpaceAppTheme {
        ArtSpaceApp()
    }
}

@Composable
fun ArtSpaceApp( modifier: Modifier = Modifier) {
    var artist by remember { mutableStateOf(0) }

    val imageResources = arrayOf(
        R.drawable.work1,
        R.drawable.work2,
        R.drawable.work3,
        R.drawable.work4
    )

    val workTitle = arrayOf(
        stringResource(R.string.workTitle1),
        stringResource(R.string.workTitle2),
        stringResource(R.string.workTitle3),
        stringResource(R.string.workTitle4),
    )

    val artistName = arrayOf(
        stringResource(R.string.artistName1),
        stringResource(R.string.artistName2),
        stringResource(R.string.artistName3),
        stringResource(R.string.artistName4),
    )

    val releaseYear = arrayOf(
        stringResource(R.string.releaseYear1),
        stringResource(R.string.releaseYear2),
        stringResource(R.string.releaseYear3),
        stringResource(R.string.releaseYear4),
    )

    Column() {
        Image(
            painter = painterResource(imageResources[artist]),
            contentDescription = artist.toString(),
        )
        Spacer(modifier = Modifier.height(32.dp))
        Column {
            Text(
                text = workTitle[artist],
                fontSize = 20.sp,
                fontWeight = FontWeight.W300
            )
            Row {
                Text(
                    text = artistName[artist],
                    fontWeight = FontWeight.W900,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = releaseYear[artist],
                    fontWeight = FontWeight.W200,
                    fontSize = 12.sp
                )
            }
        }
        Row {
            Button(onClick = {
                if (artist > 0) {
                    artist--
                } else {
                    artist = workTitle.size - 1
                }
            }) {
                Text("Previous")
            }
            Button(onClick = {
                if (artist < workTitle.size - 1) {
                    artist++
                } else {
                    artist = 0
                }
            }) {
                Text("Next")
            }
        }
    }
}



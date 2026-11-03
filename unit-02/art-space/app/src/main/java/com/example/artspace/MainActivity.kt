package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) { ArtSpaceApp() }
            }
        }
    }
}

data class Artwork(
    @DrawableRes val image: Int,
    @StringRes val title: Int,
    @StringRes val artist: Int,
    @StringRes val description: Int
)

private val artworks = listOf(
    Artwork(R.drawable.art_sunrise, R.string.sunrise_title, R.string.sunrise_artist, R.string.sunrise_description),
    Artwork(R.drawable.art_geometry, R.string.geometry_title, R.string.geometry_artist, R.string.geometry_description),
    Artwork(R.drawable.art_city, R.string.city_title, R.string.city_artist, R.string.city_description)
)

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    var artworkIndex by rememberSaveable { mutableIntStateOf(0) }
    val artwork = artworks[artworkIndex]

    BoxWithConstraints(modifier.fillMaxSize().safeDrawingPadding().padding(24.dp)) {
        val landscape = maxWidth > maxHeight
        if (landscape) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.spacedBy(32.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ArtworkImage(artwork, Modifier.weight(1f))
                Column(Modifier.weight(1f)) {
                    ArtworkLabel(artwork)
                    Spacer(Modifier.height(24.dp))
                    ArtworkControls(
                        onPrevious = { artworkIndex = (artworkIndex - 1 + artworks.size) % artworks.size },
                        onNext = { artworkIndex = (artworkIndex + 1) % artworks.size }
                    )
                }
            }
        } else {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                ArtworkImage(artwork, Modifier.weight(1f))
                ArtworkLabel(artwork)
                Spacer(Modifier.height(24.dp))
                ArtworkControls(
                    onPrevious = { artworkIndex = (artworkIndex - 1 + artworks.size) % artworks.size },
                    onNext = { artworkIndex = (artworkIndex + 1) % artworks.size }
                )
            }
        }
    }
}

@Composable
private fun ArtworkImage(artwork: Artwork, modifier: Modifier = Modifier) {
    Box(modifier.padding(16.dp), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(artwork.image),
            contentDescription = stringResource(artwork.description),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .shadow(8.dp)
                .background(Color.White)
                .padding(24.dp)
                .sizeIn(maxWidth = 420.dp, maxHeight = 420.dp)
                .aspectRatio(1f)
        )
    }
}

@Composable
private fun ArtworkLabel(artwork: Artwork, modifier: Modifier = Modifier) {
    Column(modifier.fillMaxWidth().background(Color(0xFFECE7E1)).padding(16.dp)) {
        Text(stringResource(artwork.title), style = MaterialTheme.typography.headlineSmall)
        Text(stringResource(artwork.artist), fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun ArtworkControls(
    onPrevious: () -> Unit,
    onNext: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        Button(onClick = onPrevious, modifier = Modifier.weight(1f)) {
            Text(stringResource(R.string.previous))
        }
        Button(onClick = onNext, modifier = Modifier.weight(1f)) {
            Text(stringResource(R.string.next))
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun ArtSpacePreview() {
    MaterialTheme { ArtSpaceApp() }
}

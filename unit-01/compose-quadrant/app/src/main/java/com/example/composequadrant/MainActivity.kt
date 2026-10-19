package com.example.composequadrant

 import android.os.Bundle
 import androidx.activity.ComponentActivity
 import androidx.activity.compose.setContent
 import androidx.activity.enableEdgeToEdge
 import androidx.compose.foundation.Image
 import androidx.compose.foundation.background
 import androidx.compose.foundation.layout.*
 import androidx.compose.foundation.rememberScrollState
 import androidx.compose.foundation.verticalScroll
 import androidx.compose.material.icons.Icons
 import androidx.compose.material.icons.filled.Email
 import androidx.compose.material.icons.filled.Phone
 import androidx.compose.material.icons.filled.Share
 import androidx.compose.material3.*
 import androidx.compose.runtime.Composable
 import androidx.compose.ui.Alignment
 import androidx.compose.ui.Modifier
 import androidx.compose.ui.graphics.Color
 import androidx.compose.ui.graphics.vector.ImageVector
 import androidx.compose.ui.layout.ContentScale
 import androidx.compose.ui.res.painterResource
 import androidx.compose.ui.res.stringResource
 import androidx.compose.ui.text.font.FontWeight
 import androidx.compose.ui.text.style.TextAlign
 import androidx.compose.ui.tooling.preview.Preview
 import androidx.compose.ui.unit.dp
 import androidx.compose.ui.unit.sp

 class MainActivity : ComponentActivity() {
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         enableEdgeToEdge()
         setContent {
             LabTheme {
                 Surface(modifier = Modifier.fillMaxSize()) {
                     Box(Modifier.fillMaxSize().safeDrawingPadding()) { App() }
                 }
             }
         }
     }
 }

 @Composable
 fun LabTheme(content: @Composable () -> Unit) {
     MaterialTheme(
         colorScheme = lightColorScheme(background = Color.White, surface = Color.White,
             onBackground = Color.Black, onSurface = Color.Black),
         content = content
     )
 }

 @Composable
fun App(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize()) {
        Row(Modifier.weight(1f)) {
            Quadrant(stringResource(R.string.text_title), stringResource(R.string.text_body),
                Color(0xFFEADDFF), Modifier.weight(1f))
            Quadrant(stringResource(R.string.image_title), stringResource(R.string.image_body),
                Color(0xFFD0BCFF), Modifier.weight(1f))
        }
        Row(Modifier.weight(1f)) {
            Quadrant(stringResource(R.string.row_title), stringResource(R.string.row_body),
                Color(0xFFB69DF8), Modifier.weight(1f))
            Quadrant(stringResource(R.string.column_title), stringResource(R.string.column_body),
                Color(0xFFF6EDFF), Modifier.weight(1f))
        }
    }
}

@Composable
fun Quadrant(title: String, description: String, color: Color, modifier: Modifier = Modifier) {
    Column(modifier.fillMaxHeight().background(color).padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(title, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp))
        Text(description, textAlign = TextAlign.Justify)
    }
}

 @Preview(showBackground = true, widthDp = 360, heightDp = 640)
 @Composable
 fun AppPreview() {
     LabTheme { App() }
 }

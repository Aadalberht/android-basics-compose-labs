package com.example.taskmanager

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
    Column(modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painterResource(R.drawable.ic_task_completed), contentDescription = null)
        Text(stringResource(R.string.completed), fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp))
        Text(stringResource(R.string.praise), fontSize = 16.sp)
    }
}

 @Preview(showBackground = true, widthDp = 360, heightDp = 640)
 @Composable
 fun AppPreview() {
     LabTheme { App() }
 }

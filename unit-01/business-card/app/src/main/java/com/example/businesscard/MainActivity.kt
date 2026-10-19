package com.example.businesscard

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
    Column(modifier.fillMaxSize().background(Color(0xFFD2E8D4)).padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.weight(1f))
        Profile()
        Spacer(Modifier.weight(1f))
        Contacts()
        Spacer(Modifier.height(24.dp))
    }
}

@Composable
fun Profile(modifier: Modifier = Modifier) {
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painterResource(R.drawable.android_logo),
            contentDescription = stringResource(R.string.logo_description),
            modifier = Modifier.size(112.dp).background(Color(0xFF073042)))
        Text(stringResource(R.string.full_name), fontSize = 40.sp,
            textAlign = TextAlign.Center, modifier = Modifier.padding(top = 16.dp))
        Text(stringResource(R.string.job_title), color = Color(0xFF006B3C),
            fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 8.dp))
    }
}

@Composable
fun Contacts(modifier: Modifier = Modifier) {
    Column(modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
        ContactRow(Icons.Default.Phone, stringResource(R.string.phone))
        ContactRow(Icons.Default.Share, stringResource(R.string.social))
        ContactRow(Icons.Default.Email, stringResource(R.string.email))
    }
}

@Composable
fun ContactRow(icon: ImageVector, text: String, modifier: Modifier = Modifier) {
    Row(modifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(icon, contentDescription = null, tint = Color(0xFF006B3C),
            modifier = Modifier.size(24.dp))
        Spacer(Modifier.width(24.dp))
        Text(text)
    }
}

 @Preview(showBackground = true, widthDp = 360, heightDp = 640)
 @Composable
 fun AppPreview() {
     LabTheme { App() }
 }

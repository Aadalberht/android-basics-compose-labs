package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) { LemonApp() }
            }
        }
    }
}

@Composable
fun LemonApp(modifier: Modifier = Modifier) {
    var currentStep by rememberSaveable { mutableIntStateOf(1) }
    var squeezeCount by rememberSaveable { mutableIntStateOf(0) }
    var squeezeTarget by rememberSaveable { mutableIntStateOf(2) }

    @DrawableRes val imageResource: Int
    @StringRes val instructionResource: Int
    @StringRes val descriptionResource: Int

    when (currentStep) {
        1 -> {
            imageResource = R.drawable.lemon_tree
            instructionResource = R.string.select_lemon
            descriptionResource = R.string.lemon_tree_description
        }
        2 -> {
            imageResource = R.drawable.lemon_squeeze
            instructionResource = R.string.squeeze_lemon
            descriptionResource = R.string.lemon_description
        }
        3 -> {
            imageResource = R.drawable.lemon_drink
            instructionResource = R.string.drink_lemonade
            descriptionResource = R.string.lemonade_description
        }
        else -> {
            imageResource = R.drawable.lemon_restart
            instructionResource = R.string.restart
            descriptionResource = R.string.empty_glass_description
        }
    }

    Column(
        modifier = modifier.fillMaxSize().safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = stringResource(instructionResource), fontSize = 18.sp)
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = {
                when (currentStep) {
                    1 -> {
                        currentStep = 2
                        squeezeCount = 0
                        squeezeTarget = (2..4).random()
                    }
                    2 -> {
                        squeezeCount++
                        if (squeezeCount >= squeezeTarget) currentStep = 3
                    }
                    3 -> currentStep = 4
                    else -> currentStep = 1
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC3ECD2))
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = stringResource(descriptionResource),
                modifier = Modifier.size(200.dp)
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun LemonadePreview() {
    MaterialTheme { LemonApp() }
}

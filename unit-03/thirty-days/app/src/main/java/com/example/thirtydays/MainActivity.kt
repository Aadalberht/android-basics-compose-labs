package com.example.thirtydays

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class FocusTip(val day: Int, val title: String, val details: String)

private val focusTips = listOf(
    "Clear one surface" to "Choose one desk or table and remove everything that does not help today's work.",
    "Write three priorities" to "Limit the day to three meaningful outcomes and start with the hardest one.",
    "Use a 25-minute timer" to "Work on one task until the timer rings, then take a five-minute break.",
    "Silence notifications" to "Enable focus mode and check messages only at planned times.",
    "Prepare tomorrow tonight" to "Leave your first task, files, and tools ready before you finish the day.",
    "Start with two minutes" to "Make the first action so small that beginning feels effortless.",
    "Keep one capture list" to "Put every stray thought in one trusted list instead of holding it in memory.",
    "Close unused tabs" to "Keep only the tabs required for the task currently in front of you.",
    "Define done" to "Write one sentence describing what a finished result looks like before you start.",
    "Take a walking break" to "Walk for ten minutes without your phone and let your attention reset.",
    "Batch small tasks" to "Group quick messages and administrative work into one short session.",
    "Protect the first hour" to "Spend the beginning of your workday creating before consuming information.",
    "Use full-screen mode" to "Hide sidebars and unrelated windows while doing concentrated work.",
    "Drink water" to "Keep water nearby and use breaks as a reminder to drink.",
    "Say no to one task" to "Remove or postpone one low-value commitment that competes with your priorities.",
    "Review your progress" to "At midday, compare your actions with the three priorities you selected.",
    "Create a shutdown ritual" to "Record unfinished work, choose the next action, and deliberately end the workday.",
    "Read on paper" to "Print or write down complex material when screens make concentration difficult.",
    "Use headphones wisely" to "Choose silence or steady instrumental sound without lyrics for deep work.",
    "Move the phone away" to "Place your phone outside arm's reach during a focus session.",
    "Schedule thinking time" to "Reserve a quiet block for planning and difficult decisions without meetings.",
    "Break work into verbs" to "Replace vague projects with actions such as draft, compare, test, or send.",
    "Finish before switching" to "Complete a natural checkpoint before moving to another task.",
    "Keep the workspace ready" to "Return tools and files to their places after every session.",
    "Use a distraction note" to "Write distractions down and return to them after the timer ends.",
    "Check your energy" to "Match demanding work to the time of day when you feel most alert.",
    "Make meetings specific" to "Require a clear outcome and agenda before accepting a meeting.",
    "Celebrate a small win" to "Write down one useful result you completed today.",
    "Review the month" to "Identify which focus habit helped most and which one needs adjustment.",
    "Choose one habit" to "Continue the single practice that produced the clearest improvement.",
).mapIndexed { index, pair -> FocusTip(index + 1, pair.first, pair.second) }

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { ThirtyDaysTheme { ThirtyDaysApp() } }
    }
}

@Composable
fun ThirtyDaysTheme(content: @Composable () -> Unit) {
    val colors = if (isSystemInDarkTheme()) {
        darkColorScheme(primary = Color(0xFF8FD8C0), secondary = Color(0xFFFFB77A))
    } else {
        lightColorScheme(
            primary = Color(0xFF356859),
            secondary = Color(0xFF9A4F19),
            background = Color(0xFFFFF8F2),
            surface = Color(0xFFFFF8F2),
        )
    }
    MaterialTheme(colorScheme = colors, content = content)
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ThirtyDaysApp() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("30 Days of Focus", fontWeight = FontWeight.Bold) }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = padding
        ) {
            items(focusTips, key = { it.day }) { tip -> FocusTipCard(tip) }
        }
    }
}

@Composable
fun FocusTipCard(tip: FocusTip, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .animateContentSize(),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column {
            Text(
                text = "Day ${tip.day}",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
            )
            Text(
                text = tip.title,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
            Image(
                painter = painterResource(R.drawable.focus_landscape),
                contentDescription = stringResource(R.string.illustration_description),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth().height(150.dp)
            )
            IconButton(
                onClick = { expanded = !expanded },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.ExpandMore,
                    contentDescription = stringResource(
                        if (expanded) R.string.collapse_tip else R.string.expand_tip
                    )
                )
            }
            AnimatedVisibility(expanded) {
                Text(
                    text = tip.details,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ThirtyDaysPreview() {
    ThirtyDaysTheme { FocusTipCard(focusTips.first()) }
}

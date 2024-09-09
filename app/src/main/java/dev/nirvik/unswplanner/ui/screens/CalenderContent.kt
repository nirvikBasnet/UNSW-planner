package dev.nirvik.unswplanner.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.nirvik.unswplanner.models.Calendar
import dev.nirvik.unswplanner.models.Day
import dev.nirvik.unswplanner.ui.components.WeekItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarContent(calendar: Calendar, modifier: Modifier,onClicked: (day:Day)->Unit) {
            LazyColumn(modifier = modifier) {
                items(calendar.calendar) { week ->
                    WeekItem(week){
                        onClicked(it)
                    }
                }
            }
}

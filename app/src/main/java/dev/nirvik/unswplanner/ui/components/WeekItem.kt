package dev.nirvik.unswplanner.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import dev.nirvik.unswplanner.models.Day
import dev.nirvik.unswplanner.models.Week

@Composable
fun WeekItem(week: Week, onClicked : (day:Day)->Unit) {
    Column(modifier = Modifier.padding(vertical = 8.dp).fillMaxWidth().clickable {

    },
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Week ${week.week}",style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold)
        )
        week.days.forEach { day ->
            DayItem(day){
                onClicked(it)
            }
        }


    }
}


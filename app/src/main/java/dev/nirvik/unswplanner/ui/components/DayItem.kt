package dev.nirvik.unswplanner.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import dev.nirvik.unswplanner.utils.monthNameFromIndex

@Composable
fun DayItem(day: Day, onClicked : (day: Day) -> Unit) {
    Card (modifier = Modifier.padding(2.dp).height(80.dp).background(
        Color.Transparent
    ).clickable {
       onClicked(day)
    }, elevation = CardDefaults.cardElevation(
        defaultElevation = 4.dp
    )) {
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Row (modifier = Modifier.fillMaxSize().padding(start = 5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column (modifier = Modifier.fillMaxSize().weight(0.5f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center) {
                    Text(text = day.day.toString(), style = TextStyle(
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    )
                    Text(monthNameFromIndex(day.month))
                }
                Column(modifier = Modifier.fillMaxSize().weight(1.5f).padding(2.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Top) {
                        Text(text = day.event,style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold)
                        )
                    }
                    Column(modifier = Modifier.fillMaxWidth().padding(end = 5.dp),
                        horizontalAlignment = Alignment.End,
                        verticalArrangement = Arrangement.Bottom) {
                        Text(text = day.weekday.substring(0,3))
                    }
                }


            }
        }


    }
}


package dev.nirvik.unswplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import dev.nirvik.unswplanner.models.Calendar
import dev.nirvik.unswplanner.models.Day
import dev.nirvik.unswplanner.models.Week
import dev.nirvik.unswplanner.ui.theme.UNSWPlannerTheme
import dev.nirvik.unswplanner.ui.screens.CalendarContent
import dev.nirvik.unswplanner.utils.loadJsonFromRaw
import dev.nirvik.unswplanner.utils.monthNameFromIndex
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val calendarData = remember { mutableStateOf<Calendar?>(null) }
            var showDialog by remember { mutableStateOf(false) }
            var clickedDay = remember { mutableStateOf<Day?> (null)}
            var event by remember { mutableStateOf("") }

            val json = Json {
                ignoreUnknownKeys = true
            }
            LaunchedEffect(Unit) {
                val jsonString = loadJsonFromRaw(this@MainActivity, R.raw.calendar)
                calendarData.value = json.decodeFromString(jsonString)
            }
            UNSWPlannerTheme {
                Scaffold(
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = {
                                calendarData.value?.let {
                                    Text(
                                        it.term, style = TextStyle(
                                            fontSize = 25.sp,
                                            fontWeight = FontWeight.Bold
                                        ))
                                }
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = Color.Yellow
                            )
                        )
                    }
                ) { scaffoldPadding ->
                    calendarData.value?.let { calendar ->
                        CalendarContent(calendar, modifier = Modifier.padding(scaffoldPadding)){
                          showDialog = true
                            clickedDay.value = it
                        }
                    }
                    if (showDialog){
                      BasicAlertDialog(
                          modifier = Modifier.padding(10.dp),
                          onDismissRequest = {showDialog = !showDialog},
                          properties = DialogProperties(
                              usePlatformDefaultWidth = false
                          )
                      ){
                          Surface(
                              shape = MaterialTheme.shapes.large,
                              tonalElevation = AlertDialogDefaults.TonalElevation
                          ) {
                              Column(modifier = Modifier.padding(16.dp)) {
                                  Text(
                                      text =
                                      " ${clickedDay.value?.day} ${clickedDay.value?.month?.let {
                                          convertToMonth(
                                              it
                                          )
                                      }}"
                                  )
                                  Spacer(modifier = Modifier.height(24.dp))
                                  OutlinedTextField(
                                      value = event,
                                      onValueChange ={
                                          event = it
                                      },
                                      label = {
                                          Text("Add Event")
                                      }
                                  )
                                  Spacer(modifier = Modifier.height(24.dp))
                                  TextButton(
                                      onClick = { showDialog = false },
                                      modifier = Modifier.align(Alignment.End)
                                  ) {
                                      Text("Confirm")
                                  }
                              }
                          }
                      }
                    }

                }
            }
        }
    }

}

fun convertToMonth(monthIndex: Int):String{
    val months = mapOf(
        1 to "Jan",
        2 to "Feb",
        3 to "Mar",
        4 to "Apr",
        5 to "May",
        6 to "Jun",
        7 to "Jul",
        8 to "Aug",
        9 to "Sep",
        10 to "Oct",
        11 to "Nov",
        12 to "Dec"
    )
    return months[monthIndex]!!
}



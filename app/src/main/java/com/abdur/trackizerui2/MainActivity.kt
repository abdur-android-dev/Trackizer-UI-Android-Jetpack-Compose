package com.abdur.trackizerui2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdur.trackizerui2.ui.screen.BottomMenu
import com.abdur.trackizerui2.ui.screen.TopScreen
import com.abdur.trackizerui2.ui.theme.Background1
import com.abdur.trackizerui2.ui.theme.TopBackground
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Preview
@Composable
fun MyApp() {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = TopBackground
        )
    }

    val scaffoldState  = rememberScaffoldState()
    Scaffold(bottomBar = {
        BottomMenu()
    }, backgroundColor = Background1,
        floatingActionButton = {
           FloatingActionButton(
               onClick = {  },
               contentColor = Color.White,
               backgroundColor = Color(android.graphics.Color.parseColor("#FF7966"))
           ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = null, modifier = Modifier.size(30.dp) )
           }
        },
        scaffoldState = scaffoldState,
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
    content = {padding ->
        Column(Modifier
            .padding(padding)
            .fillMaxSize()
        ) {
            TopScreen()
        }
    }
    )
}
package com.abdur.trackizerui2.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.abdur.trackizerui2.ui.theme.AvenirBlack
import com.abdur.trackizerui2.ui.theme.CalenderText
import com.abdur.trackizerui2.ui.theme.Popines_Medium

@Composable
fun RowText(topText:String,bottomText:String){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = topText,
            color = Color.White,
            fontSize = 24.sp,
            fontFamily = AvenirBlack,
            )
        Text(text = bottomText,
            color = CalenderText,
            fontSize = 14.sp,
            fontFamily = Popines_Medium,
        )
    }
}
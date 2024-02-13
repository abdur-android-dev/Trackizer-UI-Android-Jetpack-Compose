package com.abdur.trackizerui2.ui.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdur.trackizerui2.R
import com.abdur.trackizerui2.ui.theme.AvenirBlack
import com.abdur.trackizerui2.ui.theme.AvenirBook
import com.abdur.trackizerui2.ui.theme.ButtonBorder
import com.abdur.trackizerui2.ui.theme.ButtonColor
import com.abdur.trackizerui2.ui.theme.CalenderButtonBorderColor
import com.abdur.trackizerui2.ui.theme.CalenderTextColor
import com.abdur.trackizerui2.ui.theme.DotColor
import com.abdur.trackizerui2.ui.theme.Popines_Medium
import com.abdur.trackizerui2.ui.theme.SelectedColor
import com.abdur.trackizerui2.ui.theme.UnselectedColor

@Composable
fun CalenderButton(date:String, day:String, selected:Boolean){
    Button(
        onClick = {},
        colors= ButtonDefaults
            .buttonColors(
                backgroundColor = if(selected) SelectedColor else UnselectedColor,
                contentColor = Color.White),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .padding(end = 10.dp)
            .fillMaxWidth(0.65f)
            .fillMaxHeight(0.35f)
            .border(
                width = 1.dp,
                brush = Brush.horizontalGradient(listOf(CalenderButtonBorderColor, ButtonColor)),
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = date,
                fontFamily = AvenirBlack,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Text(
                text = day,
                fontFamily = Popines_Medium,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = CalenderTextColor,
                modifier = Modifier
                    .padding(top = 4.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.orangedot),
                contentDescription = null,
                tint = if(selected) DotColor else Color.Transparent,
                modifier = Modifier
                    .padding(top = 10.dp)
            )
        }
    }
}
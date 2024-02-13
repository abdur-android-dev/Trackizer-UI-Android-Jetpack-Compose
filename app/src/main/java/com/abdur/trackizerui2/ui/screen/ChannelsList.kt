package com.abdur.trackizerui2.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdur.trackizerui2.ui.theme.AvenirBlack
import com.abdur.trackizerui2.ui.theme.BoxColor
import com.abdur.trackizerui2.ui.theme.ButtonColor
import com.abdur.trackizerui2.ui.theme.CalenderButtonBorderColor

@Composable
fun ChannelDetail(topText:String, bottomText:String, resId:Int){
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(0.8f)
            .clip(RoundedCornerShape(20.dp))
            .border(
                width = 1.dp,
                brush = Brush.horizontalGradient(listOf(CalenderButtonBorderColor, ButtonColor)),
                shape = RoundedCornerShape(20.dp)
            )
            .background(BoxColor)
    ){
        Image(
                painter = painterResource(id = resId),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(start = 20.dp, top = 20.dp)
            )
            Column(
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier.fillMaxHeight()
                    .padding(start = 20.dp, bottom = 20.dp)
            ) {
                Text(
                    text = topText,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,

                )
                Text(
                    text = bottomText,
                    color = Color.White,
                    fontFamily = AvenirBlack,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(top = 5.dp)
                )
            }
        }
    }
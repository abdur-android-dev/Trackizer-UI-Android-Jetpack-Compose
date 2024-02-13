package com.abdur.trackizerui2.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
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
import androidx.constraintlayout.compose.ConstraintLayout
import com.abdur.trackizerui2.R
import com.abdur.trackizerui2.ui.screen.size.getScreenSize
import com.abdur.trackizerui2.ui.theme.AvenirBlack
import com.abdur.trackizerui2.ui.theme.AvenirBook
import com.abdur.trackizerui2.ui.theme.Background1
import com.abdur.trackizerui2.ui.theme.ButtonBorder
import com.abdur.trackizerui2.ui.theme.ButtonColor
import com.abdur.trackizerui2.ui.theme.CalenderText
import com.abdur.trackizerui2.ui.theme.Popines_Medium
import com.abdur.trackizerui2.ui.theme.TopBackground

@Preview
@Composable
fun TopScreen(){
    val screenSize = getScreenSize()
    //val screenWidth = screenSize.first
    val screenHeight = screenSize.second
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                color = Background1
            )) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(if (screenHeight > 670) 0.5f else 0.6f)
                .background(
                    color = TopBackground,
                    shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp)
                )
        )
        {

            val (headText,
                calenderText,
                ic_setting,
                subscriptionsText,
                btnJan,
                calenderDays,
            ) = createRefs()
            Text(text = "Calendar",
                fontSize = 24.sp,
                color = CalenderText,
                fontFamily = Popines_Medium,
                modifier = Modifier.constrainAs(calenderText) {
                    bottom.linkTo(headText.top)
                    linkTo(parent.start, parent.end, bias = 0.5f)
                    linkTo(parent.top, parent.bottom, bias = 0.05f)
                }
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_setting),
                contentDescription = null,
                tint = CalenderText,
                modifier = Modifier
                    .size(30.dp)
                    .clickable { }
                    .constrainAs(ic_setting) {
                        start.linkTo(calenderText.end)
                        linkTo(parent.top, parent.bottom, bias = 0.055f)
                        linkTo(parent.start, parent.end, bias = 0.9f)
                    }
            )

            Text(
                text = "Subs\n" + "Schedule",
                fontFamily = AvenirBlack,
                fontSize = 45.sp,
                color = Color.White,
                modifier = Modifier.constrainAs(headText) {
                    linkTo(parent.start, parent.end, bias = 0.1f)
                    linkTo(parent.top, parent.bottom, bias = 0.15f)
                }
            )

            Text(
                text = "3 subscriptions for today",
                fontFamily = AvenirBlack,
                fontSize = 16.sp,
                color = CalenderText,
                modifier = Modifier.constrainAs(subscriptionsText) {
                    linkTo(parent.start, parent.end, bias = 0.1f)
                    linkTo(parent.top, parent.bottom, bias = 0.02f)
                    top.linkTo(headText.bottom)
                }
            )
            Button(
                onClick = {},
                colors = ButtonDefaults
                    .buttonColors(
                        backgroundColor = ButtonColor,
                        contentColor = Color.White
                    ),
                shape = CircleShape,
                modifier = Modifier
                    .border(
                        width = 3.dp,
                        brush = Brush.horizontalGradient(listOf(ButtonBorder, ButtonColor)),
                        shape = CircleShape
                    )
                    .constrainAs(btnJan) {
                        linkTo(parent.start, parent.end, bias = 0.5f)
                        linkTo(parent.top, parent.bottom, bias = 0.00f)
                        start.linkTo(subscriptionsText.end)
                        top.linkTo(headText.bottom)
                    }
            ) {
                Text(
                    text = "January",
                    fontFamily = AvenirBook,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_dow_arrow),
                    contentDescription = null,
                    tint = Color.White
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    //.fillMaxHeight(0.25f)
                    .constrainAs(calenderDays) {
                        top.linkTo(btnJan.bottom)
                        bottom.linkTo(parent.bottom)
                        linkTo(parent.start, parent.end)
                    }
            ) {
                CalenderButton(date = "08", day = "Mo", selected = true)
                CalenderButton(date = "09", day = "Tu", selected = false)
                CalenderButton(date = "10", day = "We", selected = false)
                CalenderButton(date = "11", day = "Th", selected = false)
                CalenderButton(date = "12", day = "Fr", selected = false)
                CalenderButton(date = "13", day = "Sa", selected = false)
                CalenderButton(date = "14", day = "Su", selected = false)
            }
        }

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        )
        {
            Row (
                horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp, top = 20.dp)

            ){
                RowText(topText = "January", bottomText = "01.08.2024")
                RowText(topText = "\$24.98", bottomText = "in upcoming bills")
            }
        }

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
                modifier = Modifier.fillMaxHeight()
            ){
                item {
                    ChannelDetail(topText = "Spotify", bottomText = "$5.99", resId = R.drawable.ic_spotify)
                }
                item {
                    ChannelDetail(topText = "Youtube", bottomText = "$18.99", resId = R.drawable.ic_youtube)
                }
                item {
                    ChannelDetail(topText = "Cloud", bottomText = "$11.99", resId = R.drawable.ic_cloud)
                }
            }
        }
    }
}
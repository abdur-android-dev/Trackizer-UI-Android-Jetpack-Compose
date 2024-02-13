package com.abdur.trackizerui2.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.abdur.trackizerui2.R
import com.abdur.trackizerui2.data.BottomMenuItem
import com.abdur.trackizerui2.ui.theme.Background1
import com.abdur.trackizerui2.ui.theme.BottomActive
import com.abdur.trackizerui2.ui.theme.BottomNonActive

@Composable
fun prepareBottomMenu():List<BottomMenuItem>{
    val bottomMenuItemList = arrayListOf<BottomMenuItem>()
    bottomMenuItemList.add(BottomMenuItem(lable = "Home", icon = painterResource(id = R.drawable.home)))
    bottomMenuItemList.add(BottomMenuItem(lable = "More", icon = painterResource(id = R.drawable.more)))
    bottomMenuItemList.add(BottomMenuItem(lable = "Calendar", icon = painterResource(id = R.drawable.calendar)))
    bottomMenuItemList.add(BottomMenuItem(lable = "Layer", icon = painterResource(id = R.drawable.layermore)))
    return bottomMenuItemList
}

@Composable
fun BottomMenu(){
    val bottomMenuItem = prepareBottomMenu()
    var selectedItem by remember {
        mutableIntStateOf(0)
    }
    BottomAppBar(
        cutoutShape = CircleShape,
        backgroundColor = Background1,
    content = {
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp)
            //.border(shape = RoundedCornerShape(20.dp),width = 2.dp,color = Color(android.graphics.Color.parseColor("#22222B")))
            .background(brush = Brush.verticalGradient(
                colors = listOf(
                    Color(android.graphics.Color.parseColor("#414152")),
                    Color(android.graphics.Color.parseColor("#414152"))
                )
            ), shape = RoundedCornerShape(20.dp))

        ){
            Row {
                bottomMenuItem.forEachIndexed{index, bottomMenuItem ->
                    if(index==2){
                        BottomNavigationItem(
                            selected = false
                            , onClick = {  },
                            icon = {},
                            enabled = false)
                    }
                    BottomNavigationItem(
                        selected = (selectedItem==index),
                        onClick = { selectedItem=index },
                        icon = {
                            Icon(
                                painter = bottomMenuItem.icon,
                                contentDescription = bottomMenuItem.lable,
                                tint = if (selectedItem==index) BottomActive else BottomNonActive
                            )}
                    )
                }
            }
        }
    })
}
package com.team.agestar_android.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.semicolon.design.Body1
import com.semicolon.design.Body2
import com.semicolon.design.color.primary.gray.gray800
import com.team.agestar_android.R

@Composable
fun Header(
    painter: Painter? = null,
    title: String,
    painter2: Painter? = null,
    backgroundColor: Color = Color.Unspecified,
    onIconClick: () -> Unit = {},
) {
    Box(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
            .background(backgroundColor),
        contentAlignment = Alignment.Center,
    ) {
        Body1(text = title, fontWeight = FontWeight.Bold)
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 15.88.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(Modifier.size(16.dp))
            painter?.let {
                Image(
                    modifier = Modifier
                        .clickable(
                            interactionSource = MutableInteractionSource(),
                            indication = null,
                            enabled = true
                        ) { onIconClick() },
                    painter = it,
                    contentDescription = null
                )
            }
            Spacer(Modifier.size(width = 330.dp, height =0.dp ))
            painter2?.let {
                Image(
                    modifier = Modifier
                        .size(30.dp)
                        .clickable(
                            interactionSource = MutableInteractionSource(),
                            indication = null,
                            enabled = true
                        ) {},
                    painter = it,
                    contentDescription = null)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ShowHeader() {
    Header(
        painter = painterResource(id = R.drawable.ic_goback),
        title = "일정 수정",
        painter2 = painterResource(id = R.drawable.ic_edit_profile)
    )
}
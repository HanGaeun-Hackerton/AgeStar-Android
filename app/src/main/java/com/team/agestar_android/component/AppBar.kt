package com.team.agestar_android.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.semicolon.design.Subtitle4

@Composable
fun AppBar(
    painter: Painter? = null,
    text: String,
    backgroundColor: Color = Color.Unspecified,
    onIconClick: () -> Unit = {},
) {
    Row(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
            .background(backgroundColor),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(Modifier.size(16.dp))
        painter?.let {
            Image(
                modifier = Modifier
                    .size(24.dp)
                    .clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null,
                        enabled = true
                    ) { onIconClick() },
                painter = it,
                contentDescription = null
            )
            Spacer(Modifier.size(12.dp))
        }
        Subtitle4(
            text = text,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun CenterAppBar(
    painter: Painter? = null,
    text: String,
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
        Body1(text = text, fontWeight = FontWeight.Bold)
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
        }
    }
}

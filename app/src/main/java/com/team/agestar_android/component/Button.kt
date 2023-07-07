package com.team.agestar_android.component

import android.widget.Button
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.semicolon.design.Button
import com.semicolon.design.button.BasicButton
import com.semicolon.design.button.BasicLargeButton
import com.semicolon.design.color.primary.gray.gray100
import com.semicolon.design.color.primary.gray.gray300
import com.semicolon.design.color.primary.gray.gray50
import com.semicolon.design.color.primary.gray.gray700
import com.semicolon.design.color.primary.purple.purple400
import com.semicolon.design.color.primary.purple.purple50
import com.semicolon.design.color.primary.purple.purple500
import com.semicolon.design.color.primary.white.white
import com.team.agestar_android.ui.theme.Purple40
import com.team.agestar_android.ui.theme.main

@Composable
fun Button(
    modifier: Modifier = Modifier,
    text: String,
    isEnabled: Boolean = true,
    onClick: () -> Unit
) {
    BasicLargeButton(
        text = text,
        defaultColor = main,
        pressedColor = main,
        disabledColor = main,
        defaultTextColor = white,
        disabledTextColor = white,
        isEnabled = isEnabled,
        modifier = modifier,
        onClick = onClick
    )
}
@Composable
fun PrimaryModalButton(
    modifier: Modifier = Modifier,
    text: String,
    isEnabled: Boolean = true,
    onClick: () -> Unit,
) {
    BasicButton(
        defaultColor = main,
        pressedColor = main,
        disabledColor = main,
        isEnabled = isEnabled,
        modifier = modifier
            .height(52.dp)
            .clip(RoundedCornerShape(8.dp)),
        onClick = onClick
    ) {
        Button(text = text, color = white)
    }
}

@Composable
fun DefaultModalButton(
    modifier: Modifier = Modifier,
    text: String,
    isEnabled: Boolean = true,
    onClick: () -> Unit,
) {
    val textColor = if (isEnabled) gray700 else gray300
    BasicButton(
        defaultColor = main,
        pressedColor = main,
        disabledColor = main,
        isEnabled = isEnabled,
        modifier = modifier
            .height(52.dp)
            .clip(RoundedCornerShape(8.dp)),
        onClick = onClick
    ) {
        Button(text = text, color = textColor)
    }
}
package com.team.agestar_android.feature

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.semicolon.design.color.primary.white.white
import com.team.agestar_android.R
import com.team.agestar_android.component.AppBar
import com.team.agestar_android.component.CenterAppBar
import com.team.agestar_android.ui.theme.DevicePaddings

@Composable
fun BenefitScreen(navController: NavController) {

    Benefit(
        onBackClick = {navController.popBackStack()}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Benefit(
    onBackClick: () -> Unit
) {
    Scaffold(
        modifier = Modifier
            .background(white)
            .padding(
                top = DevicePaddings.statusBarHeightDp.dp,
                bottom = DevicePaddings.navigationBarHeightDp.dp
            ),
        topBar = {
            CenterAppBar(
                painter = painterResource(id = R.drawable.ic_goback),
                text = "혜택",
                onIconClick = onBackClick
            )
        },
    ){
        Column(Modifier.padding(top = 60.dp + it.calculateTopPadding())) {
            
        }
    }
}
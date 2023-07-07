package com.team.agestar_android.feature

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.team.agestar_android.R
import com.team.agestar_android.navigation.AppNavigationItem
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(Unit) {
        delay(500) // 2초 동안 지연
        navController.navigate(AppNavigationItem.Login.route)
    }
    Splash()
}

@Composable
private fun Splash(){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_appl_logo),
            contentDescription = null,
            modifier = Modifier.size(240.dp),
            tint = Color.Unspecified
        )
    }
}
package com.team.agestar_android

import android.content.Context
import android.content.ContextWrapper
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.semicolon.design.color.primary.gray.gray50
import com.semicolon.design.color.primary.purple.purple200
import com.semicolon.design.color.primary.white.white
import com.team.agestar_android.feature.BenefitScreen
import com.team.agestar_android.feature.ChangePassword
import com.team.agestar_android.feature.ChangePasswordScreen
import com.team.agestar_android.feature.LoginScreen
import com.team.agestar_android.feature.ProfileScreen
import com.team.agestar_android.feature.Register
import com.team.agestar_android.feature.RegisterScreen
import com.team.agestar_android.feature.SplashScreen
import com.team.agestar_android.navigation.AppNavigationItem
import com.team.agestar_android.ui.theme.DevicePaddings
import com.team.agestar_android.ui.theme.getNavigationBarHeightDp
import com.team.agestar_android.ui.theme.getStatusBarHeightDp
import com.team.agestar_android.ui.theme.main
import com.team.agestar_android.ui.theme.setStatusBarTransparent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setStatusBarTransparent()
        DevicePaddings.statusBarHeightDp = getStatusBarHeightDp()
        DevicePaddings.navigationBarHeightDp = getNavigationBarHeightDp()
        super.onCreate(savedInstanceState)
        setContent{
            BaseApp()
        }
    }
}

@Composable
fun BaseApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppNavigationItem.Login.route){
        composable(AppNavigationItem.Login.route){
            LoginScreen(navController)
        }
        composable(AppNavigationItem.Register.route){
            RegisterScreen(navController)
        }
        composable(AppNavigationItem.Profile.route){
            ProfileScreen(navController)
        }
        composable(AppNavigationItem.Main.route){
            MainScreen(navController)
        }
        composable(AppNavigationItem.Benefit.route){
            BenefitScreen(navController)
        }
        composable(AppNavigationItem.Setting.route){
            ChangePasswordScreen(navController)
        }
    }
}

@Composable
fun MainScreen(navController: NavController){
    Main(onProfileClick = { /*TODO*/ }) {

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main(
    onProfileClick: () -> Unit,
    onBenefitClick: () -> Unit
) {
    Scaffold(
        modifier = Modifier
            .background(white)
            .padding(
                top = DevicePaddings.statusBarHeightDp.dp,
                bottom = DevicePaddings.navigationBarHeightDp.dp
            ),
        topBar = {

        }
}


fun Context.getActivity(): ComponentActivity? = when (this) {
    is ComponentActivity -> this
    is ContextWrapper -> baseContext.getActivity()
    else -> null
}
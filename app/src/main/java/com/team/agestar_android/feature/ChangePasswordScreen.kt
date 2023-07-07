package com.team.agestar_android.feature

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.semicolon.design.color.primary.white.white
import com.team.agestar_android.ui.theme.DevicePaddings
import com.team.agestar_android.R
import com.team.agestar_android.component.AppBar
import com.team.agestar_android.component.Button
import com.xquare.xquare_android.component.TextField

@Composable
fun ChangePasswordScreen(navController: NavController){
    ChangePassword(
        onBackClick = { navController.popBackStack()}
    )
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChangePassword(
    onBackClick: () -> Unit
){
    val context = LocalContext.current
    var nowPassword by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    val isChangePasswordEnabled = nowPassword.isNotEmpty() && newPassword.isNotEmpty()

    Scaffold(
        modifier = Modifier
            .background(white)
            .padding(
                top = DevicePaddings.statusBarHeightDp.dp,
                bottom = DevicePaddings.navigationBarHeightDp.dp
            ),
        topBar = {
                 AppBar(
                     painter = painterResource(id = R.drawable.ic_goback),
                     text = "",
                     onIconClick = onBackClick
                 )
        },
        bottomBar = {
            Column(Modifier.padding(bottom = 16.dp)) {
                Button(text = "변경", isEnabled = isChangePasswordEnabled) {
                    
                }
                
            }
        }
    ) {
        Column(
            Modifier.padding(top = 150.dp + it.calculateTopPadding()),
        ) {
            Text(text = "비밀번호 변경", fontSize = 35.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 16.dp))
            Spacer(Modifier.size(16.dp))
            Text(text = "현재 비밀번호", modifier = Modifier.padding(start = 20.dp))
            Spacer(Modifier.size(8.dp))
            Column(Modifier.padding(horizontal = 16.dp)) {
                TextField(
                    text = nowPassword,
                    placeholder = "현재 비밀번호를 입력하세요.",
                    onTextChange = { text ->
                        nowPassword = text
                    }
                )
                Spacer(Modifier.size(24.dp))
                Text(text = "새로운 비밀번호", modifier = Modifier.padding(start = 4.dp))
                Spacer(Modifier.size(8.dp))
                TextField(
                    text = newPassword,
                    placeholder = "새로운 비밀번호를 입력하세요.",
                    isSecret = true,
                    onTextChange = { text ->
                        newPassword = text
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChangePasswordPreview(){
    ChangePassword(
        onBackClick = {}
    )
}
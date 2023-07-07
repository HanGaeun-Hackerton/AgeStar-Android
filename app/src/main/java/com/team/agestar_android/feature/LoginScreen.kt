package com.team.agestar_android.feature

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.semicolon.design.Body2
import com.semicolon.design.color.primary.gray.gray500
import com.semicolon.design.color.primary.white.white
import com.team.agestar_android.ui.theme.DevicePaddings
import com.team.agestar_android.component.Button
import com.team.agestar_android.navigation.AppNavigationItem
import com.xquare.xquare_android.component.TextField


@Composable
fun LoginScreen(navController: NavController){
    Login(
        onRegisterClick = { navController.navigate(AppNavigationItem.Register.route)},
        onMainClick = { navController.navigate(AppNavigationItem.Main.route)}
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Login(
    onRegisterClick: () -> Unit,
    onMainClick: () -> Unit,
) {
    var accountId by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val isSignInEnabled = accountId.isNotEmpty() && password.isNotEmpty()
    val interactionSource = remember { MutableInteractionSource() }
    Scaffold(
        modifier = Modifier
            .background(white)
            .padding(
                top = DevicePaddings.statusBarHeightDp.dp,
                bottom = DevicePaddings.navigationBarHeightDp.dp
            ),
        bottomBar = {
            Column(Modifier.padding(bottom = 16.dp).imePadding()) {
                Row(
                    modifier = Modifier
                        .padding(start = 90.dp)
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null
                        )  {
                            onRegisterClick()
                        }
                ) {
                    Body2(text = "아직 회원이 아니신가요? ", color = gray500)
                    Body2(text = "회원가입하기", fontWeight = FontWeight.Medium, color = Color.Black)
                }
                Spacer(Modifier.size(16.dp))
                Button(text = "로그인", isEnabled = isSignInEnabled) {
                    onMainClick()
                }
            }
        }
    ) {

        Column(
            Modifier.padding(top = 70.dp + it.calculateTopPadding()),
        ) {
            Text(text = "로그인", fontSize = 35.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 16.dp))
            Spacer(Modifier.size(16.dp))
            Text(text = "로그인", modifier = Modifier.padding(start = 20.dp))
            Spacer(Modifier.size(8.dp))
            Column(Modifier.padding(horizontal = 16.dp)) {
                TextField(
                    text = accountId,
                    placeholder = "아이디를 입력하세요.",
                    onTextChange = { text ->
                        accountId = text
                    }
                )
                Spacer(Modifier.size(24.dp))
                Text(text = "비밀번호", modifier = Modifier.padding(start = 4.dp))
                Spacer(Modifier.size(8.dp))
                TextField(
                    text = password,
                    placeholder = "비밀번호를 입력하세요.",
                    isSecret = true,
                    onTextChange = { text ->
                        password = text
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview(){
    Login(
        onRegisterClick = {},
        onMainClick = {}
    )
}
package com.team.agestar_android.feature

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import com.xquare.xquare_android.component.TextField2


@Composable
fun RegisterScreen(navController: NavController){
    Register(
        onBackClick = { navController.popBackStack()}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Register(
    onBackClick: () -> Unit
){
    val context = LocalContext.current
    var accountId by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var birthday by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    val isRegisterEnabled = accountId.isNotEmpty() && password.isNotEmpty() && birthday.isNotEmpty() && name.isNotEmpty()

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
                Button(text = "회원가입" +
                        "", isEnabled = isRegisterEnabled) {

                }

            }
        }
    ) {
        Column(
            Modifier.padding(top = 50.dp + it.calculateTopPadding()),
        ) {
            Text(text = "회원가입", fontSize = 35.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 16.dp))
            Spacer(Modifier.size(16.dp))
            Text(text = "아이디", modifier = Modifier.padding(start = 20.dp))
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
                Spacer(Modifier.size(24.dp))
                Row {
                    Text(text = "출생연도", modifier = Modifier.padding(start = 4.dp))
                    Spacer(Modifier.size(width = 170.dp, height = 0.dp))
                    Text(text = "이름", modifier = Modifier.padding(start = 4.dp))
                }
                Spacer(Modifier.size(8.dp))
                Row {
                    TextField2(
                        text = birthday,
                        placeholder = "2006-08-21",
                        onTextChange ={ text ->
                            birthday = text
                        }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_connection),
                        contentDescription = "",
                        modifier = Modifier.padding(top = 20.dp, start = 30.dp, end = 10.dp)
                    )
                    Spacer(Modifier.size(20.dp))
                    TextField2(
                        text = name,
                        placeholder = "김연우",
                        onTextChange ={ text ->
                            name = text
                        }
                    )
                }
                Spacer(Modifier.size(24.dp))
                Text(text = "주민등록번호", modifier = Modifier.padding(start = 4.dp))
                Spacer(Modifier.size(8.dp))
                Row {
                    TextField2(
                        text = birthday,
                        placeholder = "910101",
                        onTextChange ={ text ->
                            birthday = text
                        }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_connection),
                        contentDescription = "",
                        modifier = Modifier.padding(top = 20.dp, start = 30.dp, end = 10.dp)
                    )
                    Spacer(Modifier.size(20.dp))
                    TextField2(
                        text = name,
                        placeholder = "XXXXXXX",
                        onTextChange ={ text ->
                            name = text
                        }
                    )
                }
                Spacer(Modifier.size(24.dp))
                Text(text = "전화번호", modifier = Modifier.padding(start = 4.dp))
                Spacer(Modifier.size(8.dp))
                TextField(
                    text = phoneNumber,
                    placeholder = "전화번로를 입력해주세요.",
                    onTextChange = { text ->
                        phoneNumber = text
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPreview(){
    Register(
        onBackClick = {}
    )
}
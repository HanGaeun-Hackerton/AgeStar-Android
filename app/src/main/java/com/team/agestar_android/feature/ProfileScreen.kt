package com.team.agestar_android.feature

import android.app.Activity
import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.semicolon.design.color.primary.gray.gray200
import com.semicolon.design.color.primary.white.white
import com.team.agestar_android.R
import com.team.agestar_android.component.Header
import com.team.agestar_android.ui.theme.DevicePaddings

@Composable
fun ProfileScreen(navController: NavController){
    Profile(
        onBackClick = {navController.popBackStack()}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(
    onBackClick: () -> Unit,
){
    val context = LocalContext.current
    var galleryState by remember { mutableStateOf(false) }
    var logoutDialogState by remember { mutableStateOf(false) }
    val openWebViewGallery =
        rememberLauncherForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                result.data!!.data?.run {

                }
            }
            galleryState = false
        }
    val openGalleryLauncher =
        Intent(Intent.ACTION_PICK).apply {
            this.type = "image/*"
            this.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, false)
        }
    if (galleryState) {
        openWebViewGallery.launch(openGalleryLauncher)
    }
    Scaffold(
        modifier = Modifier
            .background(white)
            .padding(
                top = DevicePaddings.statusBarHeightDp.dp,
                bottom = DevicePaddings.navigationBarHeightDp.dp
            ),
        {
            Header(
                painter = painterResource(id = R.drawable.ic_goback),
                title = "마이페이지",
                painter2 = painterResource(id = R.drawable.ic_edit_profile)
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = it.let { 100.dp }),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                val profileImageModifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null,
                    ) {
                        galleryState = true
                    }

                Box {
                    Image(
                        modifier = profileImageModifier,
                        painter = painterResource(id = R.drawable.ic_default),
                        contentScale = ContentScale.Crop,
                        contentDescription = null
                    )
                    Image(
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.BottomEnd),
                        painter = painterResource(R.drawable.ic_add_gallery),
                        contentDescription = null
                    )
                }
            }
        }
    }
}
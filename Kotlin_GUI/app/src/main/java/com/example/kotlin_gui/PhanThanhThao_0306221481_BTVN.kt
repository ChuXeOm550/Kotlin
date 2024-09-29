package com.example.kotlin_gui

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlin_gui.ui.theme.Kotlin_GUITheme
import androidx.compose.ui.unit.dp //Thêm để sử dụng được dp line 62

class BTVN_0306221481 :ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Kotlin_GUITheme {
                Surface(
                    modifier=Modifier.fillMaxSize(),
                    color=MaterialTheme.colorScheme.background
                ) {
                    CaoThangApp()
                }
            }
        }
    }
}

@Composable
fun CaoThangApp (modifier: Modifier=Modifier){
    Column(
        modifier=Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WelcomeSection()

        Image(painter = painterResource(id = R.drawable.logo_cntt),
            contentDescription = null,
            modifier = modifier.fillMaxWidth())

        IconField()

        ButtonSection()

        SignIn()
    }
}

@Composable
fun WelcomeSection (modifier: Modifier=Modifier){
    Box(modifier = modifier.padding(all=12.dp)){
        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(text = "Welcome", fontWeight = FontWeight.Bold, color = Color.Blue)
            Text(text = "Vui lòng thực hiện Đăng nhập hoặc Đăng ký để sử dụng ứng dụng của chúng tôi", fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun IconField (modifier: Modifier=Modifier){
    Box(modifier = modifier.padding(all=8.dp)){
        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "Đăng nhập với tài khoản Facebook hoặc email", color = Color.Blue, fontWeight = FontWeight.Bold)
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
            ){
                Icon(Icons.Rounded.Info, contentDescription = null, modifier=Modifier.padding(8.dp), Color.Blue)
                Icon(Icons.Rounded.Email, contentDescription = null, modifier=Modifier.padding(8.dp), Color.Red)
            }
        }
    }
}


@Composable
fun ButtonSection (modifier: Modifier=Modifier){
    Box(modifier = modifier.padding(vertical = 15.dp, horizontal = 10.dp)){
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                contentColorFor(backgroundColor = Color.Blue)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(7.dp)
        ) {
            Text(text = "Đăng Ký", color = Color.White)
        }
    }
}


@Composable
fun SignIn (modifier: Modifier=Modifier){
    Box(modifier = Modifier.padding(vertical = 12.dp    )){
        Row (
            horizontalArrangement = Arrangement.Start

        ){
            Text(text = "Bạn đã có tài khoản của ứng dụng? ", fontWeight = FontWeight.Bold)
            Text(text = "Đăng Nhập", fontWeight = FontWeight.Bold, color = Color.Blue)
        }
    }

}


@Preview
@Composable
fun CaoThangPreview (modifier: Modifier=Modifier){
    CaoThangApp()
}
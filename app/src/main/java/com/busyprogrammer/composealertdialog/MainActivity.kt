package com.busyprogrammer.composealertdialog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.busyprogrammer.composealertdialog.ui.theme.ComposeAlertDialogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAlertDialogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {

                    MainContent()
                }
            }
        }
    }
}

@Composable
fun MainContent() {
    val openDialog = remember {
        mutableStateOf(false)
    }
    Box(contentAlignment = Alignment.Center) {
        Button(onClick = { openDialog.value = true }, modifier = Modifier.align(Alignment.Center)) {
            Text(text = "Alert Dialog Example")
        }
    }

    if(openDialog.value) {
        AlertDialog(shape = RoundedCornerShape(20.dp),
            onDismissRequest = {
                openDialog.value = false
            },
            text = { Text(text = "Do you want to Verify now?") },
            title = { Text(text = "Verification Required" , fontWeight = FontWeight.Bold)},
            confirmButton = {
                Button(
                    onClick = { openDialog.value = false },
                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 10.dp),
                    shape = RoundedCornerShape(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Red, backgroundColor = Color.Red
                    )

                ) {
                    Text(
                        text = "Verify Now",
                        fontSize = 12.sp,
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 4.dp),
                        color = Color.White
                    )

                }
            },
            dismissButton = {
                OutlinedButton(
                    onClick = { openDialog.value = false },
                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 10.dp),
                    border = BorderStroke(1.dp, Color.Red),
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
                ) {
                    Text(
                        text = "Not now",
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 4.dp),
                        fontSize = 12.sp,
                        color = Color.Red
                    )
                }
            })
    }

}
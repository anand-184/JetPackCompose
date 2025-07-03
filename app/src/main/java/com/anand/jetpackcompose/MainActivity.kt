package com.anand.jetpackcompose
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.anand.jetpackcompose.ui.theme.JetPackComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            JetPackComposeTheme{
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background){
                    imageAndbutton()

                }


                }
            }
        }
    }

@Composable

fun ProfileCard(){
    var outerBg by remember { mutableStateOf(Color.DarkGray) }
    Box(Modifier.fillMaxSize().padding(16.dp).background(outerBg)){
        Box(Modifier.fillMaxSize().padding(top = 50.dp, start = 20.dp, end = 20.dp, bottom = 50.dp).align(Alignment.Center).background(Color.LightGray)){
            val context = LocalContext.current
            val onClick={Toast.makeText(context,"Welcome to JetPack Compose",Toast.LENGTH_SHORT).show()
                outerBg = Color.White}
            Column(modifier = Modifier.align(Alignment.Center).padding(top = 15.dp).background(Color.White).
            clickable(onClick = onClick)){
                Text(text = "Er.Anandita",fontSize = 30.sp,color = Color(0xFF452073),
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Cursive,
                    modifier = Modifier.padding(16.dp).align(Alignment.CenterHorizontally))
                Text(text = "App Developer",
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Monospace,
                    color = Color(0xFF452073),
                    modifier = Modifier.padding(start = 16.dp).align(Alignment.CenterHorizontally))

                Row(modifier = Modifier.padding(16.dp).align(Alignment.CenterHorizontally), horizontalArrangement = Arrangement.Center){
                    Text(text = "Kotlin | ",
                        color = Color.Black,
                        fontSize = 16.sp)
                    Text(text="Python | ",fontSize = 16.sp,
                        color = Color.Black)
                    Text(text = "JetPack Compose",fontSize = 16.sp,
                        color = Color.Black, modifier = Modifier.align(Alignment.CenterVertically))
                }
            }
            Column(modifier = Modifier.align(Alignment.BottomEnd).padding(bottom = 20.dp, end = 10.dp)){
                Text(text = "📞: +91 XXXXXXXXX",fontSize = 18.sp,color=Color.Black,
                    modifier = Modifier.padding(start = 16.dp).align(Alignment.CenterHorizontally))

            }
        }
    }
}
@Composable
fun alignAndarrange(){

    /*
    Row - Horizontal Arrangement and Vertical Alignment
    Column- Vertical Arrangement and Horizontal Alignment
    Box- Alignment
     */

    Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){

        Text(text = "Row1")
    }
/*
    Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
        Text(text = "Row2")
    }
    Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.Bottom){
        Text(text = "Row3")
    }
    Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.Top){
        Text(text = "Row4")
    }
    Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically){
        Text(text = "Row5")
    }
    Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.Bottom){
        Text(text = "Row6")
    }
    Row(horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.Top){
        Text(text = "Row7")
    }
    Row(horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically){
        Text(text = "Row8")
    }
    Row(horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.Bottom) {
        Text(text = "Row9")
    }
    */
}
@Composable
fun imageAndbutton() {
    Row(verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.SpaceEvenly) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.splash_icon),
                contentDescription = "Android",
                modifier = Modifier.align(Alignment.TopStart)
                    .border(width = 1.dp, color = Color.Black)
                    .size(50.dp)
            )
                val context = LocalContext.current
                Button(
                    onClick = {
                        Toast.makeText(
                            context,
                            "Welcome to JetPack Compose",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                    modifier = Modifier.padding(start = 10.dp, end = 5.dp).align(Alignment.TopEnd)
                ) {
                    Text(text = "Click Me")
                }
        }
    }
}





@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackComposeTheme {
        imageAndbutton()

    }
}




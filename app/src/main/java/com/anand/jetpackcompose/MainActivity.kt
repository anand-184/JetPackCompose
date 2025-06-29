package com.anand.jetpackcompose
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center // centers the Column
                ) {
                    TitleWithAuthor()
                }
                }
            }
        }
    }

@Composable
fun TitleWithAuthor(){
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text="Kotlin X Jetpack Compose",
            color =Color(0xFF6C4A8C),
            fontFamily = FontFamily.SansSerif,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Row(  modifier = Modifier.align(Alignment.End)
            .padding(top = 4.dp),
            horizontalArrangement = Arrangement.End) {
            val context = LocalContext.current
            Text(
                text = "-By Anandita",
                modifier = Modifier
                    .background(Color(0xFFD0BCFF))
                    .clickable {
                        Toast.makeText(context, "Developed By: Er.Anandita", Toast.LENGTH_SHORT).show()
                    }
                    .padding(6.dp),
                color = Color(0xFF77194A),
                fontFamily = FontFamily.Cursive,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
            )
        }
    }


}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackComposeTheme {
        TitleWithAuthor()
    }
}




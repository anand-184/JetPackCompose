package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun Add(){
    Box(Modifier.fillMaxSize().background(Color.LightGray), contentAlignment = Alignment.Center){
        Text(text = "Add Screen",color = Color.Blue,fontSize = 30.sp, fontWeight = FontWeight.Bold)
    }
}
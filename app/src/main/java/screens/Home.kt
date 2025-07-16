package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anand.jetpackcompose.Screens

@Composable
fun Home(){
    val optionList=listOf("Reels","Story","Post","Live")
    Box(Modifier.fillMaxSize().background(Color.LightGray), contentAlignment = Alignment.Center){
        Text(text = "Home Screen-LazyColum-Row",color = Color.Blue,fontSize = 20.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.TopCenter).padding(top = 20.dp))

        LazyColumn(Modifier.padding(top=50.dp)) {
            items(optionList){
                Box(modifier = Modifier.size(width=300.dp, height = 400.dp)
                    .padding(top = 10.dp, bottom = 10.dp).background(if(it=="Reels"){Color.Red}
                    else if(it=="Post"){Color.Blue}
                    else if(it=="Story"){Color.Green}
                    else{Color.Magenta}),
                    contentAlignment = Alignment.Center){
                    Text(text = it,color = Color.White,fontSize = 50.sp, fontWeight = FontWeight.Bold)

                }

            }

        }

    }
}

@Preview
@Composable
fun HomePreview(){
    Home()
}
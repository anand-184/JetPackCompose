package com.anand.jetpackcompose

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.anand.jetpackcompose.ui.theme.JetPackComposeTheme
import kotlinx.coroutines.launch
import screens.Add
import screens.Home
import screens.Profile
import screens.Search
import screens.Settings

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            JetPackComposeTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    bottomNav()
                }
            }
        }
    }
}



/*@Composable
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

/*@Composable
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

*/
/*
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Sidenav() {
    val context = LocalContext.current
    val navigationController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Box(
                    Modifier
                        .background(Color.Green)
                        .fillMaxWidth()
                        .height(100.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Box(modifier = Modifier.fillMaxWidth()) {
                            Image(
                                painter = painterResource(id = R.drawable.splash_icon),
                                contentDescription = "Android",
                                modifier = Modifier
                                    .align(Alignment.CenterStart)
                                    .size(100.dp)
                            )
                            Text(
                                text = "Android X Compose",
                                color = Color.Black,
                                fontSize = 25.sp, // ✅ Corrected here
                                modifier = Modifier
                                    .padding( end = 10.dp)
                                    .align(Alignment.CenterEnd)
                            )
                        }
                    }
                }


                HorizontalDivider()

                NavigationDrawerItem(
                    label = { Text(text = "Home", color = Color.Black) },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Home") },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Home.screen) {
                            popUpTo(0) { inclusive = true }
                        }
                    }
                )
                NavigationDrawerItem(
                    label = { Text(text = "Settings", color = Color.Black) },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings") },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Settings.screen) {
                            popUpTo(0) { inclusive = true }
                        }
                    }
                )
                NavigationDrawerItem(
                    label = { Text(text = "Profile", color = Color.Black) },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Default.Person, contentDescription = "Profile") },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Profile.screen) {
                            popUpTo(0) { inclusive = true }
                        }
                    }
                )
                NavigationDrawerItem(
                    label = { Text(text = "Logout", color = Color.Black) },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Filled.ExitToApp, contentDescription = "Logout") },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        Toast.makeText(context, "Logout", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "JetPack Compose", color = Color.White) },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF6200EE),
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White,
                        actionIconContentColor = Color.White
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(imageVector = Icons.Rounded.Menu, contentDescription = "Menu")
                        }
                    }
                )
            }
        ) {
            NavHost(
                navController = navigationController,
                startDestination = Screens.Home.screen
            ) {
                composable(Screens.Home.screen) { Home() }
                composable(Screens.Profile.screen) { Profile() }
                composable(Screens.Settings.screen) { Settings() }
            }
        }
    }
}
*/
@Composable
fun bottomNav(){
    val navigationController = rememberNavController()
    val context=LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val selectedItem = remember { mutableStateOf(Icons.Default.Home) }

    Scaffold(
        bottomBar={
            BottomAppBar(containerColor = Color.Black) {
                /*Item1 */

                IconButton(onClick = {selectedItem.value=Icons.Default.Home
                navigationController.navigate(Screens.Home.screen){ popUpTo(0) }
                },modifier = Modifier.weight(1f)
                ){
                    Icon(Icons.Default.Home, contentDescription =null,modifier = Modifier.size(26.dp),
                        tint = if(selectedItem.value == Icons.Default.Home) Color.White else Color.Gray)
                }
                /*Item 2 */

                IconButton(onClick = {selectedItem.value=Icons.Default.Person
                    navigationController.navigate(Screens.Profile.screen){ popUpTo(0) }
                },modifier = Modifier.weight(1f)
                ){
                    Icon(Icons.Default.Person, contentDescription =null,modifier = Modifier.size(26.dp),
                        tint = if(selectedItem.value == Icons.Default.Person) Color.White else Color.Gray)
                }

                /*Item3*/

                Box(modifier = Modifier.weight(1f).padding(16.dp), contentAlignment = Alignment.Center) {
                    FloatingActionButton(onClick = { navigationController.navigate(Screens.AddScreen.screen) {
                            popUpTo(0) }
                    })
                    {
                        Icon(Icons.Default.Add, contentDescription =null,modifier = Modifier.size(26.dp),
                            tint = if(selectedItem.value == Icons.Default.Add) Color.White else Color.Gray)

                    }

                }

                /*Item4*/

                IconButton(onClick = {selectedItem.value=Icons.Default.Settings
                    navigationController.navigate(Screens.Settings.screen){ popUpTo(0) }
                },modifier = Modifier.weight(1f)
                ){
                    Icon(Icons.Default.Settings, contentDescription =null,modifier = Modifier.size(26.dp),
                        tint = if(selectedItem.value == Icons.Default.Settings) Color.White else Color.Gray)
                }

                /*Item5*/

                IconButton(onClick = {selectedItem.value=Icons.Default.Search
                    navigationController.navigate(Screens.Search.screen){ popUpTo(0) }
                },modifier = Modifier.weight(1f)
                ){
                    Icon(Icons.Default.Search, contentDescription =null,modifier = Modifier.size(26.dp),
                        tint = if(selectedItem.value == Icons.Default.Search) Color.White else Color.Gray)
                }

            }
        }
    ){paddingValues ->
        NavHost(navController = navigationController, startDestination = Screens.Home.screen, modifier = Modifier.padding(paddingValues)){
            composable(Screens.Home.screen){ Home() }
            composable(Screens.Profile.screen){ Profile() }
            composable(Screens.Settings.screen){ Settings() }
            composable(Screens.AddScreen.screen){ Add() }
            composable(Screens.Search.screen){Search() }
        }

    }


}

@Preview(showBackground = true)
@Composable
fun LayoutPreview() {
    JetPackComposeTheme {
        bottomNav()
    }
}

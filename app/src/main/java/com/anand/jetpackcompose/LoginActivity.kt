package com.anand.jetpackcompose


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anand.jetpackcompose.ui.theme.JetPackComposeTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposeTheme {
                Box(modifier = Modifier.fillMaxSize(),contentAlignment = Alignment.Center) {
                    LoginScreen(onLoginSuccess = {})


                }
            }
        }
    }
}

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.splash_icon),
            contentDescription = "Login Image",
            modifier = Modifier.size(400.dp).padding(top = 20.dp, bottom = 30.dp, start = 50.dp, end = 50.dp)
        )
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            shape = RoundedCornerShape(5.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedLabelColor = Color.Black,
                focusedContainerColor = Color.LightGray
            ),
            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = null) },
            modifier = Modifier.padding(top=30.dp,bottom = 10.dp)
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            shape = RoundedCornerShape(5.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedLabelColor = Color.Black,
                focusedContainerColor = Color.LightGray
            ),
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = null) },
            modifier = Modifier.padding(bottom = 10.dp),
            visualTransformation = PasswordVisualTransformation()
        )

        Box(modifier = Modifier.fillMaxSize().padding(bottom = 100.dp), contentAlignment = Alignment.BottomCenter) {
            Button(onClick = {
                if (auth(username, password)) {
                    Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                    onLoginSuccess()
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                } else {
                    Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
                }
            }, modifier = Modifier.padding(bottom = 10.dp), colors = ButtonDefaults.buttonColors(
                containerColor = Color.Green
            )
            ) {
                Text(text = "Login", color = Color.Black)

            }

        }
    }
}


private fun auth(username: String, password: String): Boolean {
    val validUsername = "admin"
    val validPassword = "password"
    return username == validUsername && password == validPassword

}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    JetPackComposeTheme {
        LoginScreen(onLoginSuccess = {})
    }
}


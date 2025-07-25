package com.anand.jetpackcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.anand.jetpackcompose.ui.theme.JetPackComposeTheme
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay

class Splash : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Firebase once
        FirebaseApp.initializeApp(this)

        setContent {
            JetPackComposeTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    SplashScreen()
                }
            }
        }
    }

    @Composable
    fun SplashScreen() {
        LaunchedEffect(key1 = true) {
            delay(500) // 2-second splash delay

            val user = FirebaseAuth.getInstance().currentUser
            if (user != null) {
                startActivity(Intent(this@Splash, MainActivity::class.java))
            } else {
                startActivity(Intent(this@Splash, LoginActivity::class.java))
            }
            finish() // Prevent returning to splash screen
        }
    }
}

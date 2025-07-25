package com.anand.jetpackcompose

import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel

class AppViewModel: ViewModel() {
    var selectedItem by mutableStateOf("")

    fun selectItem(item:String){

        selectedItem = item


    }

}
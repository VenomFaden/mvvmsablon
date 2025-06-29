package com.bitnays.retrofitvecompose.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.bitnays.retrofitvecompose.model.User


@Composable
fun UserDetay(user: User){
    Text(user.name.toString()+user.username.toString()+user.email.toString())
}

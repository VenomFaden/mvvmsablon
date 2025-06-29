package com.bitnays.retrofitvecompose.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bitnays.retrofitvecompose.model.User

@Composable
fun UserList(userList: List<User>) {
    LazyColumn(modifier = Modifier.fillMaxSize().
               background(color = MaterialTheme.colorScheme.primaryContainer))
    {
        items(userList){
            UserRow(user = it)
        }
    }
}
@Composable
fun UserRow(user: User) {
    Column(modifier = Modifier.fillMaxSize()
        .border(BorderStroke(2.dp, Color.Black))) {
        Column {
            Text(text = user.name)
        }
    }
}

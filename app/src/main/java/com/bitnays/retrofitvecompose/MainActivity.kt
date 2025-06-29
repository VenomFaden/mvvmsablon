    package com.bitnays.retrofitvecompose

    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.activity.enableEdgeToEdge
    import androidx.activity.viewModels
    import androidx.compose.foundation.layout.Box
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.padding
    import androidx.compose.material3.Scaffold
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.mutableIntStateOf
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.remember
    import androidx.compose.ui.Modifier
    import androidx.navigation.compose.NavHost
    import androidx.navigation.compose.composable
    import androidx.navigation.compose.rememberNavController
    import com.bitnays.retrofitvecompose.model.Company
    import com.bitnays.retrofitvecompose.model.User
    import com.bitnays.retrofitvecompose.screens.UserDetay
    import com.bitnays.retrofitvecompose.screens.UserList
    import com.bitnays.retrofitvecompose.ui.theme.RetrofitVeComposeTheme
    import com.bitnays.retrofitvecompose.viewmodel.UserViewModel

    class MainActivity : ComponentActivity() {
        private val viewModel : UserViewModel by viewModels<UserViewModel>()
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContent {
                val navController = rememberNavController()
                val clickedUser = remember { mutableStateOf(User(0,"","","",null,"","",Company("","",""))) }
                viewModel.getUsers()
                RetrofitVeComposeTheme {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        Box(modifier = Modifier.padding(innerPadding)) {
                            NavHost(navController = navController, startDestination = "user_list")
                            {
                                composable("user_list") {
                                    UserList(userList = viewModel.userList.value, navController,
                                        clickedUser = { user -> clickedUser.value = user }
                                    )
                                }
                                composable("user_detay") {
                                    UserDetay(user = clickedUser.value)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
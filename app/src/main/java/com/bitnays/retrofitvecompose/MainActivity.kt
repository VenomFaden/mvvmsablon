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
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.tooling.preview.Preview
    import com.bitnays.retrofitvecompose.screens.UserList
    import com.bitnays.retrofitvecompose.ui.theme.RetrofitVeComposeTheme
    import com.bitnays.retrofitvecompose.viewmodel.UserViewModel

    class MainActivity : ComponentActivity() {
        private val viewModel : UserViewModel by viewModels<UserViewModel>()
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            viewModel.getUsers()
            setContent {
                RetrofitVeComposeTheme {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        Box(modifier = Modifier.padding(innerPadding)) {

                            UserList(userList = viewModel.userList.value)
                        }
                    }
                }
            }
        }
    }
package com.bitnays.retrofitvecompose.service

import com.bitnays.retrofitvecompose.model.User
import retrofit2.http.GET

interface UserAPI {
    @GET("atilsamancioglu/UsersJSONPlaceHolder/refs/heads/main/users.json")
    suspend fun getData() : List<User>
}
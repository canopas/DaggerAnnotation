package com.canopas.dagger2.rest

import com.canopas.dagger2.model.User
import io.reactivex.Observable
import retrofit2.http.GET


interface UserService {

    @GET("users")
    fun getUser(): Observable<List<User>>
}
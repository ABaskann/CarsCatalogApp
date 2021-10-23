package com.abaskan.carscatalogapp.network

import com.abaskan.carscatalogapp.response.CarsResponse
import retrofit2.Call
import retrofit2.http.GET

interface CarsDaoInterface {

    @GET("all_cars.php")
    fun getCars() : Call<CarsResponse>
}
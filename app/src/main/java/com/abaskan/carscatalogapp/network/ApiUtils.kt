package com.abaskan.carscatalogapp.network

class ApiUtils {

    companion object{

        private const val BASE_URL = "https://armaganbaskan.com/api/carscatalog/"

        fun getCarsDaoInterface(): CarsDaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(CarsDaoInterface::class.java)

        }
    }
}
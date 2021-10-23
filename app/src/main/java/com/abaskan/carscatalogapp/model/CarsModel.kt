package com.abaskan.carscatalogapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CarsModel(
    @SerializedName("car_id") @Expose var car_id:Int,
    @SerializedName("car_name") @Expose var car_name:String,
    @SerializedName("car_engine_type1") @Expose var car_engine_type1:String,
    @SerializedName("car_engine_type2") @Expose var car_engine_type2:String,
    @SerializedName("car_color1") @Expose var car_color1:String,
    @SerializedName("car_color2") @Expose var car_color2:String,
    @SerializedName("car_color3") @Expose var car_color3:String,
    @SerializedName("car_color4") @Expose var car_color4:String,
    @SerializedName("car_image_url1") @Expose var car_image_url1:String,
    @SerializedName("car_image_url2") @Expose var car_image_url2:String,
    @SerializedName("car_image_url3") @Expose var car_image_url3:String,
    @SerializedName("car_image_url4") @Expose var car_image_url4:String,
    @SerializedName("car_price") @Expose var car_price:Float)
    :Serializable

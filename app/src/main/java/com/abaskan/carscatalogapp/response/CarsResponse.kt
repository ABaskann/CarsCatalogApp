package com.abaskan.carscatalogapp.response

import com.abaskan.carscatalogapp.model.CarsModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CarsResponse(
    @SerializedName("cars")
    @Expose var carslist: List<CarsModel>,
    @SerializedName("success")
    @Expose var success: Int)

package com.abaskan.carscatalogapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.abaskan.carscatalogapp.R
import com.abaskan.carscatalogapp.databinding.CarCardBinding
import com.abaskan.carscatalogapp.model.CarsModel
import com.squareup.picasso.Picasso

class Adapter(private var carsList:ArrayList<CarsModel>):RecyclerView.Adapter<Adapter.CarsCardDesign>() {
    class CarsCardDesign(val cardBinding: CarCardBinding):RecyclerView.ViewHolder(cardBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsCardDesign {
        val layoutInflater = LayoutInflater.from(parent.context)
        val carsCardDesignBinding = CarCardBinding.inflate(layoutInflater,parent,false)
        return CarsCardDesign(carsCardDesignBinding)
    }

    override fun onBindViewHolder(holder: CarsCardDesign, position: Int) {
        val cars = carsList[position]
        Picasso.get().load(cars.car_image_url1).into(holder.cardBinding.imageView)
        holder.cardBinding.carNameTextView.text = cars.car_name
        holder.cardBinding.detailButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_mainPageFragment_to_detailFragment)
        }



    }

    override fun getItemCount(): Int {
       return carsList.size
    }
}
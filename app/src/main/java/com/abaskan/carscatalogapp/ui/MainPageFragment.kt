package com.abaskan.carscatalogapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.abaskan.carscatalogapp.databinding.FragmentMainPageBinding
import com.abaskan.carscatalogapp.model.CarsModel
import com.abaskan.carscatalogapp.network.ApiUtils
import com.abaskan.carscatalogapp.response.CarsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainPageFragment : Fragment() {

    private var _binding:FragmentMainPageBinding? = null
    private val binding get() = _binding!!
    var carsList:ArrayList<CarsModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainPageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getCarsList()


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun getCarsList(){
        ApiUtils.getCarsDaoInterface().getCars().enqueue(
            object: Callback<CarsResponse>{
                override fun onResponse(
                    call: Call<CarsResponse>,
                    response: Response<CarsResponse>
                ) {
                    val tempList = response.body()?.carslist
                    tempList?.let {
                        carsList = it as ArrayList<CarsModel>
                        println(carsList)
                    }
                    val carsAdapter = Adapter(carsList)
                    binding.rvadapter.adapter = carsAdapter
                    binding.rvadapter.layoutManager = GridLayoutManager(context,2)
                    binding.rvadapter.setHasFixedSize(true)
                }

                override fun onFailure(call: Call<CarsResponse>, t: Throwable) {
                    println(t)
                }

            }
        )

    }


}
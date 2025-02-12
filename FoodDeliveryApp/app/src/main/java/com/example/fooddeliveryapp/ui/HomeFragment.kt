package com.example.fooddeliveryapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.adapter.RestaurantAdapter
import com.example.fooddeliveryapp.databinding.ActivityMainBinding
import com.example.fooddeliveryapp.databinding.FragmentHomeBinding
import com.example.fooddeliveryapp.model.Restaurant


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val restaurants = listOf(
        Restaurant(1, "Burger King", R.drawable.product_placeholder, 3.4, "20 min"),
        Restaurant(2, "Pizza Hut", R.drawable.product_placeholder, 3.8, "10 min"),
        Restaurant(3, "Dominos", R.drawable.product_placeholder, 3.9, "60 min"),
        Restaurant(4, "Hotel King", R.drawable.product_placeholder, 2.5, "40 min"),
        Restaurant(5, "Paras Restro", R.drawable.product_placeholder, 5.0, "35 min"),
        Restaurant(6, "Family restaurant", R.drawable.product_placeholder, 5.0, "35 min"),
        Restaurant(7, "Raghuveer Sweets", R.drawable.product_placeholder, 5.0, "35 min"),
        Restaurant(8, "Hotel Gauri IN", R.drawable.product_placeholder, 5.0, "35 min")

    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val adapter = RestaurantAdapter(restaurants) { restaurant ->
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToMenuFragment(restaurant.id)
            )
        }
        binding.recyclerView.adapter = adapter

        return binding.root
    }
}

package com.example.fooddeliveryapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddeliveryapp.databinding.ItemRestaurantBinding
import com.example.fooddeliveryapp.model.Restaurant

class RestaurantAdapter(
    private var restaurants: List<Restaurant>,
    private val onClick: (Restaurant) -> Unit
) : RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemRestaurantBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val restaurant = restaurants[position]
        holder.binding.apply {
            tvName.text = restaurant.name
            ivImage.setImageResource(restaurant.image)
            tvRating.text = "⭐ ${restaurant.rating}"
            tvDeliveryTime.text = restaurant.deliveryTime
            root.setOnClickListener { onClick(restaurant) }
        }
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }
}

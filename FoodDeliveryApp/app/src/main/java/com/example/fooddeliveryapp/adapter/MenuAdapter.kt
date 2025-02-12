package com.example.fooddeliveryapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddeliveryapp.databinding.ItemMenuBinding
import com.example.fooddeliveryapp.model.MenuItem

class MenuAdapter(
    private val menuItem: List<MenuItem>, private  val  onAddToCart:(MenuItem) -> Unit
): RecyclerView.Adapter<MenuAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemMenuBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return menuItem.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = menuItem[position]
        holder.binding.apply {
            tvName.text = item.name
            ivImage.setImageResource(item.image)
            tvPrice.text = "$${item.price}"

            btnAddToCart.setOnClickListener{
                onAddToCart(item)
            }
        }
    }
}
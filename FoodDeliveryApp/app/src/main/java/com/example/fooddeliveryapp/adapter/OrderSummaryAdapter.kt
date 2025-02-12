package com.example.fooddeliveryapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddeliveryapp.databinding.ItemOrderSummaryBinding
import com.example.fooddeliveryapp.model.CartItem

class OrderSummaryAdapter(
    private val cartItems : List<CartItem>
): RecyclerView.Adapter<OrderSummaryAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemOrderSummaryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemOrderSummaryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cartItem = cartItems[position]
        holder.binding.apply {
            tvItemName.text = cartItem.menuItem.name
            tvItemPrice.text = "$${cartItem.menuItem.price}"
            tvItemQuantity.text = "Qty: ${cartItem.quantity}"
            tvItemImage.setImageResource(cartItem.menuItem.image)
        }
    }
}
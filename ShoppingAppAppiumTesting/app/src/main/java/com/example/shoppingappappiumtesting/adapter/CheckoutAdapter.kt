package com.example.shoppingappappiumtesting.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingappappiumtesting.dataModel.CheckoutItem
import com.example.shoppingappappiumtesting.databinding.ItemCheckoutBinding

class CheckoutAdapter(
    private val items: MutableList<CheckoutItem>,
    private val onUpdate: () -> Unit
) : RecyclerView.Adapter<CheckoutAdapter.CheckoutViewHolder>() {

    inner class CheckoutViewHolder(val binding: ItemCheckoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckoutViewHolder {
        val binding = ItemCheckoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CheckoutViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CheckoutViewHolder, position: Int) {
        val item = items[position]
        with(holder.binding) {
            productImage.setImageResource(item.imageRes)
            productName.text = item.name
            productPrice.text = "₹${item.price}"
            quantityText.text = item.quantity.toString()

            // Increase quantity
            increaseButton.setOnClickListener {
                item.quantity++
                quantityText.text = item.quantity.toString()
                onUpdate()
            }

            // Decrease quantity
            decreaseButton.setOnClickListener {
                if (item.quantity > 1) {
                    item.quantity--
                    quantityText.text = item.quantity.toString()
                    onUpdate()
                }
            }

            // Remove item
            removeButton.setOnClickListener {
                items.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position, items.size)
                onUpdate()
            }
        }
    }

    override fun getItemCount(): Int = items.size
}

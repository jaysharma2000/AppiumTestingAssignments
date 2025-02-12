package com.example.fooddeliveryapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fooddeliveryapp.adapter.OrderSummaryAdapter
import com.example.fooddeliveryapp.databinding.FragmentOrderSummaryBinding
import com.example.fooddeliveryapp.model.CartItem

class OrderSummaryFragment : Fragment() {

    private  lateinit var binding: FragmentOrderSummaryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOrderSummaryBinding.inflate(inflater, container,false)

        val cartItems = arguments?.getParcelableArray("cartItems") as? Array<CartItem> ?: emptyArray()

        val totalAmount = cartItems.sumOf { it.quantity * it.menuItem.price }

        binding.recyclerView.adapter = OrderSummaryAdapter(cartItems.toList())

        binding.tvTotal.text = "Total: $${totalAmount}"
        binding.btnPlaceOrder.setOnClickListener{
            Toast.makeText(requireContext(), "Order Placed", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }

}
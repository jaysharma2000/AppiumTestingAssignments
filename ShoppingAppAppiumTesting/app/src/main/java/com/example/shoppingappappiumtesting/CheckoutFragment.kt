package com.example.shoppingappappiumtesting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppingappappiumtesting.adapter.CheckoutAdapter
import com.example.shoppingappappiumtesting.dataModel.CheckoutItem
import com.example.shoppingappappiumtesting.databinding.FragmentCheckoutBinding

class CheckoutFragment : Fragment() {
    private var _binding: FragmentCheckoutBinding? = null
    private val binding get() = _binding!!

    // Dummy selected products (in real scenario, pass data from previous screen)
    private val selectedProducts = mutableListOf(
        CheckoutItem("Product 1", 299.99, 1, R.drawable.product_placeholder),
        CheckoutItem("Product 2", 499.99, 2, R.drawable.product_placeholder),
        CheckoutItem("Product 3", 199.99, 1, R.drawable.product_placeholder)
    )

    private lateinit var adapter: CheckoutAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCheckoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        updateTotalPrice()

        // Place Order Button
        binding.placeOrderButton.setOnClickListener {
            Toast.makeText(requireContext(), "Order Placed Successfully!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupRecyclerView() {
        adapter = CheckoutAdapter(selectedProducts) {
            updateTotalPrice()
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

    private fun updateTotalPrice() {
        val total = selectedProducts.sumOf { it.price * it.quantity }
        binding.totalAmount.text = "Total: ₹${"%.2f".format(total)}"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

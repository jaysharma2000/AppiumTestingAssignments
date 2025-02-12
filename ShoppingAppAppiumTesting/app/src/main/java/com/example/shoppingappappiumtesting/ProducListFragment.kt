package com.example.shoppingappappiumtesting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppingappappiumtesting.adapter.ProductAdapter
import com.example.shoppingappappiumtesting.dataModel.Product
import com.example.shoppingappappiumtesting.databinding.FragmentProducListBinding

class ProducListFragment : Fragment() {
    private var _binding: FragmentProducListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProducListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val productList = listOf(
            Product("Product 1", 299.99, R.drawable.product_placeholder),
            Product("Product 2", 499.99, R.drawable.product_placeholder),
            Product("Product 3", 199.99, R.drawable.product_placeholder),
            Product("Product 4", 999.99, R.drawable.product_placeholder),
            Product("Product 5", 149.99, R.drawable.product_placeholder)
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = ProductAdapter(productList)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
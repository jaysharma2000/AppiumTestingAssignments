package com.example.fooddeliveryapp.ui
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.adapter.MenuAdapter
import com.example.fooddeliveryapp.databinding.FragmentMenuBinding
import com.example.fooddeliveryapp.model.CartItem
import com.example.fooddeliveryapp.model.MenuItem

class MenuFragment : Fragment() {
    private lateinit var binding: FragmentMenuBinding
    private val menuItems = listOf(
        MenuItem(1, "Burger with cheese", R.drawable.product_placeholder, 55.30),
        MenuItem(2, "Paneer pizza", R.drawable.product_placeholder, 650.0),
        MenuItem(3, "Malai cheese", R.drawable.product_placeholder, 150.0),
        MenuItem(4, "Chili pizza", R.drawable.product_placeholder, 780.0),
        MenuItem(5, "Soft drinks", R.drawable.product_placeholder, 230.0)
    )

    private val cart = mutableListOf<CartItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(inflater, container, false)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val adapter = MenuAdapter(menuItems) { menuItem ->
            val cartItem = cart.find { it.menuItem.id == menuItem.id }

            if (cartItem != null) {
                cartItem.quantity++
            } else {
                cart.add(CartItem(menuItem, 1))
            }

            val totalItems = cart.sumOf { it.quantity }
            binding.tvCartCounter.text = totalItems.toString()

            binding.tvCartCounter.visibility = if (totalItems > 0) View.VISIBLE else View.GONE
        }
        binding.recyclerView.adapter = adapter

        binding.tvCartCounter.setOnClickListener {
            findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToOrderSummaryFragment(cart.toTypedArray()))
        }
        return binding.root
    }
}

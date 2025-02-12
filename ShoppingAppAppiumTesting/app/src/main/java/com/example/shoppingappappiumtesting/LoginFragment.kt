package com.example.shoppingappappiumtesting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.shoppingappappiumtesting.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val email = binding.email.text
        val password = binding.password.text
        if(email.equals("admin") && password.equals("12345")){
//            binding.registerButton.setOnClickListener{
//                requireActivity().supportFragmentManager.beginTransaction()
//                    .replace(R.id.fragmentContainer, RegisterFragment())
//                    .addToBackStack(null)
//                    .commit()
//            }
            binding.loginButton.setOnClickListener {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, ProducListFragment())
                    .addToBackStack(null)
                    .commit()
            }
            Toast.makeText(requireContext(), "Login Successfull", Toast.LENGTH_SHORT)
                .show()
        }else{

        }

        binding.registerButton.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, RegisterFragment())
                .addToBackStack(null)
                .commit()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

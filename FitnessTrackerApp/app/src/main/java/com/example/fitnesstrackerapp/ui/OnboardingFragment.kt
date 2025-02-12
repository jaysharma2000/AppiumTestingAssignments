package com.example.fitnesstrackerapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fitnesstrackerapp.R
import com.example.fitnesstrackerapp.adapter.OnboardingAdapter
import com.example.fitnesstrackerapp.databinding.FragmentOnboardingBinding
import com.google.android.material.tabs.TabLayoutMediator

class OnboardingFragment : Fragment() {

    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tips = listOf(
            "Stay Hydrated Drink at least 8 glasses of water daily.  Hydration boosts energy & metabolism.",
            "Exercise Regularly Aim for 30 minutes of activity daily.  Mix cardio, strength, and flexibility workouts. ",
            "Eat Smart & Healthy! Choose whole foods over processed snacks.  Eat a balanced mix of proteins, carbs, and fats. "
        )

        val adapter = OnboardingAdapter(tips)
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { _, _ -> }.attach()

        binding.skipButton.setOnClickListener {
            findNavController().navigate(R.id.action_onboardingFragment_to_dashboardFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

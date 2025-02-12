package com.example.fitnesstrackerapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesstrackerapp.databinding.ItemOnboardingBinding

class OnboardingAdapter(private val tips: List<String>) : RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>() {
    inner class OnboardingViewHolder(private val binding: ItemOnboardingBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tip: String) {
            binding.tipText.text = tip
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val binding = ItemOnboardingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OnboardingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        holder.bind(tips[position])
    }

    override fun getItemCount(): Int = tips.size
}

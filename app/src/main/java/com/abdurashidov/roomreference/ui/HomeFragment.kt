package com.abdurashidov.roomreference.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.abdurashidov.roomreference.R
import com.abdurashidov.roomreference.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentHomeBinding.inflate(layoutInflater)
        binding.cards.setOnClickListener {
            findNavController().navigate(R.id.cardFragment)
        }
        binding.transaction.setOnClickListener {
            findNavController().navigate(R.id.transactionFragment)
        }
        return binding.root
    }
}
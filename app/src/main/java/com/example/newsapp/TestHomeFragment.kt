package com.example.newsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsapp.databinding.FragmentHomeBinding
import com.example.newsapp.databinding.FragmentTestHomeBinding


class TestHomeFragment : Fragment() {

    private lateinit var binding: FragmentTestHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentTestHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

}
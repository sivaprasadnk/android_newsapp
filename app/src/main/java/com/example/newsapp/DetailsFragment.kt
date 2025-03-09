package com.example.newsapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.newsapp.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        val newsItem = arguments?.getSerializable("NEWS_ITEM", News::class.java)

        Log.d("details", newsItem.toString())

        // ✅ Set the title if newsItem is not null
        newsItem?.let {
            binding.tvDetailsTitle.text = it.title
            binding.tvDetailsAuthor.text = it.author
            binding.tvDetailsContent.text = it.content
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener {
            it.findNavController().popBackStack()
        }
    }
}

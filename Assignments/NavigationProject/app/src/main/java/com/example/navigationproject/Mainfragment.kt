package com.example.navigationproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.navigationproject.databinding.MainfragmentBinding

class Mainfragment : Fragment() {

    private var _binding: MainfragmentBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        _binding = MainfragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonimage1.setOnClickListener {
            val action: MainfragmentDirections.MainToSecond = MainfragmentDirections.mainToSecond()
            action.label = "Image 1"
            action.imageArg = R.drawable.android_image_1
            Navigation.findNavController(it).navigate(action)
        }
        binding.buttonimage2.setOnClickListener {
            val action: MainfragmentDirections.MainToSecond = MainfragmentDirections.mainToSecond()
            action.label = "Image 2"
            action.imageArg = R.drawable.android_image_2
            Navigation.findNavController(it).navigate(action)
        }
        binding.buttonimage3.setOnClickListener {
            val action: MainfragmentDirections.MainToSecond = MainfragmentDirections.mainToSecond()
            action.label = "Image 3"
            action.imageArg = R.drawable.android_image_3
            Navigation.findNavController(it).navigate(action)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.navigationproject

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import  com.example.navigationproject.databinding.SecondfragmentBinding

class Secondfragment : Fragment() {
    private var _binding: SecondfragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_second, container, false)
        _binding = SecondfragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onStart() {
        super.onStart()
        arguments?.let {
            val args = SecondfragmentArgs.fromBundle(it)
            binding.textView.text = args.label
            binding.imageViewArg.setImageResource(args.imageArg)

        }
    }
}

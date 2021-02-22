package com.canaleal.sample1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.canaleal.sample1.databinding.FragmentFirstBinding
import com.canaleal.sample1.databinding.FragmentSecondBinding
import com.canaleal.sample1.domain.Pet


class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private val args: SecondFragmentArgs by navArgs()
    private lateinit var pet: Pet

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        pet = args.petter
        showPick()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backButton.setOnClickListener {
            val action = SecondFragmentDirections.actionSecondFragmentToFirstFragment()
            findNavController().navigate(action)
        }
    }


    @SuppressLint("SetTextI18n")
    private fun showPick(){

        //Get Robot and Player picks
        val itemBotStr = pet.petType
        val itemPlayerStr = pet.petName

        //Set the messages
        binding.messageBot.text = "Pet Type: $itemBotStr"
        binding.messagePlayer.text = "Name: $itemPlayerStr"


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
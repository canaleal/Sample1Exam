package com.canaleal.sample1.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.canaleal.sample1.ui.SecondFragmentArgs
import com.canaleal.sample1.ui.SecondFragmentDirections
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        if(activity is AppCompatActivity){
            (activity as AppCompatActivity).supportActionBar?.title = "Second"
            (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home ->{
                val action =
                    SecondFragmentDirections.actionSecondFragmentToFirstFragment()
                findNavController().navigate(action)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }



    @SuppressLint("SetTextI18n")
    private fun showPick(){

        val name = pet.petName
        val owner = pet.ownerName
        val isVaccinated = pet.isVaccinated

        //Set the messages
        binding.messagePetName.text = "Name: $name"
        binding.messageOwnerName.text = "Owner: $owner"
        binding.messageIsVaccinated.text = "Vaccinated: $isVaccinated"

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
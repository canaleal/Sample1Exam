package com.canaleal.sample1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.canaleal.sample1.ui.FirstFragmentDirections
import com.canaleal.sample1.R
import com.canaleal.sample1.databinding.FragmentFirstBinding
import com.canaleal.sample1.domain.Pet


class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        binding.sendButton.setOnClickListener { onSend() }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
    }

    private fun onSend(){



        val name = binding.petNameInput.text.toString()
        val owner = binding.petOwnerInput.text.toString()

        if(name == "" || owner=="" ){
            val text = "Name cannot be empty!"
            val duration = Toast.LENGTH_SHORT

            val toast = Toast.makeText(context, text, duration)
            toast.show()
        }
        else{

            val vaccinated = binding.checkBox.isChecked
            val action =
                FirstFragmentDirections.actionFirstFragmentToSecondFragment(
                    Pet(name, owner, vaccinated)
                )
            navController.navigate(action)
        }
    }
}
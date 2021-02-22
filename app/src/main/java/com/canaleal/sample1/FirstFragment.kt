package com.canaleal.sample1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.canaleal.sample1.databinding.FragmentFirstBinding
import com.canaleal.sample1.domain.Pet

/**  val name = binding.petNameInput.text.toString()

//Get the selected game text
val petType = when (binding.messageGroup.checkedRadioButtonId) {
R.id.cat_button -> getString(R.string.cat)
R.id.dog_button -> getString(R.string.dog)
else -> getString(R.string.undefined)
}

val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(Pet(name, petType))
navController.navigate(action)
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private lateinit var navController: NavController

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        binding.sendButton.setOnClickListener { onSend() }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
    }

    private fun onSend(){


    }
}
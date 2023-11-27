package com.example.sanctuary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class PetDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pet_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve the pet details from arguments
        val pet: PetEntity? = arguments?.getSerializable(PET_EXTRA) as? PetEntity

        // Update the views with pet details
        pet?.let {
            nameTextView.text = "Name: ${it.name}"
            speciesTextView.text = "Species: ${it.species}"
            // Update other views as needed
        }
    }

    companion object {
        fun newInstance(pet: PetEntity): PetDetailFragment {
            val fragment = PetDetailFragment()
            val args = Bundle()
            args.putSerializable(PET_EXTRA, pet)
            fragment.arguments = args
            return fragment
        }
    }


}
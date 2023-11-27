package com.example.sanctuary

import android.content.Context
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.slider.Slider
import java.lang.RuntimeException
import java.text.SimpleDateFormat
import java.util.Locale

class UploadFragment : Fragment() {

    private lateinit var editTextName: EditText
    private lateinit var editTextSpecies: EditText
    private lateinit var editTextBreed: EditText
    private lateinit var editTextColor: EditText
    private lateinit var editTextAge: EditText
    private lateinit var editTextOwnerContact: EditText
    private lateinit var editTextLostLocation: EditText
    private lateinit var editTextOtherDetails: EditText

    // Declare Button property
    private lateinit var btnSubmit: Button
    interface onPetEntryListener{
        fun onPetEntryAdded(PetEntry: PetEntity)
    }
    private var listener: onPetEntryListener? = null

    override fun onAttach(context: Context){
        super.onAttach(context)
        if(context is onPetEntryListener){
            listener = context
        } else{
            throw RuntimeException("$context must implement onPetEntryListener")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upload, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSubmit = view.findViewById(R.id.btnSubmit)
        editTextName = view.findViewById(R.id.editTextName)
        editTextSpecies = view.findViewById(R.id.editTextSpecies)
        editTextBreed = view.findViewById(R.id.editTextBreed)
        editTextColor = view.findViewById(R.id.editTextColor)
        editTextAge = view.findViewById(R.id.editTextAge)
        editTextOwnerContact = view.findViewById(R.id.editTextOwnerContact)
        editTextLostLocation = view.findViewById(R.id.editTextLostLocation)
        editTextOtherDetails = view.findViewById(R.id.editTextOtherDetails)

        btnSubmit.setOnClickListener {
            // Retrieve values from EditTexts
            val name = editTextName.text.toString()
            val species = editTextSpecies.text.toString()
            val breed = editTextBreed.text.toString()
            val color = editTextColor.text.toString()
            val age = editTextAge.text.toString().toIntOrNull() ?: -99
            val ownerContact = editTextOwnerContact.text.toString()
            val lostLocation = editTextLostLocation.text.toString()
            val otherDetails = editTextOtherDetails.text.toString()

            // Create a new Pet entity
            val newPet = PetEntity(
                name = name,
                species = species,
                breed = breed,
                color = color,
                age = age,
                ownerContact = ownerContact,
                lostLocation = lostLocation,
                otherDetails = otherDetails
            )
            // Now 'newPet' contains the values from the EditTexts


            listener?.onPetEntryAdded(newPet)

        }
    }
}
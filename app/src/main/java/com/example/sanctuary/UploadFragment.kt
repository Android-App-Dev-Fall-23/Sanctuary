package com.example.sanctuary

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.ImageView
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

    private lateinit var petImageView: ImageView
    private lateinit var selectImgButton: Button

    companion object {
        val IMAGE_REQUEST_CODE = 100
    }


    private lateinit var btnSubmit: Button

    interface onPetEntryListener {
        fun onPetEntryAdded(PetEntry: PetEntity)
    }

    private var listener: onPetEntryListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is onPetEntryListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement onPetEntryListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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

        selectImgButton = view.findViewById(R.id.btnSelectImage)
        petImageView = view.findViewById(R.id.petImageView)

        // Add a click listener to the "Select Image" button
        selectImgButton.setOnClickListener {
            pickImageGallery()
        }

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

            val selectedImageUri = petImageView.tag as? String
            val imagePath = selectedImageUri ?: ""

            // Create a new Pet entity
            if (imagePath.isNotBlank()) {
                // Create a new Pet entity
                val newPet = PetEntity(
                    name = name,
                    species = species,
                    breed = breed,
                    color = color,
                    age = age,
                    ownerContact = ownerContact,
                    lostLocation = lostLocation,
                    otherDetails = otherDetails,
                    imagePath = imagePath
                )

                // Now 'newPet' contains the values from the EditTexts
                listener?.onPetEntryAdded(newPet)
            } else {
                // Handle case where no image is selected
                // Show a message to the user or prevent submission
            }
        }

    }
    private fun pickImageGallery(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK){
            val selectedImageUri = data?.data
            if (selectedImageUri != null) {
                petImageView.setImageURI(selectedImageUri)
                petImageView.tag = selectedImageUri.toString()
            }else {
                // Set a placeholder image when no image is selected
                petImageView.setImageResource(R.drawable.placeholder)
                petImageView.tag = ""
            }
        }

    }
}


    /*private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    // Handle the result of the gallery intent
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            val selectedImageUri = data.data
            imageView.setImageURI(selectedImageUri)

            imageView.tag = selectedImageUri.toString()
        }
    }

}*/

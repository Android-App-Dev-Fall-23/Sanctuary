package com.example.sanctuary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class PetDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pet_detail)

        // Retrieve the pet data from the intent
        val pet: PetEntity = intent.getSerializableExtra(PET_EXTRA) as PetEntity

        // Update the UI with pet details
        val nameTextView: TextView = findViewById(R.id.nameTextView)
        val speciesTextView: TextView = findViewById(R.id.speciesTextView)
        val breedTextView: TextView = findViewById(R.id.breedTextView)
        val colorTextView: TextView = findViewById(R.id.colorTextView)
        val ageTextView: TextView = findViewById(R.id.ageTextView)
        val ownerContactTextView: TextView = findViewById(R.id.ownerContactTextView)
        val lostLocationTextView: TextView = findViewById(R.id.lostLocationTextView)
        val otherDetailsTextView: TextView = findViewById(R.id.otherDetailsTextView)

        // Set text values
        nameTextView.text = "Name: ${pet.name}"
        speciesTextView.text = "Species: ${pet.species}"
        breedTextView.text = "Breed: ${pet.breed}"
        colorTextView.text = "Color: ${pet.color}"
        ageTextView.text = "Age: ${pet.age}"
        ownerContactTextView.text = "Owner Contact: ${pet.ownerContact}"
        lostLocationTextView.text = "Lost Location: ${pet.lostLocation}"
        otherDetailsTextView.text = "Other details: ${pet.otherDetails}"
    }
}

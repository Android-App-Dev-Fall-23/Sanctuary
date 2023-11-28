package com.example.sanctuary

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.bumptech.glide.Glide

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
        val imageView: ImageView = findViewById(R.id.imageView2)

        // Set text values
        nameTextView.text = "Name: ${pet.name}"
        speciesTextView.text = "Species: ${pet.species}"
        breedTextView.text = "Breed: ${pet.breed}"
        colorTextView.text = "Color: ${pet.color}"
        ageTextView.text = "Age: ${pet.age}"
        ownerContactTextView.text = "Owner Contact: ${pet.ownerContact}"
        lostLocationTextView.text = "Lost Location: ${pet.lostLocation}"
        otherDetailsTextView.text = "Other details: ${pet.otherDetails}"

        Glide.with(this)
            .load(pet.imagePath) // Assuming there's an 'imageUrl' property in your PetEntity
            .placeholder(R.drawable.placeholder) // Placeholder image while loading
            .error(R.drawable.placeholder) // Image to show in case of an error
            .into(imageView)

    }
}

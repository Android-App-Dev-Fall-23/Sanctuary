package com.example.sanctuary

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


lateinit var nameTextView: TextView
lateinit var speciesTextView: TextView
lateinit var breedTextView: TextView
lateinit var colorTextView: TextView
lateinit var ageTextView: TextView
lateinit var lostLocationTextView: TextView
lateinit var otherDetailsTextView: TextView





class DetailActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pet_detail)

        val pets: MutableList<Pet>

        nameTextView = findViewById(R.id.nameTextView)
        speciesTextView = findViewById(R.id.speciesTextView)
        breedTextView = findViewById(R.id.breedTextView)
        colorTextView = findViewById(R.id.colorTextView)
        ageTextView = findViewById(R.id.ageTextView)
        lostLocationTextView = findViewById(R.id.lostLocationTextView)
        otherDetailsTextView = findViewById(R.id.otherDetailsTextView)

        val pet = intent.getSerializableExtra(PET_EXTRA) as Pet

        nameTextView.text = pet.name
        speciesTextView.text = pet.species
        breedTextView.text= pet.breed
        colorTextView.text= pet.color
        ageTextView.text  = pet.color
        lostLocationTextView.text= pet.lostLocation
        otherDetailsTextView.text = pet.otherDetails

    }
}
package com.example.sanctuary

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


private lateinit var nameTextView: TextView
private lateinit var speciesTextView: TextView
private lateinit var breedTextView: TextView
private lateinit var colorTextView: TextView
private lateinit var ageTextView: TextView
private lateinit var lostLocationTextView: TextView
private lateinit var otherDetailsTextView: TextView





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
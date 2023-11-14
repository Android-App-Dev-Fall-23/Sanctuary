package com.example.sanctuary

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var pets: MutableList<Pet>   // Variable to store pets as a list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.addItemBtn)  // Look up button in the main activity
        pets = mutableListOf() // Initializes pets as an empty mutable list of Pets (type specified previously)

        val recyclerView = findViewById<RecyclerView>(R.id.lostPetRv)  // Look up recycler in the main activity
        val adapter = PetAdapter(this,pets)    // Create adapter passing in a list of pets
        recyclerView.adapter = adapter  // Attach the adapter to the recycler view
        recyclerView.layoutManager = LinearLayoutManager(this)  // Specify recycler view layout type

        button.setOnClickListener {  // On button click...
            val name = findViewById<EditText>(R.id.nameEditText).text.toString()
            val species = findViewById<EditText>(R.id.speciesEditText).text.toString()
            val breed = findViewById<EditText>(R.id.breedEditText).text.toString()
            val color = findViewById<EditText>(R.id.colorEditText).text.toString()
            val age = findViewById<EditText>(R.id.ageEditText).text.toString().toInt()
            val ownerContact = findViewById<EditText>(R.id.ownerContactEditText).text.toString()
            val lostLocation = findViewById<EditText>(R.id.lostLocationEditText).text.toString()
            val otherDetails = findViewById<EditText>(R.id.otherDetailsEditText).text.toString()

            val pet = Pet(name, species, breed, color, age, ownerContact, lostLocation, otherDetails)
            pets.add(pet)
            adapter.notifyDataSetChanged()
        }
    }
}

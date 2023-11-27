package com.example.sanctuary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

lateinit var entries: MutableList<PetEntity>
lateinit var petDao: PetDao
private lateinit var adapter:PetAdapter

class LostFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lost, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        entries = mutableListOf()
        petDao = AppDatabase.getDatabase(requireContext()).petDao()

        val recyclerView: RecyclerView = view.findViewById(R.id.LostRv)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = PetAdapter(entries)
        recyclerView.adapter = adapter

        lifecycleScope.launch(Dispatchers.IO) {
            requireActivity().application.let { application ->
                // Retrieve entries using a Flow
                val allEntries =
                    (application as Sanctuary).db.petDao().getAllPets()

                // Update UI on the main thread
                withContext(Dispatchers.Main) {
                    allEntries.collect { entriesFromDatabase ->
                        entries.clear()
                        entries.addAll(entriesFromDatabase)

                        adapter.notifyDataSetChanged()
                    }
                }
            }
        }
        adapter.notifyDataSetChanged()
    }
    fun addPetEntry(petEntry: PetEntity){
        // Use coroutine to perform database operation asynchronously
        lifecycleScope.launch(Dispatchers.IO) {

            // Insert the entry into the database
            requireActivity().application.let { application ->

                (application as Sanctuary).db.petDao().insertPet(petEntry)

                // Retrieve entries using a Flow
                val allEntries =
                    (application as Sanctuary).db.petDao().getAllPets()

                // Update UI on the main thread
                allEntries.collect { entriesFromDatabase ->
                    withContext(Dispatchers.Main) {
                        entries.clear()
                        entries.addAll(entriesFromDatabase)
                        adapter.notifyDataSetChanged()
                    }
                }

            }
        }

    }
}
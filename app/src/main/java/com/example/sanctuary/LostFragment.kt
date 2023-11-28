package com.example.sanctuary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

lateinit var entries: MutableList<PetEntity>
lateinit var petDao: PetDao
private lateinit var adapter:PetAdapter
private lateinit var searchView: SearchView

class LostFragment : Fragment() {

    private lateinit var originalEntries: MutableList<PetEntity>
    private lateinit var entries: MutableList<PetEntity>
    private lateinit var petDao: PetDao
    private lateinit var adapter: PetAdapter
    private lateinit var searchView: SearchView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lost, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        originalEntries = mutableListOf() // Store the original data
        entries = mutableListOf()
        petDao = AppDatabase.getDatabase(requireContext()).petDao()

        searchView = view.findViewById(R.id.searchBar)
        val recyclerView: RecyclerView = view.findViewById(R.id.LostRv)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = PetAdapter(entries) { pet ->
            // Handle deletion here
            lifecycleScope.launch(Dispatchers.IO) {
                petDao.deletePet(pet) // Delete from the database

                withContext(Dispatchers.Main) {
                    fetchData() // Refresh the list after deletion
                }
            }// Use the global adapter
        }

        // Set the adapter to the RecyclerView
        recyclerView.adapter = adapter

        // Fetch data initially
        fetchData()

        // Set up search functionality
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    filterEntries(it) // Filter data on query change
                }
                return true
            }
        })
    }

    private fun fetchData() {
        lifecycleScope.launch(Dispatchers.IO) {
            requireActivity().application.let { application ->
                val allEntries = (application as Sanctuary).db.petDao().getAllPets()

                withContext(Dispatchers.Main) {
                    allEntries.collect { entriesFromDatabase ->
                        originalEntries.clear()
                        originalEntries.addAll(entriesFromDatabase)

                        entries.clear()
                        entries.addAll(entriesFromDatabase)

                        adapter.notifyDataSetChanged()
                    }
                }
            }
        }
    }

    private fun filterEntries(query: String) {
        entries.clear()
        originalEntries.filterTo(entries) {
            it.name.contains(query, true) ||
                    it.species.contains(query, true) ||
                    it.lostLocation.contains(query, true)
        }
        adapter.notifyDataSetChanged()
    }
}

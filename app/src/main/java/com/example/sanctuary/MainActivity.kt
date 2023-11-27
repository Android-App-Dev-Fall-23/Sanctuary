package com.example.sanctuary

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(),UploadFragment.onPetEntryListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottomNavigation)




        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_lost -> {
                    val fragment = LostFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
                    true
                }
                R.id.navigation_upload -> {
                    val fragment = UploadFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
                    true
                }
                R.id.navigation_login -> {
                    val fragment = FoundFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
                    true
                }
                else -> false
            }
        }

        if (savedInstanceState == null) {
            replaceFragment(LostFragment())
        }




    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }
        override fun onPetEntryAdded(petEntry: PetEntity) {

        lifecycleScope.launch(Dispatchers.IO) {

            // Insert the entry into the database
            (application as Sanctuary).db.petDao().insertPet(petEntry)

        }
    }
}
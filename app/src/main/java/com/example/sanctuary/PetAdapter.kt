package com.example.sanctuary

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

const val PET_EXTRA = "PET_EXTRA"
class PetAdapter( private val pets: List<PetEntity>) : RecyclerView.Adapter<PetAdapter.PetViewHolder>() {


    inner class PetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTv)
        val speciesTextView: TextView = itemView.findViewById(R.id.speciesTv)
        val lostLocationTextView: TextView = itemView.findViewById(R.id.lostLocationTv)
        val imageView: ImageView= itemView.findViewById(R.id.imageView)
        // Add more views as needed for other attributes

        init {
            // Add a click listener to the itemView
            itemView.setOnClickListener {
                // Get the clicked pet
                val clickedPet = pets[adapterPosition]

                // Create an intent to launch the PetDetailFragment
                val intent = Intent(itemView.context, PetDetailActivity::class.java)
                intent.putExtra(PET_EXTRA, clickedPet)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.lost_pet_item, parent, false)
        return PetViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        val currentPet = pets[position]
        holder.nameTextView.text = "Name: ${currentPet.name}"
        holder.speciesTextView.text = "Species: ${currentPet.species}"
        holder.lostLocationTextView.text = "Last Seen: ${currentPet.lostLocation}"
        // Bind other attributes as needed
        if (!currentPet.imagePath.isNullOrEmpty()) {
            Glide.with(holder.itemView.context)
                .load(currentPet.imagePath)
                .into(holder.imageView)
        } else {

            Glide.with(holder.itemView.context)
                .load(R.drawable.placeholder)
                .into(holder.imageView)
        }
    }

    override fun getItemCount(): Int {
        return pets.size
    }
//    companion object {
//        fun addItemDecoration(recyclerView: RecyclerView) {
//            val layoutManager = LinearLayoutManager(recyclerView.context)
//            recyclerView.layoutManager = layoutManager
//
//            val dividerItemDecoration = DividerItemDecoration(recyclerView.context, layoutManager.orientation)
//            recyclerView.addItemDecoration(dividerItemDecoration)
//        }
    }

private fun Intent.putExtra(petExtra: String, clickedPet: PetEntity) {

}


private fun Intent.putExtra(petExtra: String, pet: Pet) {

}

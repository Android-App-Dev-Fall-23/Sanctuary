package com.example.sanctuary

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

const val PET_EXTRA = "PET_EXTRA"
class PetAdapter(private val context: Context, private val pets: List<Pet>) : RecyclerView.Adapter<PetAdapter.PetViewHolder>() {

    inner class PetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTv)
        val speciesTextView: TextView = itemView.findViewById(R.id.speciesTv)
        val lostLocationTextView: TextView = itemView.findViewById(R.id.lostLocationTv)
        // Add more views as needed for other attributes

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val pet = pets[adapterPosition]
            //Toast.makeText(context, movie.movieTitle,Toast.LENGTH_LONG).show()
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(PET_EXTRA, pet)
            context.startActivity(intent)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.pet_item, parent, false)
        return PetViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        val currentPet = pets[position]
        holder.nameTextView.text = "Name: ${currentPet.name}"
        holder.speciesTextView.text = "Species: ${currentPet.species}"
        holder.lostLocationTextView.text = "Lost Location: ${currentPet.lostLocation}"
        // Bind other attributes as needed
    }

    override fun getItemCount(): Int {
        return pets.size
    }


}

private fun Intent.putExtra(petExtra: String, pet: Pet) {

}

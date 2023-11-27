package com.example.sanctuary

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pets")
data class PetEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    val name: String,
    val species: String,
    val breed: String,
    val color: String,
    val age: Int,
    val ownerContact: String,
    val lostLocation: String,
    val otherDetails: String,
    val imagePath: String

)

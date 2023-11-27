package com.example.sanctuary

class Pet (
    val name: String = "",
    val species: String ="",
    val breed: String ="",
    val color: String ="",
    val age: Int= -99,
    val ownerContact: String= "",
    val lostLocation: String= "",
    val otherDetails: String="",
    val imagePath: String?
)
{
        var found: Boolean = false

    }
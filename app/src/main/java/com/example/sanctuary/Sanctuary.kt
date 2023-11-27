package com.example.sanctuary

import android.app.Application

class Sanctuary: Application() {
    val db by lazy { AppDatabase.getDatabase(this) }
}
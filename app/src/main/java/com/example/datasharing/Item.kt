package com.example.datasharing

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var name: String="",
    var quantity: Int=0,
    var rate: Int=0
)

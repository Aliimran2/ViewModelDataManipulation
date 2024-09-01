package com.example.datasharing

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ItemDao {

    @Delete
    suspend fun delete(item: Item)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Item)

    @Update
    suspend fun updateItem(item: Item)

    @Query("SELECT * FROM items WHERE id = :itemId")
    fun getItemById(itemId: Int): LiveData<Item>

    @Query("SELECT * FROM items")
    fun getAll():LiveData<List<Item>>
}


package com.example.datasharing

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class ItemDataBase:RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object {
        @Volatile
        private var INSTANCE: ItemDataBase? = null

        fun getDatabase(context: Context): ItemDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemDataBase::class.java,
                    "milkFlow_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
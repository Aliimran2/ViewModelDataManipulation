package com.example.datasharing

import androidx.lifecycle.LiveData

class Repository(val itemDao:ItemDao) {

    val allItems :LiveData<List<Item>> = itemDao.getAll()

    suspend fun insetItem(item: Item){
        itemDao.insert(item)
    }

    suspend fun updateItem(item: Item){
        itemDao.updateItem(item)
    }

    suspend fun deleteItem(item: Item){
        itemDao.delete(item)
    }

    fun getItemByIt(id:Int):LiveData<Item>{
        return itemDao.getItemById(id)
    }

}
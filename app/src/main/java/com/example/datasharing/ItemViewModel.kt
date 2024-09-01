package com.example.datasharing

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ItemViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = ItemDataBase.getDatabase(application).itemDao()
    private val repository = Repository(dao)
    val allItems: LiveData<List<Item>> = repository.allItems

    var itemName = ""
    var itemRate = 0
    var itemQuantity = 0

    val itemString = allItems.map { items ->
        formatItem(items)
    }

    fun addItem() {
        viewModelScope.launch {
            val item = Item()
            item.name = itemName
            item.rate = itemRate
            item.quantity = itemQuantity
            repository.insetItem(item)

        }
    }

    fun formatItem(items: List<Item>): String {
        return items.fold("") { str, obj ->
            str + "\n" + formateListItem(obj)
        }
    }

    fun formateListItem(obj: Item): String {
        var str = "ID: ${obj.id}"
        str += "\n" + "Name: ${obj.name}"
        str += "\n" + "Quantity: ${obj.quantity}"
        str += "\n" + "Rate: ${obj.rate}\n\n"
        return str
    }

}

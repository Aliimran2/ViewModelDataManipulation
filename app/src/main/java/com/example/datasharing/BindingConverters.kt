package com.example.datasharing

import androidx.databinding.InverseMethod

object BindingConverters {

    @JvmStatic
    @InverseMethod("stringToInt")
    fun intToString(value: Int?): String {
        return value?.toString() ?: ""
    }

    @JvmStatic
    fun stringToInt(value: String?): Int? {
        return value?.toIntOrNull()
    }
}
package com.example.pichau.drcarango
import Data.Oficina
import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
class OficinasViewModel{
    val oficinas = ObservableArrayList<Oficina>()
    val loadingVisibility = ObservableBoolean(false)
    val message = ObservableField<String>()

    fun load() {
        loadingVisibility.set(true)
        message.set("")

        loadingVisibility.set(false)
    }
}
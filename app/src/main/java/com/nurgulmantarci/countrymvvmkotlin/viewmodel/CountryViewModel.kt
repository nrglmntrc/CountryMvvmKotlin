package com.nurgulmantarci.countrymvvmkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nurgulmantarci.countrymvvmkotlin.model.Country

class CountryViewModel : ViewModel(){

    val countryLiveData= MutableLiveData<Country>()

    fun getDataFromRoom() {
        val country = Country("Turkey","Asia","Ankara","TRY","Turkish","www.ss.com")
        countryLiveData.value = country
    }
}
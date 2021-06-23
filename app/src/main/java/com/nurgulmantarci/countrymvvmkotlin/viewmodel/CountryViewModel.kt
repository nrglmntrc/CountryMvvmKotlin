package com.nurgulmantarci.countrymvvmkotlin.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nurgulmantarci.countrymvvmkotlin.model.Country
import com.nurgulmantarci.countrymvvmkotlin.service.CountryDatabase
import kotlinx.coroutines.launch

class CountryViewModel(application: Application) : BaseViewModel(application){

    val countryLiveData= MutableLiveData<Country>()

    fun getDataFromRoom(uuid: Int){
        launch {
            val dao=CountryDatabase(getApplication()).countryDao()
            val country=dao.getCountry(uuid)
            countryLiveData.value=country
        }
    }

//    fun getDataFromRandom() {
//        val country = Country("Turkey","Asia","Ankara","TRY","Turkish","www.ss.com")
//        countryLiveData.value = country
//    }
}

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nurgulmantarci.countrymvvmkotlin.model.Country
import com.nurgulmantarci.countrymvvmkotlin.service.CountryAPIService
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class FeedViewModel:ViewModel() {

    private val countryApiService=CountryAPIService()
    private val disposable=CompositeDisposable()

    val countries = MutableLiveData<List<Country>>()
    val countryError = MutableLiveData<Boolean>()
    val countryLoading = MutableLiveData<Boolean>()


    fun getDataFromAPI(){
        countryLoading.value=true


    }





//    fun refreshData() {
//
//        val country = Country("Turkey","Asia","Ankara","TRY","Turkish","www.ss.com")
//        val country2 = Country("France","Europe","Paris","EUR","French","www.ss.com")
//        val country3 = Country("Germany","Europe","Berlin","EUR","German","www.ss.com")
//
//        val countryList = arrayListOf<Country>(country,country2,country3)
//
//        countries.value = countryList
//        countryError.value = false
//        countryLoading.value = false
//    }





}
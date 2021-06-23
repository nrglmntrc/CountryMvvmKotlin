package com.nurgulmantarci.countrymvvmkotlin.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.nurgulmantarci.countrymvvmkotlin.R
import com.nurgulmantarci.countrymvvmkotlin.adapter.CountryAdapter
import com.nurgulmantarci.countrymvvmkotlin.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_feed.*


class FeedFragment : Fragment() {

    private lateinit var viewModel: ListViewModel
    private val countryAdapter = CountryAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel=ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.refreshData()

        recyclerviewCountryList.layoutManager=LinearLayoutManager(context)
        recyclerviewCountryList.adapter=countryAdapter

        swipeRefreshLayout.setOnRefreshListener {
            recyclerviewCountryList.visibility=View.GONE
            txtCountryError.visibility=View.GONE
            progressCountryLoading.visibility=View.VISIBLE
            viewModel.refreshFromAPI()
            swipeRefreshLayout.isRefreshing=false
        }


        observeLiveData()

    }

    private fun observeLiveData(){
        viewModel.countries.observe(viewLifecycleOwner, Observer { conturies->
            conturies?.let {
                recyclerviewCountryList.visibility=View.VISIBLE
                countryAdapter.updateCountryList(conturies)
            }
        })

        viewModel.countryError.observe(viewLifecycleOwner, Observer { error ->
            error?.let{
                if(it){
                    txtCountryError.visibility=View.VISIBLE
                    recyclerviewCountryList.visibility=View.GONE

                }else{
                    txtCountryError.visibility=View.GONE
                    recyclerviewCountryList.visibility=View.VISIBLE
                }
            }
        })

        viewModel.countryLoading.observe(viewLifecycleOwner, Observer { loading->
            loading?.let {
                if (it) {
                    progressCountryLoading.visibility = View.VISIBLE
                    recyclerviewCountryList.visibility = View.GONE
                    txtCountryError.visibility = View.GONE
                } else {
                    progressCountryLoading.visibility = View.GONE
                }
            }
        })


    }


}
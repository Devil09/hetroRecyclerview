package com.example.mvvmretrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hetrogenousrecyclerview.models.User
import java.util.*

class MainActivityViewModel : ViewModel() {

    lateinit var liveDataList: MutableLiveData<ArrayList<Any>>

    init {
        liveDataList = MutableLiveData()
    }


    fun getLiveDataObserver(): MutableLiveData<ArrayList<Any>> {
        return liveDataList;
    }


    fun getSampleArrayList()  {
        val items: ArrayList<Any> = ArrayList()
        items.add(User("Dany Targaryen", "Valyria"))
        items.add(User("Rob Stark", "Winterfell"))
        items.add("image")
        items.add(User("Jon Snow", "Castle Black"))
        items.add("image")
        items.add(User("Tyrion Lanister", "King's Landing"))
        liveDataList.postValue(items)
    }
}
package com.example.hetrogenousrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hetrogenousrecyclerview.adapter.ComplexRecyclerViewAdapter
import com.example.hetrogenousrecyclerview.models.User
import com.example.mvvmretrofit.viewmodel.MainActivityViewModel
import java.util.ArrayList


class MainActivity : AppCompatActivity() {

    lateinit var recyclerViewAdapter : ComplexRecyclerViewAdapter

    lateinit var recyclerView : RecyclerView
    //


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.recyclerView) as RecyclerView


        recyclerview()
        initializeViewModel()


    }

    fun recyclerview() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerViewAdapter = ComplexRecyclerViewAdapter()
        recyclerView.adapter = recyclerViewAdapter
    }

    private fun initializeViewModel(){
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this , {
            if (it != null){
                recyclerViewAdapter.setList(it)
                recyclerViewAdapter.notifyDataSetChanged()
            }
            else{
                System.out.println("No Data")
            }
        })

        viewModel.getSampleArrayList()
    }


}
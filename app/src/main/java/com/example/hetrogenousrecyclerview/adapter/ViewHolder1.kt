package com.example.hetrogenousrecyclerview.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hetrogenousrecyclerview.R

class ViewHolder1(v: View) : RecyclerView.ViewHolder(v) {
    var label1: TextView
    var label2: TextView

    init {
        label1 = v.findViewById(R.id.text1)
        label2 = v.findViewById(R.id.text2)
    }
}
package com.example.hetrogenousrecyclerview.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hetrogenousrecyclerview.R


class RecyclerViewSimpleTextViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var simpleLabel: TextView

    init {

        simpleLabel = view.findViewById(R.id.simpletext)

    }
}

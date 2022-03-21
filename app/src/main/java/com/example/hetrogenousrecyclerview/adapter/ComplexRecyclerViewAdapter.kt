package com.example.hetrogenousrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hetrogenousrecyclerview.R
import com.example.hetrogenousrecyclerview.models.User


class ComplexRecyclerViewAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val USER = 0
    private val IMAGE = 1

    private var items : List<Any>? = null


    fun setList(countryList : List<Any>?){
        this.items = countryList
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return items!!.size
    }

    override fun getItemViewType(position: Int): Int {
        //More to come
        if (items?.get(position) is User) {
            return USER
        } else if (items?.get(position) is String) {
            return IMAGE
        }
        return -1
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder: RecyclerView.ViewHolder
        val inflater = LayoutInflater.from(viewGroup.context)
        when (viewType) {
            USER -> {
                val v1: View = inflater.inflate(R.layout.layout_viewholder1, viewGroup, false)
                viewHolder = ViewHolder1(v1)
            }
            IMAGE -> {
                val v2: View = inflater.inflate(R.layout.layout_viewholder2, viewGroup, false)
                viewHolder = ViewHolder2(v2)
            }
            else -> {
                val v: View = inflater.inflate(R.layout.simple_list_item_1, viewGroup, false)
                viewHolder = RecyclerViewSimpleTextViewHolder(v)
            }
        }
        return viewHolder
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        when (viewHolder.itemViewType) {
            USER -> {
                val vh1 = viewHolder as ViewHolder1
                configureViewHolder1(vh1, position)
            }
            IMAGE -> {
                val vh2 = viewHolder as ViewHolder2
                configureViewHolder2(vh2)
            }
            else -> {
                val vh: RecyclerViewSimpleTextViewHolder =
                    viewHolder as RecyclerViewSimpleTextViewHolder
                configureDefaultViewHolder(vh, position)
            }
        }
    }

    private fun configureDefaultViewHolder(vh: RecyclerViewSimpleTextViewHolder, position: Int) {

        vh.simpleLabel.text = "Simple name"
    }

    private fun configureViewHolder1(vh1: ViewHolder1, position: Int) {
        val user = items?.get(position) as User
        if (user != null) {
            vh1.label1.text = "Name: " + user.userName
            vh1.label2.text = "Hometown: " + user.location
        }
    }

    private fun configureViewHolder2(vh2: ViewHolder2) {
        vh2.imageView.setImageResource(R.drawable.sample_golden_gate)
    }
}


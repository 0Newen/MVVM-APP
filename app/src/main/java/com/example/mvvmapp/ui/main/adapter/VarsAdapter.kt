package com.example.mvvmapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmapp.R
import com.example.mvvmapp.data.model.AcronymBaseLf
import com.example.mvvmapp.data.model.AcronymLfs
import kotlinx.android.synthetic.main.item_layout.view.*

class VarsAdapter(private val vars: ArrayList<AcronymBaseLf>) :
    RecyclerView.Adapter<VarsAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(vars: AcronymBaseLf) {
            itemView.tv_main.text = vars.lf
            itemView.tv_frequency.text = vars.freq.toString()
            itemView.tv_since.text = vars.since.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_vars_layout, parent,
                false
            )
        )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(vars[position])

    override fun getItemCount(): Int = vars.size

    fun addData(vars: ArrayList<AcronymBaseLf>){
        vars.clear()
        vars.addAll(vars)
    }
}
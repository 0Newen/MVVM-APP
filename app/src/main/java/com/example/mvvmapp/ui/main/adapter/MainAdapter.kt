package com.example.mvvmapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmapp.R
import com.example.mvvmapp.data.model.Acronym
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter(private val acronym: ArrayList<Acronym>) :
    RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    private lateinit var onClickListener: OnClickListener

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(acronym: Acronym) {
            itemView.tv_main.text = acronym.sf
            itemView.tv_since.visibility=View.GONE
            itemView.tv_frequency.visibility=View.INVISIBLE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(acronym[position])
        holder.itemView.setOnClickListener {
            onClickListener.onclick(position, acronym)
        }
    }


    override fun getItemCount(): Int = acronym.size

    fun addDta(list: List<Acronym>) {
        acronym.clear()
        acronym.addAll(list)
    }

    interface OnClickListener{
        fun onclick(position: Int,acronym: ArrayList<Acronym>)
    }

    fun setOnClickListener(onClickListener: OnClickListener){
        this.onClickListener=onClickListener
    }
}
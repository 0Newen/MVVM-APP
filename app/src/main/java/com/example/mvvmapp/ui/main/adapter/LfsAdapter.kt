package com.example.mvvmapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmapp.R
import com.example.mvvmapp.data.model.Acronym
import com.example.mvvmapp.data.model.AcronymLfs
import kotlinx.android.synthetic.main.item_layout.view.*

class LfsAdapter(private val lfs: ArrayList<AcronymLfs>) :
    RecyclerView.Adapter<LfsAdapter.DataViewHolder>() {

    private lateinit var onClickListener: OnClickListener

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(lfs: AcronymLfs) {
            itemView.tv_main.text = lfs.lf
            itemView.tv_frequency.text = lfs.freq.toString()
            itemView.tv_since.text = lfs.since.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_lfs_layout, parent,
                false
            )
        )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(lfs[position])
        holder.itemView.setOnClickListener {
            onClickListener.onclick(position, lfs)
        }

    }


    override fun getItemCount(): Int = lfs.size

    interface OnClickListener {
        fun onclick(position: Int, lfs: ArrayList<AcronymLfs>)
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    fun addLfs(lfs: ArrayList<AcronymLfs>){
        lfs.clear()
        lfs.addAll(lfs)
    }
}
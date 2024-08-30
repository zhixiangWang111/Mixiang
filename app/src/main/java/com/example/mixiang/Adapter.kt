package com.example.mixiang

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class KepuAdapter(private val columnDataList: List<ColumnData>) :
    RecyclerView.Adapter<KepuAdapter.ColumnViewHolder>() {

    class ColumnViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.columnText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColumnViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.column_item, parent, false)

        return ColumnViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ColumnViewHolder, position: Int) {
        val columnData = columnDataList[position]
        holder.textView.text = columnData.textContent
    }

    override fun getItemCount(): Int {
        return columnDataList.size

    }
}

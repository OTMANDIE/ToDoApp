package com.example.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(private val itemList: MutableList<TaskData>): RecyclerView.Adapter<TaskAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.findViewById(R.id.textView1)
        val textView2: TextView = itemView.findViewById(R.id.textView2)
        val textView3: TextView = itemView.findViewById(R.id.textView3)
        val textView4: TextView = itemView.findViewById(R.id.textView4)
        val button3: Button = itemView.findViewById(R.id.button3)
    }
    fun removeItem(position: Int) {
        itemList.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, itemCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.textView1.text = item.title
        holder.textView2.text = item.priority.toString()
        holder.textView3.text = item.description
        holder.textView4.text = item.endDate
        holder.button3.setOnClickListener {
            removeItem(position)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun getTaskList(): List<TaskData> {
        return itemList
    }
}
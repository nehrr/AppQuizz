package com.example.quizz

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.question_list_item.view.*

class QuestionAdapter(val items: MutableList<Question>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.question_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.question.text = items[position]?.question
        holder.a1.text = items[position]?.a1
        holder.a2.text = items[position]?.a2
        holder.a3.text = items[position]?.a3
        holder.deleteButton.setOnClickListener({ view -> removeItem(holder.adapterPosition) })
    }

    fun removeItem(position: Int) {
        Questions.map.removeAt(position)
        this.notifyDataSetChanged()
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val question = view.question
    val a1 = view.a1
    val a2= view.a2
    val a3 = view.a3
    val deleteButton = view.deleteButton
}

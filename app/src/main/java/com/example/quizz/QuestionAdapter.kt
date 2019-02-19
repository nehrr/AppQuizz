package com.example.quizz

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
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

        if (items[position]?.solution == "a1") {
            holder.a1.setTextColor(Color.parseColor("#22722c"))
            holder.a1.setTypeface(Typeface.DEFAULT_BOLD)
        }

        if (items[position]?.solution == "a2") {
            holder.a2.setTextColor(Color.parseColor("#22722c"))
            holder.a2.setTypeface(Typeface.DEFAULT_BOLD)
        }

        if (items[position]?.solution == "a3") {
            holder.a3.setTextColor(Color.parseColor("#22722c"))
            holder.a3.setTypeface(Typeface.DEFAULT_BOLD)
        }

        holder.deleteButton.setOnClickListener({ view -> removeItem(holder.adapterPosition, holder) })
    }

    fun removeItem(position: Int, holder: ViewHolder) {
        Questions.map.removeAt(position)
        holder.a1.setTextColor(Color.parseColor("#808080"))
        holder.a2.setTextColor(Color.parseColor("#808080"))
        holder.a2.setTextColor(Color.parseColor("#808080"))
        holder.a1.setTypeface(Typeface.DEFAULT)
        holder.a2.setTypeface(Typeface.DEFAULT)
        holder.a3.setTypeface(Typeface.DEFAULT)

        if (items[position]?.solution == "a1") {
            holder.a1.setTextColor(Color.parseColor("#22722c"))
            holder.a1.setTypeface(Typeface.DEFAULT_BOLD)
        }

        if (items[position]?.solution == "a2") {
            holder.a2.setTextColor(Color.parseColor("#22722c"))
            holder.a2.setTypeface(Typeface.DEFAULT_BOLD)
        }

        if (items[position]?.solution == "a3") {
            holder.a3.setTextColor(Color.parseColor("#22722c"))
            holder.a3.setTypeface(Typeface.DEFAULT_BOLD)
        }

        this.notifyDataSetChanged()
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val question = view.question
    val a1 = view.a1
    val a2 = view.a2
    val a3 = view.a3
    val deleteButton = view.deleteButton
}

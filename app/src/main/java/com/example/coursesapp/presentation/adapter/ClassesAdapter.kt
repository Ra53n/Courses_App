package com.example.coursesapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coursesapp.R
import com.example.coursesapp.databinding.NextClassItemBinding
import com.example.coursesapp.presentation.model.ClassUiModel

class ClassesAdapter() : RecyclerView.Adapter<ClassesAdapter.ClassesViewHolder>() {

    private var classes: List<ClassUiModel> = emptyList()

    fun setItems(classes: List<ClassUiModel>) {
        this.classes = classes
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassesViewHolder {
        return ClassesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.next_class_item, parent, false)
        )
    }

    override fun getItemCount() = classes.size

    override fun onBindViewHolder(holder: ClassesViewHolder, position: Int) {
        holder.bind(classes[position])
    }

    inner class ClassesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = NextClassItemBinding.bind(view)
        fun bind(clazz: ClassUiModel) {
            binding.image.setImageResource(clazz.icon)
            binding.title.text = clazz.clazz
            binding.time.text = clazz.duration
        }
    }
}
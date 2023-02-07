package com.example.coursesapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coursesapp.R
import com.example.coursesapp.databinding.HomeworkItemBinding
import com.example.coursesapp.presentation.model.HomeworkUiModel

class HomeworkAdapter() : RecyclerView.Adapter<HomeworkAdapter.HomeworkViewHolder>() {

    private var homeworks: List<HomeworkUiModel> = emptyList()

    fun setItems(homeworks: List<HomeworkUiModel>) {
        this.homeworks = homeworks
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeworkViewHolder {
        return HomeworkViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.homework_item, parent, false)
        )
    }

    override fun getItemCount() = homeworks.size

    override fun onBindViewHolder(holder: HomeworkViewHolder, position: Int) {
        holder.bind(homeworks[position])
    }

    inner class HomeworkViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = HomeworkItemBinding.bind(view)

        fun bind(homework: HomeworkUiModel) {
            binding.classTitle.text = homework.clazz
            binding.image.setImageResource(homework.icon)
            binding.homework.text = homework.homework
            binding.timeLeft.text = homework.daysLeft
        }
    }
}
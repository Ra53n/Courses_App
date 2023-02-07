package com.example.coursesapp.domain.model

import com.example.coursesapp.R

enum class Clazz(val className: String, val iconId: Int) {
    History("History", R.drawable.bow_and_arrow),
    Literature("Literature", R.drawable.books),
    PhysicalEducation("PhysicalEducation", R.drawable.basketball),
    Math("Math", R.drawable.triangular_ruler)
}
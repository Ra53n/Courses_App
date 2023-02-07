package com.example.coursesapp.data.repository

import com.example.coursesapp.domain.model.HomeworkEntity

interface HomeworkRepository {
    fun getHomeworks(): List<HomeworkEntity>
}
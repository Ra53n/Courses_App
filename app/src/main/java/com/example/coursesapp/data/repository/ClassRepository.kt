package com.example.coursesapp.data.repository

import com.example.coursesapp.domain.model.ClassEntity

interface ClassRepository {
    fun getClasses(): List<ClassEntity>
}
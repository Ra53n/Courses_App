package com.example.coursesapp.data.repository

import com.example.coursesapp.domain.model.ClassEntity
import com.example.coursesapp.domain.model.Clazz

class ClassLocalRepositoryImpl : ClassRepository {
    override fun getClasses() = listOf(
        ClassEntity(
            clazz = Clazz.History,
            lessonBeginningTime = "8:00",
            lessonEndingTime = "8:45"
        ),
        ClassEntity(
            clazz = Clazz.Literature,
            lessonBeginningTime = "9:00",
            lessonEndingTime = "9:45"
        ),
        ClassEntity(
            clazz = Clazz.Math,
            lessonBeginningTime = "10:00",
            lessonEndingTime = "10:45"
        ),
        ClassEntity(
            clazz = Clazz.PhysicalEducation,
            lessonBeginningTime = "11:15",
            lessonEndingTime = "12:00"
        )
    )
}
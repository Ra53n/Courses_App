package com.example.coursesapp.presentation.mapper

import android.content.res.Resources
import com.example.coursesapp.R
import com.example.coursesapp.domain.model.ClassEntity
import com.example.coursesapp.presentation.model.ClassUiModel

class ClassEntityToUiModelMapper(private val resources: Resources) {
    fun map(entity: ClassEntity) = with(entity) {
        ClassUiModel(
            clazz = clazz.className,
            duration = resources.getString(
                R.string.duration,
                lessonBeginningTime,
                lessonEndingTime
            ),
            icon = clazz.iconId
        )
    }
}
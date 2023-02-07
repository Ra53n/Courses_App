package com.example.coursesapp.presentation.mapper

import android.content.res.Resources
import com.example.coursesapp.R
import com.example.coursesapp.domain.model.HomeworkEntity
import com.example.coursesapp.presentation.model.HomeworkUiModel

class HomeworkEntityToUiModelMapper(private val resources: Resources) {
    fun map(entity: HomeworkEntity) =
        with(entity) {
            HomeworkUiModel(
                clazz = clazz.className,
                daysLeft = resources.getString(R.string.days_left, daysLeft),
                icon = clazz.iconId,
                homework = homework
            )
        }
}
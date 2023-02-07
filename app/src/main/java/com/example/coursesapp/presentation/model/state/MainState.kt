package com.example.coursesapp.presentation.model.state

import com.example.coursesapp.presentation.model.ClassUiModel
import com.example.coursesapp.presentation.model.HomeworkUiModel
import com.example.coursesapp.presentation.model.TimerUiModel

data class MainState(
    val todayClasses: List<ClassUiModel> = emptyList(),
    val classesToday: Int? = null,
    val homeworks: List<HomeworkUiModel> = emptyList(),
    val timer: TimerUiModel? = null,
    val examStarted: Boolean = false
)

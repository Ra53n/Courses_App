package com.example.coursesapp.presentation.model.event

sealed class MainEvent {
    object ExamStartAlertShowed : MainEvent()
}
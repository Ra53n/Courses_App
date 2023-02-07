package com.example.coursesapp.presentation.viewModel

import android.os.CountDownTimer
import androidx.lifecycle.ViewModel
import com.example.coursesapp.data.repository.ClassRepository
import com.example.coursesapp.data.repository.HomeworkRepository
import com.example.coursesapp.presentation.mapper.ClassEntityToUiModelMapper
import com.example.coursesapp.presentation.mapper.HomeworkEntityToUiModelMapper
import com.example.coursesapp.presentation.model.TimerUiModel
import com.example.coursesapp.presentation.model.event.MainEvent
import com.example.coursesapp.presentation.model.state.MainState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MainViewModel(
    private val classRepository: ClassRepository,
    private val homeworkRepository: HomeworkRepository,
    private val classMapper: ClassEntityToUiModelMapper,
    private val homeworkMapper: HomeworkEntityToUiModelMapper
) : ViewModel() {

    private val viewState = MutableStateFlow(MainState())

    val viewStateObserve: StateFlow<MainState>
        get() = viewState

    init {
        loadData()
        startCountDownTimer()
    }

    fun sendEvent(event: MainEvent) {
        if (event is MainEvent.ExamStartAlertShowed) {
            viewState.update { viewState.value.copy(examStarted = false) }
        }
    }

    private fun startCountDownTimer() {
        object : CountDownTimer(259200000L, 60000) {
            override fun onTick(millis: Long) {
                val days = millis.div(86_400_000L)
                val hours = millis.div(3600_000L) - days * 24
                val minutes = millis.div(60000) - days * 24 * 60 - hours * 60

                updateTimer(
                    days = days.toString(),
                    hours = hours.toString(),
                    minutes = minutes.toString()
                )
            }

            override fun onFinish() {
                viewState.update { viewState.value.copy(examStarted = true) }
            }

        }.start()
    }

    private fun updateTimer(days: String, hours: String, minutes: String) {
        val daysPair = getTimePair(days)
        val hoursPair = getTimePair(hours)
        val minutesPair = getTimePair(minutes)
        viewState.update {
            viewState.value.copy(
                timer = TimerUiModel(
                    daysFirst = daysPair.first,
                    daysSecond = daysPair.second,
                    hoursFirst = hoursPair.first,
                    hoursSecond = hoursPair.second,
                    minutesFirst = minutesPair.first,
                    minutesSecond = minutesPair.second
                )
            )
        }
    }

    private fun getTimePair(time: String): Pair<String, String> {
        val timeChars = time.toCharArray()
        return if (timeChars.size == 2) {
            Pair(timeChars[0].toString(), timeChars[1].toString())
        } else {
            Pair("0", timeChars[0].toString())
        }
    }


    private fun loadData() {
        viewState.update {
            val todayClasses = classRepository.getClasses().map { clazz -> classMapper.map(clazz) }
            viewState.value.copy(
                todayClasses = todayClasses,
                classesToday = todayClasses.size,
                homeworks = homeworkRepository.getHomeworks()
                    .map { homework -> homeworkMapper.map(homework) }
            )
        }
    }
}
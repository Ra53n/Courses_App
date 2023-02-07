package com.example.coursesapp.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.coursesapp.R
import com.example.coursesapp.databinding.MainFragmentBinding
import com.example.coursesapp.presentation.adapter.ClassesAdapter
import com.example.coursesapp.presentation.adapter.HomeworkAdapter
import com.example.coursesapp.presentation.model.TimerUiModel
import com.example.coursesapp.presentation.model.event.MainEvent
import com.example.coursesapp.presentation.viewModel.MainViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModel()

    private val classesAdapter by lazy { ClassesAdapter() }

    private val homeworkAdapter by lazy { HomeworkAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextClass.adapter = classesAdapter
        binding.homeworks.adapter = homeworkAdapter
        observeUiState()
    }

    private fun observeUiState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.viewStateObserve.collect { state ->
                classesAdapter.setItems(state.todayClasses)
                homeworkAdapter.setItems(state.homeworks)
                binding.classesTotal.text =
                    resources.getString(R.string.classes_today, state.classesToday)
                state.timer?.let {
                    updateTimer(it)
                }
                if (state.examStarted) {
                    showExamStartedAlert()
                }
            }
        }
    }

    private fun showExamStartedAlert() {
        Toast.makeText(requireContext(), getString(R.string.exam_started), Toast.LENGTH_SHORT)
            .show()
        viewModel.sendEvent(MainEvent.ExamStartAlertShowed)
    }

    private fun updateTimer(timer: TimerUiModel) {
        with(binding) {
            daysFirst.text = timer.daysFirst
            daysSecond.text = timer.daysSecond
            hoursFirst.text = timer.hoursFirst
            hoursSecond.text = timer.hoursSecond
            minutesFirst.text = timer.minutesFirst
            minutesSecond.text = timer.minutesSecond
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.coursesapp.data.repository

import com.example.coursesapp.domain.model.Clazz
import com.example.coursesapp.domain.model.HomeworkEntity

class HomeworkLocalRepositoryImpl : HomeworkRepository {
    override fun getHomeworks() = listOf(
        HomeworkEntity(
            clazz = Clazz.History,
            daysLeft = 3,
            homework = "Learn about 20's century"
        ),
        HomeworkEntity(
            clazz = Clazz.Literature,
            daysLeft = 2,
            homework = "Read scenes 1.1-1.12 of The Master and Margarita"
        ),
        HomeworkEntity(
            clazz = Clazz.Math,
            daysLeft = 6,
            homework = "Do exercise 35 and 36"
        )
    )
}
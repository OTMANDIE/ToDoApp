package com.example.todoapp

import java.io.Serializable

data class TaskData(
    val title: String,
    val description: String,
    val priority: Priority,
    val endDate: String
):Serializable

enum class Priority {
    HIGH,
    MEDIUM,
    LOW
}
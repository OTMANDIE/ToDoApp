package com.example.todoapp

data class Task(
    val title: String,
    val description: String,
    val priority: Priority,
    val endDate: String
)

enum class Priority {
    HIGH,
    MEDIUM,
    LOW
}
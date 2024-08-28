package com.example.daylog.data.modals

data class TaskItemData(
    val date: String,
    val day: String,
    val title: String,
    val description: String,
    val tag: String,
    val emojiResId: Int // Resource ID for the emoji drawable
)

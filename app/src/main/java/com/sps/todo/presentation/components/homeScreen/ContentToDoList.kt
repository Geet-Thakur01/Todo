package com.sps.todo.presentation.components.homeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.sps.todo.presentation.viewmodels.MainActivityViewModel

@Composable
fun ContentToDoList(
    paddingValues: PaddingValues,
    viewModel: MainActivityViewModel
) {
    val todoList by viewModel.todoList.collectAsState()

    if (todoList.isEmpty()) {
        ShowEmptyScreen()
    }else{
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            if (todoList.isEmpty()) {
                ShowEmptyScreen()
            }
            todoList.forEach { todoItem ->
                TodoListItem(todoItem = todoItem)
            }
        }
    }
}
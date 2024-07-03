package com.sps.todo.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sps.todo.data.models.Todo
import com.sps.todo.domain.usecases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(private val useCases: UseCases) : ViewModel() {

    private val _todoList = MutableStateFlow<List<Todo>>(emptyList())
    val todoList: StateFlow<List<Todo>> get() = _todoList

    init {
        getTodoList()
    }

    private fun getTodoList() {
        viewModelScope.launch {
            val result = viewModelScope.async(Dispatchers.IO) {
                useCases.todoListUseCase.excecute()
            }
            withContext(Dispatchers.Main) {
                _todoList.value = result.await()
                println(_todoList.value)
            }
        }
    }

    fun addTodoItem(text: String) {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.insertTodoUseCase.excecute(Todo(text = text))
        }
    }
}
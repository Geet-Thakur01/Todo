package com.sps.todo.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sps.todo.data.models.Todo
import com.sps.todo.domain.usecases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(private val useCases: UseCases) : ViewModel() {

    private val _todoList = MutableStateFlow<List<Todo>>(emptyList())
    val todoList: StateFlow<List<Todo>> get() = _todoList

    private val _snackBarError = MutableStateFlow("")
    val snackBarError get() = _snackBarError

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        Log.e("TaskViewModel", "Coroutine exception: $exception")
    }
    init {
        getTodoList()
    }

    private fun getTodoList() {
        viewModelScope.launch(coroutineExceptionHandler) {
            useCases.todoListUseCase.excecute().collect { toDOList ->
                _todoList.value = toDOList
            }
        }
    }
    fun addTodoItem(text: String) {
        if(text.isEmpty() || text.lowercase()=="error"){
            _snackBarError.value="Please enter valid String"
            return
        }
        viewModelScope.launch(Dispatchers.IO) {
            delay(2000)
            useCases.insertTodoUseCase.excecute(Todo(text = text))
        }
    }
}
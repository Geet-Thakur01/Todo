package com.sps.todo.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sps.todo.data.models.Todo
import com.sps.todo.domain.usecases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(private val useCases: UseCases) : ViewModel() {

    private val _todoList = MutableLiveData<List<Todo>>()
    val todoList: LiveData<List<Todo>> get() = _todoList

    fun getTodoList() {
        viewModelScope.launch {
            val todoList = useCases.todoListUseCase.excecute()
            _todoList.value=todoList
        }
    }

    fun addTodoItem(text:String){
        viewModelScope.launch(Dispatchers.IO) {
            useCases.insertTodoUseCase.excecute(Todo(text = text))
        }
    }
}
package com.sps.todo.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sps.todo.data.models.Todo
import com.sps.todo.domain.usecases.Useases
import kotlinx.coroutines.launch


class MainActivityViewModel : ViewModel() {
    val useases = Useases()

    private val _todoList = MutableLiveData<List<Todo>>()
    val todoList: LiveData<List<Todo>> get() = _todoList

    fun getTodoList() {
        viewModelScope.launch {
            val todoList = useases.todoListUseCase.excecute()
            _todoList.value=todoList
        }
    }

    fun addTodoItem(text:String){
        viewModelScope.launch {
//            useases.insertTodoUseCase.excecute()
        }
    }
}
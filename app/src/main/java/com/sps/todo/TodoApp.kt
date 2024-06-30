package com.sps.todo

import android.app.Application
import androidx.room.Room
import com.sps.todo.data.db.AppDataBase


//@HiltAndroidApp
class TodoApp:Application(){
    companion object {
        lateinit var database: AppDataBase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java,
            "todo_db"
        ).build()
    }
}
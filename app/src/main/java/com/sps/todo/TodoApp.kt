package com.sps.todo

import android.app.Application
import androidx.room.Room
import com.sps.todo.data.db.AppDataBase
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class TodoApp:Application()
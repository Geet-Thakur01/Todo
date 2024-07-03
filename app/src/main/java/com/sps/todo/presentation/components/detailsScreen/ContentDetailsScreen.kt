package com.sps.todo.presentation.components.detailsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sps.todo.presentation.viewmodels.MainActivityViewModel

@Composable
fun ContentDetailsScreen(
    innerPadding: PaddingValues,
    viewModel: MainActivityViewModel,
    addButtonAction: () -> Unit
) {
    var text by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .padding(top = 20.dp)
            .fillMaxSize()
    ) {
        TextField(
            value = text,
            onValueChange = { newText -> text = newText },
            label = { Text("Enter todo item") }
        )
        Spacer(modifier = Modifier.height(20.dp))
        ElevatedButton(onClick = {
            viewModel.addTodoItem(text)
            addButtonAction.invoke()
        }) {
            Text(text = "Add ToDo")
        }
    }
}
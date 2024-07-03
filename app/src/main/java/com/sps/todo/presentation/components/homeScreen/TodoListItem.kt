package com.sps.todo.presentation.components.homeScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sps.todo.data.models.Todo

@Composable
fun TodoListItem(
    modifier: Modifier = Modifier,
    todoItem: Todo
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(2.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onPrimary),
        modifier = Modifier.padding(2.dp).fillMaxWidth()
    ) {
        Text(text = todoItem.text,
            modifier = modifier.padding(10.dp))
    }
}
package com.sps.todo.presentation.components.detailsScreen

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.sps.todo.R
import com.sps.todo.presentation.viewmodels.MainActivityViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    navController: NavHostController,
    viewModel: MainActivityViewModel,
) {
    val addButtonAction:()->Unit={navController.navigateUp()}
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(stringResource(id = R.string.app_name))
                }
            )
        },
    ) { innerPadding ->
        ContentDetailsScreen(innerPadding, viewModel,addButtonAction)
    }
}
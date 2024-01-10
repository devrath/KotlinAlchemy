package com.istudio.app.modules.module_exercises.exercise_1

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.istudio.app.ui.composables.AppButton
import com.istudio.app.utils.endpoints.EndPointSimulation
import com.istudio.app.utils.log.ThreadInfoLogger.logThreadInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Exercise1(navController: NavHostController){

    val viewModel: Exercise1vm = hiltViewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        var currentValue by remember { mutableStateOf("") }
        var isActionButtonEnabled by remember { mutableStateOf(false) }

        val keyboardController = LocalSoftwareKeyboardController.current

        OutlinedTextField(
            value = currentValue,
            onValueChange = {
                currentValue = it
                // Enable it if there are data entered in the input field
                if(!currentValue.isNullOrBlank()){ isActionButtonEnabled = true }
            },
            label = { Text(text = "Enter a value")},
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { keyboardController?.hide() }
            ),

        )

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(
            text = "ACTION",
            isEnabled = isActionButtonEnabled,
            onClick = {
                logThreadInfo("button callback")
                isActionButtonEnabled = false

                CoroutineScope(Dispatchers.Default).launch {
                    // -------> Observe here since the long running operation is performed on separate task, UI is not blocked
                    val repo = EndPointSimulation.endPointCall("12")
                    Log.d("endpoint","Reputation:->$repo")
                }

                isActionButtonEnabled = true
            }
        )


    }

}
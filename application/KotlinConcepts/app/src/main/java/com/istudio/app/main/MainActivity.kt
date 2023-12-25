package com.istudio.app.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.istudio.app.modules.module_demos.basic_fundamentals.ui.KotlinBasicsDemo
import com.istudio.app.modules.module_demos.channels.ChannelsDemo
import com.istudio.app.modules.module_demos.flows.FlowsDemo
import com.istudio.app.modules.module_demos.flows.modules.flow_basics.chapters.display_data_from_server.DisplayDataFromServerDemo
import com.istudio.app.modules.module_demos.flows.modules.flow_basics.ui.FlowBasics
import com.istudio.app.modules.module_demos.higher_order_functions.ui.HigherOrderFunctionDemo
import com.istudio.app.modules.module_demos.kotlin_annotations.ui.KotlinAnnotationsDemo
import com.istudio.app.modules.module_demos.sealed_class.ui.SealedClassDemo
import com.istudio.app.modules.module_selection.ModuleDemo
import com.istudio.app.modules.module_selection.ModuleSelectionScreen
import com.istudio.app.ui.theme.KotlinConceptsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinConceptsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = ModuleDemo.FlowBasics.rout
                    ) {
                        // Selection Screen
                        composable(ModuleDemo.DemoSelection.rout) {
                            ModuleSelectionScreen(navController = navController)
                        }
                        // Kotlin basics Screen
                        composable(ModuleDemo.KotlinBasicsDemo.rout) {
                            KotlinBasicsDemo(navController = navController)
                        }
                        // Channel demo
                        composable(ModuleDemo.ChannelsDemo.rout) {
                            ChannelsDemo(navController = navController)
                        }
                        // Sealed Class demo
                        composable(ModuleDemo.SealedClassDemo.rout) {
                            SealedClassDemo(navController = navController)
                        }
                        // Higher Order functions demo
                        composable(ModuleDemo.HigherOrderFunctions.rout) {
                            HigherOrderFunctionDemo(navController = navController)
                        }
                        // Kotlin Annotations demo
                        composable(ModuleDemo.AnnotationsInKotlin.rout) {
                            KotlinAnnotationsDemo(navController = navController)
                        }
                        // Kotlin Flow Selection
                        composable(ModuleDemo.FlowsSelection.rout) {
                            FlowsDemo(navController = navController)
                        }
                        // Flow Basics
                        composable(ModuleDemo.FlowBasics.rout) {
                            FlowBasics(navController = navController)
                        }
                        // Display data from server
                        composable(ModuleDemo.DisplayDataFromServer.rout) {
                            DisplayDataFromServerDemo(navController = navController)
                        }

                    }

                }
            }
        }
    }
}
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
import com.istudio.app.modules.module_demos.coroutines.CoroutinesDemo
import com.istudio.app.modules.module_demos.coroutines.coroutine_cancellation.CoroutinesCancellationSelection
import com.istudio.app.modules.module_demos.coroutines.coroutine_cancellation.ensure_active_demo.EnsureActiveDemo
import com.istudio.app.modules.module_demos.coroutines.coroutine_cancellation.is_active_demo.IsActiveDemo
import com.istudio.app.modules.module_demos.coroutines.coroutine_cancellation.non_cancellable_job.NonCancellableDemo
import com.istudio.app.modules.module_demos.coroutines.coroutine_cancellation.root_children_cencel_demo.RootChildrenCancelDemo
import com.istudio.app.modules.module_demos.coroutines.dispatchers.DispatchersDemo
import com.istudio.app.modules.module_demos.coroutines.job.JobDemoSelection
import com.istudio.app.modules.module_demos.coroutines.launch_and_withcontext.LaunchAndWithContextDemo
import com.istudio.app.modules.module_demos.coroutines.simple_structured_concurrency.SimpleStructuredConcurrencyDemo
import com.istudio.app.modules.module_demos.coroutines.suspend_and_launch_demo.SuspendAndLaunchDemo
import com.istudio.app.modules.module_demos.coroutines.using_join.UsingJoinDemo
import com.istudio.app.modules.module_demos.flows.FlowsDemo
import com.istudio.app.modules.module_demos.flows.modules.flow_basics.chapters.display_data_from_server.DisplayDataFromServerDemo
import com.istudio.app.modules.module_demos.flows.modules.intermediate_operators.IntermediateOperators
import com.istudio.app.modules.module_demos.flows.modules.terminal_operators.TerminalOperators
import com.istudio.app.modules.module_demos.flows.modules.flow_basics.ui.FlowBasics
import com.istudio.app.modules.module_demos.higher_order_functions.ui.HigherOrderFunctionDemo
import com.istudio.app.modules.module_demos.kotlin_annotations.ui.KotlinAnnotationsDemo
import com.istudio.app.modules.module_demos.nested_vs_inner.ui.NestedVsInner
import com.istudio.app.modules.module_demos.sealed_class.ui.SealedClassDemo
import com.istudio.app.modules.module_demos.type_alias.ui.TypeAlias
import com.istudio.app.modules.module_exercises.ExerciseSelection
import com.istudio.app.modules.module_exercises.exercise_1.Exercise1
import com.istudio.app.modules.module_exercises.exercise_2.Exercise2
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
                        startDestination = ModuleDemo.CoroutinesDemo.rout
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
                        // Type Alias
                        composable(ModuleDemo.TypeAlias.rout) {
                            TypeAlias(navController = navController)
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
                        // Terminal Operators
                        composable(ModuleDemo.TerminalOperators.rout) {
                            TerminalOperators(navController = navController)
                        }
                        // Intermediate Operators
                        composable(ModuleDemo.IntermediateOperators.rout) {
                            IntermediateOperators(navController = navController)
                        }
                        // NestedVsInner Demo
                        composable(ModuleDemo.NestedVsInner.rout) {
                            NestedVsInner(navController = navController)
                        }
                        // Coroutines Demo
                        composable(ModuleDemo.CoroutinesDemo.rout) {
                            CoroutinesDemo(navController = navController)
                        }
                        // Simple structured concurrency
                        composable(ModuleDemo.SimpleStructuredConcurrencyDemo.rout) {
                            SimpleStructuredConcurrencyDemo(navController = navController)
                        }
                        // Dispatchers Demo
                        composable(ModuleDemo.DispatchersDemo.rout) {
                            DispatchersDemo(navController = navController)
                        }
                        // Exercises
                        composable(ModuleDemo.Exercises.rout) {
                            ExerciseSelection(navController = navController)
                        }
                        // Exercise-1
                        composable(ModuleDemo.Exercise1.rout) {
                            Exercise1(navController = navController)
                        }
                        // Exercise-2
                        composable(ModuleDemo.Exercise2.rout) {
                            Exercise2(navController = navController)
                        }
                        // Coroutine cancellation demo
                        composable(ModuleDemo.CoroutinesCancellationSelection.rout) {
                            CoroutinesCancellationSelection(navController = navController)
                        }
                        // CoRoutine cancellation selection
                        composable(ModuleDemo.RootChildrenCancelDemo.rout) {
                            RootChildrenCancelDemo(navController = navController)
                        }
                        // CoRoutine isActive Demo
                        composable(ModuleDemo.CoroutinesCancellationIsActiveDemo.rout) {
                            IsActiveDemo(navController = navController)
                        }
                        // CoRoutine EnsureActive Demo
                        composable(ModuleDemo.EnsureActiveDemo.rout) {
                            EnsureActiveDemo(navController = navController)
                        }
                        // CoRoutine NonCancellable Demo
                        composable(ModuleDemo.NonCancellableDemo.rout) {
                            NonCancellableDemo(navController = navController)
                        }
                        // Suspend and Launch demo
                        composable(ModuleDemo.SuspendAndLaunchDemo.rout) {
                            SuspendAndLaunchDemo(navController = navController)
                        }
                        // Launch And WithContext demo
                        composable(ModuleDemo.LaunchAndWithContextDemo.rout) {
                            LaunchAndWithContextDemo(navController = navController)
                        }
                        // Job Demo
                        composable(ModuleDemo.JobDemoSelection.rout) {
                            JobDemoSelection(navController = navController)
                        }
                        // Using Join Demo
                        composable(ModuleDemo.UsingJoinDemo.rout) {
                            UsingJoinDemo(navController = navController)
                        }
                    }
                }
            }
        }
    }
}
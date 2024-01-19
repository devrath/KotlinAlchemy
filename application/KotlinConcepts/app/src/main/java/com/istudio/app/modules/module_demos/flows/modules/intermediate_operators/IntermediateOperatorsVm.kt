package com.istudio.app.modules.module_demos.flows.modules.intermediate_operators

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.dropWhile
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.filterNot
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.takeWhile
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.EmptyCoroutineContext

@HiltViewModel
class IntermediateOperatorsVm @Inject constructor(
    @ApplicationContext private val context: Context,
) : ViewModel() {

    private val flowOfIntegers = flowOf(1, 2, 3, 4, 5)

    /**
     * ****************************************
     * OPERATOR: Map Operator
     * DESCRIPTION: Using the map operator, We shall transform Integers into Strings
     * ****************************************
     * Types of map Operators:-
     * ****************************************
     * (1) flowOfIntegers.map {  }
     *
     * (2) flowOfIntegers.mapNotNull {  }
     *
     * (3) flowOfIntegers.mapLatest {  }
     * ****************************************
     */
    fun mapOperator() {
        viewModelScope.launch {

            flowOfIntegers.map {
                it.toString()
            }.collect {
                if(it is String){
                    // Use smart cast to check if it is string
                    println("Received value: -->$it")
                }
            }
        }
    }

    /**
     * OPERATOR: Filter Operator
     * DESCRIPTION: Using the filter operator, We can con apply a filter to remove emissions that does not meet the criteria
     * ****************************************
     * Useful Filter Operators:-
     * ****************************************
     * (1) flowOfIntegers.filter {  }
     *
     * (2) flowOfIntegers.filterNot {  }
     *
     * (3) flowOfIntegers.filterIsInstance<Int>{ }
     * ****************************************
     */
    fun filterOperator() {
        viewModelScope.launch {
            flowOfIntegers.filter {
                // We use modulus function to check if the number is divisible by 2
                it%2 == 0
            }.collect{
                println("Received value: -->$it")
            }
        }
    }

    /**
     * OPERATOR: Take Operator
     * DESCRIPTION: They are called sizing operators that limit the size of emission based on a predicate condition
     * ****************************************
     * useful take Operators:-
     * ****************************************
     * (1) flowOfIntegers.take{ }
     *
     * (2) flowOfIntegers.takeIf {  }
     *
     * (3) flowOfIntegers.takeWhile {  }
     *
     * (4) flowOfIntegers.takeUnless {  }
     * ****************************************
     */
    fun takeOperator() {
        val scope = CoroutineScope(EmptyCoroutineContext)
        scope.launch {
            flowOfIntegers.take(2).collect{
                println("Received value: -->$it")
            }
        }
    }

    /**
     * OPERATOR: Drop Operator
     * DESCRIPTION: We basically drop the mentioned initial emissions specified
     * ****************************************
     * Useful drop Operators:-
     * ****************************************
     * (1) flowOfIntegers.drop{ }
     *
     * (2) flowOfIntegers.dropWhile {  }
     * ****************************************
     */
    fun dropOperator() {
        val scope = CoroutineScope(EmptyCoroutineContext)
        scope.launch {
            flowOfIntegers.drop(1).collect{
                println("Received value: -->$it")
            }
        }
    }

    /**
     * OPERATOR: Transform Operator
     * DESCRIPTION:
     * We can transform the data apply some predicate conditions and emit the new value,
     * We can also emit multiple emissions
     * This is basically applying a collection of operators together and emitting the emission downstream
     */
    fun transformOperator() {
        val scope = CoroutineScope(EmptyCoroutineContext)
        scope.launch {
            flowOfIntegers.transform {
                if((it%2)==0){
                    // Elements that are divisible by 2
                    emit(it)
                }
            }.collect{
                println("Received value: -->$it")
            }
        }
    }

}
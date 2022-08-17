package com.droid.code

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    val variableLamda = { Log.d("Hello","Logging lamda") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       //higherOrderFunctionDemo(initialStr = "Initial String",::printString)

        demoOne(variableLamda)
    }

    private fun demoOne(variableLamda: () -> Int) {
        variableLamda()
    }


    private fun higherOrderFunctionDemo(initialStr: String, finalStr: (String) -> Unit) {
        Log.d("Hello",initialStr)
    }

    /**
     * Function that prints string
     */
    private fun printString(value: String) {
        Log.d("Hello",value)
    }

}
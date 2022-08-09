package com.droid.democode.abstractVariable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.droid.democode.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val monkeyObj = Monkey()
        Log.d("Hello","<----START--->")
        Log.d("Hello","Animal number: -> "+monkeyObj.colorOfAnimal)
        Log.d("Hello","<----END--->")

    }

}


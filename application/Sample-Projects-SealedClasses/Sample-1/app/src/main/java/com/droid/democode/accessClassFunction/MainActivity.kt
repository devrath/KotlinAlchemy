package com.droid.democode.accessClassFunction

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
        monkeyObj.printColorOfAnimal()
        Log.d("Hello","Animal number: -> "+monkeyObj.animalNumber)
        monkeyObj.animalNumber++
        Log.d("Hello","Animal number: -> "+monkeyObj.animalNumber)
        Log.d("Hello","<----END--->")

    }

}


package com.droid.democode.suggestOptions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.droid.democode.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val catData = getCats()

        when(catData){
            is Camel -> { /* Some logic */ }
            is Animal.Cat -> { /* Some logic */ }
            is Animal.Dog -> { /* Some logic */ }
            is Monkey -> { /* Some logic */ }
        }

    }

    fun getCats() : Animal {  return Animal.Cat }

}
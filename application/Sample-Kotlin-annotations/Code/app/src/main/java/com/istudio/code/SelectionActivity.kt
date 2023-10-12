package com.istudio.code

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.istudio.code.databinding.ActivitySelectionBinding
import com.istudio.code.modules.jvmField.DemoJavaAnnotation
import com.istudio.code.modules.jvmOverloads.DemoJvmOverloadsAnnotation
import com.istudio.code.modules.jvmStatic.DemoJvmStaticAnnotation

class SelectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListeners();
    }

    private fun setOnClickListeners() {
        binding.apply {
            jvmFieldId.setOnClickListener { DemoJavaAnnotation().initiate()}
            jvmOverloadsId.setOnClickListener { DemoJvmOverloadsAnnotation().initiate() }
            jvmStaticId.setOnClickListener { DemoJvmStaticAnnotation().initiate() }
        }
    }

}
package com.demo.code.activities

import android.content.Intent
import android.os.Bundle
import com.demo.code.base.BaseActivity
import com.demo.code.databinding.ActivitySelectionBinding
import com.demo.code.modules.observabletypes.ObservableTypesActivity

class SelectionActivity : BaseActivity() {

    private lateinit var binding: ActivitySelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hideUpButton()
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.apply {
            btnUseCasesId.setOnClickListener {
                startActivity(Intent(this@SelectionActivity, MainActivity::class.java))
            }
            jobsId.setOnClickListener {
                startActivity(Intent(this@SelectionActivity, JobsActivity::class.java))
            }
            suspendingFunctionsId.setOnClickListener {
                startActivity(Intent(this@SelectionActivity, SuspendingFuncActivity::class.java))
            }
            typesOfObservablesId.setOnClickListener {
                startActivity(Intent(this@SelectionActivity, ObservableTypesActivity::class.java))
            }
        }
    }

    override fun getToolbarTitle() = "Selection Screen"


}
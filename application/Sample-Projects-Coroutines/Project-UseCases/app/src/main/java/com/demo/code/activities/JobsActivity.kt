package com.demo.code.activities

import android.os.Bundle
import com.demo.code.base.BaseActivity
import com.demo.code.databinding.ActivityJobsBinding
import kotlinx.coroutines.*

@DelicateCoroutinesApi
class JobsActivity : BaseActivity() {

    override fun getToolbarTitle() = "Jobs in Coroutine"

    private lateinit var binding: ActivityJobsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJobsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hideUpButton()
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.apply {
            retryDemoId.setOnClickListener {
                retryDemo()
            }
            simpleDemoOneId.setOnClickListener {
                simpleJobOneDemo()
            }
            simpleDemoTwoId.setOnClickListener {
                simpleJobTwoDemo()
            }
        }
    }

    private fun simpleJobTwoDemo() {

       val rootJob = GlobalScope.launch(start = CoroutineStart.DEFAULT){

           val parentJob = launch {
               delay(10)
               println("Parent job started")
               delay(10)
           }

           val childOneJob = launch() {
               delay(10)
               println("Child one job started")
               delay(10)
           }

           val childTwoJob = launch() {
               delay(10)
               println("Child two job started")
               delay(10)
           }

           if(parentJob.children.iterator().hasNext()){
               val childCnt = parentJob.children
               println("Parent has $childCnt children")
           }else{
               println("Parent has no children")
           }

           Thread.sleep(1000)
       }

        /**
         * OUTPUT:->
         * Parent has kotlin.sequences.SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1@85caa11 children
         * Parent job started
         * Child two job started
         * Child one job started
         */

    }

    private fun simpleJobOneDemo() {

        /**
         * This since executed by Lazy, It will start only when invoked
         */
        val job1 = GlobalScope.launch(start=CoroutineStart.LAZY) {
            delay(200)
            println("Two")
            delay(200)
        }

        GlobalScope.launch {
            delay(200)
            println("One")
            // Job is invoked here so it is executed here
            job1.join()
            println("Three")
        }

        /**
         * 2021-10-09 12:08:38.108 18586-18711/com.demo.code I/System.out: One
         * 2021-10-09 12:08:38.311 18586-18711/com.demo.code I/System.out: Two
         * 2021-10-09 12:08:38.519 18586-18711/com.demo.code I/System.out: Three
         */
    }

    private fun retryDemo(){
        GlobalScope.launch {
            repeat(3){
                delay(200)
                println("Execution happened")
            }
        }

        /** Output:
         * Execution happened
         * Execution happened
         * Execution happened
         */
    }


}
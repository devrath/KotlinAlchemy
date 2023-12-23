package com.istudio.app.modules.module_demos.channels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class ChannelsDemoVm @Inject constructor( ) : ViewModel() {

    // <! ------------------- COMMUNICATING BETWEEN COROUTINES ------------------->
    // A channel of languages
    private var languageChannel = Channel<Languages>()

    /**
     * Sending and receiving only one value
     */
    fun simpleCommunication() {

        // Co-Routine - 1
        viewModelScope.launch {
            languageChannel.send(Languages.English)
        }

        // Co-Routine - 2
        viewModelScope.launch {
            println(languageChannel.receive())
        }

    }

    /**
     * Sending and receiving multiple values
     */
    fun sendingMultipleValues() {

        // Co-Routine - 1
        viewModelScope.launch {
            languageChannel.send(Languages.English)
            languageChannel.send(Languages.Hindi)
            languageChannel.send(Languages.French)
        }

        // Co-Routine - 2
        viewModelScope.launch {
            languageChannel.consumeEach {
                println(languageChannel.receive())
            }
        }

    }


    /**
     * Canceling a channel
     */
    fun cancellingChannel() {

        // Co-Routine - 1
        viewModelScope.launch {
            println("Sending value - 1")
            languageChannel.send(Languages.English)
            println("Sending value - 2")
            languageChannel.send(Languages.Hindi)
            println("Sending value - 3")
            languageChannel.send(Languages.French)
        }

        // Co-Routine - 2
        viewModelScope.launch {
            try {
                println(languageChannel.receive())
                languageChannel.cancel(CancellationException("Custom Exception"))
                println(languageChannel.receive())
                println(languageChannel.receive())
            }catch (ex : Exception){
                println(ex.message)
                println("Is it closed for Send: -> "+languageChannel.isClosedForSend)
                println("Is it closed for Receive: -> "+languageChannel.isClosedForReceive)
            }
        }

    }


    /**
     * Closing a channel
     */
    fun closingChannel() {

        // Co-Routine - 1
        viewModelScope.launch {
            languageChannel.send(Languages.English)
            languageChannel.close()
            languageChannel.send(Languages.Hindi)
            languageChannel.send(Languages.French)

        }

        // Co-Routine - 2
        viewModelScope.launch {
            languageChannel.consumeEach {
                println(languageChannel.receive())
            }
        }

    }


    enum class Languages { English , Hindi , French }

    // <! ------------------- COMMUNICATING BETWEEN COROUTINES ------------------->


    // <! ------------------- USING PRODUCE IN CHANNELS -------------------------->



    enum class Superheroes { Batman , Superman , Spiderman }
    // <! ------------------- USING PRODUCE IN CHANNELS -------------------------->


}